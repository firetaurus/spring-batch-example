package it.siae.bopae.estrazionecodariconciliazionebatch.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

public class ScheduledExecution {

    private static final Logger log = LoggerFactory.getLogger(ScheduledExecution.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Scheduled(fixedRate = 20000)
    public void runJob() {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobExecution jobExecution = null;
        try {
            jobExecution = jobLauncher.run(job, new JobParameters(maps));
        } catch (JobExecutionAlreadyRunningException e) {
            log.error("{} ", e);
        } catch (JobRestartException e) {
            log.error("{} ", e);
        } catch (JobInstanceAlreadyCompleteException e) {
            log.error("{} ", e);
        } catch (JobParametersInvalidException e) {
            log.error("{} ", e);
        }


        log.info("Batch is running...");
        while (jobExecution.isRunning()) {
            log.info("...");
        }

        log.info("{}, ", jobExecution.getStatus());

    }

}
