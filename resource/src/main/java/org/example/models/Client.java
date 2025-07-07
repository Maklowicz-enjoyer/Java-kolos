package org.example.models;

public class Client {

    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Client(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }



}
