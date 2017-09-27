package com.shaffer.java8.streams;

import com.shaffer.common.Person;
import com.shaffer.common.Sex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonFilterTest {
    @Test
    public void testfilterByMaleSexWithEmptyArray() {
        //Given
        List<Person> personList = new ArrayList<>();

        //When
        List<Person> filteredList =  PersonFilter.filterByMaleSex(personList);

        //then
        assertThat(filteredList.isEmpty(), is(true));
    }

    @Test
    public void testfilterByMaleSexWithPopulatedArray() {
        //Given
        List<Person> personList = Arrays.asList(
                new Person("Bob", 12, Sex.MALE),
                new Person("Martha", 24, Sex.FEMALE),
                new Person("Jim", 23, Sex.MALE),
                new Person("Emily",26, Sex.FEMALE),
                new Person("Leia", 52, Sex.FEMALE),
                new Person("Mark", 51, Sex.MALE),
                new Person("Julie", 5, Sex.FEMALE)
        );

        //When
        List<Person> filteredList =  PersonFilter.filterByMaleSex(personList);

        //then
        assertThat(filteredList.isEmpty(), is(false));
        assertThat(filteredList.size(), is(3));
        assertThat(filteredList.get(0).getName(), is("Bob"));
        assertThat(filteredList.get(1).getName(), is("Jim"));
        assertThat(filteredList.get(2).getName(), is("Mark"));
    }

    @Test
    public void testfilterBySexWithPopulatedArray() {
        //Given
        List<Person> personList = Arrays.asList(
                new Person("Bob", 12, Sex.MALE),
                new Person("Martha", 24, Sex.FEMALE),
                new Person("Jim", 23, Sex.MALE),
                new Person("Emily",26, Sex.FEMALE),
                new Person("Leia", 52, Sex.FEMALE),
                new Person("Mark", 51, Sex.MALE),
                new Person("Julie", 5, Sex.FEMALE)
        );

        //When
        List<Person> filteredList =  PersonFilter.filterBySex(personList, Sex.FEMALE);

        //then
        assertThat(filteredList.isEmpty(), is(false));
        assertThat(filteredList.size(), is(4));
        assertThat(filteredList.get(0).getName(), is("Martha"));
        assertThat(filteredList.get(1).getName(), is("Emily"));
        assertThat(filteredList.get(2).getName(), is("Leia"));
        assertThat(filteredList.get(3).getName(), is("Julie"));
    }
}
