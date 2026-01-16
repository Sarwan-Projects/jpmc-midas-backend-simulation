package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConduit {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final IncentiveService incentiveService;

    public DatabaseConduit(UserRepository userRepository,
                           TransactionRepository transactionRepository,
                           IncentiveService incentiveService) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.incentiveService = incentiveService;
    }

    public void save(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

    public void validateAndRecord(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        // Basic Validation
        if (sender != null && recipient != null && sender.getBalance() >= transaction.getAmount()) {

            // 1. Get the incentive from the external REST API
            Incentive incentive = incentiveService.getIncentive(transaction);
            float bonus = incentive.getAmount();

            // 2. Adjust Balances
            // Sender: loses only the transaction amount
            sender.setBalance(sender.getBalance() - transaction.getAmount());

            // Recipient: gets the amount PLUS the incentive bonus
            recipient.setBalance(recipient.getBalance() + transaction.getAmount() + bonus);

            // 3. Persist (Save) the changes to the database
            userRepository.save(sender);
            userRepository.save(recipient);

            // 4. Record the transaction with the incentive amount included
            TransactionRecord record = new TransactionRecord(sender, recipient, transaction.getAmount(), bonus);
            transactionRepository.save(record);
        }
    }
}