package gr.hua.dit.ds.Katanemimena_Ergasia;

import gr.hua.dit.ds.Katanemimena_Ergasia.Utils.TestJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KatanemimenaErgasiaApplication {

	public static void main(String[] args) throws InterruptedException {
		TestJDBC.TestConnection();

		TimeUnit.SECONDS.sleep(2);

		SpringApplication.run(KatanemimenaErgasiaApplication.class, args);
	}

}
