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
 * @author Pedram Hosseini
 */
public class TextProcessor {

    /**
     * Normalizing the PDF text
     *
     * @param text
     */
    private List<String> TextNormalizer(String text) {

        // we store all the nomalized lines in lines list
        List<String> lines = new ArrayList<>();

        //removing some extra characters
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

    /**
     * Searching a field using a search key
     *
     * @param text
     * @param key
     */
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

    /**
     * Checking whether a line is a match using a key or not
     *
     * @param key
     * @param line
     */
    private boolean IsMatchKey(String key, String line) {
        // Case: Getting full string for userKey (case insensitive) matches
        Pattern p = Pattern.compile(String.format("(?i)(.*%s.*\\s?.*:\\s*?.*)", key));
        Matcher matcher = p.matcher(line);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
