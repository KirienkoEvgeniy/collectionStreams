package org.demo;


public class Student {

    private String name;
    private double age;
    private int mark;

    public Student(String name, int mark, double age) {
        this.name = name;
        this.mark = mark;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }
}
