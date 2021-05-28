import com.sun.jdi.event.ClassUnloadEvent;
import controller.Controller;
import model.Client;
import view.AddFrame;
import view.ClientTable;
import view.MenuFrame;
import view.SearchFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main{
    public static void main(String[] args){
        List<Client> list = new ArrayList<Client>();
        Controller controller = new Controller(list);
        MenuFrame menuFrame = new MenuFrame(controller);
    }
}
