package company.domain.repository;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;

import java.util.List;

public class ManufacturedRepositoryImpl implements ManufacturedRepository
{

    @Override
    public ManufacturerEntity findById(long id) {
        return null;
    }

    @Override
    public void save(ManufacturerEntity manufacturerEntity) {

    }

    @Override
    public void update(ManufacturerEntity manufacturerEntity) {

    }

    @Override
    public void delete(ManufacturerEntity manufacturerEntity) {

    }

    @Override
    public List<ManufacturerEntity> findAll() {
        return null;
    }

    @Override
    public List<ManufacturerEntity> findByCountryId(CountryEntity countryEntity) {
        return null;
    }

    public void clearManufacturersTable () {}
}
