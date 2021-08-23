package DataStructures;

import DataStructures.ADTs.State;

import java.util.Objects;

public class Node implements Comparable<Node>{
    public State state;
    public Node parent;
    public String operator;
    public int depth;
    public int pathCost;

    public Node(State state) {
        this.state = state;

        parent = null;
        operator = null;
        depth = 0;
        pathCost = 0;
    }

    public Node(State state, Node parent, String operator, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.pathCost = pathCost;

        depth = parent.depth + 1;
    }

    @Override
    public int compareTo(Node node) {
        return pathCost - node.pathCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return depth == node.depth && pathCost == node.pathCost && Objects.equals(state, node.state) && Objects.equals(parent, node.parent) && Objects.equals(operator, node.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, parent, operator, depth, pathCost);
    }
}
