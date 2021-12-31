package XPence.XPence.Service;

import XPence.XPence.Model.Transaction;
import java.util.List;

public interface TransactionService {

    public Transaction saveTransaction(Transaction transaction);

    public List<Transaction> fetchTransactions();

    public void deleteTransactionById(Long transactionId);

    public Transaction fetchTransactionById(Long transactionId);

//    public Transaction updateTransaction(Long transactionId, Transaction transaction);
}
