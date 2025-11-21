package OOProject1;

public class ToyotaCorolla extends Vehicle {
    private String color;
    public ToyotaCorolla(boolean isOn, int gasLevelPercentage, boolean[] wheelCondition,String color) {
        super(isOn, gasLevelPercentage, wheelCondition);
        this.color = color;
    }

}
