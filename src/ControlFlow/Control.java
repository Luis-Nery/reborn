package ControlFlow;

public class Control {
    public static void main(String[] args) {
        ifPractice(20,30);
        whilePractice(4,3);
        switchPractice(21,30);

    }
    public static void ifPractice(int x, int y) {
        if(x==y){
            System.out.println("true");
        }else if (x==y+1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void whilePractice(int x, int y) {
        System.out.println(x+" "+y);
        while(x!=y){
            if(x>y){
                x--;
            }else {
                x++;
            }
            System.out.println(x+" "+y);
        }

        do {
            System.out.println("This should only print once!");
        }while(x!=y);
    }
    public static void switchPractice(int x, int y) {
        switch((x+y)%5){
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            default:
                System.out.println("An error occurred");
        }
    }
}
