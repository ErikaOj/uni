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
        int count = 0;
        for (Student student : studentList) {
            if (student.majorID == this.majorID && student.entranceYear == this.entranceYear) {
                count++;
                break;
            }
        }
        this.studentID = entranceYear + String.valueOf(majorID) + String.format("%02d", count + 1);
    }


    public String toString() {
        return "Student {ID =" + id + ", Name =" + Person.findByID(personID).name +
                ", Student ID=" + studentID + ", Major ID =" + majorID + "}";
    }
}

