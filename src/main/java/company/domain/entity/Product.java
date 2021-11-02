package company.domain.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Product {
    private Long id;
    private String name;
    private String manufacturedName;
    private Date registrationDate;
    private String category;
    private double price;
    private Long count;
}
