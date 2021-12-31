package XPence.XPence.Service;

import org.springframework.beans.factory.annotation.Autowired;

import XPence.XPence.Model.Category;
import XPence.XPence.Model.TransactionType;
import XPence.XPence.Repository.CategoryRepository;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> fetchCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);

    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category catDB = categoryRepository.findById(categoryId).get();
        if (Objects.nonNull(category.getName()) && !"".equalsIgnoreCase(category.getName()) && category.getTransactionType().equals(TransactionType.EXPENSE)) {
            catDB.setName(category.getName());
            catDB.setTransactionType(TransactionType.INCOME);
        }

        if (Objects.nonNull(category.getName()) && !"".equalsIgnoreCase(category.getName()) && category.getTransactionType().equals(TransactionType.INCOME)) {
            catDB.setName(category.getName());
            catDB.setTransactionType(TransactionType.EXPENSE);
        }
        return categoryRepository.save(catDB);
    }

    @Override
    public Category fetchCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

}
