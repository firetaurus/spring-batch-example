package it.firetaurus.batch.readfilesystem.batch;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BatchReader implements ItemReader<FlatFileItemReader<BatchModelExample>> {

    @Override
    public FlatFileItemReader<BatchModelExample> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
//
//    @Autowired
//    LineMapper lineMapper;

//    @Resource(lookup = "$input")
//    private org.springframework.core.io.Resource input;

//    @Override
//    public FlatFileItemReader<BatchModelExample> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        FlatFileItemReader<BatchModelExample> flatFileItemReader = new FlatFileItemReader<>();
//
//        flatFileItemReader.setResource(input);
//        flatFileItemReader.setName("MUS/LIR/DOR-Reader");
//        flatFileItemReader.setLinesToSkip(0);
//        flatFileItemReader.setLineMapper(lineMapper);
//
//        return flatFileItemReader;
//
//    }
}
