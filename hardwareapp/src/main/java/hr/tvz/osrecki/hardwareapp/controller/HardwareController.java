package hr.tvz.osrecki.hardwareapp.controller;

import hr.tvz.osrecki.hardwareapp.dto.HardwareDTO;
import hr.tvz.osrecki.hardwareapp.model.HardwareCommand;
import hr.tvz.osrecki.hardwareapp.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("hardware")
public class HardwareController {

    private final HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.findAll();
    }

    @GetMapping("{code}")
    public ResponseEntity<HardwareDTO> getHardware(@PathVariable String code) {
        return hardwareService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command) {
        return hardwareService.save(command)
                .map(dto -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(dto)
                )
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        hardwareService.delete(code);
    }
}
