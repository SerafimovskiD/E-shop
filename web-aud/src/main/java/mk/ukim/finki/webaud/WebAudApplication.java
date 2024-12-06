package mk.ukim.finki.webaud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebAudApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAudApplication.class, args);
    }
}

