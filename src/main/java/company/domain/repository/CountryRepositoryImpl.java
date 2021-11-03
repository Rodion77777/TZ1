package company.domain.repository;

import company.domain.entity.CountryEntity;
import org.hibernate.Session;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository
{

    @Override
    public CountryEntity findById(long id) {

        return null;
    }

    @Override
    public void save(CountryEntity countryEntity) {

    }

    @Override
    public void update(CountryEntity countryEntity) {

    }

    @Override
    public void delete(CountryEntity countryEntity) {

    }

    @Override
    public List<CountryEntity> findAll() {
        return null;
    }

    public void clearCountriesTable () {}
}
