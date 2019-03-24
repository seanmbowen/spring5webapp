package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher harperCollins = new Publisher("Haper Collins", "9 Bogert Avenue");
        Publisher wrox = new Publisher("Wrox", "20 Bogert Avenue");

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        saveRepositories(harperCollins, eric, ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("JEEE Development without EJB", "1235", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        saveRepositories(wrox, rod, noEJB);
    }

    private void saveRepositories(Publisher harperCollins, Author rod, Book noEJB) {
        publisherRepository.save(harperCollins);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
