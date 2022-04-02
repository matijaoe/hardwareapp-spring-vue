package hr.tvz.osrecki.hardwareapp.service;

import hr.tvz.osrecki.hardwareapp.dto.HardwareDTO;
import hr.tvz.osrecki.hardwareapp.model.Hardware;
import hr.tvz.osrecki.hardwareapp.model.HardwareType;
import hr.tvz.osrecki.hardwareapp.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        Optional<Hardware> hardware = hardwareRepository.findByCode(code);
        if (hardware.isPresent() && hardware.get().getType().equals(HardwareType.GPU) && hardware.get().getAvailableCount() < 3) {
            return Optional.of(new HardwareDTO(hardware.get().getName(), hardware.get().getPrice() * 2));
        }
        return Optional.of(mapHardwareToDTO(hardware.get()));
    }

    private HardwareDTO mapHardwareToDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }
}
