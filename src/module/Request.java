package module;

public class Request {
    private Person owner;
    private Car car;
    private int state; /*-1 Pending, 0 In process, 1 Finished*/
   

    public Request(Person owner, Car car, int state) {
        this.owner = owner;
        this.car = car;
        this.state = state;
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
}
