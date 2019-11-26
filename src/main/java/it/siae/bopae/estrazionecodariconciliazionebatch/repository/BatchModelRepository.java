package it.siae.bopae.estrazionecodariconciliazionebatch.repository;

import it.siae.bopae.estrazionecodariconciliazionebatch.model.BatchModelExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchModelRepository extends JpaRepository<BatchModelExample, Long> {

}
