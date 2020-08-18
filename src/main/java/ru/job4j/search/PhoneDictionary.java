package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var combine = ((Predicate<Person>) person -> person.getName().contains(key))
                .or(person -> person.getSurname().contains(key))
                .or(person -> person.getPhone().contains(key))
                .or(person -> person.getAddress().contains(key));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
