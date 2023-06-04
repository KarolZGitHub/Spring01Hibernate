package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@AllArgsConstructor
class ValidationController {

    private final Validator validator;
    private BookService bookService;

    @RequestMapping("/validate/{id}")
    String validateTest(@PathVariable long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        Book second = new Book();
        if(book.isPresent()){
            second = book.get();
        }
        Set<ConstraintViolation<Book>> violations = validator.validate(second);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                log.error(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
            model.addAttribute("violations", violations);

            return "/violation/violations";
        } else {
            return "Validation status OK!";
        }
    }
}