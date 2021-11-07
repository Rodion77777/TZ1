package company.api.controllers;

import company.business.DTO.ProductDTO;
import company.business.services.ProductService;
import company.domain.entity.ProductEntity;
import company.domain.managers.ShowManager;
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


    @GetMapping("/getProductDTO")
    public ProductDTO getProductDTO ()
    {
        return productService.getProductDTO();
    }

    @GetMapping("/getVarProducts")
    public List<ProductDTO> getVarProducts ()
    {
        var varProducts = productService.getAllProducts();
        new ShowManager().inConsole.showThis(varProducts);
        return varProducts;
    }
}
