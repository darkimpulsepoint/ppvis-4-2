package view;

import controller.Controller;
import model.Client;
import model.FIO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddFrame {

    private Controller controller;
    private JFrame newFrame;
    private ClientTable table;
    private GridBagConstraints gridBagConstraints;

    public AddFrame(Controller controller, ClientTable table) {
        this.controller = controller;
        newFrame = new JFrame();
        newFrame.setVisible(true);
        newFrame.setSize(600,600);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight=1;
        this.table = table;
        this.addClient();
    }

    public void addClient(){
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        JPanel panel1 = new JPanel(new GridBagLayout());
//        panel1.setBounds(0,0, 500,300);
        JLabel surname = new JLabel("Фамилия:");
        JTextField surnameField = new JTextField(20);

        panel1.add(surname, gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel1.add(surnameField, gridBagConstraints);

        JLabel name = new JLabel("Имя");

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=3;
        panel1.add(name, gridBagConstraints);

        JTextField nameField = new JTextField();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=4;
        panel1.add(nameField, gridBagConstraints);

        JLabel patronymic = new JLabel("Отчество");
        JTextField patronymicField = new JTextField();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=6;
        panel1.add(patronymic,gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=7;
        panel1.add(patronymicField, gridBagConstraints);


        JLabel accountNumber = new JLabel("Номер счета");
        JTextField accountNumberField = new JTextField();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=9;
        panel1.add(accountNumber,gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=10;
        panel1.add(accountNumberField,gridBagConstraints);

        JLabel adresd = new JLabel("Адрес");
        JTextField adressField = new JTextField();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=12;
        panel1.add(adresd,gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=13;
        panel1.add(adressField, gridBagConstraints);

        JLabel mobilePhone = new JLabel("Мобильный");
        JTextField mobilePhoneField = new JTextField();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=15;
        panel1.add(mobilePhone,gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=16;
        panel1.add(mobilePhoneField, gridBagConstraints);

        JLabel homePhone = new JLabel("Домашний");
        JTextField homePhoneField = new JTextField();

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=18;
        panel1.add(homePhone, gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=19;
        panel1.add(homePhoneField,gridBagConstraints);
        JButton addClient = new JButton("Добавить");

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=24;
        gridBagConstraints.gridheight=2;
        panel1.add(addClient, gridBagConstraints);

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!surnameField.getText().equals("") && !nameField.getText().equals("") && !patronymicField.getText().equals("")  &&
                        !accountNumberField.getText().equals("") && !adressField.getText().equals("") &&
                        !mobilePhoneField.getText().equals("") && !homePhoneField.getText().equals(""))
                {
                    controller.addClient(new Client(new FIO(surnameField.getText(), nameField.getText(), patronymicField.getText()),
                            mobilePhoneField.getText(), homePhoneField.getText(), adressField.getText(), accountNumberField.getText()));
                    table.numeration();
                    JOptionPane.showMessageDialog(null, "Клиент добавлен.");
                }
                else
                    {
                    JOptionPane.showMessageDialog(null, "Заполните все поля!");
                }
            }
       });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newFrame.setContentPane(panel1);
        newFrame.setVisible(true);
    }
}
