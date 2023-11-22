package vn.edu.iuh.fit.thuchanhwww_buoi3.daos;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Candidate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CandidateRepositories  extends AbstractRepositories<Candidate, UUID> {
    public CandidateRepositories(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Candidate> getAll() {
        String sql = "SELECT * FROM candidate";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Candidate.class));
    }

    @Override
    public Optional<Candidate> getByID(UUID uuid) {
        String sql = "SELECT * FROM candidate WHERE id = ?";
        try {
            Candidate candidate = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Candidate.class), uuid);
            return Optional.ofNullable(candidate);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); //
        }
    }

    @Override
    public boolean add(Candidate entity) throws Exception {
        String sql = "INSERT INTO candidate (id, dob, email, full_name, phone, address) VALUES (?, ?, ?, ?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(sql, entity.getId(), entity.getDob(), entity.getEmail(), entity.getFullName(), entity.getPhone(), entity.getAddress());

        return rowsAffected > 0;
    }

    @Override
    public boolean update(Candidate entity) {
        String sql = "UPDATE candidate SET dob = ?, email = ?, full_name = ?, phone = ?, address = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, entity.getDob(), entity.getEmail(), entity.getFullName(), entity.getPhone(), entity.getAddress(), entity.getId());
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM candidate WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, uuid);

        return rowsAffected > 0;
    }
}
