package silver.bittiger.cs504.food.order.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name="food_delivery_order")
public class OrderInfoBO {

    public enum OrderType{
        NORMAL("Normal"), PROMOTION("Promotion"), FREEPROMOTION("FreePromotion");

        private String value;

        OrderType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }

        /**
         * Instead of Enum.valueOf(), get Enum by value
         * */
        public static OrderType getEnum(String value) {
            for(OrderType v : values())
                if(v.getValue().equalsIgnoreCase(value)) return v;
            throw new IllegalArgumentException();
        }

    }

    @Embedded
    private UserInfoBO userInfoBO;

    @Id
    @GeneratedValue
    private Long id;

    private String orderStatus;

    private OrderType orderType;

    private BigDecimal orderAmount;

    @JsonIgnore
    private Timestamp createTime;

    @JsonIgnore
    private Integer deliveryEstimationMinutes;

    @Embedded
    private List<ItemInfoBO> itemInfoBOList;

    private String dietRestrictionNote;

    @JsonCreator
    public OrderInfoBO(
            @JsonProperty("userInfo") UserInfoBO userInfoBO,
    @JsonProperty("orderStatus") String orderStatus,
    @JsonProperty("orderType") String orderType,
    @JsonProperty("orderAmount") String orderAmount,
    @JsonProperty("itemInfoList") List<ItemInfoBO> itemInfoBOList,
    @JsonProperty("notes") String dietRestrictionNote){
        this.userInfoBO = userInfoBO;
        this.orderStatus = orderStatus;
        this.orderType = OrderType.getEnum(orderType);
        this.orderAmount = new BigDecimal(orderAmount);
        this.itemInfoBOList = itemInfoBOList;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.deliveryEstimationMinutes = deliveryEstimation(5, 60);
        this.dietRestrictionNote = dietRestrictionNote;
    }

    private Integer deliveryEstimation(Integer min, Integer max){
        Random rn = new Random();
        return min + rn.nextInt(max - min + 1);
    }


}
