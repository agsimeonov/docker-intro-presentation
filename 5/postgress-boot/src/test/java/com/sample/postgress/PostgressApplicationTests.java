package com.sample.postgress;

import static org.junit.Assert.assertFalse;

import com.sample.postgress.service.EmployeeService;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {PostgressApplicationTests.Initializer.class})
public class PostgressApplicationTests {

	@ClassRule
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres")
			.withDatabaseName("postgres").withUsername("postgres").withPassword("admin");

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
							"spring.datasource.username=" + postgreSQLContainer.getUsername(),
							"spring.datasource.password=" + postgreSQLContainer.getPassword())
					.applyTo(configurableApplicationContext.getEnvironment());
		}
	}

	@Autowired
	private EmployeeService service;

	@Test
	public void contextLoads() {
		System.out.println(service.findAll());
		assertFalse(service.findAll().isEmpty());
	}
}
