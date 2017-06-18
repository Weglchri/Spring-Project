package com.mkyong.form.model;

public class User {

    private int id;
    private String firstname;
    private String lastname;

    public User(int id, String firstname, String lastname) {
         setUserId(id);
         setFirstname(firstname);
         setLastname(lastname);
    }

    public User(){}

    private void setUserId(int id) {
        this.id = id;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getUserId(){
        return id;
    }

    public String getFirstname() { return firstname;}

    public String getLastname() { return lastname; }
}

