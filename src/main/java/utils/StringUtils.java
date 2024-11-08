package utils;

import java.text.Normalizer;
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
}
