package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.email LIKE :starts%")
    List<Author> emailStartsAt(@Param("starts") String starts);
    @Query("SELECT a FROM Author a WHERE a.pesel LIKE :starts%")
    List<Author> peselStartsAt(@Param("starts") String starts);
}
