package at.fhj.swd.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String firstname;
    private String lastname;

    public User(int id, String firstname, String lastname) {
         setId(id);
         setFirstname(firstname);
         setLastname(lastname);
    }

    public User(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() { return firstname;}

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() { return lastname; }

}

