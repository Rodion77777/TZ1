package company.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "manufacturer", schema = "products_schema", catalog = "products_database")
public class ManufacturerEntity
{
    @Id
    @Column(name = "manufacturer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long manufacturerId;

    @Basic
    @Column(name = "manufacturer_name", nullable = false, length = -1)
    private String manufacturerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_country_id")
    private CountryEntity countryEntity;

    @OneToMany(mappedBy = "manufacturerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntityList;

    public ManufacturerEntity () {}

    public ManufacturerEntity (String manufacturerName, CountryEntity countryEntity)
    {
        this.manufacturerName = manufacturerName;
        this.countryEntity = countryEntity;
        this.productEntityList = new ArrayList<>();
    }

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryByManufacturerCountryId) {
        this.countryEntity = countryByManufacturerCountryId;
    }

    public List<ProductEntity> getProductEntityList () {
        return productEntityList;
    }

    public void setProductEntityList (List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    public void addProductEntity (ProductEntity productEntity) {
        productEntityList.add(productEntity);
    }

    public void removeProductEntity (ProductEntity productEntity) {
        productEntityList.remove(productEntity);
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
