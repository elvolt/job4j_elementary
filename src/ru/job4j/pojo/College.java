package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setPatronymic("Ivanovich");
        student.setGroupNum(2);
        student.setDateOfAdmission(LocalDate.of(1992, 12, 2));

        System.out.println("Student: "
                + String.join(" ", student.getSurname(), student.getName(), student.getPatronymic())
                + ".\nDate of admission: " + student.getDateOfAdmission()
                + ".\nGroup: " + student.getGroupNum());
    }
}
