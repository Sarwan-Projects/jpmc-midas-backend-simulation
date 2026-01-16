package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final DatabaseConduit databaseConduit;
    private final UserRepository userRepository;

    // Spring will automatically inject these two beans
    public KafkaConsumer(DatabaseConduit databaseConduit, UserRepository userRepository) {
        this.databaseConduit = databaseConduit;
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core")
    public void listen(Transaction transaction) {
        databaseConduit.validateAndRecord(transaction);

        UserRecord wilbur = userRepository.findByName("wilbur");
        if (wilbur != null) {
            System.out.println("DEBUG: Wilbur's current balance is: " + wilbur.getBalance());
        }
    }
}