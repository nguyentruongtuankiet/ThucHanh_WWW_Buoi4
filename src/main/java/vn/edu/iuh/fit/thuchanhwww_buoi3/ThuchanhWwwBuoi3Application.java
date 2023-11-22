package vn.edu.iuh.fit.thuchanhwww_buoi3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;
import vn.edu.iuh.fit.thuchanhwww_buoi3.service.AddressService;

import java.util.UUID;

@SpringBootApplication
public class ThuchanhWwwBuoi3Application {
    @Autowired
    private AddressService addressService;
    public static void main(String[] args) {


        SpringApplication.run(ThuchanhWwwBuoi3Application.class, args);
        System.out.println("Tuan Kiet");
    }

//    @Bean
//    public CommandLineRunner testService(){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                Address address = new Address(
//						UUID.randomUUID(),"street","city",1,"232-323-232","code"
//				);
//                System.out.println(addressService.add(address));
//            }
//        };
//    };


}
