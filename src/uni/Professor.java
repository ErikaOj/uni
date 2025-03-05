package uni;

import base.Person;

import java.util.*;

public class Professor {
    public int id;
    public int personID;
    public int majorID;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    private static int idCounter = 1;

    public Professor(int personID, int majorID) {
        this.id = idCounter++;
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public static Professor findById(int id) {
        for (Professor professor : professorList) {
            if (professor.id == id) {
                return professor;
            }
        }
        return null;
    }

    public String toString() {
        return "Professor {ID =" + id + ", Name =" + Person.findByID(personID).name +
                ", Major ID =" + majorID + "}";
    }
}

