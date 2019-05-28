package it.siae.bopae.estrazionecodariconciliazionebatch.repository;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BopaeCodaRiconciliazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodaRinconciliazioneRepository extends JpaRepository<BopaeCodaRiconciliazione, Long> {

}
