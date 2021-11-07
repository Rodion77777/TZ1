package company.domain.managers;

import company.business.DTO.ProductDTO;
import company.domain.entity.CountryEntity;
import company.domain.entity.ManufacturerEntity;
import company.domain.entity.ProductEntity;
import company.domain.repository.CountryRepositoryImpl;
import company.domain.repository.ManufacturedRepositoryImpl;
import company.domain.repository.ProductRepositoryImpl;

import java.util.List;

import static java.lang.System.out;

public class ShowManager
{
    private final CountryRepositoryImpl countryRepository;
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final ProductRepositoryImpl productRepository;
    public final InConsole inConsole;

    public ShowManager()
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
                        me.getCountryEntity() == null ? -1 : me.getCountryEntity().getCountryId());
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
                        pe.getManufacturerEntity() == null ? -1 : pe.getManufacturerEntity().getManufacturerId(),
                        pe.getProductManufacturerDate(),
                        pe.getProductCategory(),
                        pe.getProductPrice(),
                        pe.getProductCount());
            }

            out.println(doubleLine);
        }

        public void showThis (CountryEntity countryEntity)
        {
            String doubleLine = "=".repeat(56);

            out.printf("%s\n| %-53s|\n%s\n", doubleLine, "COUNTRY ENTITY", doubleLine);
            out.printf("|%21s |%30s |\n%s\n", "ID", "NAME", doubleLine);
            out.printf("|%21s |%30s |\n", countryEntity.getCountryId(), countryEntity.getCountryName());

            out.println(doubleLine);
        }

        public void showThis (ManufacturerEntity manufacturerEntity)
        {
            String doubleLine = "=".repeat(79);

            out.printf("%s\n| %-76s|\n%s\n", doubleLine, "MANUFACTURER ENTITY", doubleLine);
            out.printf("|%21s |%30s |%21s |\n%s\n", "ID", "NAME", "COUNTRY_ID", doubleLine);

            out.printf("|%21d |%30s |%21d |\n",
                    manufacturerEntity.getManufacturerId(),
                    manufacturerEntity.getManufacturerName(),
                    manufacturerEntity.getCountryEntity() == null ? -1 : manufacturerEntity.getCountryEntity().getCountryId());

            out.println(doubleLine);
        }

        public void showThis (ProductEntity productEntity)
        {
            String doubleLine = "=".repeat(146);

            out.printf("%s\n| %-143s|\n%s\n", doubleLine, "PRODUCT TABLE", doubleLine);
            out.printf("|%21s |%30s |%21s |%11s |%20s |%20s |%8s |\n",
                    "ID", "NAME", "MANUF_ID", "MANUF_DATE", "CATEGORY", "PRICE", "COUNT");
            out.println(doubleLine);

            out.printf("|%21d |%30s |%21s |%11s |%20s |%20.2f |%8d |\n",
                    productEntity.getProductId(),
                    productEntity.getProductName(),
                    productEntity.getManufacturerEntity() == null ? -1 : productEntity.getManufacturerEntity().getManufacturerId(),
                    productEntity.getProductManufacturerDate(),
                    productEntity.getProductCategory(),
                    productEntity.getProductPrice(),
                    productEntity.getProductCount());

            out.println(doubleLine);
        }

        public void showThis (ProductDTO productDTO)
        {
            String doubleLine = "=".repeat(168);

            out.printf("%s\n| %-165s|\n%s\n", doubleLine, "PRODUCT TABLE", doubleLine);
            out.printf("|%21s |%30s |%21s |%11s |%20s |%20s |%20s |%8s |\n",
                    "ID", "NAME", "MANUF_NAME", "MANUF_DATE", "COUNTRY_NAME", "CATEGORY", "PRICE", "COUNT");
            out.println(doubleLine);

            out.printf("|%21d |%30s |%21s |%11s |%20s |%20s |%20.2f |%8d |\n",
                    productDTO.getId(),
                    productDTO.getName(),
                    productDTO.getManufacturedDTO() == null ? -1 : productDTO.getManufacturedDTO().getName(),
                    productDTO.getManufacturerDate(),
                    productDTO.getManufacturedDTO().getCountryDTO().getName(),
                    productDTO.getCategoryDTO(),
                    productDTO.getPrice(),
                    productDTO.getCount());

            out.println(doubleLine);
        }
    }
}