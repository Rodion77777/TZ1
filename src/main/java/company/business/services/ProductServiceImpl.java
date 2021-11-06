package company.business.services;

import company.business.models.ProductDTO;
import company.business.models.components.CountryDTO;
import company.business.models.components.ManufacturerDTO;
import company.domain.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService
{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getProducts() {
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
