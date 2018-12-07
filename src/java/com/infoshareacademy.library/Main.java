package java.com.infoshareacademy.library;

import infoshareacademy.library.Employee;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Library !");

        // przykładowy pracownik jeszcze nie pobierany z pliku zewnętrznego
        // hasło nie jest wyswietalne
        Employee jank = new Employee(1, "jank", "11111", "Jan Kowalski", true);
        jank.printEmployee();
    }
}
