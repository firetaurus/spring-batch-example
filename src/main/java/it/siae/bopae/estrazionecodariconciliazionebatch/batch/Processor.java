package it.siae.bopae.estrazionecodariconciliazionebatch.batch;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BopaeCodaRiconciliazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Processor implements ItemProcessor<BopaeCodaRiconciliazione, BopaeCodaRiconciliazione> {

    public static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public BopaeCodaRiconciliazione process(BopaeCodaRiconciliazione bopaeCodaRiconciliazione) throws Exception {

        //FIXME: dummy processor
        // cambia solo la data
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//        String dataArchiviazioneDefinito = bopaeCodaRiconciliazione.getDataArchiviazioneDefinito();
//        Date parse = sdf.parse(dataArchiviazioneDefinito);
//        String dataArchiviazioneDefinito1 = parse.toString();
//
//        bopaeCodaRiconciliazione.setDataArchiviazioneDefinito(dataArchiviazioneDefinito1);
//
//        log.info("Modificata la data archivio definitivo da {} a {}", dataArchiviazioneDefinito, parse.toString());
        bopaeCodaRiconciliazione.setTimeDate(new Date());
        return bopaeCodaRiconciliazione;
    }


}
