package XPence.XPence.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import XPence.XPence.Model.Category;
import XPence.XPence.Model.TransactionType;
import XPence.XPence.Repository.CategoryRepository;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;
    private Category category1;
    private Category category2;
    List<Category> categoryList;

    @BeforeEach
    void setUp() {
        category1 = new Category();
        category1.setCategoryId(1L);
        category1.setName("Communication");
        category1.setTransactionType(TransactionType.INCOME);

        category2 = new Category();
        category1.setCategoryId(1L);
        category1.setName("Transport");
        category1.setTransactionType(TransactionType.EXPENSE);

        categoryList = new ArrayList<Category>();
        categoryList.add(category1);
        categoryList.add(category2);
    }

    @Test
    void createCategory() {
        when(categoryRepository.save(any())).thenReturn(category1);
        categoryService.saveCategory(category1);
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    void getAllCategories() {
	categoryRepository.save(category1);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> categoryList1 = categoryService.fetchCategories();
        assertEquals(categoryList1, categoryList);
        verify(categoryRepository, times(1)).save(category1);
        verify(categoryRepository, times(1)).findAll();
    }
    
    void updateCategory() {
	
    }
    
    @Test
    void deleteCategoryById() {
	Long catId = category1.getCategoryId();
	categoryService.deleteCategoryById(catId);
	verify(categoryRepository,times(1)).deleteById(catId);
    }
}
