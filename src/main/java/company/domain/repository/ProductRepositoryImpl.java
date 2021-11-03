package company.domain.repository;

import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository
{

    @Override
    public ProductEntity findById(long id) {
        return null;
    }

    @Override
    public void save(ProductEntity productEntity) {

    }

    @Override
    public void update(ProductEntity productEntity) {

    }

    @Override
    public void delete(ProductEntity productEntity) {

    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public List<ProductEntity> findByManufacturerId(ManufacturerEntity manufacturerEntity) {
        return null;
    }

    public void clearProductsTable () {}
}
