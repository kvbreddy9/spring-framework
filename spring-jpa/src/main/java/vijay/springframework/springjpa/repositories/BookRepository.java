package vijay.springframework.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import vijay.springframework.springjpa.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
