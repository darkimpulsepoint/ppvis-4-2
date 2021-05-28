package model;

public class Client {
    FIO fio;
    String accountNumber;
    String adress;
    String mobilePhone;
    String homePhone;


    public Client(){
        fio=null;
//        this.accountNumber=0;
        this.adress=null;
        this.mobilePhone=null;
        this.homePhone=null;
    }

    public Client(FIO fio, String mobilePhone, String homePhone, String adress, String accountNumber){
        this.fio=fio;
        this.mobilePhone=mobilePhone;
        this.homePhone=homePhone;
        this.adress=adress;
        this.accountNumber=accountNumber;
    }

    public void setFio(FIO fio){
        this.fio=fio;
    }

    public FIO getFio(){
        return fio;
    }

    public void  setMobilePhone(String mobilePhone){
        this.mobilePhone=mobilePhone;
    }

    public void setHomePhone(String homePhone){
        this.homePhone=homePhone;
    }

    public String getMobilePhone(){
        return mobilePhone;
    }

    public String getHomePhone(){
        return homePhone;
    }

    public void setSurname(String surname){
        this.fio.setSurname(surname);
    }

    public void setName(String name){
        this.fio.setSurname(name);
    }

    public void setPatronymic(String patronymic){
        this.fio.setPatronymic(patronymic);
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAdress(String adress){
        this.adress=adress;
    }

    public String getAdress(){
        return adress;
    }
}
