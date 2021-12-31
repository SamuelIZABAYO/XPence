package XPence.XPence.Service;

import java.util.List;

import XPence.XPence.Model.Account;

public interface AccountService {
    public Account saveAccount(Account account);

    public List<Account> fetchAccounts();
    
}
