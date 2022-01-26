package XPence.XPence.Service;

import XPence.XPence.Model.Account;
import XPence.XPence.Model.Category;
import XPence.XPence.Model.Profile;
import XPence.XPence.Model.Transaction;
import XPence.XPence.Model.TransactionType;
import XPence.XPence.Repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;
    @MockBean
    private TransactionRepository transactionRepository;
    private Account account;
    private Profile profile;
    private Category category;
    private Transaction transaction1;
    private Transaction transaction2;
    List<Transaction> transactionList;

    @BeforeEach
    void setUp() {
        profile = new Profile();
        profile.setId(1L);
        profile.setName("Yves");
        profile.setEmail("abc@gmail.com");
        profile.setPassword("1234");
        profile.setProfilePicture("asd.png");
        profile.setPhoneNumber("4444");
        

        account = new Account();
        account.setAccountId(1L);
        account.setCurrency("Rwf");
        account.setDescription("Savings");
        account.setName("Mobile Money");
        account.setProfile(profile);

        category = new Category();
        category.setCategoryId(1L);
        category.setName("Communication");
        category.setTransactionType(TransactionType.INCOME);

        transaction1 = new Transaction();
        transaction1.setTransactionId(1L);
        transaction1.setRegistrationDate(LocalDate.now());
        transaction1.setDescription("Telecommunication");
        transaction1.setAmount(40000.0);
        transaction1.setAccount(account);
        transaction1.setCategory(category);

        transaction2 = new Transaction();
        transaction2.setTransactionId(2L);
        transaction2.setRegistrationDate(LocalDate.now());
        transaction2.setDescription("Food");
        transaction2.setAmount(80000.0);
        transaction2.setAccount(account);
        transaction2.setCategory(category);

        transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);

    }
    @Test
    void createCategory() {
        when(transactionRepository.save(any())).thenReturn(transaction1);
        transactionService.saveTransaction(transaction1);
        verify(transactionRepository, times(1)).save(any());
    }

    @Test
    void getAllCategories() {
	transactionRepository.save(transaction1);
        when(transactionRepository.findAll()).thenReturn(transactionList);
        List<Transaction> transactionList1 = transactionService.fetchTransactions();
        assertEquals(transactionList1, transactionList);
        verify(transactionRepository, times(1)).save(transaction1);
        verify(transactionRepository, times(1)).findAll();
    }
    
    void updateTransaction() {
	
    }
    
    @Test
    void deleteCategoryById() {
	Long transactionId = transaction1.getTransactionId();
	transactionService.deleteTransactionById(transactionId);
	verify(transactionRepository,times(1)).deleteById(transactionId);
    }
}
