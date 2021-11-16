package company.domain.managers;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.domain.repository.CountryRepository;
import company.domain.repository.ManufacturedRepository;
import company.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static java.lang.System.out;

public class SaveManager
{
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ManufacturedRepository manufacturedRepository;
    @Autowired
    private ProductRepository productRepository;

    public InDatabase inDatabase;


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
