package CollectionPractice;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] array= new int[5];
        boolean[] bool= new boolean[5];
        char[] chars= new char[5];
        float[] floats= new float[5];
        double[] doubles= new double[5];
        String[] strings= new String[5];
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bool));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(strings));
        theArrayList();
    }
    public static void theArrayList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<20;i++){
            list.add(i);
        }
        list.get(0);
        list.remove(0);
        list.size();
        System.out.println(list);
    }
}
