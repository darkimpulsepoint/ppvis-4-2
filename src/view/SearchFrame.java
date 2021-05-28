package view;

import controller.Controller;
import model.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchFrame {
    private Controller controller;
    private List<Client> searchList;
    private ClientTable table;

    public SearchFrame(Controller controller) {
        this.controller = controller;
        table = new ClientTable(new Controller(new ArrayList<Client>()));
        this.searchTeacher();
    }

    public void searchTeacher(){

        JLabel mobilePhone = new JLabel("Номер телефона");
        JComboBox<String> mobilePhones = new JComboBox<>();
            for(String fac:controller.getListOfMobilePhone()){
                mobilePhones.addItem(fac);
            }

        JLabel surnameList = new JLabel("Фамилия");

        JLabel accountNumberList = new JLabel("Номер счета");

        JLabel numbersInPhone = new JLabel("Цифры в телефоне");

        JButton searchByPhone = new JButton("Найти по телефону");

        JButton searchBySurname = new JButton("Найти по фамилии");
        JButton searchByAccountNumber = new JButton("Найти по номеру счета");
        JButton searchByAdress = new JButton("Найти по адресу");
        JButton searchByFioAndSomeNumbersOfPhone = new JButton("Найти по фамилии и цифрам телефона");

        JTextField phoneInput = new JTextField(20);

        JTextField surname_1_input = new JTextField(20);

        JTextField accountNumberInput = new JTextField(20);

        JTextField adressInput = new JTextField(20);

        JTextField surname_2_input = new JTextField(20);
        JTextField numberOfPhone = new JTextField(20);

        searchByPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchList = controller.findByPhone(phoneInput.getText());
                table.makeTable(searchList);
            }
        });

        searchBySurname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchList = controller.findBySurname(surname_1_input.getText());
                table.makeTable(searchList);
            }
        });

       searchByAccountNumber.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               searchList = controller.findByAccountNumber(accountNumberInput.getText());
               table.makeTable(searchList);
           }
       });

        searchByAdress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchList = controller.findByAdress(adressInput.getText());
                table.makeTable(searchList);
            }
        });

        searchByFioAndSomeNumbersOfPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchList = controller.findByFioAndSomeNumbersOfPhone(surname_2_input.getText(), numberOfPhone.getText());
                table.makeTable(searchList);
            }
        });


        JPanel panel=new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints=new GridBagConstraints();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        panel.add(mobilePhone,gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        panel.add(phoneInput,gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.gridheight=1;
        panel.add(new JLabel(" "), gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        panel.add(searchByPhone,gridBagConstraints);
// by account number
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=3;
        gridBagConstraints.gridheight=2;
        panel.add(new JLabel(" "), gridBagConstraints);

        gridBagConstraints.gridheight=1;
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=5;
        panel.add(accountNumberList, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=5;
        panel.add(accountNumberInput, gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=6;
        panel.add(new JLabel(" "), gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=7;
        panel.add(searchByAccountNumber, gridBagConstraints);
// by FIO and numbers in phone

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=8;
        panel.add(new JLabel(" "), gridBagConstraints);


        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=9;
        panel.add(surnameList, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=9;
        panel.add(surname_2_input, gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=10;
        panel.add(numberOfPhone, gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=10;
        panel.add(numbersInPhone, gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=12;
        panel.add(new JLabel(" "), gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=13;
        panel.add(searchByFioAndSomeNumbersOfPhone, gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=14;
        panel.add(new JLabel(" "), gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=15;
        panel.add(new JLabel(" "), gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=16;
        gridBagConstraints.gridwidth=2;
        panel.add(new JScrollPane(table.getTable()), gridBagConstraints);



        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setSize(600,800);


        frame.setVisible(true);

    }

}

