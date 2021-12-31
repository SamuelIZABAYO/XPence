package XPence.XPence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import XPence.XPence.Model.Account;

public interface AccountRepository  extends JpaRepository<Account, Long> {

}
