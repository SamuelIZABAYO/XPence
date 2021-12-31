package XPence.XPence.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import XPence.XPence.Model.Category;
import XPence.XPence.Service.CategoryService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/category")
    public List<Category> fetchCategories() {
        return categoryService.fetchCategories();
    }

    @DeleteMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return "Category deleted successfully!!";
    }

    @PutMapping("/update_category/{id}")
    public Category updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {
        return categoryService.updateCategory(categoryId, category);

    }
}
