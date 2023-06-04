package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
      Optional<Book> optionalBook = bookRepository.findById(id);
      return optionalBook.orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByRating(int rating) {
        return bookRepository.findByRating(rating);
    }

    public List<Book> findByPublisherIsNotNull() {
        return bookRepository.findByPublisherIsNotNull();
    }

    public List<Book> findByPublisher(Publisher publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthors(author);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> findByTitle(String title){
       return bookRepository.findByTitle(title);
    }
    public List<Book> findByCategory(Category category){
        return bookRepository.findByCategory(category);
    }
    public List<Book> findByCategoryId(long id){
        return bookRepository.findByCategoryId(id);
    }
}