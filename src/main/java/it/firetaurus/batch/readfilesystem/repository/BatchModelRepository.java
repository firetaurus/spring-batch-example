package it.firetaurus.batch.readfilesystem.repository;

import it.firetaurus.batch.readfilesystem.model.BatchModelExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchModelRepository extends JpaRepository<BatchModelExample, Long> {

}
