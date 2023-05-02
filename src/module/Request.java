package module;

import module.Person;

public class Request {
    private Person owner;
    private Car car;
    private int state; /*-1 Pending, 0 In process, 1 Finished*/
    private String service;
    private double total;
    private boolean delivery;
   

    public Request(Person owner, Car car, int state, String service, double total, boolean delivery) {
        this.owner = owner;
        this.car = car;
        this.state = state;
        this.service = service;
        this.total = total;
        this.delivery = delivery;
    }

    public Person getOwner() {
        return owner;
    }

    public Car getCar() {
        return car;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }  

    public String getService() {
        return service;
    }

    public double getTotal() {
        return total;
    }

    public boolean isDelivery() {
        return delivery;
    }
    
    public String toString() {
        return owner.toString() + car.toString() + "\nState: " + state + "\nService: " + service + "\nTotal: " + total + "\nDelivery: " + delivery;
    }
}
