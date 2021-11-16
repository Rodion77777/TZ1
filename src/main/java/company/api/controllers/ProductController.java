package company.api.controllers;

import company.business.DTO.ProductDTO;
import company.business.services.ProductService;
import company.domain.managers.DTOManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts ()
    {
        return productService.getAllProducts();
    }


    @GetMapping("/getProductDTO")
    public ProductDTO getProductDTO (@RequestParam long id)
    {
        return productService.getProductDTOById(id);
    }

    @GetMapping("/getAllVarProducts")
    public List<ProductDTO> getVarProducts ()
    {
        var varProducts = productService.getAllProducts();
        new DTOManager().showThis((ProductDTO) varProducts);
        return varProducts;
    }

    @GetMapping("/getOneVarProduct")
    public ProductDTO getOneVarProduct (@RequestParam long id)
    {
        var varProduct = productService.getProductDTOById (id);
        new DTOManager().showThis(varProduct);
        return varProduct;
    }
}
