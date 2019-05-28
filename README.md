## Spring Batch

A first implementation of Spring Batch for Reader , Processor and Writer.
Read from file, 10 elements (chuck) , the process the data , and then write into DB.

## Running 

```sh
mvn spring-boot:run
```

Then simply just go on the browser and type:

http://localhost:9999/load

## DB - in memory H2

For develpment only i used H2 Db, that you can find , once the application is up and running 
here: http://localhost:9999/h2-console

## Useful queries for H2 and Spring Batch

```hsqldb
SELECT * FROM BOPAE_CODA_RICONCILIAZIONE;

SELECT * FROM BATCH_JOB_EXECUTION;
SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT;

SELECT * FROM BATCH_STEP_EXECUTION;
SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT;
```