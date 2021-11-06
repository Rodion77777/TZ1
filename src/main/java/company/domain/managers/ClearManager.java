package company.domain.managers;

import company.domain.repository.CountryRepositoryImpl;
import company.domain.repository.ManufacturedRepositoryImpl;
import company.domain.repository.ProductRepositoryImpl;

import static java.lang.System.out;

public class ClearManager
{
    private final CountryRepositoryImpl countryRepository;
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final ProductRepositoryImpl productRepository;
    public final ClearDatabase clearDatabase;

    public ClearManager ()
    {
        countryRepository = new CountryRepositoryImpl();
        manufacturedRepository = new ManufacturedRepositoryImpl();
        productRepository = new ProductRepositoryImpl();
        clearDatabase = new ClearDatabase();
    }

    public class ClearDatabase
    {
        public void clearAllTables ()
        {
            out.println("All tables cleanup start...");

            countryRepository.clearCountriesTable();
            manufacturedRepository.clearManufacturersTable();
            productRepository.clearProductsTable();

            out.println("All tables have been cleared.");
        }

        public void clearCountryTable ()
        {
            countryRepository.clearCountriesTable();
            out.println("\"County\" table have been cleared.");
        }

        public void clearManufactureTable ()
        {
            manufacturedRepository.clearManufacturersTable();
            out.println("\"Manufacture\" table have been cleared.");
        }

        public void clearProductTable ()
        {
            productRepository.clearProductsTable();
            out.println("\"Product\" table have been cleared.");
        }
    }
}
