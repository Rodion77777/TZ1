package company.domain.managers;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.domain.repository.CountryRepositoryImpl;
import company.domain.repository.ManufacturedRepositoryImpl;
import company.domain.repository.ProductRepositoryImpl;

import java.util.List;

import static java.lang.System.out;

public class SaveManager
{
    private final CountryRepositoryImpl countryRepository;
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final ProductRepositoryImpl productRepository;
    public final InDatabase inDatabase;

    public SaveManager ()
    {
        this.countryRepository = new CountryRepositoryImpl();
        this.manufacturedRepository = new ManufacturedRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        inDatabase = new InDatabase();
    }

    public class InDatabase
    {
        public void saveAllEntity (List<CountryEntity> countryEntityList, List<ManufacturerEntity> manufacturerEntityList, List<ProductEntity> productEntityList)
        {
            out.println("Recording of objects in the database...");

            saveCountries(countryEntityList);
            saveManufacturers(manufacturerEntityList);
            saveProducts(productEntityList);

            out.println("Database entry completed!");
        }

        public void saveCountries (List<CountryEntity> countryEntityList)
        {
            for (CountryEntity ce : countryEntityList)
            {
                countryRepository.save(ce);
            }
            out.println("Countries successfully recorded.");
        }

        public void saveManufacturers (List<ManufacturerEntity> manufacturerEntityList)
        {
            for (ManufacturerEntity me : manufacturerEntityList)
            {
                manufacturedRepository.save(me);
            }
            out.println("Manufacturers successfully recorded.");


        }

        public void saveProducts (List<ProductEntity> productEntityList)
        {
            for (ProductEntity pe : productEntityList)
            {
                productRepository.save(pe);
            }
            out.println("Products successfully recorded.");
        }
    }
}
