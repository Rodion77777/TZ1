package company.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country", schema = "products_schema", catalog = "products_database")
public class CountryEntity
{
    @Id
    @Column(name = "country_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId;

    @Basic
    @Column(name = "country_name", nullable = false, length = -1)
    private String countryName;

    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManufacturerEntity> manufacturerEntityList;

    public CountryEntity () {}

    public CountryEntity (String countryName) {
        this.countryName = countryName;
        manufacturerEntityList = new ArrayList<>();
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<ManufacturerEntity> getManufacturerEntityList () {
        return manufacturerEntityList;
    }

    public void setManufacturerEntityList (List<ManufacturerEntity> manufacturerEntityList) {
        this.manufacturerEntityList = manufacturerEntityList;
    }

    public void addManufacturerEntity (ManufacturerEntity manufacturerEntity) {
        manufacturerEntityList.add(manufacturerEntity);
    }

    public void removeManufacturerEntity (ManufacturerEntity manufacturerEntity) {
        manufacturerEntityList.remove(manufacturerEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return countryId == that.countryId && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }
}
