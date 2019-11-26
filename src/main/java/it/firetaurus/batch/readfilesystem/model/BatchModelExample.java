package it.firetaurus.batch.readfilesystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    public String getBollettinoId() {
        return bollettinoId;
    }

    public void setBollettinoId(String bollettinoId) {
        this.bollettinoId = bollettinoId;
    }

    public String getDataArchiviazioneDefinito() {
        return dataArchiviazioneDefinito;
    }

    public void setDataArchiviazioneDefinito(String dataArchiviazioneDefinito) {
        this.dataArchiviazioneDefinito = dataArchiviazioneDefinito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIscrivendo() {
        return iscrivendo;
    }

    public void setIscrivendo(int iscrivendo) {
        this.iscrivendo = iscrivendo;
    }

    public String getNumero_repertorio() {
        return numero_repertorio;
    }

    public void setNumero_repertorio(String numero_repertorio) {
        this.numero_repertorio = numero_repertorio;
    }

    public String getPosizioneSis() {
        return posizioneSis;
    }

    public void setPosizioneSis(String posizioneSis) {
        this.posizioneSis = posizioneSis;
    }

    public String getIrregolarita1() {
        return irregolarita1;
    }

    public void setIrregolarita1(String irregolarita1) {
        this.irregolarita1 = irregolarita1;
    }

    public String getIrregolarita2() {
        return irregolarita2;
    }

    public void setIrregolarita2(String irregolarita2) {
        this.irregolarita2 = irregolarita2;
    }

    public String getIrregolarita3() {
        return irregolarita3;
    }

    public void setIrregolarita3(String irregolarita3) {
        this.irregolarita3 = irregolarita3;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BatchModelExample{");
        sb.append("id=").append(id);
        sb.append(", iscrivendo='").append(iscrivendo).append('\'');
        sb.append(", numero_repertorio='").append(numero_repertorio).append('\'');
        sb.append(", posizioneSis='").append(posizioneSis).append('\'');
        sb.append(", irregolarita1='").append(irregolarita1).append('\'');
        sb.append(", irregolarita2='").append(irregolarita2).append('\'');
        sb.append(", irregolarita3='").append(irregolarita3).append('\'');
//        sb.append(", sezione='").append(sezione).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
