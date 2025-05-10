package org.interview.questions.sorting;

import java.util.*;

public class ComparatorSorting {

    static List<Person> persons = new ArrayList<>();
        static {
            persons.add(new Person("Gagan","Ubbey",46));
            persons.add(new Person("Nidhi","Ubbey",39));
            persons.add(new Person("Kimanya","Ubbey",12));
            persons.add(new Person("Yajat","Ubbey",10));
        }
    public static void main(String[] args) {
        System.out.println(persons);
        Comparator<Person> byFirstName = Comparator.comparing(Person::getFirstName);
        Comparator<Person> byLastName = Comparator.comparing(Person::getLastName);
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Comparator<Person> byFirstNameThenLastName = Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName);

        persons.sort(byFirstName);
        System.out.println("Sorted by first name "+persons);
        persons.sort(byLastName);
        System.out.println("Sorted by last name "+persons);
        persons.sort(byAge);
        System.out.println("Sorted by Age name "+persons);
        persons.sort(byFirstNameThenLastName);
        System.out.println("Sorted by first name then last name "+persons);

    }

}


class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}