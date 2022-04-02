package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Hardware;
import hr.tvz.osrecki.hardwareapp.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private final Set<Hardware> MOCK_HARDWARE = new HashSet<>(Arrays.asList(
            new Hardware("Intel Core i7-12700K", "BX8071512700K", 384.98, HardwareType.CPU, 14),
            new Hardware("Intel Core i9-12900K", "BX8071512900K", 614.99, HardwareType.CPU, 6),
            new Hardware("SAMSUNG 970 EVO PLUS", "MZV7S500BAM", 69.99, HardwareType.STORAGE, 31),
            new Hardware("Western Digital WD BLACK SN850", "WDS100T1X0E", 149.99, HardwareType.STORAGE, 18),
            new Hardware("CORSAIR Vengeance RGB Pro 32GB", "CMW32GX4M2D3600C18", 124.99, HardwareType.RAM, 9),
            new Hardware("GIGABYTE Gaming GeForce RTX 3070 Ti", "N82E16814932443", 858.33, HardwareType.GPU, 3)
    ));

    @Override
    public Set<Hardware> findAll() {
        return MOCK_HARDWARE;
    }


    @Override
    public Optional<Hardware> findByCode(final String code) {
        return MOCK_HARDWARE.stream().filter(item -> Objects.equals(item.getCode(), code)).findAny();
    }

    @Override
    public Optional<Hardware> save(final Hardware hardware) {
//        TODO: duplicate error handling response
        if (!MOCK_HARDWARE.contains(hardware)) {
            MOCK_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
        return Optional.empty();
    }


    @Override
    public Optional<Hardware> update(final Hardware hardware) {
        return Optional.empty();
    }

    @Override
    public void deleteByCode(final String code) {
        MOCK_HARDWARE.removeIf(item -> Objects.equals(item.getCode(), code));
    }
}


