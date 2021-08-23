package DataStructures.ADTs;

import DataStructures.Node;

public abstract class GenericSearchProblem {
    public String[] operators;
    public State initialState;

    public GenericSearchProblem() {

    }

    public abstract boolean goalTest(State state, String operator);

    public abstract int pathCost(Node parent, String operator);

    // This is used for heuristics, basically if an invalid action is done we add a penalty to the path cost
    public abstract int pathCost(Node parent, String operator, int penalty);

    public abstract int heuristicOne(Node parent, String operator);

    public abstract int heuristicTwo(Node parent, String operator);

    public abstract String generalSearch(String problem, String qingFunc);
}
