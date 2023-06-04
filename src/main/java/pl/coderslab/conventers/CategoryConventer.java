package pl.coderslab.conventers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.service.CategoryService;

import java.util.Optional;

public class CategoryConventer implements Converter<String, Category>{
    @Autowired
    private CategoryService categoryService;
    @Override
    public Category convert(String source){
        return categoryService.findById(Long.parseLong(source));
    }
}
