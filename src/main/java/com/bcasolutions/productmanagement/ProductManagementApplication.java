package com.bcasolutions.productmanagement;
import com.bcasolutions.productmanagement.services.ProductSvc;
import com.bcasolutions.productmanagement.services.impl.ProductSvcImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductManagementApplication {
	@Bean
	public ProductSvc productSvc()
	{
		return new ProductSvcImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
}
