package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.*;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByRating(int rating);

    List<Book> findByPublisherIsNotNull();

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByAuthors(Author author);

    //Zmieniona nazwa metody, spring nie tworzy automatycznie zapytania tylko używa adnotacji @Query, poprzednia nazwa
    // to : findByTitle
    @Query("select b from Book b where b.title= :title")
    List<Book> alaMaKota(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    List<Book> findByCategoryId(long id);

    Optional<Book> findFirstByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.rating between :first and :second")
    List<Book> bookRatingBetween(@Param("first") int first, @Param("second") int second);
    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> bookByPublisher(@Param("publisher") Publisher publisher);
    @Query("select b from Book b where b.category = :category order by :title")
    Optional<Book> bookByCategorySortedByTitle(@Param("category") Category category, @Param("title") String title);

}

