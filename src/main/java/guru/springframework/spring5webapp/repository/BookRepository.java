package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sean.bowen
 * @version 1.0
 * <p>
 * Creation date: 2019-07-14
 * @since 2019
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
