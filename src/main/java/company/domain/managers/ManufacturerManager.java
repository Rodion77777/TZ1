package company.domain.managers;

import company.domain.entity.ManufacturerEntity;
import company.domain.repository.ManufacturedRepositoryImpl;
import java.util.List;
import static java.lang.System.out;

public class ManufacturerManager
{
    private final ManufacturedRepositoryImpl manufacturedRepository;
    private final String doubleLine;
    private final String sequence;

    public ManufacturerManager ()
    {
        this.manufacturedRepository = new ManufacturedRepositoryImpl();
        this.doubleLine = "=".repeat(79);
        this.sequence = "|%21d |%30s |%21d |\n";
    }

    private void tableHeader ()
    {
        out.printf("%s\n| %-76s|\n%s\n", doubleLine, "MANUFACTURER ENTITY", doubleLine);
        out.printf("|%21s |%30s |%21s |\n%s\n", "ID", "NAME", "COUNTRY_ID", doubleLine);
    }

    public void showThis (ManufacturerEntity manufacturerEntity)
    {
        tableHeader();

        out.printf(sequence,
                manufacturerEntity.getManufacturerId(),
                manufacturerEntity.getManufacturerName(),
                manufacturerEntity.getCountryEntity() == null ? -1 : manufacturerEntity.getCountryEntity().getCountryId());

        out.println(doubleLine);
    }

    public void showThis (List<ManufacturerEntity> manufacturerEntityList)
    {
        tableHeader();

        for (ManufacturerEntity me : manufacturerEntityList) {
            out.printf(sequence,
                    me.getManufacturerId(),
                    me.getManufacturerName(),
                    me.getCountryEntity() == null ? -1 : me.getCountryEntity().getCountryId());
        }

        out.println(doubleLine);
    }

    public void shotDatabaseTable ()
    {
        showThis(manufacturedRepository.findAll());
    }
}
