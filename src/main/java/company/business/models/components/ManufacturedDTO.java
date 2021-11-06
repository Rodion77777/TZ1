package company.business.models.components;

public class ManufacturedDTO
{
    private final long id;
    private final String name;
    private final CountryDTO countryDTO;

    public ManufacturedDTO (long id, String name, CountryDTO countryDTO)
    {
        this.id = id;
        this.name = name;
        this.countryDTO = countryDTO;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryDTO getCountryDTO() {
        return countryDTO;
    }
}
