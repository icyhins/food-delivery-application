package silver.bittiger.cs504.food.order.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserInfoBO {

    private String userId;

    private String userName;

    private String address;

    private String phoneNum;

    @JsonCreator
    public UserInfoBO(@JsonProperty("userId") String userId,
                      @JsonProperty("userName") String userName,
                      @JsonProperty("address") String address,
                      @JsonProperty("phoneNum") String phoneNum){
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.phoneNum = phoneNum;
    }

}
