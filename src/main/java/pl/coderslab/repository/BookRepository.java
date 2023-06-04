package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.*;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByRating(int rating);

    List<Book> findByPublisherIsNotNull();

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByAuthors(Author author);

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(long id);

    Optional<Book> findFirstByCategoryOrderByTitle(Category category);
}
