package XPence.XPence.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XPence.XPence.Model.Account;
import XPence.XPence.Repository.AccountRepository;

@Service
public class AccountServiceImplimentation implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> fetchAccounts() {

        return accountRepository.findAll();
    }
}
