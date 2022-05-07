package hr.tvz.osrecki.hardwareapp.hardware.repository;

import hr.tvz.osrecki.hardwareapp.hardware.model.Hardware;
import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareType;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static final String SELECT_ALL = "SELECT id, code, name, price, type, quantity FROM hardware ";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public HardwareRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Hardware> findAll() {
        List<Hardware> hardware = new ArrayList<>();
        try {
            hardware = jdbc.query(SELECT_ALL, this::mapRowToHardware);
            return hardware;
        } catch (EmptyResultDataAccessException e) {
            return hardware;
        }
    }

    @Override
    public List<Hardware> searchByCode(String query) {
        List<Hardware> hardware = new ArrayList<>();
        try {
            String pattern = query + "%";
            return jdbc.query(SELECT_ALL + " WHERE LOWER(code) LIKE LOWER(?)", this::mapRowToHardware, pattern);
        } catch (EmptyResultDataAccessException e) {
            return hardware;
        }
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT_ALL + "WHERE code = ?", this::mapRowToHardware, code));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        try {
            hardware.setId(saveHardwareDetails(hardware));
            return Optional.of(hardware);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> update(String code, Hardware hardware) {
        String sql = "UPDATE hardware SET " + "code = ?, " + "name = ?, " + "price = ?, " + "type = ?, " + "quantity = ? " + "WHERE code = ?";

        int executed = jdbc.update(sql, hardware.getCode(), hardware.getName(), hardware.getPrice(), hardware.getType().toString(), hardware.getQuantity(), code);

        System.out.println(executed);

        if (executed > 0) {
            return Optional.of(hardware);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        jdbc.update("DELETE FROM hardware WHERE code = ?", code);
    }

    private Long saveHardwareDetails(Hardware hardware) {
        Map<String, Object> values = new HashMap<>();

        values.put("code", hardware.getCode());
        values.put("name", hardware.getName());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType().toString());
        values.put("quantity", hardware.getQuantity());

        return inserter.executeAndReturnKey(values).longValue();
    }

    private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException {
        return new Hardware(rs.getLong("id"), rs.getString("code"), rs.getString("name"), rs.getDouble("price"), HardwareType.valueOf(rs.getString("type")), rs.getInt("quantity"));
    }
}
