package company.business.models;

import company.business.models.components.CategoryDTO;
import company.business.models.components.ManufacturedDTO;

import java.sql.Date;

public class ProductDTO
{
    private final long id;
    private final String name;
    private final Date manufacturerDate;
    private final ManufacturedDTO manufacturedDTO;
    private final CategoryDTO categoryDTO;
    private final double price;
    private final long count;

    public ProductDTO(long id, String name, Date manufacturerDate, ManufacturedDTO manufacturedDTO, CategoryDTO categoryDTO, double price, long count) {
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

    public String getName() {
        return name;
    }

    public Date getManufacturerDate() {
        return manufacturerDate;
    }

    public ManufacturedDTO getManufacturedDTO() {
        return manufacturedDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public double getPrice() {
        return price;
    }

    public long getCount() {
        return count;
    }
}
