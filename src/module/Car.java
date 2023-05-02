package module;

public class Car {
    private String make;
    private int model;
    private String plate;

    public Car(String make, int model, String plate) {
        this.make = make;
        this.model = model;
        this.plate = plate;
    }

    public String getMake() {
        return make;
    }

    public int getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }
    
    public String toString() {
        return "\nMake: " + make + "\nModel: " + model + "\nPlate: " + plate; 
    }
}
