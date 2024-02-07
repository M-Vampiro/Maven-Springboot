package com.vtxlab.bootcamp.demosbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  // Simulate the actual process of " mvn spring-boot:run "
// Testing @SpringBootApplication -> @Component + @Autowired
// To trigger @SpringBootTest, we use "mav clean test"
class DemoSbFakeDatabaseApplicationTests {

	// In @SpringBootTest environment
	// the spring context will contain all your custom beans
	// i.e. @Controller, @Service, @Configuration, @Bean

	@Test // At least one @Test to start up the test environment
	void contextLoads() {
	}

}
