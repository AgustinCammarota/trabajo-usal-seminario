package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaApplication.class, args);
    }

    public void run(String... args) throws Exception {
        String password = "1234";
        //PUEDO USAR EL passwordEncoder para crear passsword encriptadas, necesarias para poder usar sprin security desde la base de datos:
        for (int i = 0; i < 2; i++) {
            String passwordEncriptada = passwordEncoder.encode(password);
            System.out.println(passwordEncriptada);
        }
    }
}
