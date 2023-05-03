package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
                
                fillTable();
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
    
    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) requests.table.getModel();
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        
        if(!requestsList.isEmpty()) {
            // Created row per request and filling the columns 
            for(int i = 0; i < requestsList.size(); i++) {
                model.addRow(new Object[]{requestsList.get(i).getOwner().getFirstName(), requestsList.get(i).getOwner().getLastName(), requestsList.get(i).getOwner().getPhoneNumber(),
                                  requestsList.get(i).getCar().getMake(), requestsList.get(i).getCar().getModel(), requestsList.get(i).getCar().getPlate(),
                                  requestsList.get(i).getState(), requestsList.get(i).getService(), requestsList.get(i).getTotal(), requestsList.get(i).isDelivery()});   
            }
            
            // Putting the columns contenct in the left side
            for(int i = 0; i < requests.table.getColumnCount(); i++) {
                requests.table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
            }
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
        } else {
            add.message.setText("Invalid data.");
        }
    }
}
