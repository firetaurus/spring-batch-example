package it.siae.bopae.estrazionecodariconciliazionebatch.batch;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BatchModelExample;
import it.siae.bopae.estrazionecodariconciliazionebatch.repository.BatchModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<BatchModelExample> {

    public static final Logger log = LoggerFactory.getLogger(DBWriter.class);

    @Autowired
    private BatchModelRepository repository;

    @Override
    public void write(List<? extends BatchModelExample> list) throws Exception {

        log.info("Record salvati: {}", list);

        repository.save(list);


    }
}
