package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledConfig {

  // @Scheduled(fixedRate = 2000)
  public void fixedRateTask() throws InterruptedException {
    System.out.println("start: fixedRateTask " + System.currentTimeMillis());;
    Thread.sleep(1000);
    System.out.println("end: fixedRateTask");
  }

  // @Scheduled(fixedDelay = 2000)
  public void fixedDelayTask() throws InterruptedException {
    System.out.println("start: fixedDelayTask " + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("end: fixedDelayTask");
  }

  // @Scheduled(cron = "*/5 * * * * ?") // every 5 sec, similar to fixedDelay
  @Scheduled(cron = "5 * * * * ?") // every 5 sec, similar to fixedDelay
  @Async
  public void cronTask5() throws InterruptedException {
    System.out.println("start cronTask5");
    Thread.sleep(10000);
    System.out.println("end cronTask5");
  }

  @Scheduled(cron = "10 * * * * ?") // every 5 sec, similar to fixedDelay
  @Async
  public void cronTask10() throws InterruptedException {
    System.out.println("start cronTask10");
    Thread.sleep(10000);
    System.out.println("end cronTask10");
  }

}
