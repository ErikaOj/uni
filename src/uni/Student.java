package uni;

import base.Person;

import java.util.*;

public class Student {
    public int id;
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;
    public static ArrayList<Student> studentList = new ArrayList<>();
    private static int idCounter = 1;

    public Student(int personID, int entranceYear, int majorID) {
        this.id = idCounter++;
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        setStudentCode();
        studentList.add(this);
    }

    public static Student findById(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    private void setStudentCode() {
        this.studentID = entranceYear + String.format("%02d",majorID) + String.format("%02d", id);
    }


    public String toString() {
        return "Student {ID =" + id + ", Name =" + Person.findByID(personID).name +
                ", Student ID=" + studentID + ", Major ID =" + majorID + "}";
    }
}

