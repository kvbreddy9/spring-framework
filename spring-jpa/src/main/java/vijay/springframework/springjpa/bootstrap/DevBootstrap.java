package vijay.springframework.springjpa.bootstrap;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vijay.springframework.springjpa.model.Author;
import vijay.springframework.springjpa.model.Book;
import vijay.springframework.springjpa.repositories.AuthorRepository;
import vijay.springframework.springjpa.repositories.BookRepository;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Author vijay = new Author("Vijay","Kalluri");
        Book spring = new Book("Spring Framework","1234","John Tompson");
        vijay.getBooks().add(spring);
        spring.getAuthors().add(vijay);

        authorRepository.save(vijay);
        bookRepository.save(spring);

        Author rohan = new Author("Rohan","Kalluri");
        Book scala = new Book("Scala Programming","5678","Martin Odersky");
        rohan.getBooks().add(scala);

        authorRepository.save(rohan);
        bookRepository.save(scala);

    }
}
