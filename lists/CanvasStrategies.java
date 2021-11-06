package lists;

import java.util.HashMap;
import java.util.Map;

import src.interfaces.*;
import src.shapes.Point;

public class CanvasStrategies {

    public static Map<String, IFunction> createStrategies(ICanvas c) {
        Map<String, IFunction> strategies = new HashMap<String, IFunction>();
        strategies.put("Shape", (value) -> c.changeShape((int) value));
        strategies.put("cExt", (value) -> c.changeColorExter((int) value));
        strategies.put("cInt", (value) -> c.changeColorInter((int) value));
        strategies.put("Click", (point) -> c.selectShape((Point) point));
        strategies.put("trash", (o) -> c.removeSelected());
        return strategies;
    }
}
