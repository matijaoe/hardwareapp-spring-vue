package hr.tvz.osrecki.hardwareapp.service;

import hr.tvz.osrecki.hardwareapp.dto.HardwareDTO;
import hr.tvz.osrecki.hardwareapp.model.HardwareCommand;

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
