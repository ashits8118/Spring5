package com.ashitsathish.spring5webapp.bootstrap;

import com.ashitsathish.spring5webapp.model.Author;
import com.ashitsathish.spring5webapp.model.Book;
import com.ashitsathish.spring5webapp.model.Publisher;
import com.ashitsathish.spring5webapp.respositories.AuthorRepository;
import com.ashitsathish.spring5webapp.respositories.BookRepository;
import com.ashitsathish.spring5webapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1 = new Publisher("foo","2951 S King Drive");
        Book ddd = new Book("Domain Driven Design", "1234",
                publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        publisherRepository.save(publisher1);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2 = new Publisher("peeia","3001 S King Drive");
        Book noEJB = new Book("J2EE Development without EJB", "23444",
                publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        publisherRepository.save(publisher2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
