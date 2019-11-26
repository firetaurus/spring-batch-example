package it.siae.bopae.estrazionecodariconciliazionebatch.batch;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BatchModelExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Processor implements ItemProcessor<BatchModelExample, BatchModelExample> {

    public static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public BatchModelExample process(BatchModelExample batchModelExample) throws Exception {
        batchModelExample.setTimeDate(new Date());
        return batchModelExample;
    }


}
