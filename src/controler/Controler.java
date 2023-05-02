package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import module.Request;
import view.*;

public class Controler implements ActionListener{
    private ArrayList<Request> requestsList;
    private Home home = new Home();
    private Add add = new Add();
    private Requests requests = new Requests();
       
    public Controler(){}
    
    public Controler(ArrayList<Request> requestsList){
        this.requestsList = requestsList;
        
        home.addRequest.addActionListener(this);
        home.viewRequests.addActionListener(this);
        add.home.addActionListener(this);
        add.submit.addActionListener(this);
        requests.home.addActionListener(this);     
    }
    
    public void start() {
        add.addingButtons();
        
        home.setTitle("Home");
        add.setTitle("Add");
        requests.setTitle("Requests");
        
        home.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "View requests":
                requests.setVisible(true);
                home.setVisible(false);
                break;
            case "Add request":
                add.setVisible(true);
                home.setVisible(false);
                break;
            case "Home":
                add.setVisible(false);
                requests.setVisible(false);
                home.setVisible(true);
                break;
        }
    }
}
