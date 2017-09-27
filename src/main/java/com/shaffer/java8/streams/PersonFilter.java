package com.shaffer.java8.streams;

import com.shaffer.common.Person;
import com.shaffer.common.Sex;

import java.util.List;
import java.util.stream.Collectors;

public class PersonFilter {
    public static List<Person> filterByMaleSex(List<Person> personList) {
        return personList.stream()
                .filter(p -> p.getSex() == Sex.MALE)
                .collect(Collectors.toList());
    }
}
