package System;

import java.util.ArrayList;

public class Course {
    private String name;
    private int capacity;
    private ArrayList<String> majors;

    public Course(String name, int capacity, ArrayList<String> majors) {
        this.name = name;
        this.capacity = capacity;
        this.majors = majors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<String> majors) {
        this.majors = majors;
    }
}
