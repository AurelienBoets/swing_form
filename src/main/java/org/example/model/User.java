package org.example.model;

public class User {
    private String name;
    private String mail;
    private String gender;

    public User(String name, String mail, String gender) {
        this.name = name;
        this.mail = mail;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
