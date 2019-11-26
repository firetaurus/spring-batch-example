package it.siae.bopae.estrazionecodariconciliazionebatch.config;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BopaeCodaRiconciliazione;
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

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<BopaeCodaRiconciliazione> itemReader,
                   ItemProcessor<BopaeCodaRiconciliazione, BopaeCodaRiconciliazione> itemProcessor,
                   ItemWriter<BopaeCodaRiconciliazione> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-load-file")
                .<BopaeCodaRiconciliazione, BopaeCodaRiconciliazione>chunk(10)
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

    //
//    @Bean
//    public SkipPolicy fileVerificationSkipper() {
//        return new FileVerificationSkipper();
//    }
    @Bean
    public FlatFileItemReader<BopaeCodaRiconciliazione> flatFileItemReader(@Value("${input}") Resource resource) {

        FlatFileItemReader<BopaeCodaRiconciliazione> flatFileItemReader = new FlatFileItemReader<>();

        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("MUS/LIR/DOR-Reader");
        flatFileItemReader.setLinesToSkip(0);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<BopaeCodaRiconciliazione> lineMapper() {
        DefaultLineMapper<BopaeCodaRiconciliazione> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(";");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames(new String[]{"iscrivendo", "numero_repertorio", "bollettinoId", "posizioneSis", "irregolarita1", "irregolarita2", "irrecolarita3", "dataArchiviazioneDefinito"});

        BeanWrapperFieldSetMapper<BopaeCodaRiconciliazione> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BopaeCodaRiconciliazione.class);

        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
