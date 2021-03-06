package company;

import company.domain.components.*;
import company.domain.configuration.Motherboards;
import company.domain.configuration.Processors;
import company.domain.entity.*;
import company.domain.managers.*;
import company.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class HibernateApplication
{
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ManufacturedRepository manufacturedRepository;
    @Autowired
    private ProductRepository productRepository;
    List<CountryEntity> countryEntityList;
    List<ManufacturerEntity> manufacturerEntityList;
    List<ProductEntity> productEntityList;

    public HibernateApplication ()
    {
        this.countryEntityList = new ArrayList<>();
        this.manufacturerEntityList = new ArrayList<>();
        this.productEntityList = new ArrayList<>();
    }

    public void run ()
    {
        //createObjects();
        //new SaveManager().inDatabase.saveAllEntity(countryEntityList, manufacturerEntityList, productEntityList);

        new CountryManager().showDatabaseTable();
        new ManufacturerManager().shotDatabaseTable();
        new ProductManager().showDatabaseTable();

        ProductEntity pe = productRepository.findById(180L).get();
        List<ProductEntity> pel = (List<ProductEntity>) productRepository.findAll();
        new ProductManager().showThis(pe);
        new ProductManager().showThis(pel);
    }

    public void createObjects ()
    {
        out.println("Creating Objects: country, manufactured and product");

        CountryEntity TAIWAN = new CountryEntity(Countries.TAIWAN.toString());
        ManufacturerEntity ASUS = new ManufacturerEntity(Manufacturers.ASUS.toString(), TAIWAN);

        ProductEntity CROSSHAIR = new ProductEntity(
                Motherboards.ROG_CROSSHAIR_IIIV.toString(),
                Category.MOTHERBOARD.toString(),
                13000.1, 1, ASUS);
        ASUS.addProductEntity(CROSSHAIR);

        ProductEntity PRIME = new ProductEntity(
                Motherboards.PRIME_X370_PRO.toString(),
                Category.MOTHERBOARD.toString(),
                3400.5, 1, ASUS);
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

        ManufacturerEntity INTEL = new ManufacturerEntity(Manufacturers.INTEL.toString(), USA);

        ProductEntity ALDER_LAKE = new ProductEntity(
                Processors.ALDER_LAKE_12900K.toString(),
                Category.PROCESSOR.toString(),
                15600.1, 1, INTEL);
        INTEL.addProductEntity(ALDER_LAKE);

        out.println("Object creation successfully completed!");

        countryEntityList.add(TAIWAN);
        countryEntityList.add(USA);
        manufacturerEntityList.add(ASUS);
        manufacturerEntityList.add(AMD);
        manufacturerEntityList.add(INTEL);
        productEntityList.add(CROSSHAIR);
        productEntityList.add(PRIME);
        productEntityList.add(RYZEN_9);
        productEntityList.add(RYZEN_5);
        productEntityList.add(ALDER_LAKE);
    }

    public void clearAllEntityList ()
    {
        countryEntityList = null;
        manufacturerEntityList = null;
        productEntityList = null;
    }
}