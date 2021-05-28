package controller;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import model.Teacher;
//import model.TeacherFIO;
import model.Client;
import model.FIO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

public class LoadController {

    public ArrayList<Client> parse(File file) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            LoaderHandler handler = new LoaderHandler();
            saxParser.parse(file, handler);
            return handler.getTeachers();
        }
        catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    private static class LoaderHandler extends DefaultHandler {

        private boolean boolsurname = false;
        private boolean boolname = false;
        private boolean boolpatronymic = false;
        private boolean boolhomephone = false;
        private boolean boolmobilephone = false;
        private boolean boolaccountnumber = false;
        private boolean booladress = false;

        private ArrayList<Client> clients = null;

        private Client client = null;
        private FIO clientFIO = null;
        private String data;

        public ArrayList<Client> getTeachers() {
            return clients;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(qName.equalsIgnoreCase("client")) {
                client = new Client();
                clientFIO = new FIO();
                if(clients == null) {
                    clients = new ArrayList<>();

                }
            }
            else if (qName.equalsIgnoreCase("surname")) {
                boolsurname = true;
            }
            else if (qName.equalsIgnoreCase("name")) {
                boolname = true;
            }
            else if (qName.equalsIgnoreCase("patronymic")) {
                boolpatronymic = true;
            }
            else if (qName.equalsIgnoreCase("homePhone")) {
                boolhomephone = true;
            }
            else if (qName.equalsIgnoreCase("mobilePhone")) {
                boolmobilephone = true;
            }
            else if (qName.equalsIgnoreCase("accountNumber")) {
                boolaccountnumber = true;
            }
            else if (qName.equalsIgnoreCase("adress")) {
                booladress = true;
            }

            data = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if(boolsurname) {
                clientFIO.setSurname(data);
                boolsurname = false;
            }
            else if (boolname) {
                clientFIO.setName(data);
                boolname = false;
            }
            else if (boolpatronymic) {
                clientFIO.setPatronymic(data);
                boolpatronymic = false;
            }
            else if (boolhomephone) {
                client.setHomePhone(data);
                boolhomephone = false;
            }
            else if (boolmobilephone) {
                client.setMobilePhone(data);
                boolmobilephone = false;
            }
            else if (boolaccountnumber) {
                client.setAccountNumber(data);
                boolaccountnumber = false;
            }
            else if (booladress) {
                client.setAdress(data);
                booladress = false;
            }

            if (qName.equalsIgnoreCase("client")) {
                client.setFio(clientFIO);
                clients.add(client);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            data = new String(ch, start, length);

        }
    }

}