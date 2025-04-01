package test2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAbbreviations {

    public static List<String> converter(List<String> rowInfo) {

        Map<String, String> abbreviattions = new HashMap<>();
        abbreviattions.put("OD", "SEG. ODONTOLÓGICA");
        abbreviattions.put("AMB", "SEG. AMBULATORIAL");

        for (int i = 0; i < rowInfo.size(); i++) {
            if (abbreviattions.containsKey(rowInfo.get(i))) {
                rowInfo.set(i, abbreviattions.get(rowInfo.get(i)));

            }
        }
        return rowInfo;
    }
}