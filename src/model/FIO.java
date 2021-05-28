package model;

public class FIO {
    private String surname;
    private String name;
    private String patronymic;

    public FIO(){
        this.name=null;
        this.surname=null;
        this.patronymic=null;
    }

    public FIO(String surname, String name, String patronymic){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPatronymic(String patronymic){
        this.patronymic=patronymic;
    }

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public String getPatronymic(){
        return patronymic;
    }

}
