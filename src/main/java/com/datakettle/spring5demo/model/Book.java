package com.datakettle.spring5demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // For JPA for object creation in DB
public class Book {

    @Id //For JPA to consider as ID
    @GeneratedValue(strategy = GenerationType.AUTO) // For JPA to auto generate the ID
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany() //To tell JPA to have a many to many relationship with Author
    @JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id") ,
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    //Join Table is used to mention the join columns for join tables.
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }


    public Book(String title,String isbn,String publisher) {
        this.title=title;
        this.isbn=isbn;
        this.publisher=publisher;
    }


    public Book(String title,String isbn,String publisher,Set<Author> authors) {

        this.publisher=publisher;
        this.isbn=isbn;
        this.title=title;
        this.authors=authors;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
