package silver.bittiger.cs504.food.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuItemBO {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private BigDecimal price;

    @JsonCreator
    public MenuItemBO(
            @JsonProperty("itemName") String name,
            @JsonProperty("itemType") String type,
            @JsonProperty("itemPrice") String price
    ){
        this.name = name;
        this.type = type;
        this.price = new BigDecimal(price);
    }

}
