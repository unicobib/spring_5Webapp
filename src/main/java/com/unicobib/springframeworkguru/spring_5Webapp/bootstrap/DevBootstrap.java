package com.unicobib.springframeworkguru.spring_5Webapp.bootstrap;

import com.unicobib.springframeworkguru.spring_5Webapp.model.Author;
import com.unicobib.springframeworkguru.spring_5Webapp.model.Book;
import com.unicobib.springframeworkguru.spring_5Webapp.repository.AuthorRepository;
import com.unicobib.springframeworkguru.spring_5Webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    public AuthorRepository authorRepo;
    public BookRepository bookRepo;

    public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Author bibek = new Author("Bibek","Dey");
        Book aaa = new Book("Java Design Patterns","1234","oxford");
        bibek.getBooks().add(aaa);
        aaa.getAuthors().add(bibek);

        Author mahesh = new Author("Maheshwar","Garai");
        Book bbb = new Book("Microservices Architecture","3659","Packt Pub");
        mahesh.getBooks().add(bbb);
        bbb.getAuthors().add(mahesh);

        authorRepo.save(bibek);
        bookRepo.save(aaa);

        authorRepo.save(mahesh);
        bookRepo.save(bbb);
    }
}
