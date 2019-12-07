package puzzle3;

import java.util.Objects;

public class Wire {
    private int x;
    private int y;
    private boolean isCrossedByWire1;
    private boolean isCrossedByWire2;

    Wire(int x, int y, boolean isCrossedByWire1, boolean isCrossedByWire2) {
        this.x = x;
        this.y = y;
        this.isCrossedByWire1 = isCrossedByWire1;
        this.isCrossedByWire2 = isCrossedByWire2;
    }

    Wire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    boolean isCrossedByWire1() {
        return isCrossedByWire1;
    }

    void setCrossedByWire1() {
        isCrossedByWire1 = true;
    }

    boolean isCrossedByWire2() {
        return isCrossedByWire2;
    }

    void setCrossedByWire2() {
        isCrossedByWire2 = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wire that = (Wire) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
