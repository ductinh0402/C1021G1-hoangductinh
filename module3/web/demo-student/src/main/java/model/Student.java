package model;

public class Student {
    private int id;
    private String name;
    private String birthday;
    private String email;
    private double point;

    public Student() {
    }

    public Student(int id, String name, String birthday, String email, double point) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.point = point;
    }

    public Student(String name, String birthday, String email, double point) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
