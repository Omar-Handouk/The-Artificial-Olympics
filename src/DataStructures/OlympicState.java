package DataStructures;

import DataStructures.ADTs.State;

import java.util.ArrayList;
import java.util.Objects;

public class OlympicState extends State {
    public Point position;
    public ArrayList<Point> remComp;
    public boolean isLighten;
    public OlympicState(Point position, ArrayList<Point> remComp, boolean isLighten) {
        this.position = position;
        this.remComp = remComp;
        this.isLighten = isLighten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OlympicState that = (OlympicState) o;
        return isLighten == that.isLighten && Objects.equals(position, that.position) && Objects.equals(remComp, that.remComp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, remComp, isLighten);
    }
}
