package infoshareacademy.library;

public class Employee {
    private int id;                 //  unikatowy nr pracownika
    private String userName;        // login pracownika
    private String password;        // hasło do logowania(może się przyda może nie)
    private String fullName;        // Pełne imię i nazwisko pracownika
    private boolean active;         // czy pracownik jest aktywny

    // konstruktor

    public Employee(int id, String userName, String password, String fullName, boolean active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.active = active;
    }

    // gettery i settery

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void printEmployee() {
        System.out.println("Id pracownika: " + id +
                " , Login: " + userName +
                " , Imię i nazwisko: " + fullName +
                " , Pracownik aktywny: " + active);
    }

}
