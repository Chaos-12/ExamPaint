package lists;

import java.util.HashMap;
import java.util.Map;

import src.interfaces.*;
import src.shapes.Point;

public class PainterStrategies {

    public static Map<String, IFunction> createStrategies(IPainter painter) {
        Map<String, IFunction> strategies = new HashMap<String, IFunction>();
        strategies.put("Shape", (value) -> painter.setShapeBuilder((int) value));
        strategies.put("cExt", (value) -> painter.setColorExt((int) value));
        strategies.put("cInt", (value) -> painter.setColorInt((int) value));
        strategies.put("initPoint", (p) -> painter.setInitialPoint((Point) p));
        strategies.put("endPoint", (p) -> {
            painter.setEndPoint((Point) p);
            painter.paintShape();
        });
        return strategies;
    }
}