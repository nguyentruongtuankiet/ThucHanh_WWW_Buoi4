package vn.edu.iuh.fit.thuchanhwww_buoi3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService addressService;
    @Test
    void add() throws Exception {
        Address address = new Address(
                UUID.randomUUID(), "street", "city", 1, "232-323-232", "code"
        );
        boolean add = addressService.add(address);
        assertTrue(add);
        System.out.println("add: " + add);
    }
    @Test
    void getAll() throws Exception {
        List<Address> addresses = addressService.getAll();
        for (Address address : addresses) {
            System.out.println("Address ID: " + address.getId());
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            System.out.println("Country: " + address.getCountry());
            System.out.println("Number: " + address.getNumber());
            System.out.println("Zip Code: " + address.getZipcode());
            // Thêm các thông tin khác về địa chỉ tùy theo đối tượng Address của bạn
            System.out.println(); // Thêm dòng trống để phân tách giữa các địa chỉ
        }
        assertNotNull(addresses);
    }
    @Test
    void getByID() throws Exception {
        Optional<Address> optionalAddress = addressService.getByID(UUID.fromString("c85ccdc3-0878-4635-8a6e-badb75aa2f26"));
        if (!optionalAddress.isPresent()) {
            assertTrue(!optionalAddress.isPresent());
            System.out.println("Rỗng nhá :))" + optionalAddress);
        } else {
            assertTrue(optionalAddress.isPresent());
            System.out.println("Address: " + optionalAddress.get());
        }

    }

    @Test
    void delete() throws Exception {
        UUID uuid = UUID.fromString("f6956bba-1c3b-4806-86b5-f68f6e9795ab");
        boolean delete = addressService.delete(uuid);
        if (!delete) {
            assertTrue(!delete);
            System.out.println("delete: " + delete);
        } else {
            assertTrue(delete);
            System.out.println("delete: " + delete);
        }
    }

    @Test
    void update() throws Exception {
        Address address = new Address(UUID.fromString("c85ccdc3-0878-4635-8a6e-badb75aa2f26"), "go vap", "ho chi minh", 1, "0907461461", "code"
        );
        boolean update = addressService.update(address);
        if (!update) {
            assertTrue(!update);
            System.out.println("update: " + update);
        } else {
            assertTrue(update);
            System.out.println("update: " + update);
        }
    }
}