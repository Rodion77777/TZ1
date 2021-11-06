package company.business.services;

import company.business.models.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
}
