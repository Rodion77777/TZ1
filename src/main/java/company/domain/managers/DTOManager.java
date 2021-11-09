package company.domain.managers;

import company.business.DTO.ProductDTO;
import java.util.List;
import static java.lang.System.out;

public class DTOManager
{
    private final String doubleLine;
    private final String sequence;

    public DTOManager ()
    {
        this.doubleLine = "=".repeat(168);
        this.sequence = "|%21d |%30s |%21s |%11s |%20s |%20s |%20.2f |%8d |\n";
    }

    private void headerTable ()
    {
        out.printf("%s\n| %-165s|\n%s\n", doubleLine, "PRODUCT DTO", doubleLine);
        out.printf("|%21s |%30s |%21s |%11s |%20s |%20s |%20s |%8s |\n",
                "ID", "NAME", "MANUF_NAME", "MANUF_DATE", "COUNTRY_NAME", "CATEGORY", "PRICE", "COUNT");
        out.println(doubleLine);
    }

    public void showThis (ProductDTO productDTO)
    {
        headerTable();

        out.printf(sequence,
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getManufacturedDTO() == null ? -1 : productDTO.getManufacturedDTO().getName(),
                productDTO.getManufacturerDate(),
                productDTO.getManufacturedDTO().getCountryDTO().getName(),
                productDTO.getCategoryDTO(),
                productDTO.getPrice(),
                productDTO.getCount());

        out.println(doubleLine);
    }

    private void showThis (List<ProductDTO> productDTOList)
    {
        headerTable();

        for (ProductDTO productDTO : productDTOList)
        {
            out.printf(sequence,
                    productDTO.getId(),
                    productDTO.getName(),
                    productDTO.getManufacturedDTO() == null ? -1 : productDTO.getManufacturedDTO().getName(),
                    productDTO.getManufacturerDate(),
                    productDTO.getManufacturedDTO().getCountryDTO().getName(),
                    productDTO.getCategoryDTO(),
                    productDTO.getPrice(),
                    productDTO.getCount());
        }

        out.println(doubleLine);
    }
}
