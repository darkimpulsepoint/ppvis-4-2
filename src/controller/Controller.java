package controller;
import model.Client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Client> clients;
    private PageOfTable page;

    public Controller(List<Client> list) {
        clients = list;
        page = new PageOfTable(clients);
    }

//----------
    public List<Client> load(File file){
        LoadController load = new LoadController();
        this.clients = load.parse(file);
        page = new PageOfTable(clients);
        return this.clients;
    }

    public  int getSize(){
        return  this.clients.size();
    }

    public void save(File file){
        SaveController save = new SaveController();
        save.parser(file, clients);
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void deleteClient(List<Client> client){
        for(Client cli : client){
            clients.remove(cli);
        }
    }

    public List<String> getListOfMobilePhone(){
        List<String> list= new ArrayList<>();  //FXCollections.observableArrayList();
        for(Client cli: clients) { list.add(cli.getMobilePhone()); }
        return list;
    }

    public List<Client> getClients(){
        return clients;
    }

    public List<Client> findByMobilePhonePhone(String Phone){
        List<Client> list= new ArrayList<>();
        for(Client cli: clients) {
            if (cli.getHomePhone().equals(Phone)||cli.getMobilePhone().equals(Phone))
                list.add(cli);
        }
        return list;
    }

    public List<Client> findByPhone(String Phone){
        List<Client> list= new ArrayList<>();
        for(Client cli: clients) {
            if (cli.getHomePhone().equals(Phone)||cli.getMobilePhone().equals(Phone))
                list.add(cli);
        }
        return list;
    }

    public List<Client> findByAccountNumber(String accountNumber){
        List<Client> list= new ArrayList<>();
        for(Client cli: clients) {
            if (cli.getAccountNumber().equals(accountNumber))
                list.add(cli);
        }
        return list;
    }


    public List<Client> findBySurname(String surname) {
        List<Client> list = new ArrayList<>();
        for (Client cli : clients) {
            if (cli.getFio().getSurname().equals(surname)) {
                list.add(cli);
            }
        }
            return list;
    }

    public List<Client> findByFioAndSomeNumbersOfPhone(String surname, String numbers){
        List<Client> list = new ArrayList<>();
        for (Client cli : clients) {
            if (cli.getFio().getSurname().equals(surname)&&cli.getMobilePhone().contains(numbers)) {
                if(!(numbers.equals("")||surname.equals("")))
                     list.add(cli);
            }
        }
        return list;
    }

    public List<Client> findByAdress(String adress) {
        List<Client> list = new ArrayList<>();
        for (Client cli : clients) {
            if (cli.getAdress().equals(adress)) {
                list.add(cli);
            }
        }
            return list;
    }

    public List<Client> getPage(int numberOfPage, int rowsInPage){
        return page.getPageOfTable(numberOfPage, rowsInPage);
    }

    public int getLastPage(int rowsPerPage){
        return page.calculateLastPage(rowsPerPage);
    }
}
