package module;

import module.Person;

public class Request {
    private Person owner;
    private Car car;
    private int state; /*-1 Pending, 0 In process, 1 Finished*/
    private String service;
   

    public Request(Person owner, Car car, int state, String service) {
        this.owner = owner;
        this.car = car;
        this.state = state;
        this.service = service;
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
}
