package OOProject1;

import java.util.Arrays;

abstract class Vehicle implements VehicleFunctions {
    private final int WHEELCOUNT = 4;
    private boolean[] areWheelsDamaged = new boolean[WHEELCOUNT];
    private boolean isOn;
    private int gasLevelPercentage;

    public Vehicle(boolean isOn,int gasLevelPercentage,boolean[] wheelCondition) {
        this.isOn=isOn;
        this.gasLevelPercentage=gasLevelPercentage;
        this.areWheelsDamaged=wheelCondition;
    }

    @Override
    public void turnOn() {
        System.out.println("Vehicle turned on.");
        this.isOn=true;
    }

    @Override
    public void turnOff() {
        System.out.println("Vehicle turned off.");
        this.isOn=false;
    }

    @Override
    public int fuelUp(int fuelAdded) {
        System.out.println("Vehicle fueled up.");
        this.gasLevelPercentage=this.gasLevelPercentage+fuelAdded;
        return this.gasLevelPercentage;
    }
    public boolean areWheelsDamaged(){
        boolean wheelDamaged=false;
        for(int i=0;i<this.areWheelsDamaged.length;i++){
            if(this.areWheelsDamaged[i]){
                System.out.println(i+1);
                wheelDamaged=true;
            }
        }
        System.out.println("Wheel status"+ Arrays.toString(areWheelsDamaged));
        return wheelDamaged;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public int getGasLevelPercentage() {
        return this.gasLevelPercentage;
    }

    public void setGasLevelPercentage(int gasLevelPercentage) {
        this.gasLevelPercentage = gasLevelPercentage;
    }
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setAreWheelsDamaged(boolean[] areWheelsDamaged) {
        this.areWheelsDamaged = areWheelsDamaged;
    }
}
