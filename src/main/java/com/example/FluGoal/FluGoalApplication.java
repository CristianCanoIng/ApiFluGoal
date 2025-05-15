package com.example.FluGoal;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluGoalApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(FluGoalApplication.class, args);
	}

	private static void loadEnv() {
		// Solo cargar .env si NO estamos en producción
		String isRender = System.getenv("RENDER"); // Render define esta variable automáticamente

		if (isRender == null) {
			try {
				Dotenv dotenv = Dotenv.load();
				System.setProperty("DB_URL", dotenv.get("DB_URL"));
				System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
				System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
			} catch (Exception e) {
				System.err.println("No se pudo cargar el archivo .env: " + e.getMessage());
			}
		} else {
			// En Render, las variables ya están en el entorno y no es necesario usar dotenv
			System.out.println("Entorno de producción detectado (Render). Usando variables de entorno del sistema.");
		}
	}
}
