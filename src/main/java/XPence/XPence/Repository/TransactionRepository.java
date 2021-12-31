package XPence.XPence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import XPence.XPence.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
