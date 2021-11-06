package lists;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorData {

    private static List<String> colorString;
    private static List<Color> colorList;

    public static void createLists() {
        colorString = new ArrayList<String>();
        colorList = new ArrayList<Color>();
        colorString.add("Black");
        colorList.add(Color.black);
        colorString.add("White");
        colorList.add(Color.white);
        colorString.add("Red");
        colorList.add(Color.red);
        colorString.add("Green");
        colorList.add(Color.green);
        colorString.add("Blue");
        colorList.add(Color.blue);
        colorString.add("Yellow");
        colorList.add(Color.yellow);
        colorString.add("Orange");
        colorList.add(Color.orange);
        colorString.add("Pink");
        colorList.add(Color.pink);
    }

    public static List<String> getColorString() {
        return colorString;
    }

    public static List<Color> getColorList() {
        return colorList;
    }

    public static String getColorInfo() {
        String output = "List of Colors: ";
        for (int i = 0; i < colorString.size(); i++) {
            output = output + colorString.get(i) + ", ";
        }
        return output;
    }
}
