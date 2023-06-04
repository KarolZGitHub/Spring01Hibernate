package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AuthorFormController {
    private AuthorService authorService;

    @GetMapping(path = "/author/list" , produces = "text/plain;charset=utf-8")
    public String getAllAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author/allAuthors";
    }
    @GetMapping(path = "/author/form" , produces = "text/plain;charset=utf-8")
    public String showAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "author/form";
    }
    @PostMapping(path = "/author/form")
    public String createAuthor(@Valid Author author, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/author/form";
        }
        authorService.save(author);
        return "redirect:/author/list";
    }
    @GetMapping(path = "/author/edit")
    String editAuthor(@RequestParam long id, Model model){
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/editForm";
    }
    @PostMapping(path = "/author/edit")
    String processEditAuthor(@Valid Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/author/edit";
        }
        authorService.update(author);
        return "redirect:/author/list";
    }
}
