package com.datakettle.spring5demo.model;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //JPA annotation for database object creation
public class Author {

    @Id // this is too tell JPA that this is a generated ID
    @GeneratedValue(strategy = GenerationType.AUTO) //Same as above
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors") // To configure JPA to have a many to many relationship with Books
    // Mapped by is used for removing unnessary join tables in the H2 db.Considering this as target
    private Set<Book> books = new HashSet<>();


    public Author() {
    }

    public Author(String firstName,String lastName) {

        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Author(String firstName,String lastName,Set<Book> books) {

        this.firstName=firstName;
        this.lastName=lastName;
        this.books = books;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }


}
