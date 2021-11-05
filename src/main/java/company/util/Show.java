package company.util;

import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.domain.repository.CountryRepositoryImpl;
import company.domain.repository.ManufacturedRepositoryImpl;
import company.domain.repository.ProductRepositoryImpl;

import java.util.List;

import static java.lang.System.out;

public class Show {

    private final CountryRepositoryImpl countryRepository;
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final ProductRepositoryImpl productRepository;
    public final InConsole inConsole;

    public Show ()
    {
        this.countryRepository = new CountryRepositoryImpl();
        this.manufacturedRepository = new ManufacturedRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        this.inConsole = new InConsole();
    }

    public class InConsole
    {
        public void showAllTable ()
        {
            showCountryTable();
            showManufacturerTable();
            showProductTable();
        }

        public void showCountryTable ()
        {
            List<CountryEntity> countryEntityTable = countryRepository.findAll();
            String doubleLine = "=".repeat(56);

            out.printf("%s\n| %-53s|\n%s\n", doubleLine, "COUNTRY TABLE", doubleLine);
            out.printf("|%21s |%30s |\n%s\n", "ID", "NAME", doubleLine);

            for (CountryEntity ce : countryEntityTable) {
                out.printf("|%21s |%30s |\n", ce.getCountryId(), ce.getCountryName());
            }

            out.println(doubleLine);
        }

        public void showManufacturerTable ()
        {
            List<ManufacturerEntity> manufacturerEntityTable = manufacturedRepository.findAll();
            String doubleLine = "=".repeat(79);

            out.printf("%s\n| %-76s|\n%s\n", doubleLine, "MANUFACTURER TABLE", doubleLine);
            out.printf("|%21s |%30s |%21s |\n%s\n", "ID", "NAME", "COUNTRY_ID", doubleLine);

            for (ManufacturerEntity me : manufacturerEntityTable) {
                out.printf("|%21d |%30s |%21d |\n",
                        me.getManufacturerId(),
                        me.getManufacturerName(),
                        me.getCountryEntity().getCountryId());
            }

            out.println(doubleLine);
        }

        public void showProductTable ()
        {
            List<ProductEntity> productEntityTable = productRepository.findAll();
            String doubleLine = "=".repeat(146);

            out.printf("%s\n| %-143s|\n%s\n", doubleLine, "PRODUCT TABLE", doubleLine);
            out.printf("|%21s |%30s |%21s |%11s |%20s |%20s |%8s |\n",
                    "ID", "NAME", "MANUF_ID", "MANUF_DATE", "CATEGORY", "PRICE", "COUNT");
            out.println(doubleLine);

            for (ProductEntity pe : productEntityTable) {
                out.printf("|%21d |%30s |%21s |%11s |%20s |%20.2f |%8d |\n",
                        pe.getProductId(),
                        pe.getProductName(),
                        pe.getManufacturerEntity().getManufacturerId(),
                        pe.getProductManufacturerDate(),
                        pe.getProductCategory(),
                        pe.getProductPrice(),
                        pe.getProductCount());
            }

            out.println(doubleLine);
        }
    }
}