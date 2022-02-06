package XPence.XPence.Service;

import XPence.XPence.Model.Account;
import XPence.XPence.Model.Profile;
import XPence.XPence.Repository.AccountRepository;

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
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;
    private Account account1;
    private Account account2;
    private Profile profile;
    List<Account> accountList;

    @BeforeEach
    void setUp() {
	profile = new Profile();
	profile.setId(1L);
	profile.setName("Yves");
	profile.setEmail("abc@gmail.com");
	profile.setPassword("1234");
	profile.setProfilePicture("asd.png");
	profile.setPhoneNumber("4444");
	profile.setEnabled(true);

	account1 = new Account();
	account1.setAccountId(1L);
	account1.setCurrency("Rwf");
	account1.setDescription("Savings");
	account1.setName("Mobile Money");
	account1.setProfile(profile);

	account2 = new Account();
	account2.setAccountId(1L);
	account2.setCurrency("CHY");
	account2.setDescription("Transport");
	account2.setName("Bank");
	account2.setProfile(profile);

	accountList = new ArrayList<>();
	accountList.add(account1);
	accountList.add(account2);

    }

    @Test
    void createAccount() {
	when(accountRepository.save(any())).thenReturn(account1);
	accountService.saveAccount(account1);
	verify(accountRepository, times(1)).save(any());
    }

    @Test
    void getAllAccounts() {
	accountRepository.save(account1);
	when(accountRepository.findAll()).thenReturn(accountList);
	List<Account> accountList1 = accountService.fetchAccounts();
	assertEquals(accountList1, accountList);
	verify(accountRepository, times(1)).save(account1);
	verify(accountRepository, times(1)).findAll();
    }
}
