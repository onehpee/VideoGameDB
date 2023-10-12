package org.example.User;

public class User {
    /**
     * id - unique
     * First Name
     * Last Name
     * UserName - unique
     * password
     * console
     *
     * getter and setter
     */
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String console;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getConsole(){
        return console;
    }

    public void setConsole(String console){
        this.console=console;
    }
}
