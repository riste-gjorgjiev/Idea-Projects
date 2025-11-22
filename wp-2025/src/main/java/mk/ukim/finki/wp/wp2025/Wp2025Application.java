package mk.ukim.finki.wp.wp2025;

import mk.ukim.finki.wp.wp2025.servlet.HelloWorldServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Wp2025Application {
    public static void main(String[] args) {
        SpringApplication.run(Wp2025Application.class, args);
    }


    @Bean
    public ServletRegistrationBean<HelloWorldServlet> helloServlet(){
        return new ServletRegistrationBean<>(new HelloWorldServlet(), "/hello", "/");
    }
}
