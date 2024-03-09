package org.example.processing;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Patterns {
    public static ArrayList<Pattern> patterns;
    static {
        patterns = new ArrayList<>();
        patterns.add(Pattern.compile("[-]?[+]?\\b[0-9]+[*][X][\\^][0-9]+"));    // +-number * X ^ number
        patterns.add(Pattern.compile("[-]?[+]?\\b[0-9]+[X][\\^][0-9]+"));       // +-number X ^ number
        patterns.add(Pattern.compile("[-]?[+]?\\b[0-9]+[*][X]"));               // +-number * X
        patterns.add(Pattern.compile("[-]?[+]?\\b[0-9]+[X]"));                  // +-number X
        patterns.add(Pattern.compile("[-]?[+]?\\b[X][\\^][0-9]+"));             // +- X ^ number
        patterns.add(Pattern.compile("[-]?[+]?\\b[X]"));                        // +- X
        patterns.add(Pattern.compile("[-]?[+]?\\b[0-9]+"));                     // +-number
        //check expressions X200 maybe double passing through the string and checking the end result or switching pattern order
    }
}
