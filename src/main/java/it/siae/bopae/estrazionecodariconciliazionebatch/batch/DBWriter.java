package it.siae.bopae.estrazionecodariconciliazionebatch.batch;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BopaeCodaRiconciliazione;
import it.siae.bopae.estrazionecodariconciliazionebatch.repository.CodaRinconciliazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<BopaeCodaRiconciliazione> {

    public static final Logger log = LoggerFactory.getLogger(DBWriter.class);

    @Autowired
    private CodaRinconciliazioneRepository repository;


    @Override
    public void write(List<? extends BopaeCodaRiconciliazione> list) throws Exception {

        log.info("Record salvati: {}", list);

        repository.save(list);


    }
}
