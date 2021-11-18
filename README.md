# Service APIs not working in Job executions

See: [TestJob.java](./src/main/java/deprec/impl/TestJob.java).
```java
 @Override
 public JobRunnerResponse runJob (final JobRunnerRequest request)
 {
     final Space space = this.m_spaceService.find ().withKeys ("ds").fetchOrNull ();
     LOG.error ("TEST");
     LOG.error (space.getName ());
     return JobRunnerResponse.success ();        
 }
```

```log
[INFO] [talledLocalContainer] 2021-11-18 11:50:00,216 ERROR [Caesium-1-4] [deprec.impl.TestJob] runJob TEST
[INFO] [talledLocalContainer] 2021-11-18 11:50:00,216 ERROR [Caesium-1-4] [impl.schedule.caesium.JobRunnerWrapper] runJob Scheduled job deprec.confluence-test-deprecated-apis:testJob#testJobKey-runNow-1637232600187 failed to run
[INFO] [talledLocalContainer] java.lang.NullPointerException
[INFO] [talledLocalContainer] 	at deprec.impl.TestJob.runJob(TestJob.java:30)
[INFO] [talledLocalContainer] 	at com.atlassian.confluence.impl.schedule.caesium.JobRunnerWrapper.doRunJob(JobRunnerWrapper.java:117)
[INFO] [talledLocalContainer] 	at com.atlassian.confluence.impl.schedule.caesium.JobRunnerWrapper.lambda$runJob$0(JobRunnerWrapper.java:87)
[INFO] [talledLocalContainer] 	at com.atlassian.confluence.impl.vcache.VCacheRequestContextManager.doInRequestContextInternal(VCacheRequestContextManager.java:84)
[INFO] [talledLocalContainer] 	at com.atlassian.confluence.impl.vcache.VCacheRequestContextManager.doInRequestContext(VCacheRequestContextManager.java:68)
[INFO] [talledLocalContainer] 	at com.atlassian.confluence.impl.schedule.caesium.JobRunnerWrapper.runJob(JobRunnerWrapper.java:87)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.core.JobLauncher.runJob(JobLauncher.java:134)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.core.JobLauncher.launchAndBuildResponse(JobLauncher.java:106)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.core.JobLauncher.launch(JobLauncher.java:90)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.CaesiumSchedulerService.launchJob(CaesiumSchedulerService.java:435)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.CaesiumSchedulerService.executeLocalJob(CaesiumSchedulerService.java:402)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.CaesiumSchedulerService.executeQueuedJob(CaesiumSchedulerService.java:380)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.SchedulerQueueWorker.executeJob(SchedulerQueueWorker.java:66)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.SchedulerQueueWorker.executeNextJob(SchedulerQueueWorker.java:60)
[INFO] [talledLocalContainer] 	at com.atlassian.scheduler.caesium.impl.SchedulerQueueWorker.run(SchedulerQueueWorker.java:35)
[INFO] [talledLocalContainer] 	at java.lang.Thread.run(Thread.java:748)
[INFO] [talledLocalContainer] 2021-11-18 11:50:00,220 WARN [Caesium-1-4] [impl.schedule.caesium.JobRunnerWrapper] runJob Scheduled job deprec.confluence-test-deprecated-apis:testJob#testJobKey-runNow-1637232600187 completed unsuccessfully with response JobRunnerResponse[runOutcome=FAILED,message='NullPointerException']
```
