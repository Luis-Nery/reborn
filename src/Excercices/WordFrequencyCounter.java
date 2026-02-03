package Excercices;
import java.util.*;
public class WordFrequencyCounter {
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else {
                map.put(word, 1);
            }
        }

    return map;
    }

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> freq = wordFrequency(text);

        System.out.println();
// Should show: the=3, fox=2, quick=1, brown=1, etc.
    }
}
