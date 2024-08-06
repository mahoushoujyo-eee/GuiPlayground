package System;

public class Student {
    private String name;
    private String no;
    private String major;

    public Student(String name, String no, String major) {
        this.name = name;
        this.no = no;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
