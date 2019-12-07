package puzzle3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrossedWires {
    private ArrayList<Wire> grid = new ArrayList<>();
    private HashMap<WireType, Wire> wireNode = new HashMap<>();

    public CrossedWires() {
        grid.add(new Wire(0, 0, true, true));
        wireNode.put(WireType.WIRE1, new Wire(0, 0));
        wireNode.put(WireType.WIRE2, new Wire(0, 0));

        WireData.WIRE1.forEach(wire -> createWirePath(wire.substring(0, 1), Integer.parseInt(wire.substring(1)), WireType.WIRE1));
        WireData.WIRE2.forEach(wire -> createWirePath(wire.substring(0, 1), Integer.parseInt(wire.substring(1)), WireType.WIRE2));
    }

    public int calculateManhattanDistance() {
        int manhattanDistance = 0;
        for (Wire w : grid) {
            if (w.isCrossedByWire1() && w.isCrossedByWire2()) {
                int min = Math.abs(w.getX()) + Math.abs(w.getY());
                if (manhattanDistance == 0 || min < manhattanDistance) manhattanDistance = min;
            }
        }
        return manhattanDistance;
    }

    public int calculateFewestCombinedStepsToReachIntersection() {
        int totalDistance = 0;
        for (Wire w : grid) {
            if (w.isCrossedByWire1() && w.isCrossedByWire2()) {
                int min = navigateWireAndGetTotalLength(WireType.WIRE1, w) + navigateWireAndGetTotalLength(WireType.WIRE2, w);
                if (totalDistance == 0 || min < totalDistance) totalDistance = min;
            }
        }
        return totalDistance;
    }

    private int navigateWireAndGetTotalLength(WireType wireType, Wire wireNode) {
        List<String> wireData = wireType == WireType.WIRE1 ? WireData.WIRE1 : WireData.WIRE2;
        int totalLength = 0;
        Wire wire = new Wire(0, 0);
        for (String wireLine : wireData) {
            String direction = wireLine.substring(0, 1);
            int length = Integer.parseInt(wireLine.substring(1));
            for (int i = 0; i < length; i++) {
                switch (direction) {
                    case "U":
                        wire.setX(wire.getX());
                        wire.setY(wire.getY() - 1);
                        break;
                    case "D":
                        wire.setX(wire.getX());
                        wire.setY(wire.getY() + 1);
                        break;
                    case "L":
                        wire.setX(wire.getX() - 1);
                        wire.setY(wire.getY());
                        break;
                    case "R":
                        wire.setX(wire.getX() + 1);
                        wire.setY(wire.getY());
                        break;
                }
                totalLength++;
                if (wireNode.equals(wire)) {
                    return totalLength;
                }
            }
        }
        return totalLength;
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
