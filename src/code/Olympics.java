package code;

import DataStructures.ADTs.GenericSearchProblem;
import DataStructures.Point;
import DataStructures.ADTs.State;
import DataStructures.Node;
import DataStructures.OlympicState;

import java.util.*;
import java.util.stream.Stream;

public class Olympics extends GenericSearchProblem {

    public static final String[] operators = {"up", "down", "left", "right", "pick", "light"};
    public static final int[] moveRow = {-1, +1, 0, 0};
    public static final int[] moveCol = {0, 0, -1, +1};

    public String problem;
    public int rows;
    public int cols;
    public Point jarvisPosition;
    public Point flamePosition;
    public ArrayList<Point> components;
    public ArrayList<Point> poisonCells;

    public Olympics(String problem) {
        super();

        this.problem = problem;
        getData();

        super.operators = operators;
        super.initialState = new OlympicState(jarvisPosition, components, false);
    }

    /**
     * Method that generates a random grid based on these following specifications:
     * Grid Size = 5x5 -> 15x15
     * Number of Components = 5 -> 10
     * Number of poisonous cells = 2 -> 25
     * Output format: Grid Size;Jarvis Initial Position;Flame Position;Components' Positions;Poisonous Cells' Positions
     * Position format: (i, j) = (row, col)
     *
     * @return String
     */
    public static String genGrid() {
        Random generator = new Random(System.currentTimeMillis());

        StringBuilder grid = new StringBuilder();

        int rows = generator.nextInt(11) + 5;
        int cols = generator.nextInt(11) + 5;
        int components = generator.nextInt(6) + 5;
        int poisonCells = generator.nextInt(24) + 2;

        ArrayList<Point> positions = new ArrayList<>();
        HashSet<Point> taken = new HashSet<>();

        while (positions.size() != (2 + components + poisonCells)) { // Jarvis + Flame + #PoisonCells + #Components
            Point point = new Point(generator.nextInt(rows), generator.nextInt(cols));

            if (taken.contains(point)) {
                continue;
            }

            positions.add(point);
            taken.add(point);
        }

        grid.append(rows).append(',').append(cols);

        for (int i = 0; i < positions.size(); ++i) {
            if (i == 0 || i == 1 || i == 2 || i == 2 + components) {
                grid.append(';');
            } else {
                grid.append(',');
            }

            Point position = positions.get(i);

            grid.append(position.x).append(',').append(position.y);
        }

        return grid.toString();
    }

    /**
     * Method that takes a string input that represents the problem and return a 2D array of ints that contain the following:
     * Index[0]: Grid Size
     * Index[1]: Jarvis Position
     * Index[2]: Flame Position
     * Index[3]: Components' Positions
     * Index[4]: Poison Cells' Positions
     *
     * @param grid Description of the current problem
     * @return int[][]
     */
    public static int[][] parseGridData(String grid) {
        int[][] data = new int[5][];

        String[] split = grid.split(";");

        for (int i = 0; i < 5; ++i) {
            data[i] = Stream.of(split[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }

        return data;
    }

    /**
     * Method that takes a string input representing a problem and
     * returns a 2D array of characters that visualize the problem.
     *
     * @param grid Description of current problem
     * @return char[][]
     */
    public static char[][] characterGrid(String grid) {
        int[][] data = parseGridData(grid);

        char[][] charGrid = new char[data[0][0]][data[0][1]];

        for (char[] chars : charGrid) {
            Arrays.fill(chars, '*');
        }

        charGrid[data[1][0]][data[1][1]] = 'J';
        charGrid[data[2][0]][data[2][1]] = 'F';

        for (int i = 0; i < data[3].length; i += 2) {
            charGrid[data[3][i]][data[3][i + 1]] = 'C';
        }

        for (int i = 0; i < data[4].length; i += 2) {
            charGrid[data[4][i]][data[4][i + 1]] = 'P';
        }

        return charGrid;
    }

    /**
     * Method that a 2D array of character representing a problem and return a String visualizing the problem
     *
     * @param grid 2D array of character representing a problem
     * @return String
     */
    public static String drawGrid(char[][] grid) {
        StringBuilder stringGrid = new StringBuilder();

        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (j != 0) {
                    stringGrid.append('|');
                }

                stringGrid.append(chars[j]);
            }
            stringGrid.append("\n");
        }

        return stringGrid.toString();
    }

    public static String solve(String grid, String strategy, boolean visualize) {
        Olympics olympics = new Olympics(grid);

        String solution = olympics.generalSearch(grid, strategy);

        if (solution == null) {
            return "No Solution!";
        }

        if (visualize) {
            visualizeSolution(solution, grid);
        }

        return solution;
    }

    public static void visualizeSolution(String solution, String grid) {
        int[][] data = parseGridData(grid);

        String[] split = solution.split(";");
        String[] actions = split[0].split(",");

        Point jarPos = new Point(data[1][0], data[1][1]);
        char[][] charGrid = characterGrid(grid);

        for (char[] chars : charGrid) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("------");

        // IMPORTANT:
        // Symbol list:
        // J: Jarvis
        // C: Component
        // P: Poison cell
        // W: Jarvis with component/Flame
        // F: Flame not lighten
        // X: Flame lighten
        // *: Empty Cell
        for (String operation : actions) {
            int actionIndex = -1;
            for (int i = 0; i < operators.length; ++i) {
                if (operation.equals(operators[i])) {
                    actionIndex = i;
                    break;
                }
            }

            if (actionIndex != 4 && actionIndex != 5) {
                if (charGrid[jarPos.x + moveRow[actionIndex]][jarPos.y + moveCol[actionIndex]] != '*') {
                    charGrid[jarPos.x][jarPos.y] = '*';
                    charGrid[jarPos.x + moveRow[actionIndex]][jarPos.y + moveCol[actionIndex]] = 'W';
                } else {
                    charGrid[jarPos.x][jarPos.y] = '*';
                    charGrid[jarPos.x + moveRow[actionIndex]][jarPos.y + moveCol[actionIndex]] = 'J';
                }

                jarPos.x = jarPos.x + moveRow[actionIndex];
                jarPos.y = jarPos.y + moveCol[actionIndex];
            } else if (actionIndex == 4) {
                charGrid[jarPos.x][jarPos.y] = 'J';
            } else {
                charGrid[jarPos.x][jarPos.y] = 'X';
            }

            System.out.print(drawGrid(charGrid));
            System.out.println("------");
        }
    }

    public static void main(String[] args) {
        String grid = "5,5;1,2;3,2;0,3,2,1,3,4,4,0,4,3;0,1,0,2,3,1,3,3,4,2";

        boolean generated = true;

        System.out.println(Olympics.solve(generated ? Olympics.genGrid() : grid, "AS1", false));
        //char[][] charGrid = Olympics.characterGrid(grid);
        //System.out.println(Olympics.drawGrid(charGrid));
    }

    public void getData() {
        int[][] data = parseGridData(problem);

        rows = data[0][0];
        cols = data[0][1];
        jarvisPosition = new Point(data[1][0], data[1][1]);
        flamePosition = new Point(data[2][0], data[2][1]);

        components = new ArrayList<>();
        for (int i = 0; i < data[3].length; i += 2) {
            components.add(new Point(data[3][i], data[3][i + 1]));
        }

        poisonCells = new ArrayList<>();
        for (int i = 0; i < data[4].length; i += 2) {
            poisonCells.add(new Point(data[4][i], data[4][i + 1]));
        }
    }

    public String printSolution(Node solution, int expandedNodes) {
        Stack<String> operations = new Stack<>();

        while (solution.parent != null) {
            operations.push(solution.operator);

            solution = solution.parent;
        }

        StringBuilder sol = new StringBuilder();

        boolean first = true;

        while (!operations.isEmpty()) {
            if (first) {
                first = false;
            } else {
                sol.append(',');
            }

            sol.append(operations.pop());
        }

        sol.append(';').append(expandedNodes);

        return sol.toString();
    }

    @Override
    public boolean goalTest(State state, String operator) {
        OlympicState olympicState = (OlympicState) state;

        return olympicState.position.equals(flamePosition) && olympicState.remComp.size() == 0 && operator.equals("light");
    }

    @Override
    public int pathCost(Node parent, String operator) {
        int reward = 0;

        switch (operator) {
            case "pick" -> reward += 150;
            case "light" -> reward += 15000;
            default -> reward -= 1;
        }

        reward += parent.pathCost;

        return reward;
    }

    @Override
    public int pathCost(Node parent, String operator, int penalty) {
        return pathCost(parent, operator) + penalty;
    }

    public int operationIndex(String operator) {
        int index = -1;

        for (int i = 0; i < operators.length; ++i) {
            if (operator.equals(operators[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Heuristic based on manhattan distance
     *
     * Method that returns a value based on a child node's state and the result of applying an action on its parent state
     * Why is it the parent state?
     * Mainly because we want to estimate the path cost of choosing a certain action to accomplish out goal, we want to
     * smartly choose the best action to take so that our costs are minimized.
     * In the case of our problem, we may want to greedily choose the next closest node from our current position
     * that means if I take a certain action (example: move forward) the cost of taking that action must be lower than
     * taking every other action.
     *
     * In our problem we can use distance metrics to actually do this, we can use: Manhattan Distance & Chess board distance
     * to see which action provides the closest path to a goal
     *
     * This is admissible for the following reason:
     * - A certain distance estimate is guaranteed to find the shortest path from our position to a goal position.
     * - A goal position is a position where we either find a component or a flame,
     * in both cases we do pick or light which are the best actions to do.
     * - Our actual cost must be composed of actions that pass with every node with a best order, i.e a good path must go to
     * the closest node instead of taking a zigzag path.
     * - Our function also satisfies the centring property i.e h(n) = 0, as taking the manhattan distance it must produce
     * h(n) = 0 if the distance between jarvis and a component/flame is zero.
     * @param parent Node
     * @param operator Operator applied on a parent state
     * @return int
     */

    @Override
    public int heuristicOne(Node parent, String operator) {
        OlympicState state = (OlympicState) parent.state;

        // Steps to finding the heuristic value
        // 1. Before applying any operation look up the closest target
        //  1.1 A component if the parent still has components
        //  1.2 The flame if all components are exhausted
        // 2. Based on the passed operator: Apply the heuristic function
        int val = 0;

        if (!operator.equals("pick") && !operator.equals("light")) {
            // If components are exhausted then the closest goal is the flame after applying the operation on the position
            // of the parent
            if (state.remComp.size() == 0) {
                val =
                        Math.abs(flamePosition.x - jarvisPosition.x + moveRow[operationIndex(operator)])
                                + Math.abs(flamePosition.y - jarvisPosition.y + moveCol[operationIndex(operator)]);
            } else {
                // Before moving, find the closest component to jarvis
                Point closestGoal = null;
                int distance = Integer.MAX_VALUE;

                for (int i = 0; i < state.remComp.size(); ++i) {
                    Point p = state.remComp.get(i);
                    int d = Math.abs(p.x - jarvisPosition.x) + Math.abs(p.y - jarvisPosition.y);

                    if (d < distance) {
                        distance = d;
                        closestGoal = p;
                    }
                }

                if (closestGoal != null) {
                    val = Math.abs(closestGoal.x - jarvisPosition.x + moveRow[operationIndex(operator)])
                            + Math.abs(closestGoal.y - jarvisPosition.y + moveCol[operationIndex(operator)]);
                }
            }
        }

        return val * -1 + parent.pathCost;
    }

    /**
     * Heuristic based on chess board distance
     * @param parent Node
     * @param operator Operator applied on a parent state
     * @return int
     */
    @Override
    public int heuristicTwo(Node parent, String operator) {
        OlympicState state = (OlympicState) parent.state;

        int val = 0;

        if (!operator.equals("pick") && !operator.equals("light")) {
            if (state.remComp.size() == 0) {
                val =
                        Math.max(Math.abs(flamePosition.x - jarvisPosition.x + moveRow[operationIndex(operator)]),
                                Math.abs(flamePosition.y - jarvisPosition.y + moveCol[operationIndex(operator)]));
            } else {
                Point closestGoal = null;
                int distance = Integer.MAX_VALUE;

                for (int i = 0; i < state.remComp.size(); ++i) {
                    Point p = state.remComp.get(i);
                    int d = Math.max(Math.abs(p.x - jarvisPosition.x), Math.abs(p.y - jarvisPosition.y));

                    if (d < distance) {
                        distance = d;
                        closestGoal = p;
                    }
                }

                if (closestGoal != null) {
                    val = Math.max(Math.abs(closestGoal.x - jarvisPosition.x + moveRow[operationIndex(operator)]),
                            Math.abs(closestGoal.y - jarvisPosition.y + moveCol[operationIndex(operator)]));
                }
            }
        }

        return val * -1 + parent.pathCost;
    }

    @Override
    public String generalSearch(String problem, String qingFunc) {
        String solution = null;

        switch (qingFunc) {
            case "BF":
                solution = BFS();
                break;
            case "DF":
                solution = DFS();
                break;
            case "UC":
                solution = UC();
                break;
            case "GR1":
                solution = GR(1);
                break;
            case "GR2":
                solution = GR(2);
                break;
            case "AS1":
                solution = AS(1);
                break;
            case "AS2":
                solution = AS(2);
                break;
        }

        return solution;
    }

    /**
     * This method takes the position of jarvis and checks if a chosen operation is valid based on these conditions:
     * up/down/left/right: Movement does not exceed grid boundary and movement does not land on a poison cell
     * pick: Jarvis is on a component cell
     * light: Jarvis is on a flame cell, flame not lighten & no components remaining
     *
     * @return boolean
     */
    public boolean validOperation(OlympicState jarvisState, String operator) {
        boolean valid;

        if (!operator.equals("pick") && !operator.equals("light")) {
            valid = 0 <= jarvisState.position.x && jarvisState.position.x < rows &&
                    0 <= jarvisState.position.y && jarvisState.position.y < cols &&
                    !poisonCells.contains(jarvisState.position);

        } else if (operator.equals("pick")) {
            valid = jarvisState.remComp.contains(jarvisState.position);
        } else {
            valid = jarvisState.position.equals(flamePosition) && !jarvisState.isLighten && jarvisState.remComp.size() == 0;
        }


        return valid;
    }

    public String BFS() {
        Node solution = null;
        int expandedNodes = 0;

        Queue<Node> queue = new LinkedList<>();
        HashSet<OlympicState> visitedStates = new HashSet<>();

        Node root = new Node(super.initialState);
        queue.add(root);
        visitedStates.add((OlympicState) root.state);

        while (!queue.isEmpty()) {
            Node front = queue.remove();
            OlympicState frontState = (OlympicState) front.state;

            expandedNodes += 1;
            // Check if node is a goal node
            if (goalTest(front.state, front.operator)) {
                solution = front;
                break;
            }

            // Apply all operators and check if the state of a potential child is not repeated
            OlympicState childState;
            Node child;

            // Apply movement operators
            for (int i = 0; i < 4; ++i) {
                childState = new OlympicState(
                        new Point(frontState.position.x + moveRow[i], frontState.position.y + moveCol[i]),
                        new ArrayList<>(frontState.remComp), false);

                // Check if operation is valid or state was not visited before
                if (!validOperation(childState, operators[i]) || visitedStates.contains(childState)) {
                    continue;
                }

                child = new Node(childState, front, operators[i], 0);

                queue.add(child);
                visitedStates.add(childState);
            }

            // Apply Light Operation
            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[5])) {
                childState.isLighten = true;

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[5], 0);

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }

            // Apply Pick
            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[4])) {
                childState.remComp.remove(childState.position);

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[4], 0);

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }
        }

        if (solution == null) {
            return null;
        }

        return printSolution(solution, expandedNodes);
    }

    public String DFS() {
        Node solution = null;
        int expandedNodes = 0;

        Stack<Node> stack = new Stack<>();
        HashSet<OlympicState> visitedStates = new HashSet<>();

        Node root = new Node(super.initialState);

        stack.push(root);
        visitedStates.add((OlympicState) root.state);

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            OlympicState topState = (OlympicState) top.state;

            expandedNodes += 1;

            if (goalTest(top.state, top.operator)) {
                solution = top;
                break;
            }

            OlympicState childState;
            Node child;

            for (int i = 0; i < 4; ++i) {
                childState = new OlympicState(
                        new Point(topState.position.x + moveRow[i], topState.position.y + moveCol[i]),
                        new ArrayList<>(topState.remComp), false);

                if (!validOperation(childState, operators[i]) || visitedStates.contains(childState)) {
                    continue;
                }

                child = new Node(childState, top, operators[i], 0);

                stack.push(child);
                visitedStates.add(childState);
            }

            childState = new OlympicState(new Point(topState.position), new ArrayList<>(topState.remComp), false);
            if (validOperation(childState, operators[5])) {
                childState.isLighten = true;

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, top, operators[5], 0);

                    stack.push(child);
                    visitedStates.add(childState);
                }
            }

            childState = new OlympicState(new Point(topState.position), new ArrayList<>(topState.remComp), false);
            if (validOperation(childState, operators[4])) {
                childState.remComp.remove(childState.position);

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, top, operators[4], 0);

                    stack.push(child);
                    visitedStates.add(childState);
                }
            }
        }

        if (solution == null) {
            return null;
        }

        return printSolution(solution, expandedNodes);
    }

    public String UC() {
        Node solution = null;
        int expandedNodes = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<OlympicState> visitedStates = new HashSet<>();

        Node root = new Node(super.initialState);
        queue.add(root);
        visitedStates.add((OlympicState) root.state);

        while (!queue.isEmpty()) {
            Node front = queue.remove();
            OlympicState frontState = (OlympicState) front.state;

            expandedNodes += 1;

            if (goalTest(front.state, front.operator)) {
                solution = front;
                break;
            }

            OlympicState childState;
            Node child;

            for (int i = 0; i < 4; ++i) {
                childState = new OlympicState(
                        new Point(frontState.position.x + moveRow[i], frontState.position.y + moveCol[i]),
                        new ArrayList<>(frontState.remComp), false
                );

                if (!validOperation(childState, operators[i]) || visitedStates.contains(childState)) {
                    continue;
                }

                child = new Node(childState, front, operators[i], pathCost(front, operators[i]));

                queue.add(child);
                visitedStates.add(childState);
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[5])) {
                childState.isLighten = true;

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[5], pathCost(front, operators[5]));

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[4])) {
                childState.remComp.remove(childState.position);

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[4], pathCost(front, operators[4]));

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }
        }

        if (solution == null) {
            return null;
        }

        return printSolution(solution, expandedNodes);
    }

    public String GR(int heuristic) {
        Node solution = null;
        int expandedNodes = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<OlympicState> visitedStates = new HashSet<>();

        Node root = new Node(super.initialState);
        queue.add(root);
        visitedStates.add((OlympicState) root.state);

        while (!queue.isEmpty()) {
            Node front = queue.remove();
            OlympicState frontState = (OlympicState) front.state;

            expandedNodes += 1;

            if (goalTest(front.state, front.operator)) {
                solution = front;
                break;
            }

            OlympicState childState;
            Node child;

            for (int i = 0; i < 4; ++i) {
                childState = new OlympicState(
                        new Point(frontState.position.x + moveRow[i], frontState.position.y + moveCol[i]),
                        new ArrayList<>(frontState.remComp), false
                );

                if (!validOperation(childState, operators[i]) || visitedStates.contains(childState)) {
                    continue;
                }

                child = new Node(childState, front, operators[i],
                        heuristic == 1 ? heuristicOne(front, operators[i]) : heuristicTwo(front, operators[i]));

                queue.add(child);
                visitedStates.add(childState);
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[5])) {
                childState.isLighten = true;

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[5],
                            heuristic == 1 ? heuristicOne(front, operators[5]) : heuristicTwo(front, operators[5]));

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[4])) {
                childState.remComp.remove(childState.position);

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[4],
                            heuristic == 1 ? heuristicOne(front, operators[4]) : heuristicTwo(front, operators[4]));

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }
        }

        if (solution == null) {
            return null;
        }

        return printSolution(solution, expandedNodes);
    }

    public String AS(int heuristic) {
        Node solution = null;
        int expandedNodes = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<OlympicState> visitedStates = new HashSet<>();

        Node root = new Node(super.initialState);
        queue.add(root);
        visitedStates.add((OlympicState) root.state);

        while (!queue.isEmpty()) {
            Node front = queue.remove();
            OlympicState frontState = (OlympicState) front.state;

            expandedNodes += 1;

            if (goalTest(front.state, front.operator)) {
                solution = front;
                break;
            }

            OlympicState childState;
            Node child;

            for (int i = 0; i < 4; ++i) {
                childState = new OlympicState(
                        new Point(frontState.position.x + moveRow[i], frontState.position.y + moveCol[i]),
                        new ArrayList<>(frontState.remComp), false
                );

                if (!validOperation(childState, operators[i]) || visitedStates.contains(childState)) {
                    continue;
                }

                // THe minus front.pathCost here is because the heuristic and path cost both add parent cost,
                // so we need to subtract one
                child = new Node(childState, front, operators[i],
                        heuristic == 1 ? heuristicOne(front, operators[i]) : heuristicTwo(front, operators[i]) +
                        pathCost(front, operators[i]) - front.pathCost);

                queue.add(child);
                visitedStates.add(childState);
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[5])) {
                childState.isLighten = true;

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[5],
                            heuristic == 1 ? heuristicOne(front, operators[5]) : heuristicTwo(front, operators[5]) +
                            pathCost(front, operators[5]) - front.pathCost);

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }

            childState = new OlympicState(new Point(frontState.position), new ArrayList<>(frontState.remComp), false);
            if (validOperation(childState, operators[4])) {
                childState.remComp.remove(childState.position);

                if (!visitedStates.contains(childState)) {
                    child = new Node(childState, front, operators[4],
                            heuristic == 1 ? heuristicOne(front, operators[4]) : heuristicTwo(front, operators[4]) +
                            pathCost(front, operators[4]) - front.pathCost);

                    queue.add(child);
                    visitedStates.add(childState);
                }
            }
        }

        if (solution == null) {
            return null;
        }

        return printSolution(solution, expandedNodes);
    }
}
