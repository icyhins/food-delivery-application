package silver.bittiger.cs504.food.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantBO {

    public enum RestaurantLevel{
        TOPTEN("TopTen"), POPULAR("Popular"), GOOD("Good"), GENERAL("General");

        private String value;

        RestaurantLevel(String value){
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
        public static RestaurantLevel getEnum(String value) {
            for(RestaurantLevel v : values())
                if(v.getValue().equalsIgnoreCase(value)) return v;
            throw new IllegalArgumentException();
        }

    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String phoneNum;

    private RestaurantLevel level;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "menuItemId")),
            @AttributeOverride(name = "name", column = @Column(name = "menuItemName"))
    })
    private List<MenuItemBO> menuItemList;


    @JsonCreator
    public RestaurantBO(
            @JsonProperty("restName") String name,
            @JsonProperty("restAddr") String address,
            @JsonProperty("phoneNum") String phoneNum,
            @JsonProperty("restLevel") String level,
            @JsonProperty("menuItemList") List<MenuItemBO> menuItemList
    ){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.level = RestaurantLevel.getEnum(level);
        this.menuItemList = menuItemList;
    }

}
