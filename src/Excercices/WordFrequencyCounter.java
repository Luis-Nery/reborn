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

    public static void printSortedByFrequency(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1,e2)->e2.getValue()-e1.getValue());
        for (Map.Entry<String,Integer> entry : list) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> freq = wordFrequency(text);
        printSortedByFrequency(freq);
// Should show: the=3, fox=2, quick=1, brown=1, etc.
    }
}
