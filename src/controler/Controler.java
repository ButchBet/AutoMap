package controler;

import java.util.ArrayList;
import module.Request;
import view.*;

public class Controler {
    private ArrayList<Request> requestsList;
    private Home home = new Home();
    private Add add = new Add();
    private Requests requests = new Requests();
    
    
    
    public Controler(){}
    
    public Controler(ArrayList<Request> requests){
        this.requestsList = requests;
    }
    
    public void start() {
        add.addingButtons();
        add.setVisible(true);
    }
}
