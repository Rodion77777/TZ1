package company.api.controllers;

import company.business.models.ProductDTO;
import company.business.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts ()
    {
        return productService.getAllProducts();
    }
}
