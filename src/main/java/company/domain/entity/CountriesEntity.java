package company.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "products_schema", catalog = "products_database")
public class CountriesEntity {
    private long countryId;
    private String countryName;

    @Id
    @Column(name = "country_id", nullable = false)
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country_name", nullable = false, length = -1)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return countryId == that.countryId && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }
}
