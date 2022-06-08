package hr.tvz.osrecki.hardwareapp;

import hr.tvz.osrecki.hardwareapp.hardware.service.HardwareService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AvailableHardwareJob extends QuartzJobBean {

    @Autowired
    private HardwareService hardwareService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String divider = "---------------------------------------";
        System.out.println("\nHardveri koje moš kupit!!!\n" + divider);
        this.hardwareService.findAll()
                .forEach((item) -> System.out.println(item.getName() + " - " + item.getQuantity()));

    }
}