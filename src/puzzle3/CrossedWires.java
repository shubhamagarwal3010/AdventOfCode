package puzzle3;

import java.util.ArrayList;
import java.util.HashMap;

public class CrossedWires {
    private ArrayList<Wire> grid = new ArrayList<>();
    private HashMap<WireType, Wire> wireNode = new HashMap<>();

    public int calculateManhattanDistance() {

        grid.add(new Wire(0, 0, true, true));
        wireNode.put(WireType.WIRE1, new Wire(0, 0));
        wireNode.put(WireType.WIRE2, new Wire(0, 0));

        WireData.WIRE1.forEach(wire -> createWirePath(wire.substring(0, 1), Integer.parseInt(wire.substring(1)), WireType.WIRE1));
        WireData.WIRE2.forEach(wire -> createWirePath(wire.substring(0, 1), Integer.parseInt(wire.substring(1)), WireType.WIRE2));

        int manhattanDistance = 0;
        for (Wire w : grid) {
            if (w.isCrossedByWire1() && w.isCrossedByWire2()) {
                int min = Math.abs(w.getX()) + Math.abs(w.getY());
                if (manhattanDistance == 0 || min < manhattanDistance) manhattanDistance = min;
            }
        }
        return manhattanDistance;
    }

    private void createWirePath(String direction, int length, WireType wireType) {
        for (int i = 1; i <= length; i++) {
            int x = wireNode.get(wireType).getX();
            int y = wireNode.get(wireType).getY();
            switch (direction) {
                case "U":
                    updateWireMap(new Wire(x, y - 1), wireType);
                    break;
                case "D":
                    updateWireMap(new Wire(x, y + 1), wireType);
                    break;
                case "L":
                    updateWireMap(new Wire(x - 1, y), wireType);
                    break;
                case "R":
                    updateWireMap(new Wire(x + 1, y), wireType);
                    break;
            }
        }
    }

    private void updateWireMap(Wire wire, WireType wireType) {
        int index = grid.indexOf(wire);
        if (index != -1) {
            if (wireType == WireType.WIRE1) grid.get(index).setCrossedByWire1();
            else grid.get(index).setCrossedByWire2();
        } else {
            if (wireType == WireType.WIRE1) wire.setCrossedByWire1();
            else wire.setCrossedByWire2();
            grid.add(wire);
        }
        wireNode.replace(wireType, wire);
    }

    private enum WireType {
        WIRE1,
        WIRE2
    }

}
