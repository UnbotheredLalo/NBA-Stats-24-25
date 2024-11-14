package com.laloball.nbastats.api.utils;

import java.text.Normalizer;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * This method normalizes the user's input in case the String 'name' entered
     * does not exactly match the diacritics contained in the attribute of the 'Player' object and lowercase it
     * at the sametime
     * @param input (E.g. "luka doncic")
     * @return "Luka Dončić"
     */
    public static String normalize(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }

    /**
     * Method to concatenate strings with a comma, avoiding a comma at the beginning or end.
     * @param currentString The current string, which may be empty or have a value.
     * @param newString The new string to add.
     * @return The concatenated string with a comma, if not empty.
     */
    public static String concatenateWithComma(String currentString, String newString) {
        if (Objects.isNull(currentString) || currentString.isEmpty()) {
            return newString;
        }

        return currentString + ", " + newString;
    }
}
