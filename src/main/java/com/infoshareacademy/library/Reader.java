package com.infoshareacademy.library;

public class Reader {
    private int id;                 // unikatowe id
    private String firstName;       // imię czytelnika
    private String lastName;        // nazwisko czytelnika
    private String phoneNumber;     // nr tel czytelnika
    private String email;           // email czytelnika
    private boolean active;         // czy aktywny, czy zablokowany

    // Konstruktor

    public Reader(int id, String firstName, String lastName, String phoneNumber, String email, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.active = active;
    }

    // gettery & settery


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void printReader(){
        System.out.println("Id czytelnika: " + id +
                " Imię: " + firstName +
                " Nazwisko: " + lastName +
                " Nr tel: " + phoneNumber +
                " Email: " + email +
                " Aktywny: " + active);
    }

}
