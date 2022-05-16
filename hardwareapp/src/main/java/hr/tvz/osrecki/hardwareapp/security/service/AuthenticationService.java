package hr.tvz.osrecki.hardwareapp.security.service;

import hr.tvz.osrecki.hardwareapp.security.command.LoginCommand;
import hr.tvz.osrecki.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
