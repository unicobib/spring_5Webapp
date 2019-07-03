package com.unicobib.springframeworkguru.spring_5Webapp.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
    Set<Author> authors = new HashSet<>();

    public Book(){

    }

    public Book(String title, String isbn, String publisher){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(String title, String isbn, String publisher, Set<Author> authors){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
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
}
