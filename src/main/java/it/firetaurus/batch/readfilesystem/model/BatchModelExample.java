package it.firetaurus.batch.readfilesystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@lombok.Data
@Entity
public class BatchModelExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int iscrivendo;
    String numero_repertorio;
    String bollettinoId;
    String posizioneSis;
    String irregolarita1;
    String irregolarita2;
    String irregolarita3;
    String dataArchiviazioneDefinito;
    Date timeDate;

    public BatchModelExample() {
    }

}
