package hr.tvz.osrecki.hardwareapp;

import hr.tvz.osrecki.hardwareapp.hardware.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HardwareappApplication {

    @Autowired
    private HardwareService hardwareService;

    public static void main(String[] args) {
        SpringApplication.run(HardwareappApplication.class, args);
    }
}
