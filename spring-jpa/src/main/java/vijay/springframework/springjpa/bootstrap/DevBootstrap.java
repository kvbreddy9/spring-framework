package vijay.springframework.springjpa.bootstrap;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vijay.springframework.springjpa.model.Author;
import vijay.springframework.springjpa.model.Book;
import vijay.springframework.springjpa.model.Publisher;
import vijay.springframework.springjpa.repositories.AuthorRepository;
import vijay.springframework.springjpa.repositories.BookRepository;
import vijay.springframework.springjpa.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

        Publisher abc = new Publisher("ABC","Hyderabad");
        Publisher xyz = new Publisher("XYZ","Bangalore");

        publisherRepository.save(abc);
        publisherRepository.save(xyz);

        Author vijay = new Author("Vijay","Kalluri");
        Book spring = new Book("Spring Framework","1234",abc);
        vijay.getBooks().add(spring);
        spring.getAuthors().add(vijay);

        authorRepository.save(vijay);
        bookRepository.save(spring);

        Author rohan = new Author("Rohan","Kalluri");
        Book scala = new Book("Scala Programming","5678",xyz);
        rohan.getBooks().add(scala);

        authorRepository.save(rohan);
        bookRepository.save(scala);

    }
}
