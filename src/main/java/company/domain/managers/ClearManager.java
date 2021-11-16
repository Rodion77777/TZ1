package company.domain.managers;

import company.domain.repository.CountryRepository;
import company.domain.repository.ManufacturedRepository;
import company.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static java.lang.System.out;

public class ClearManager
{
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ManufacturedRepository manufacturedRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    public ClearDatabase clearDatabase;

    public class ClearDatabase
    {
        public void clearAllTables ()
        {
            out.println("All tables cleanup start...");

            clearCountryTable();
            clearManufactureTable();
            clearProductTable();

            out.println("All tables have been cleared.");
        }

        public void clearCountryTable ()
        {
            countryRepository.deleteAll();
            out.println("\"County\" table have been cleared.");
        }

        public void clearManufactureTable ()
        {
            manufacturedRepository.deleteAll();
            out.println("\"Manufacture\" table have been cleared.");
        }

        public void clearProductTable ()
        {
            productRepository.deleteAll();
            out.println("\"Product\" table have been cleared.");
        }
    }
}
