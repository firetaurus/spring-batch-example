package it.firetaurus.batch.readfilesystem.config;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import it.firetaurus.batch.readfilesystem.scheduled.ScheduledExecution;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<BatchModelExample> itemReader,
                   ItemProcessor<BatchModelExample, BatchModelExample> itemProcessor,
                   ItemWriter<BatchModelExample> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-load-file")
                .<BatchModelExample, BatchModelExample>chunk(1)
                .reader(itemReader)
                .faultTolerant()
//                .skipPolicy(fileVerificationSkipper())
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        Job job = jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

        return job;
    }

//    @Bean
//    public ScheduledExecution scheduledExecution() {
//        return new ScheduledExecution();
//    }

    //
//    @Bean
//    public SkipPolicy fileVerificationSkipper() {
//        return new FileVerificationSkipper();
//    }
    @Bean
    public FlatFileItemReader<BatchModelExample> flatFileItemReader(@Value("${input}") Resource resource) {

        FlatFileItemReader<BatchModelExample> flatFileItemReader = new FlatFileItemReader<>();

        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("MUS/LIR/DOR-Reader");
        flatFileItemReader.setLinesToSkip(0);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<BatchModelExample> lineMapper() {
        DefaultLineMapper<BatchModelExample> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(";");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames(new String[]{"iscrivendo", "numero_repertorio", "bollettinoId", "posizioneSis", "irregolarita1", "irregolarita2", "irrecolarita3", "dataArchiviazioneDefinito"});

        BeanWrapperFieldSetMapper<BatchModelExample> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BatchModelExample.class);

        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
