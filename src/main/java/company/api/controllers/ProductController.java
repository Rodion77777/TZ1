package company.api.controllers;

import company.business.DTO.ProductDTO;
import company.business.services.ProductService;
import company.domain.managers.DTOManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static java.lang.System.out;

@RestController
public class ProductController {
    private ProductService productService;
    private String marker = "*\n".repeat(50);

    public ProductController (ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts ()
    {
        out.println(marker);
        return productService.getAllProducts();
    }


    @GetMapping("/getProductDTO")
    public ProductDTO getProductDTO ()
    {
        out.println(marker);
        return productService.getProductDTO();
    }

    @GetMapping("/getAllVarProducts")
    public List<ProductDTO> getVarProducts ()
    {
        out.println(marker);
        var varProducts = productService.getAllProducts();
        new DTOManager().showThis((ProductDTO) varProducts);
        return varProducts;
    }

    @GetMapping("/getOneVarProduct")
    public ProductDTO getOneVarProduct ()
    {
        var varProduct = productService.getProductDTO();
        new DTOManager().showThis(varProduct);
        return varProduct;
    }
}
