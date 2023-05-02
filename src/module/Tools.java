package module;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class Tools {
    private  HashMap<String, Double> servicesCost = new HashMap<String, Double>();
    public Tools() {
        servicesCost.put("Hand wash", 50000.0);
        servicesCost.put("Integrated trolley dryer in the equipment", 890000.0);
        servicesCost.put("Special wash brushes", 123000.0);
        servicesCost.put("Special applications", 230000.0);
        servicesCost.put("Orcelain coating and bodywork crystallization", 4500000.0);
        servicesCost.put("Deep washing", 356000.0);
        servicesCost.put("Delivery", 100000.0);
    }
    
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    public boolean isAPhoneNumber(String phoneNumber) {
        String regex = "\\d{10}";
        
        return phoneNumber.matches(regex);
    }
    
    public boolean areJTextFieldEmply(ArrayList<JTextField> jTextFields) {
        for(int i = 0; i < jTextFields.size(); i++) {
            if(jTextFields.get(i).getText().isEmpty()) {
                return true;
            }
        }
        
        return false;
    }
    
    public Double getServicesCost(String service) {
        return servicesCost.get(service);
    }
}
