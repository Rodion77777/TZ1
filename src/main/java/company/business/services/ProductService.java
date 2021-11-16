package company.business.services;

import company.business.DTO.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService
{
    List<ProductDTO> getAllProducts ();
    ProductDTO getProductDTOById (long id);
}
