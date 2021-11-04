package company.domain.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "products_schema", catalog = "products_database")
public class ProductEntity
{
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Basic
    @Column(name = "product_name", nullable = false, length = -1)
    private String productName;

    @Basic
    @Column(name = "product_manufacturer_date", nullable = false)
    private Date productManufacturerDate;

    @Basic
    @Column(name = "product_category", nullable = false, length = -1)
    private String productCategory;

    @Basic
    @Column(name = "product_price", nullable = false, precision = 0)
    private float productPrice;

    @Basic
    @Column(name = "product_count", nullable = false)
    private long productCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_manufacturer_id")
    private ManufacturerEntity manufacturerEntity;

    public ProductEntity () {}
    public ProductEntity (String productName, String productCategory, float productPrice, long productCount, ManufacturerEntity manufacturerEntity)
    {
        this.productName = productName;
        this.productManufacturerDate = new Date(new java.util.Date().getDate());
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.manufacturerEntity = manufacturerEntity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductManufacturerDate() {
        return productManufacturerDate;
    }

    public void setProductManufacturerDate(Date productManufacturerDate) {
        this.productManufacturerDate = productManufacturerDate;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public ManufacturerEntity getManufacturerEntity() {
        return manufacturerEntity;
    }

    public void setManufacturerEntity(ManufacturerEntity manufacturerByProductManufacturerId) {
        this.manufacturerEntity = manufacturerByProductManufacturerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && Float.compare(that.productPrice, productPrice) == 0 && productCount == that.productCount && Objects.equals(productName, that.productName) && Objects.equals(productManufacturerDate, that.productManufacturerDate) && Objects.equals(productCategory, that.productCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productManufacturerDate, productCategory, productPrice, productCount);
    }

}
