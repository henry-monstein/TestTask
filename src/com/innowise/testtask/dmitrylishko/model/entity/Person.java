package com.innowise.testtask.dmitrylishko.model.entity;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String email;
    private String[] roles;
    private String[] phones;

    public Person() {
    }

    public Person(String name, String surname, String email, String[] roles, String[] phones) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getRole(int i) {
        return roles[i];
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void setRole(String role, int i) {
        this.roles[i] = role;
    }

    public String[] getPhones() {
        return phones;
    }

    public String getPhone(int i) {
        return phones[i];
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public void setPhone(String phone, int i) {
        this.phones[i] = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.hashCode() != o.hashCode()) return false;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(email, person.email) &&
                Arrays.equals(roles, person.roles) &&
                Arrays.equals(phones, person.phones);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, email);
        result = 353 * result + Arrays.hashCode(roles);
        result = 353 * result + Arrays.hashCode(phones);
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "; Surname: " + surname +
                "; Email: " + email +
                "; Roles: " + Arrays.toString(roles) +
                "; Phones: " + Arrays.toString(phones) + ";";
    }
}
