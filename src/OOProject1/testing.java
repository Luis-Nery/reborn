package OOProject1;

public class testing {
    public static void main(String[] args) {
        ToyotaCorolla pearl = new ToyotaCorolla(false,100, new boolean[4],"White");
        boolean [] pearlWheel =  new boolean[4];
        pearlWheel[3] = true;
        pearl.setAreWheelsDamaged(pearlWheel);
        System.out.println(pearl.areWheelsDamaged());
    }
}
