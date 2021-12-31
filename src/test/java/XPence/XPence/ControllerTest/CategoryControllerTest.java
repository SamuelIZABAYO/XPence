package XPence.XPence.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import XPence.XPence.Model.Category;
import XPence.XPence.Service.CategoryService;

public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;
    private Category category;

    @BeforeEach
    void setUp() {

    }

    @Test
    void saveCategory() {

    }
}
