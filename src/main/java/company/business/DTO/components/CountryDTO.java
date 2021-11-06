package company.business.DTO.components;

public class CountryDTO
{
    private final long id;
    private final String name;

    public CountryDTO (long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
