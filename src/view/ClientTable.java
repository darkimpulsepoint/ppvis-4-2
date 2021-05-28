package view;
import controller.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientTable {

    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    String[] columnNames = {"ФИО", "Номер счета", "Адрес", "Мобильный", "Домашний"};
    private Controller controller;
    private boolean used = false;
    private JButton nextPageBtn, previousPageBtn, lastPageBtn, firstPageBtn, choiceBtn;
    private int rowsPerPage = 8;
    private int thisPageNumber = 1;
    private int lastPage = 1;
    private JLabel PageLabel;
    private GridLayout grid;
    private JLabel thisPageLabel, descriptionLabel;
    private JTextField rowsChoice;

    public ClientTable(Controller controller) {
        this.table = new JTable();
        this.scrollPane = new JScrollPane(table);
        this.model = new DefaultTableModel();
        PageLabel = new JLabel();
        setPageLabel(PageLabel);
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setSize(new Dimension(800,300));

        scrollPane.setSize(new Dimension(800, 300));

        this.controller = controller;
        this.used = false;
        this.grid = new GridLayout();
        this.thisPageLabel = new JLabel();
        this.descriptionLabel = new JLabel();
        this.rowsChoice = new JTextField();

    }

    private void setPageLabel(JLabel label){
        label.setText(thisPageNumber+"/"+lastPage);
    }

    private void makePage(List<Client> list){
        clean();
        for (Client cli:list) {
            String fio = cli.getFio().getSurname()+" "+cli.getFio().getName()+" "+cli.getFio().getPatronymic();
            String[] row= {fio,cli.getAccountNumber(), cli.getAdress(), cli.getMobilePhone(), cli.getHomePhone() };
            model.addRow(row);
        }
        setPageLabel(PageLabel);
    }

    private void clean(){
        this.model=new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        scrollPane.setPreferredSize(new Dimension(245, 200));
    }

    public void makeTable(List<Client> list) {
        clean();
        controller = new Controller(list);
        numeration();
        makePage(controller.getPage(thisPageNumber, rowsPerPage));
    }

        public void numeration(){

        rowsChoice.setPreferredSize(new Dimension(50,20));
        thisPageNumber = 1;
        lastPage = controller.getLastPage(rowsPerPage);
        descriptionLabel.setText("Number of entries: " + controller.getSize() + "  ");

        choiceBtn = new JButton("Split");
        choiceBtn.setPreferredSize(new Dimension(100,20));
        choiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
//                    rowsPerPage = Integer.parseInt(rowsChoice.getText());
                    rowsPerPage=8;
                    thisPageNumber = 1;
                    makePage(controller.getPage(thisPageNumber, rowsPerPage));
                    lastPage = controller.getLastPage(rowsPerPage);
                    thisPageLabel.setText(thisPageNumber + "/" + lastPage);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Введите число");
                }
            }
        });

        firstPageBtn=new JButton("1");
        firstPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (thisPageNumber != 1) {
                    thisPageNumber = 1;
                    makePage(controller.getPage(thisPageNumber, rowsPerPage));
                    thisPageLabel.setText(thisPageNumber + "/" + lastPage);
                }
            }
        });

        lastPageBtn=new JButton(" >> ");
        lastPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (thisPageNumber != lastPage) {
                    thisPageNumber = lastPage;
                    makePage(controller.getPage(thisPageNumber, rowsPerPage));
                    thisPageLabel.setText(thisPageNumber + "/" + lastPage);
                }
            }
        });
        thisPageLabel.setText(thisPageNumber + "/" + lastPage);

    }

    public JButton getNextPageBtn(){
        nextPageBtn= new JButton(">");
        nextPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (thisPageNumber + 1 <= lastPage) {
                    thisPageNumber++;
                    makePage(controller.getPage(thisPageNumber, rowsPerPage));
                    thisPageLabel.setText(thisPageNumber + "/" + lastPage);
                    setPageLabel(PageLabel);
                }
            }
        });
        return nextPageBtn;
    }

    public JLabel getPageLabel(){
        return PageLabel;
    }

    public JButton getPreviousPageBtn(){
        previousPageBtn=new JButton("<");
        previousPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (thisPageNumber -1 > 0) {
                    thisPageNumber--;
                    makePage(controller.getPage(thisPageNumber, rowsPerPage));
                    thisPageLabel.setText(thisPageNumber + "/" + lastPage);
                    setPageLabel(PageLabel);
                }
            }
        });

        return previousPageBtn;
    }

    public JTable getTable(){
        return table;
    }

    public int getLastPageNumber(){
        return lastPage;
    }

    public int getThisPageNumber(){
        return thisPageNumber;
    }
}
