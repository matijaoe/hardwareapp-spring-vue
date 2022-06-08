package hr.tvz.osrecki.hardwareapp.hardware.service;

import hr.tvz.osrecki.hardwareapp.hardware.model.Hardware;
import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareCommand;
import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareDTO;
import hr.tvz.osrecki.hardwareapp.hardware.repository.HardwareRepository;
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

    public List<HardwareDTO> searchByCode(String query) {
        return hardwareRepository.searchByCode(query).stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(final String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> save(final HardwareCommand command) {
        return hardwareRepository.save(mapCommandToHardware(command)).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> update(final String code, final HardwareCommand command) {
        return hardwareRepository.update(code, mapCommandToHardware(command)).map(this::mapHardwareToDTO);
    }

    @Override
    public void delete(final String code) {
        hardwareRepository.deleteByCode(code);
    }

    private HardwareDTO mapHardwareToDTO(final Hardware hardware) {
        return new HardwareDTO(hardware.getCode(), hardware.getName(), hardware.getPrice(), hardware.getQuantity());
    }

    private Hardware mapCommandToHardware(final HardwareCommand command) {
        return new Hardware(command.getCode(), command.getName(), command.getPrice(), command.getType(), command.getQuantity());
    }

}
