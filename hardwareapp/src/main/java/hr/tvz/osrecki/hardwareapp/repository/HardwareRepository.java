package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Hardware;

import java.util.Optional;
import java.util.Set;

public interface HardwareRepository {

    Set<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Optional<Hardware> save(Hardware hardware);

    Optional<Hardware> update(Hardware hardware);

    void deleteByCode(String code);
}
