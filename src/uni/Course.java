package uni;

import java.util.*;

public class Course {
    public int id;
    public String title;
    public int units;
    public static ArrayList<Course> courseList = new ArrayList<>();
    private static int idCounter = 1;

    public Course(String title, int units) {
        this.id = idCounter++;
        this.title = title;
        this.units = units;
        courseList.add(this);
    }

    public static Course findById(int id) {
        for (Course course : courseList) {
            if (course.id == id) {
                return course;
            }
        }
        return null;
    }
}