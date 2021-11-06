package company.business.DTO.components;

public class ManufacturerDTO
{
    private final long id;
    private final String name;
    private final CountryDTO countryDTO;

    public ManufacturerDTO(long id, String name, CountryDTO countryDTO)
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
