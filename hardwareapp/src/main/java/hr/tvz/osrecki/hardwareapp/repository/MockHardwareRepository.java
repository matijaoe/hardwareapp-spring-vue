package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Hardware;
import hr.tvz.osrecki.hardwareapp.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private final Set<Hardware> MOCK_HARDWARE = new HashSet<>(Arrays.asList(
            new Hardware("BX8071512700K", "Intel Core i7-12700K", 384.98, HardwareType.CPU, 14),
            new Hardware("BX8071512900K", "Intel Core i9-12900K", 614.99, HardwareType.CPU, 6),
            new Hardware("N82E16819113683", "AMD Ryzen 5 5600GE", 220.00, HardwareType.CPU, 22),
            new Hardware("N82E16819113664", "AMD Ryzen 9 5900X", 395.00, HardwareType.CPU, 11),
            new Hardware("N82E16819113665", "AMD Ryzen 7 5800X", 359.00, HardwareType.CPU, 28),
            new Hardware("N82E16814932443", "GIGABYTE Gaming GeForce RTX 3070 Ti", 858.33, HardwareType.GPU, 3),
            new Hardware("MZV7S500BAM", "SAMSUNG 970 EVO PLUS", 69.99, HardwareType.STORAGE, 31),
            new Hardware("WDS100T1X0E", "Western Digital WD BLACK SN850", 149.99, HardwareType.STORAGE, 18),
            new Hardware("BLM2K8G44C19U4B", "Crucial Ballistix MAX 4400 MHz", 79.99, HardwareType.STORAGE, 20),
            new Hardware("N82E16820232880", "G.SKILL Ripjaws V Series 16GB DDR4", 85.99, HardwareType.RAM, 16),
            new Hardware("N82E16820821488", "OLOy Blade RGB 32GB DDR5", 309.99, HardwareType.RAM, 3),
            new Hardware("CMW32GX4M2D3600C18", "CORSAIR Vengeance RGB Pro 32GB", 124.99, HardwareType.RAM, 9),
            new Hardware("N82E16813119500", "Asus ROG STRIX B550-F", 229.99, HardwareType.MBO, 1),
            new Hardware("N82E16813119504", "ASUS ROG Maximus Z690 Hero", 599.99, HardwareType.MBO, 5)
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
        if (!MOCK_HARDWARE.contains(hardware)) {
            MOCK_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Hardware> update(final String code, final Hardware updatedHardware) {
        boolean exists = MOCK_HARDWARE.removeIf(
                item -> Objects.equals(item.getCode(), code) &&
                        Objects.equals(item.getCode(), updatedHardware.getCode())
        );

        if (exists) {
            MOCK_HARDWARE.add(updatedHardware);
            return Optional.of(updatedHardware);
        }
        return Optional.empty();
    }

    @Override
    public void deleteByCode(final String code) {
        MOCK_HARDWARE.removeIf(item -> Objects.equals(item.getCode(), code));
    }
}


