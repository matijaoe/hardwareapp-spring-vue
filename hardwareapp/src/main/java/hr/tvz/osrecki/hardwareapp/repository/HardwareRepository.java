package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Optional<Hardware> save(Hardware hardware);

    Optional<Hardware> update(String code, Hardware updatedHardware);

    void deleteByCode(String code);
}
