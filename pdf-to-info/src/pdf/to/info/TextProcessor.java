/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.to.info;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phosseini
 */
public class TextProcessor {

    private List<String> TextNormalizer(String text) {
        List<String> lines = new ArrayList<>();
        text = text.replaceAll("\r\n", "\n");
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
        String reg = "^.*(" + GenerateKeyRegex(key) + ") *:.*$|" + "[" + GenerateKeyRegex(key) + "0-9.,\\/#!$%\\^&\\*;:{}=\\-_`~( ) ]+:[A-Za-z0-9.,\\/#!$%\\^&\\*;:{}=\\-_`~( ) ]+";
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).matches(reg)) {
                String[] fields = lines.get(i).split(":");
                return fields[1].trim();
            }
        }
        return "No value found!";
    }

    private String GenerateKeyRegex(String key) {
        String keyRegex = "";
        for (int i = 0; i < key.length(); i++) {
            if (Character.isLowerCase(key.charAt(i))) {
                keyRegex += Character.toString(key.charAt(i)).toUpperCase();
            } else if (Character.isUpperCase(key.charAt(i))) {
                keyRegex += Character.toString(key.charAt(i)).toLowerCase();
            }
            keyRegex += Character.toString(key.charAt(i));
        }
        return keyRegex;
    }
}
