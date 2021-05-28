package view;

import controller.Controller;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteFrame {
    private Controller controller;
    private JFrame newFrame;
    private ClientTable table;
    private List<Client> deleteList, resultList;

    public DeleteFrame(Controller controller, ClientTable table) {
        this.controller = controller;
        newFrame = new JFrame();
        newFrame.setSize(600,800);
        this.table = table;
        delete();
    }

    public void delete() {

        JLabel bySurname = new JLabel("Фамилия");
        JTextField surname_1_input = new JTextField(15);
        JButton deleteBySurname = new JButton("Удалить по фамилии");

        JLabel byMobilePhone = new JLabel("Номер телефона");
        JTextField mobilePhoneInput = new JTextField(15);
        JButton deleteByMobilePhone = new JButton("Удалить по номеру телефона");
////////////////////

        JLabel byAccountNumber = new JLabel("Номер счета");
        JTextField accountNumberInput = new JTextField(15);
        JButton deleteByAccountNumber = new JButton("Удалить по номеру счета");
////////////////////
        JLabel byAdress = new JLabel("Адрес");
        JTextField adressInput = new JTextField();
        JButton deleteByAdress = new JButton("Удалить по адресу");
///////////////////

        deleteBySurname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteList = controller.findBySurname(surname_1_input.getText());
                controller.deleteClient(deleteList);
                dialog(deleteList.size());
                table.numeration();
            }
        });

        deleteByAdress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteList = controller.findByAdress(adressInput.getText());
                controller.deleteClient(deleteList);
                dialog(deleteList.size());
                table.numeration();
            }
        });

        deleteByMobilePhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteList = controller.findByMobilePhonePhone(mobilePhoneInput.getText());
                controller.deleteClient(deleteList);
                dialog(deleteList.size());
                table.numeration();
            }
        });

        deleteByAccountNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteList = controller.findByAccountNumber(accountNumberInput.getText());
                controller.deleteClient(deleteList);
                dialog(deleteList.size());
                table.numeration();
            }
        });

        JPanel contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx=0;
        constraints.gridy=0;
        contentPane.add(bySurname, constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        contentPane.add(surname_1_input,constraints);

        constraints.gridx=0;
        constraints.gridy=2;
        contentPane.add(deleteBySurname, constraints);

        constraints.gridx=0;
        constraints.gridy=3;
        contentPane.add(new JLabel(" "), constraints);

        constraints.gridx=0;
        constraints.gridy=4;
        contentPane.add(byMobilePhone, constraints);

        constraints.gridx=0;
        constraints.gridy=5;
        contentPane.add(mobilePhoneInput,constraints);

        constraints.gridx=0;
        constraints.gridy=6;
        contentPane.add(deleteByMobilePhone, constraints);

        constraints.gridx=0;
        constraints.gridy=7;
        contentPane.add(new JLabel(" "), constraints);
        //
        constraints.gridx=0;
        constraints.gridy=8;
        contentPane.add(byAccountNumber,constraints);

        constraints.gridx=0;
        constraints.gridy=9;
        contentPane.add(accountNumberInput,constraints);

        constraints.gridx=0;
        constraints.gridy=10;
        contentPane.add(deleteByAccountNumber,constraints);

        constraints.gridx=0;
        constraints.gridy=11;
        contentPane.add(new JLabel(" "), constraints);

        newFrame.setVisible(true);
        newFrame.setTitle("Удаление");
        newFrame.setContentPane(contentPane);
    }

    private void dialog(int counter) {
        JOptionPane.showMessageDialog(null, "Было удалено " + counter);
    }
}
