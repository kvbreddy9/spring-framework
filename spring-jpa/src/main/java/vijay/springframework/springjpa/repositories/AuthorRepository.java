package vijay.springframework.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import vijay.springframework.springjpa.model.Author;

public interface AuthorRepository  extends CrudRepository<Author,Long> {
}
