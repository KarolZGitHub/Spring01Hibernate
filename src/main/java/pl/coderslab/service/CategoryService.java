package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    public void save(Category category){
        categoryRepository.save(category);
    }
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

}
