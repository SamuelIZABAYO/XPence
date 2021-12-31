package XPence.XPence.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XPence.XPence.Model.Transaction;
import XPence.XPence.Repository.TransactionRepository;
import java.util.List;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> fetchTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransactionById(Long trasactionId) {
        transactionRepository.deleteById(trasactionId);
    }

    @Override
    public Transaction fetchTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).get();
    }

//    @Override
//    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
//        Transaction depDB = transactionRepository.findById(transactionId).get();
//
//        if(depDB!=null){
//            
//        }
//        if (Objects.nonNull(transaction.getAmount())) {
//            depDB.setAmount(transaction.getAmount());
//        }
//
//        if (Objects.nonNull(transaction.getDescription())) {
//            depDB.setDescription(transaction.getDescription());
//        }
//
//        if (Objects.nonNull(transaction.getCategory())) {
//            depDB.setCategory(transaction.getCategory());
//        }
//        if (Objects.nonNull(transaction.getAccount())) {
//            depDB.setAccount(transaction.getAccount());
//        }
//        return transactionRepository.save(depDB);
//    }
}
