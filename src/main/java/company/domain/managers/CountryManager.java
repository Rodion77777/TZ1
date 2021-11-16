package company.domain.managers;

import company.domain.entity.CountryEntity;
import company.domain.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static java.lang.System.out;

public class CountryManager
{
    @Autowired
    private CountryRepository countryRepository;
    private final String doubleLine;
    private final String sequence;

    public CountryManager()
    {
        this.doubleLine = "=".repeat(56);
        this.sequence = "|%21s |%30s |\n";
    }

    private void headerTable ()
    {
        out.printf("%s\n| %-53s|\n%s\n", doubleLine, "COUNTRY ENTITY", doubleLine);
        out.printf("|%21s |%30s |\n%s\n", "ID", "NAME", doubleLine);
    }

    public void showThis (CountryEntity countryEntity)
    {
        headerTable();
        out.printf(sequence, countryEntity.getCountryId(), countryEntity.getCountryName());
        out.println(doubleLine);
    }

    private void showThis (List<CountryEntity> countryEntityList)
    {
        headerTable();
        for (CountryEntity ce : countryEntityList) {
            out.printf(sequence, ce.getCountryId(), ce.getCountryName());
        }
        out.println(doubleLine);
    }

    public void showDatabaseTable ()
    {
        showThis(countryRepository.findAll().iterator().next());
    }
}
