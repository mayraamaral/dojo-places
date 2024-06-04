package br.com.alura.dojoplaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DojoPlacesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DojoPlacesApplication.class, args);
    }
}
