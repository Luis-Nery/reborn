package Excercices;
import java.util.*;
public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        //Set<Integer> set = new HashSet<>(list);
        Set<Integer> set =  new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
    public static void main(String[]args){
        List<Integer> nums = Arrays.asList(5, 3, 5, 1, 3, 8, 1);
        System.out.println(removeDuplicates(nums));  // Should print [5, 3, 1, 8]
    }
}
