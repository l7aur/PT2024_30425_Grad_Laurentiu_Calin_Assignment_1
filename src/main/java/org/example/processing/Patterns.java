package org.example.processing;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Patterns {
    public static ArrayList<Pattern> patterns2;
    static {
        patterns2 = new ArrayList<>();
        patterns2.add(Pattern.compile("[-|+]\\b[0-9]+\\*X\\^[0-9]+"));  // +-number * X ^ number
        patterns2.add(Pattern.compile("[0-9]+\\*X\\^[0-9]+"));          // number * X ^ number

        patterns2.add(Pattern.compile("[-|+]\\b[0-9]+X\\^[0-9]+"));     // +-number X ^ number
        patterns2.add(Pattern.compile("[0-9]+X\\^[0-9]+"));             // number X ^ number

        patterns2.add(Pattern.compile("[-|+]\\b[0-9]+\\*X"));           // +-number * X
        patterns2.add(Pattern.compile("[0-9]+\\*X"));                   // number * X

        patterns2.add(Pattern.compile("[-|+]\\b[0-9]+X"));              // +-number X
        patterns2.add(Pattern.compile("[0-9]+X"));                      // +-number X

        patterns2.add(Pattern.compile("[-|+]\\bX\\^[0-9]+"));           // +- X ^ number
        patterns2.add(Pattern.compile("X\\^[0-9]+"));                   //  X ^ number

        patterns2.add(Pattern.compile("[-|+]\\bX"));                    // +- X
        patterns2.add(Pattern.compile("X"));                            //  X

        patterns2.add(Pattern.compile("[-|+]\\b[0-9]+"));               // +-number
        patterns2.add(Pattern.compile("[0-9]+"));                       // number
    }
}
