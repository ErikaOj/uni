package base;

import java.util.*;

public class Person {
    public int id;
    public String name;
    public String nationalID;
    public static ArrayList<Person> personList = new ArrayList<>();
    private static int idCounter = 1;

    public Person(String name, String nationalID) {
        this.id = idCounter++;
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
    }

    public static Person findByID(int id) {
        for (Person person : personList) {
            if (person.id == id) {
                return person;
            }
        }
        return null;
    }
}