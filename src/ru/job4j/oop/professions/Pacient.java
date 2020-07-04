package ru.job4j.oop.professions;

import java.util.Calendar;

public class Pacient {
    private String name;
    private String surname;
    private String diagnosis;
    private Calendar birthday;
    private Boolean isOperated;

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public Calendar getBirthday() {
        return this.birthday;
    }

    public Boolean getIsOperated() {
        return  this.isOperated;
    }
}
