package automap;

import controler.Controler;
import java.util.ArrayList;
import module.Request;

public class AutoMap {
    private static ArrayList<Request> requests = new ArrayList<Request>();
    
    public static void main(String[] args) {
       Controler controler = new Controler(requests); 
       
       controler.start();
    }
    
}
