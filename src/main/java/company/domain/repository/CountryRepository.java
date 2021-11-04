package company.domain.repository;


import company.domain.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {
    CountryEntity findById (long id);
    void save (CountryEntity countryEntity);
    void update (CountryEntity countryEntity);
    void delete (CountryEntity countryEntity);
    List<CountryEntity> findAll ();
}
