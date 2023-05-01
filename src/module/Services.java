package module;

import java.util.ArrayList;

public class Services {
    private ArrayList<String> names;
    private ArrayList<Double> costs;

    public Services(ArrayList<String> names, ArrayList<Double> costs) {
        this.names = names;
        this.costs = costs;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }          
}
