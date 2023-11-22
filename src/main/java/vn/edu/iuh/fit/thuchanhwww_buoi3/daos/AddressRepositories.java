package vn.edu.iuh.fit.thuchanhwww_buoi3.daos;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AddressRepositories extends AbstractRepositories<Address, UUID> {
    public AddressRepositories(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Address> getAll() {
        String sql = "SELECT * FROM address";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }

    @Override
    public Optional<Address> getByID(UUID uuid) {
        String sql = "SELECT * FROM address WHERE id = ?";
        try {
            Address address = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), uuid);
            return Optional.ofNullable(address);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); //
        }

    }

    @Override
    public boolean add(Address entity) throws Exception {
        String sql = "INSERT INTO address (id, street, city, country, number, zipcode) VALUES (?, ?, ?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, entity.getId(), entity.getStreet(), entity.getCity(), entity.getCountry(), entity.getNumber(), entity.getZipcode());

        return rowsAffected > 0;
    }

    @Override
    public boolean update(Address entity) {
        String sql = "UPDATE address SET street = ?, city = ?, country = ?, number = ?, zipcode = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, entity.getStreet(), entity.getCity(), entity.getCountry(), entity.getNumber(), entity.getZipcode(), entity.getId());
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM address WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, uuid);

        return rowsAffected > 0;
    }
}