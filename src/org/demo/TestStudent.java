package org.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStudent {

    public static void main(String[] args) {

        Student student = new Student("name1", 1, 33);
        Student student1 = new Student("name2", 11, 23);
        Student student2 = new Student("name3", 5, 35);
        Student student3 = new Student("name4", 6, 65);
        Student student4 = new Student("name5", 4, 55);


        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

// получить Set который содержит имена студентов
        Set<Student> collect = studentList.stream().collect(Collectors.toSet());
        for (Student stud : collect) {
            System.out.println("Student name -> " +stud.getName());
        }
        System.out.println();

//получить Map где ключ - name,значение - объект Student (1)
        Map<String, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getName,
                Function.identity()));
        for (String s : studentMap.keySet()) {
            System.out.println("Key -> "+ s + "  Value -> " + studentMap.get(s));
        }
        System.out.println();

//получить List студентов, отсортированных по age
        List<Student> sortedStudent = studentList.stream().sorted(Comparator.comparing(Student::getAge).
                reversed()).collect(Collectors.toList());
        sortedStudent.forEach(e -> System.out.println("Name:"+ e.getName()+", Age: "+e.getAge()+", Mark:"+e.getMark()));
        System.out.println();

//посчитать количество студентов с списке
        long count = studentList.stream().count();
        System.out.println("number of students on the list -> " + count);
        System.out.println();

//посчитеть количество уникальных студентов в списке (distinct)
        long countDistinct = studentList.stream().distinct().count();
        System.out.println("number of unique students on the list -> " + countDistinct);
        System.out.println();

//    распечатать содержимое Map в формате ключ = знаяение, используя форматируемый вывод (String.format)

        studentMap.entrySet().stream().forEach(entry->{
            System.out.println(String.format("%s  = %s %f %d ", entry.getKey(),
                    entry.getValue().getName(), entry.getValue().getAge(), entry.getValue().getMark()));
        });
        studentMap.entrySet().stream().forEach(entry->{
        System.out.println(String.format("Key = %s Name = %s  ", entry.getKey(),
                entry.getValue()));
    });
        System.out.println();

//преобразовать Map в Set который будет содержать age студентов

        studentMap.values().stream().collect(Collectors.toSet()).forEach(entry ->{
            System.out.print(String.format(" %f ", entry.getAge()));});
    }

}
