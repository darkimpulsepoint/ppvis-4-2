package controller;

import model.Client;

import java.util.List;

public class PageOfTable {
    private List<Client> listOfClients;

    PageOfTable(List<Client> list){
        listOfClients=list;
    }

    List<Client> getPageOfTable(int pageNumber,int rowsPerPage){
//        if()
        try {
            return listOfClients.subList((pageNumber - 1) * rowsPerPage, pageNumber * rowsPerPage);
        }catch (Exception e){
            return listOfClients.subList((pageNumber - 1) * rowsPerPage, listOfClients.size());
        }
    }

    public int calculateLastPage(int rowsPerPage){
        int lastPage;
        if(listOfClients.size()%rowsPerPage!=0){
            lastPage = listOfClients.size()/rowsPerPage+1;
        } else lastPage = listOfClients.size()/rowsPerPage;
        return lastPage;
    }
}
