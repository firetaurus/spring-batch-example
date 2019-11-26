package it.firetaurus.batch.readfilesystem.batch;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BatchProcessor implements ItemProcessor<BatchModelExample, BatchModelExample> {

    public static final Logger log = LoggerFactory.getLogger(BatchProcessor.class);

    @Override
    public BatchModelExample process(BatchModelExample batchModelExample) throws Exception {
        batchModelExample.setTimeDate(new Date());
        return batchModelExample;
    }


}
