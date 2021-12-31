package XPence.XPence.Service;

import XPence.XPence.Model.Category;
import java.util.List;

public interface CategoryService {

    public Category saveCategory(Category category);

    public List<Category> fetchCategories();

    public void deleteCategoryById(Long id);

    public Category fetchCategoryById(Long categoryId);

    public Category updateCategory(Long categoryId, Category category);
}
