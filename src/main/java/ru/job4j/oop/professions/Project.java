package ru.job4j.oop.professions;

import java.util.Calendar;

public class Project {
    private String name;
    private Calendar startDate;
    private Calendar endDate;

    public String getName() {
        return this.name;
    }

    public Calendar getStartDate() {
        return this.startDate;
    }

    public Calendar getEndDate() {
        return this.endDate;
    }
}
