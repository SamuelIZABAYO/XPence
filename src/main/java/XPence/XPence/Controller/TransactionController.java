package XPence.XPence.Controller;

import XPence.XPence.Model.Transaction;
import XPence.XPence.Service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
	return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/transaction")
    public List<Transaction> fetchCategories() {
	return transactionService.fetchTransactions();
    }

    @DeleteMapping("/delete_transaction/{id}")
    public String deleteTransaction(@PathVariable("id") Long transactionId) {
	transactionService.deleteTransactionById(transactionId);
	return "Transaction deleted successfully!!";
    }
//    @PutMapping("/update_transaction/{id}")
//    public Transaction updateTransaction(@PathVariable("id") Long transactionId, @RequestBody Transaction transaction) {
//        return transactionService.(transactionId, transaction);
//
//    }
}
