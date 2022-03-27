package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Hardware;
import hr.tvz.osrecki.hardwareapp.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private final List<Hardware> MOCK_HARDWARE = Arrays.asList(
            new Hardware("Intel Core i7-12700K", "BX8071512700K", 384.98, HardwareType.CPU, 14),
            new Hardware("Intel Core i9-12900K", "BX8071512900K", 614.99, HardwareType.CPU, 6),
            new Hardware("SAMSUNG 970 EVO PLUS", "MZV7S500BAM", 69.99, HardwareType.STORAGE, 31),
            new Hardware("Western Digital WD BLACK SN850", "WDS100T1X0E", 149.99, HardwareType.STORAGE, 18),
            new Hardware("CORSAIR Vengeance RGB Pro 32GB", "CMW32GX4M2D3600C18", 124.99, HardwareType.RAM, 9),
            new Hardware("GIGABYTE Gaming GeForce RTX 3070 Ti", "N82E16814932443", 858.33, HardwareType.GPU, 3)
    );

    @Override
    public List<Hardware> findAll() {
        return MOCK_HARDWARE;
    }

    @Override
    public Optional<Hardware> findByCode(final String code) {
        return MOCK_HARDWARE.stream().filter(item -> Objects.equals(item.getCode(), code)).findAny();
    }
}


