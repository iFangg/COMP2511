package scrabble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scrabble {
    private int score;
    private String string;
    private ArrayList<String> subwords;
    private List<String> dictionary = new ArrayList<String>(Arrays.asList("ab", "abe", "able", "ad", "ae", "ae", "ah",
            "al", "ale", "at", "ate", "ba", "bad", "be", "be", "bead", "bed", "bra", "brad", "bread", "bred", "cabble",
            "cable", "ea", "ea", "eat", "eater", "ed", "ha", "hah", "hat", "hate", "hater", "hath", "he", "heat",
            "heater", "heath", "heather", "heathery", "het", "in", "io", "ion", "li", "lin", "lion", "on", "program",
            "ra", "rad", "re", "rea", "read", "red", "sa", "sat", "scabble", "scrabble", "se", "sea", "seat", "seathe",
            "set", "seth", "sh", "sha", "shat", "she", "shea", "sheat", "sheath", "sheathe", "sheather", "sheathery",
            "sheth", "st", "te"));

    public Scrabble(String s) {
        this.score = 0;
        this.string = s;
        this.subwords = new ArrayList<>();
    }

    public int score() {
        subwordCount(string);
        return score;
    }

    public String subwordCount(String s) {
        if (s.length() < 2) return s;
        // System.out.println(s);
        if (!dictionary.contains(s)) return s;
        // System.out.println("hey!\n");
        if (!subwords.contains(s)) {
            this.score++;
            subwords.add(s);
        } else {
            return s;
        }
        for (int i = 1; i <= s.length(); i++) {
            String newStr = s.substring(0, i - 1)  + s.substring(i, s.length());
            // System.out.println(newStr);
            subwordCount(newStr);
        }
        return s;
    }

    // Main function written for debugging purposes
    public static void main(String[] args) {
        String s = "lion";
        Scrabble test = new Scrabble(s);
        int result = test.score();
        System.out.println(result);
    }
}
