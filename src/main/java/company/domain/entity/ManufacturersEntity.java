package company.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manufacturers", schema = "products_schema", catalog = "products_database")
public class ManufacturersEntity {
    private long manufacturerId;
    private String manufacturerName;
    private CountriesEntity countriesByManufacturerCountryId;

    @Id
    @Column(name = "manufacturer_id", nullable = false)
    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Basic
    @Column(name = "manufacturer_name", nullable = false, length = -1)
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturersEntity that = (ManufacturersEntity) o;
        return manufacturerId == that.manufacturerId && Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerId, manufacturerName);
    }

    @ManyToOne
    @JoinColumn(name = "manufacturer_country_id", referencedColumnName = "country_id", nullable = false)
    public CountriesEntity getCountriesByManufacturerCountryId() {
        return countriesByManufacturerCountryId;
    }

    public void setCountriesByManufacturerCountryId(CountriesEntity countriesByManufacturerCountryId) {
        this.countriesByManufacturerCountryId = countriesByManufacturerCountryId;
    }
}
