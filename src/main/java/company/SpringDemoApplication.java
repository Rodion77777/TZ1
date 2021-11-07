package company;

import company.api.controllers.ProductController;
import company.business.services.ProductServiceImpl;
import company.domain.repository.ProductRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication
{
    public static void main (String[] args)
    {
        new ProductController(new ProductServiceImpl(new ProductRepositoryImpl())).getVarProducts();
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
