package company.business.services;

import company.business.DTO.ProductDTO;
import company.business.DTO.components.CountryDTO;
import company.business.DTO.components.ManufacturerDTO;
import company.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService
{
    private ProductRepository productRepository;

    public ProductServiceImpl (ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts()
    {
        return productRepository
                .findAll()
                .stream().map(p -> new ProductDTO(
                        p.getProductId(),
                        p.getProductName(),
                        p.getProductManufacturerDate(),
                        new ManufacturerDTO(
                                p.getManufacturerEntity().getManufacturerId(),
                                p.getManufacturerEntity().getManufacturerName(),
                                new CountryDTO(
                                        p.getManufacturerEntity().getCountryEntity().getCountryId(),
                                        p.getManufacturerEntity().getCountryEntity().getCountryName()
                                )
                        ),
                        p.getProductCategory(),
                        p.getProductPrice(),
                        p.getProductCount()))
                .collect(Collectors.toList());
    }
}
