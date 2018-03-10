package com.datakettle.spring5demo.Bootstrap;

import com.datakettle.spring5demo.model.Author;
import com.datakettle.spring5demo.model.Book;
import com.datakettle.spring5demo.model.Publisher;
import com.datakettle.spring5demo.repositories.AuthorRepository;
import com.datakettle.spring5demo.repositories.BookRepository;
import com.datakettle.spring5demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher hc = new Publisher("Harper , Collins"," 123 abs street");
        Publisher wx = new Publisher("Worx"," 386 abs street");

        publisherRepository.save(hc);
        publisherRepository.save(wx);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);



        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","23444",wx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        authorRepository.save(rod);
        bookRepository.save(noEJB);




    }

}
