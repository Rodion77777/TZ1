package company.domain.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "products_schema", catalog = "products_database")
public class ProductEntity
{
    private long productId;
    private String productName;
    private Date productManufacturerDate;
    private String productCategory;
    private float productPrice;
    private long productCount;
    private ManufacturerEntity manufacturersByProductManufacturerId;

    public ProductEntity () {}

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name", nullable = false, length = -1)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_manufacturer_date", nullable = false)
    public Date getProductManufacturerDate() {
        return productManufacturerDate;
    }

    public void setProductManufacturerDate(Date productManufacturerDate) {
        this.productManufacturerDate = productManufacturerDate;
    }

    @Basic
    @Column(name = "product_category", nullable = false, length = -1)
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Basic
    @Column(name = "product_price", nullable = false, precision = 0)
    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_count", nullable = false)
    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false)
    public ManufacturerEntity getManufacturersByProductManufacturerId() {
        return manufacturersByProductManufacturerId;
    }

    public void setManufacturersByProductManufacturerId(ManufacturerEntity manufacturersByProductManufacturerId) {
        this.manufacturersByProductManufacturerId = manufacturersByProductManufacturerId;
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
