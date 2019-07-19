package com.unicobib.springframeworkguru.spring_5Webapp.bootstrap;

import com.unicobib.springframeworkguru.spring_5Webapp.model.Author;
import com.unicobib.springframeworkguru.spring_5Webapp.model.Book;
import com.unicobib.springframeworkguru.spring_5Webapp.model.Publisher;
import com.unicobib.springframeworkguru.spring_5Webapp.repository.AuthorRepository;
import com.unicobib.springframeworkguru.spring_5Webapp.repository.BookRepository;
import com.unicobib.springframeworkguru.spring_5Webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepo;
    private BookRepository bookRepo;
    private PublisherRepository publisherRepo;

    public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo,PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Author bibek = new Author("Bibek","Dey");
        Publisher pub1 = new Publisher("oxford");
        Book aaa = new Book("Java Design Patterns","1234",pub1);
        bibek.getBooks().add(aaa);
        aaa.getAuthors().add(bibek);

        Author mahesh = new Author("Maheshwar","Garai");
        Publisher pub2 = new Publisher("Packt Pub");
        Book bbb = new Book("Microservices Architecture","3659",pub2);
        mahesh.getBooks().add(bbb);
        bbb.getAuthors().add(mahesh);

        authorRepo.save(bibek);
        publisherRepo.save(pub1);
        bookRepo.save(aaa);


        authorRepo.save(mahesh);
        publisherRepo.save(pub2);
        bookRepo.save(bbb);
    }
}
