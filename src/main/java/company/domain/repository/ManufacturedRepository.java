package company.domain.repository;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;

import java.util.List;

public interface ManufacturedRepository {
    ManufacturerEntity findById (long id);
    void save (ManufacturerEntity manufacturerEntity);
    void update (ManufacturerEntity manufacturerEntity);
    void delete (ManufacturerEntity manufacturerEntity);
    List<ManufacturerEntity> findAll ();
    List<ManufacturerEntity> findByCountryEntity(CountryEntity countryEntity);
}
