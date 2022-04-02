package hr.tvz.osrecki.hardwareapp.service;

import hr.tvz.osrecki.hardwareapp.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {

    List<HardwareDTO> findAll();

    HardwareDTO findByCode(String code);
}
