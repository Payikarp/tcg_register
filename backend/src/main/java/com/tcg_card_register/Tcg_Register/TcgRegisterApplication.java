package com.tcg_card_register.Tcg_Register;

import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication()
public class TcgRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcgRegisterApplication.class, args);

	}

}
