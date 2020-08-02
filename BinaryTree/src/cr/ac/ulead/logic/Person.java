package cr.ac.ulead.logic;

import java.time.LocalDate;

public class Person {

    private String id;
    private String name;
    private String lastname;
    private LocalDate birthday;

    public Person(String id, String name, String lastname, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
