package it.firetaurus.batch.readfilesystem.batch;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
public class LineMapper implements org.springframework.batch.item.file.LineMapper<BatchModelExample> {

    public static final String[] DELIMITERS = new String[]{"iscrivendo", "numero_repertorio", "bollettinoId", "posizioneSis", "irregolarita1", "irregolarita2", "irrecolarita3", "dataArchiviazioneDefinito"};

    public LineMapper() {
        DefaultLineMapper<BatchModelExample> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(";");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames(DELIMITERS);
        BeanWrapperFieldSetMapper<BatchModelExample> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BatchModelExample.class);

        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
    }

    @Override
    public BatchModelExample mapLine(String s, int i) throws Exception {
        return null;
    }
}
