package company.domain.managers;

import company.domain.entity.ProductEntity;
import company.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static java.lang.System.out;

public class ProductManager
{
    @Autowired
    private ProductRepository productRepository;
    private final String doubleLine;
    private final String sequence;

    public ProductManager ()
    {
        this.doubleLine = "=".repeat(146);
        this.sequence = "|%21d |%30s |%21s |%11s |%20s |%20.2f |%8d |\n";
    }

    private void headerTable ()
    {
        out.printf("%s\n| %-143s|\n%s\n", doubleLine, "PRODUCT TABLE", doubleLine);
        out.printf("|%21s |%30s |%21s |%11s |%20s |%20s |%8s |\n%s\n",
                "ID", "NAME", "MANUF_ID", "MANUF_DATE", "CATEGORY", "PRICE", "COUNT", doubleLine);
    }

    public void showThis (ProductEntity productEntity)
    {
        headerTable();

        out.printf(sequence,
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getManufacturerEntity() == null ? -1 : productEntity.getManufacturerEntity().getManufacturerId(),
                productEntity.getProductManufacturerDate(),
                productEntity.getProductCategory(),
                productEntity.getProductPrice(),
                productEntity.getProductCount());

        out.println(doubleLine);
    }

    public void showThis (List<ProductEntity> productEntityList)
    {
        headerTable();

        for (ProductEntity pe : productEntityList) {
            out.printf(sequence,
                    pe.getProductId(),
                    pe.getProductName(),
                    pe.getManufacturerEntity() == null ? -1 : pe.getManufacturerEntity().getManufacturerId(),
                    pe.getProductManufacturerDate(),
                    pe.getProductCategory(),
                    pe.getProductPrice(),
                    pe.getProductCount());
        }

        out.println(doubleLine);
    }

    public void showDatabaseTable ()
    {
        showThis(productRepository.findAll().iterator().next());
    }
}
