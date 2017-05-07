package silver.bittiger.cs504.food.order.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ItemInfoBO {

    private String restaurantId;

    private String itemId;

    private Integer quantity;

    @JsonCreator
    public ItemInfoBO(@JsonProperty("restaurantId") String restaurantId,
                      @JsonProperty("itemId") String itemId,
                      @JsonProperty("quantity") String quantity){
            this.restaurantId =restaurantId;
            this.itemId = itemId;
            this.quantity = Integer.valueOf(quantity);
    }

}
