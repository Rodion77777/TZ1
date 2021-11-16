package company.business.services;

import company.business.DTO.ProductDTO;
import company.business.DTO.components.CountryDTO;
import company.business.DTO.components.ManufacturerDTO;
import company.domain.entity.ProductEntity;
import company.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
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
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(p -> new ProductDTO(
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

    @Override
    public ProductDTO getProductDTOById (long id)
    {
        ProductEntity pe = productRepository.findById(id).get();

        CountryDTO countryDTO = new CountryDTO(
                pe.getManufacturerEntity().getCountryEntity().getCountryId(),
                pe.getManufacturerEntity().getCountryEntity().getCountryName());

        ManufacturerDTO manufacturerDTO = new ManufacturerDTO(
                pe.getManufacturerEntity().getManufacturerId(),
                pe.getManufacturerEntity().getManufacturerName(),
                countryDTO);

        return new ProductDTO(
                pe.getProductId(),
                pe.getProductName(),
                pe.getProductManufacturerDate(),
                manufacturerDTO,
                pe.getProductCategory(),
                pe.getProductPrice(),
                pe.getProductCount());
    }
}
