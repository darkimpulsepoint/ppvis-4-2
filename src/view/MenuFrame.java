package view;

import controller.Controller;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class MenuFrame {

    private Controller controller;
    private JFrame frame;
    private ClientTable clientTable;
    private JFileChooser FileChooser;
    private GridBagConstraints constraints;

    public MenuFrame(Controller controller) {
        this.controller = controller;
        this.frame = new JFrame();
        this.frame.setSize(600,800);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.clientTable = new ClientTable(this.controller);
        constraints = new GridBagConstraints();
        show();
    }

    private void setLabelCurrentPage(JLabel label){
        label.setText("Текущая страница: " + clientTable.getThisPageNumber());
    }

    private void setLabelLastPage(JLabel label){
        label.setText("Последняя страница: " + clientTable.getLastPageNumber());
    }

    private boolean tableCreated = false;
    private String pathFile;    // имя файла
    private Desktop desktop = Desktop.getDesktop();

    public void show() {
        frame.setTitle("menu");

        JButton openButton = new JButton("Открыть файл"); //open & load file

        JButton searchButton = new JButton("Поиск"); //search

        JButton addButton = new JButton("Добавить");

        JButton deleteButton = new JButton("Удалить");

        JButton saveButton = new JButton("Сохранить");

        JLabel currentPage = new JLabel();
        setLabelCurrentPage(currentPage);

        JLabel maximumPage = new JLabel();
        setLabelLastPage(maximumPage);

        JButton refresh = new JButton();

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "XML files", "xml");
                chooser.setFileFilter(filter);

                chooser.showDialog(null,"выбрать");

                File selectedFile = chooser.getSelectedFile();
                if (selectedFile != null) {
                    List loadResult = controller.load(selectedFile);    //получаем массив из xml файла
//                    clientTable.clean();
                    clientTable.makeTable(controller.getClients());
                    pathFile = selectedFile.getName();
                }

                setLabelCurrentPage(currentPage);
                setLabelLastPage(maximumPage);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SearchFrame search = new SearchFrame(controller);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteFrame deleteFrame = new DeleteFrame(controller, clientTable);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddFrame addFrame = new AddFrame(controller, clientTable);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
                fileChooser.setFileFilter(filter);
                fileChooser.showDialog(null, "сохранить");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    controller.save(file);
                    System.out.println(file.getName());
                }
            }
        });

        JButton nextPage =clientTable.getNextPageBtn();
        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setLabelCurrentPage(currentPage);
            }
        });

        JButton prevPage = clientTable.getPreviousPageBtn();
        prevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setLabelCurrentPage(currentPage);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientTable.makeTable(controller.getClients());
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        constraints.insets = new Insets(0,20,0,20);
        constraints.fill=GridBagConstraints.HORIZONTAL;
//        constraints.gridwidth=1;
//        constraints.weightx=0.2;
        constraints.gridx=0;
        constraints.gridy=0;
        panel.add(openButton,constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        panel.add(searchButton,constraints);

        constraints.gridx=0;
        constraints.gridy=2;
        panel.add(addButton,constraints);

        constraints.gridx=0;
        constraints.gridy=3;
        panel.add(deleteButton,constraints);

        constraints.gridx=0;
        constraints.gridy=4;
        panel.add(saveButton,constraints);

        constraints.gridx=0;
        constraints.gridy=5;
        panel.add(new JLabel(" "), constraints);

        constraints.gridx=0;
        constraints.gridy=6;
        panel.add(nextPage, constraints);

//        constraints.anchor=GridBagConstraints.EAST;
        constraints.gridx=0;
        constraints.gridy=7;
        panel.add(prevPage, constraints);

        constraints.gridx=0;
        constraints.gridy=8;
        panel.add(refresh, constraints);

        constraints.gridx=0;
        constraints.gridy=9;
        panel.add(clientTable.getPageLabel(), constraints);

        constraints.gridx=0;
        constraints.gridy=10;
        constraints.weightx=1;
        constraints.gridwidth=3;
        panel.add(new JScrollPane(clientTable.getTable()), constraints);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }


    private void removeTable(){
        //groupOfElements.getChildren().remove(ТУТ БУДЕТ ТВОЯ ТАБЛИЦА);
        tableCreated = false;
    }

}
