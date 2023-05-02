package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JTextField;
import module.Car;
import module.Person;
import module.Request;
import module.Tools;
import view.*;

public class Controler implements ActionListener{
    private ArrayList<Request> requestsList;
    private Home home = new Home();
    private Add add = new Add();
    private Requests requests = new Requests();
    
    Tools tools = new Tools();
       
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
            case "Submit":
                createRequest();
                break;
        }
    }
    
    private void createRequest() {
        ArrayList<JTextField> jTextFields = new ArrayList();
        
        jTextFields.add(add.firstName);
        jTextFields.add(add.lastName);
        jTextFields.add(add.phoneNumber);
        jTextFields.add(add.make);
        jTextFields.add(add.model);
        jTextFields.add(add.plate);
                
        String service = tools.getSelectedButtonText(add.getButtonGroup1());
                
        // Checkig that the phone number is valid, the user has selected any service and the JTextfields are not empty
        if(tools.isAPhoneNumber(add.phoneNumber.getText()) && service != null && !tools.areJTextFieldEmply(jTextFields)) {
            Person owner = new Person(add.firstName.getText(), add.lastName.getText(), Long.parseLong(add.phoneNumber.getText()));
            Car car = new Car(add.make.getText(), Integer.parseInt(add.model.getText()), add.plate.getText());
                    
            double total = tools.getServicesCost(service);
                    
            if(add.service7.isSelected()) {
                total += tools.getServicesCost("Delivery");
            }
                    
            Request request = new Request(owner, car, -1, service, total, add.service7.isSelected());
                    
            requestsList.add(request);
                    
           System.out.println(request.toString());
        }
    }
}
