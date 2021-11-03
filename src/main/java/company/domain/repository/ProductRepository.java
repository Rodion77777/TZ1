package company.domain.repository;

import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity findById (long id);
    void save (ProductEntity productEntity);
    void update (ProductEntity productEntity);
    void delete (ProductEntity productEntity);
    List<ProductEntity> findAll ();
    List<ProductEntity> findByManufacturerId (ManufacturerEntity manufacturerEntity);
}