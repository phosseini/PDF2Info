/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.to.info;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author phosseini
 */
public class TextProcessor {

    private List<String> TextNormalizer(String text) {
        List<String> lines = new ArrayList<>();
        text = text.replaceAll("\r\n", "\n");
        text = text.replace(new String(Character.toChars(160)), " ");
        text = text.replace("  ", " ");
        String[] allLines = text.split("\n");
        for (int i = 0; i < allLines.length; i++) {
            if (!allLines[i].trim().replace("\n", "").replace(" ", "").equals("")) {
                lines.add(allLines[i].trim().replace("\n", ""));
            }
        }
        return lines;
    }

    public String ExtractFields(String text, String key) {
        List<String> lines = TextNormalizer(text);
        for (int i = 0; i < lines.size(); i++) {
            if (IsMatchKey(key, lines.get(i).trim())) {
                String[] fields = lines.get(i).split(":");
                return fields[1].trim();
            }
        }
        return "No value found!";
    }

    private boolean IsMatchKey(String key, String line) {
        // Case: Getting full string for userKey (case insensitive) matches
        Pattern p1 = Pattern.compile(String.format("(?i)(.*%s.*\\s?.*:\\s*?.*)", key));
        Matcher matcher1 = p1.matcher(line);
        if (matcher1.matches()) {
            return true;
        }
        return false;
    }
}