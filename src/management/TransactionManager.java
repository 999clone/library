package management;

import datastructures.lists.CustomLinkedList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    // TODO: Define a data structure that stores transactions
    private CustomLinkedList<Transaction> transactions;

    public TransactionManager() {
        transactions = new CustomLinkedList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        // TODO: Add the transaction to your data structure
        transactions.addLast(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        return (Transaction) transactions.get(index);
    }
}
