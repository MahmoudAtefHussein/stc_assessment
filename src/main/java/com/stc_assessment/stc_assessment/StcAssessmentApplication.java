package com.stc_assessment.stc_assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StcAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StcAssessmentApplication.class, args);
		systemInit();
	}

	private static void systemInit() {
		System.out.println("******************************************************************************************");
		System.out.println("   _____ _______ _____                                                       _   \n" +
				"  / ____|__   __/ ____|     /\\                                              | |  \n" +
				" | (___    | | | |         /  \\   ___ ___  ___  ___ ___ _ __ ___   ___ _ __ | |_ \n" +
				"  \\___ \\   | | | |        / /\\ \\ / __/ __|/ _ \\/ __/ __| '_ ` _ \\ / _ \\ '_ \\| __|\n" +
				"  ____) |  | | | |____   / ____ \\\\__ \\__ \\  __/\\__ \\__ \\ | | | | |  __/ | | | |_ \n" +
				" |_____/   |_|  \\_____| /_/    \\_\\___/___/\\___||___/___/_| |_| |_|\\___|_| |_|\\__|\n" +
				"                                                                                 ");
		System.out.println("***************************************************************** Back End Started *******");

	}

}
