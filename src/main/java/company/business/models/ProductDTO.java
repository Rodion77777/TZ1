package company.business.models;

import company.business.models.components.ManufacturerDTO;

import java.sql.Date;

public class ProductDTO
{
    private final long id;
    private final java.lang.String name;
    private final Date manufacturerDate;
    private final ManufacturerDTO manufacturedDTO;
    private final String categoryDTO;
    private final double price;
    private final long count;

    public ProductDTO(long id, java.lang.String name, Date manufacturerDate, ManufacturerDTO manufacturedDTO, String categoryDTO, double price, long count) {
        this.id = id;
        this.name = name;
        this.manufacturerDate = manufacturerDate;
        this.manufacturedDTO = manufacturedDTO;
        this.categoryDTO = categoryDTO;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public java.lang.String getName() {
        return name;
    }

    public Date getManufacturerDate() {
        return manufacturerDate;
    }

    public ManufacturerDTO getManufacturedDTO() {
        return manufacturedDTO;
    }

    public String getCategoryDTO() {
        return categoryDTO;
    }

    public double getPrice() {
        return price;
    }

    public long getCount() {
        return count;
    }
}
