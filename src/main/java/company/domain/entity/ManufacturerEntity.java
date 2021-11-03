package company.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manufacturers", schema = "products_schema", catalog = "products_database")
public class ManufacturerEntity
{
    private long manufacturerId;
    private String manufacturerName;
    private CountryEntity countriesByManufacturerCountryId;

    public ManufacturerEntity () {}

    @Id
    @Column(name = "manufacturer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_country_id", referencedColumnName = "country_id", nullable = false)
    public CountryEntity getCountriesByManufacturerCountryId() {
        return countriesByManufacturerCountryId;
    }

    public void setCountriesByManufacturerCountryId(CountryEntity countriesByManufacturerCountryId) {
        this.countriesByManufacturerCountryId = countriesByManufacturerCountryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerEntity that = (ManufacturerEntity) o;
        return manufacturerId == that.manufacturerId && Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerId, manufacturerName);
    }
}
