package com.mongoconnect.mongoconnect.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpendINBooks;
    private LocalDateTime created;

    public String getId() {
        return id;
    }

    public Student(String firstName, String lastName, String email, Gender gender, Address address, BigDecimal totalSpendINBooks, List<String> favoriteSubjects, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.totalSpendINBooks = totalSpendINBooks;
        this.favoriteSubjects = favoriteSubjects;
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getFavoriteSubjects() {
        return favoriteSubjects;
    }

    public BigDecimal getTotalSpendINBooks() {
        return totalSpendINBooks;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFavoriteSubjects(List<String> favoriteSubjects) {
        this.favoriteSubjects = favoriteSubjects;
    }

    public void setTotalSpendINBooks(BigDecimal totalSpendINBooks) {
        this.totalSpendINBooks = totalSpendINBooks;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && gender == student.gender && Objects.equals(address, student.address) && Objects.equals(favoriteSubjects, student.favoriteSubjects) && Objects.equals(totalSpendINBooks, student.totalSpendINBooks) && Objects.equals(created, student.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, gender, address, favoriteSubjects, totalSpendINBooks, created);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", favoriteSubjects=" + favoriteSubjects +
                ", totalSpendINBooks=" + totalSpendINBooks +
                ", created=" + created +
                '}';
    }
}
