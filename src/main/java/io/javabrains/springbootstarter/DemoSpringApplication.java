package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@Configuration
@ComponentScan({"controller","springbootstarter"})
@EnableAutoConfiguration*/
@SpringBootApplication
public class DemoSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}
}
