package ru.job4j.oop.professions;

import java.util.Calendar;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private Calendar birthday;

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEducation() {
        return this.education;
    }

    public Calendar getBirthday() {
        return  this.birthday;
    }
}
