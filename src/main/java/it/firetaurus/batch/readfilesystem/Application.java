package it.firetaurus.batch.readfilesystem;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import it.firetaurus.batch.readfilesystem.repository.BatchModelRepository;
import it.firetaurus.batch.readfilesystem.scheduled.ScheduledExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(BatchModelRepository batchModelRepository) throws Exception {
        return (String[] args) -> {
            BatchModelExample user1 = new BatchModelExample();
            BatchModelExample user2 = new BatchModelExample();
            batchModelRepository.save(user1);
            batchModelRepository.save(user2);
            batchModelRepository.findAll().forEach(user -> System.out.println(user));
        };
    }



}
