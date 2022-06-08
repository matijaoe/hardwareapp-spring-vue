package hr.tvz.osrecki.hardwareapp;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {
    @Bean
    public JobDetail objavaAvailableHardware() {
        return JobBuilder.newJob(AvailableHardwareJob.class).withIdentity("availableHardwareTrigger").storeDurably().build();
    }

    @Bean
    public Trigger objavaJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(objavaAvailableHardware())
                .withIdentity("availableHardwareTrigger").withSchedule(scheduleBuilder).build();
    }
}