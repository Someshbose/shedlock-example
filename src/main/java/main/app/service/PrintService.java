package main.app.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

  @Scheduled(initialDelayString = "1000" , fixedRateString = "1000")
  @SchedulerLock(name = "scheduledTaskName")
  public void print(){
    System.out.println("Hello");
  }
}
