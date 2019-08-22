package vijay.springframework.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import vijay.springframework.springjpa.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
