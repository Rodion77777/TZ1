package company;

import company.domain.components.Category;
import company.domain.components.Countries;
import company.domain.components.Manufacturers;
import company.domain.configuration.Motherboards;
import company.domain.configuration.Processors;
import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.domain.repository.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HibernateApplication {

    private final CountryRepositoryImpl countryRepository;
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final ProductRepositoryImpl productRepository;
    List<CountryEntity> countryEntityList;
    List<ManufacturerEntity> manufacturerEntityList;
    List<ProductEntity> productEntityList;

    public HibernateApplication ()
    {
        this.countryRepository = new CountryRepositoryImpl();
        this.manufacturedRepository = new ManufacturedRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        this.countryEntityList = new ArrayList<>();
        this.manufacturerEntityList = new ArrayList<>();
        this.productEntityList = new ArrayList<>();
    }

    public void run ()
    {
        createObjects();
        clearDB();
    }

    public void createObjects ()
    {
        out.println("Creating Objects: country, manufactured and product");

        CountryEntity TAIWAN = new CountryEntity(Countries.TAIWAN.toString());
        ManufacturerEntity ASUS = new ManufacturerEntity(Manufacturers.ASUS.toString(), TAIWAN);

        ProductEntity CROSSHAIR = new ProductEntity(
                Motherboards.ROG_CROSSHAIR_IIIV.toString(),
                Category.MOTHERBOARD.toString(),
                13000, 1, ASUS);
        ASUS.addProductEntity(CROSSHAIR);

        ProductEntity PRIME = new ProductEntity(
                Motherboards.PRIME_X370_PRO.toString(),
                Category.MOTHERBOARD.toString(),
                3400, 1, ASUS);
        ASUS.addProductEntity(PRIME);

        CountryEntity USA = new CountryEntity(Countries.USA.toString());
        ManufacturerEntity AMD = new ManufacturerEntity(Manufacturers.AMD.toString(), USA);

        ProductEntity RYZEN_9 = new ProductEntity(
                Processors.RYZEN_9_3900_XT.toString(),
                Category.PROCESSOR.toString(),
                16000, 1, AMD);
        AMD.addProductEntity(RYZEN_9);

        ProductEntity RYZEN_5 = new ProductEntity(
                Processors.RYZEN_5_1600.toString(),
                Category.PROCESSOR.toString(),
                3100, 1, AMD);
        AMD.addProductEntity(RYZEN_5);

        out.println("Object creation successfully completed!");

        out.println("Recording of objects in the database...");
        countryRepository.save(TAIWAN);
        manufacturedRepository.save(ASUS);
        manufacturedRepository.save(AMD);
        //productRepository.save(CROSSHAIR); // порождает ошибку - такой обьект уже есть
        //productRepository.save(PRIME);
        //productRepository.save(RYZEN_9);
        //productRepository.save(RYZEN_5);
        out.println("Database entry completed!");

        countryEntityList.add(TAIWAN);
        manufacturerEntityList.add(ASUS);
        manufacturerEntityList.add(AMD);
        productEntityList.add(CROSSHAIR);
        productEntityList.add(RYZEN_9);
        productEntityList.add(RYZEN_5);
    }

    public void show () {}

    public void clearDB ()
    {
        countryRepository.clearCountriesTable();
        manufacturedRepository.clearManufacturersTable();
        productRepository.clearProductsTable();
        countryEntityList = null;
        manufacturerEntityList = null;
        productEntityList = null;
    }
}
