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
            new Hardware("AMD Ryzen 5 5600GE", "N82E16819113683", 220.00, HardwareType.CPU, 22),
            new Hardware("AMD Ryzen 9 5900X", "N82E16819113664", 395.00, HardwareType.CPU, 11),
            new Hardware("AMD Ryzen 7 5800X", "N82E16819113665", 359.00, HardwareType.CPU, 28),
            new Hardware("GIGABYTE Gaming GeForce RTX 3070 Ti", "N82E16814932443", 858.33, HardwareType.GPU, 3),
            new Hardware("SAMSUNG 970 EVO PLUS", "MZV7S500BAM", 69.99, HardwareType.STORAGE, 31),
            new Hardware("Western Digital WD BLACK SN850", "WDS100T1X0E", 149.99, HardwareType.STORAGE, 18),
            new Hardware("Crucial Ballistix MAX 4400 MHz", "BLM2K8G44C19U4B", 79.99, HardwareType.STORAGE, 20),
            new Hardware("G.SKILL Ripjaws V Series 16GB DDR4", "N82E16820232880", 85.99, HardwareType.RAM, 16),
            new Hardware("OLOy Blade RGB 32GB DDR5", "N82E16820821488", 309.99, HardwareType.RAM, 3),
            new Hardware("CORSAIR Vengeance RGB Pro 32GB", "CMW32GX4M2D3600C18", 124.99, HardwareType.RAM, 9),
            new Hardware("Asus ROG STRIX B550-F", "N82E16813119500", 229.99, HardwareType.MBO, 1),
            new Hardware("ASUS ROG Maximus Z690 Hero", "N82E16813119504", 599.99, HardwareType.MBO, 5)
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


