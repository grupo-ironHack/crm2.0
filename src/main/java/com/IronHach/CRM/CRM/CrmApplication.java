package com.IronHach.CRM.CRM;

import com.IronHach.CRM.CRM.models.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		String action = "";

		Boolean quitApp = true;
		try {
			Steps.greeting();
			while (quitApp) {
				action = Steps.menu();
				quitApp = Steps.actions(action);
				action = "";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

