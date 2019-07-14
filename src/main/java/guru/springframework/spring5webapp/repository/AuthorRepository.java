package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sean.bowen
 * @version 1.0
 * <p>
 * Creation date: 2019-07-14
 * @since 2019
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
