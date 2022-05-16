package hr.tvz.osrecki.hardwareapp.security.service;

import hr.tvz.osrecki.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
