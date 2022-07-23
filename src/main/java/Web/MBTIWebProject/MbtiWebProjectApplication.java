package Web.MBTIWebProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MbtiWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbtiWebProjectApplication.class, args);
	}

}
