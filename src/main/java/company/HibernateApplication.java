package company;

import company.domain.configuration.Motherboards;
import company.domain.entity.*;
import company.domain.repository.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HibernateApplication {

    private final CountryRepository countryRepository;
    private final ManufacturedRepository manufacturedRepository;
    private final ProductRepository productRepository;
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
    }

    public void createObjects ()
    {
        out.println("Creating Objects: country, manufactured and product");

        CountryEntity TAIWAN = new CountryEntity(Countries.TAIWAN.toString());
        ManufacturerEntity ASUS = new ManufacturerEntity(Manufacturers.ASUS.toString(), TAIWAN);
        ProductEntity CROSSHAIR = new ProductEntity(
                Motherboards.ROG_CROSSHAIR_IIIV.toString(),
                Category.MOTHERBOARD.toString(),
                13000.00, 1, ASUS);
        ASUS.addProductEntity(CROSSHAIR);

        out.println("Object creation successfully completed!");

        out.println("Recording of objects in the database...");
        countryRepository.save(TAIWAN);
        manufacturedRepository.save(ASUS);
        productRepository.save(CROSSHAIR);
        out.println("Database entry completed!");

        countryEntityList.add(TAIWAN);
        manufacturerEntityList.add(ASUS);
        productEntityList.add(CROSSHAIR);
    }
}
