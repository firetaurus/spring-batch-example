package it.firetaurus.batch.readfilesystem.batch;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class BatchReader implements ItemReader<FlatFileItemReader<BatchModelExample>> {

//    @Autowired
//    LineMapper lineMapper;

    @Override
    public FlatFileItemReader<BatchModelExample> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        FlatFileItemReader<BatchModelExample> flatFileItemReader = new FlatFileItemReader<>();
//
//        flatFileItemReader.setResource(resource);
//        flatFileItemReader.setName("MUS/LIR/DOR-Reader");
//        flatFileItemReader.setLinesToSkip(0);
//        flatFileItemReader.setLineMapper(lineMapper);
        return null;
    }

    //
    @Resource
    private DataSource dataSource = DataSourceBuilder.create().build();



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
