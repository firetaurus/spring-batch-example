package it.firetaurus.batch.readfilesystem.batch;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import it.firetaurus.batch.readfilesystem.repository.BatchModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchWriter implements ItemWriter<BatchModelExample> {

    public static final Logger log = LoggerFactory.getLogger(BatchWriter.class);

    @Autowired
    private BatchModelRepository repository;

    @Override
    public void write(List<? extends BatchModelExample> list) throws Exception {
        log.info("Record salvati: {}", list);
        log.info("Record salvati: {}", list);

        repository.save(list);
    }
}
