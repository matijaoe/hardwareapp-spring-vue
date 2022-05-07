package hr.tvz.osrecki.hardwareapp.hardware.service;

import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareCommand;
import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    List<HardwareDTO> searchByCode(String query);

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand command);

    Optional<HardwareDTO> update(String code, HardwareCommand command);

    void delete(String code);
}
