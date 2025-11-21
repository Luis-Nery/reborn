package iterating;

import java.util.Arrays;

public class loops {
    public static void main(String[] args) {
        forEachLoop();

    }

    public static void theForLoop(){
        System.out.println("This is the method of theForLoop");
        System.out.println("Here we will cover incrementing loops");

        //***
        //This is for the incrementing loops
        // ---
        // The following loop will print all numbers between 0 and 100
        for(int i=0;i<100;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        // Following loop will do all numbers between 1 and 100 inclusive
        for(int i=1;i<=100;i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        //The following loop will print all the even numbers between 1 and 100 inclusive
        for(int i=2; i<=100;i+=2){
            System.out.print(i + " ");
        }
        System.out.println();
        //The following loop will print all the odd numbers between 1 and 100 inclusive
        for(int i=1; i<=100;i+=2){
            System.out.print(i + " ");
        }
        //***
    }
    public static void theForLoopInverse(){
        System.out.println("This is the method of theForLoopInverse");
        //Here we will loop from 100 to 0 as in a decreasing motion
        for(int i=100;i>0;i--){
            System.out.print(i+" ");
        }
        System.out.println();
        //Here we will print all the even numbers between 100 and 1 inclusive in descending order
        for(int i=100;i>=1;i-=2){
            System.out.print(i+" ");
        }
        System.out.println();
        //Here we will print all the odd numbers between 100 and 1 inclusive in descending order
        for(int i=99;i>=1;i-=2){
            System.out.print(i+" ");
        }
    }
    public static void theNestedLoop(){
        System.out.println("This is the method of theNestedLoop");
        //Here we will print a simple pyramid to see the understanding of the double for loop
        for(int i=1;i<=3;i++){
            for(int j=3-i;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<2*i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void loopingOverArrays(){
        System.out.println("This is the method of loopingOverArrays");
        int[] array= new int[10];
        for(int i=0;i< array.length;i++){
            array[i]= i;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void forEachLoop(){
        System.out.println("This is the method of forEachLoop");
        int[] array= new int[10];
        for(int i=0;i<array.length;i++){
            array[i]= i;
        }
        for(int a: array){
            System.out.print(a+" ");
        }

    }
}
