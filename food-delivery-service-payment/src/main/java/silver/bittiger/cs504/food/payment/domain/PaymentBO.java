package silver.bittiger.cs504.food.payment.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embedded;
import java.sql.Timestamp;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentBO {



    @Embedded
    private UserPaymentInfoBO userPaymentInfoBO;

    private String orderId;

    private String paymentId;

    private Timestamp payTime;

    private String payResult;


    @JsonCreator
    public PaymentBO(
            @JsonProperty("userInfo") UserPaymentInfoBO userPaymentInfoBO,
            @JsonProperty("orderId") String orderId
    ){
        this.userPaymentInfoBO = userPaymentInfoBO;
        this.orderId = orderId;
        this.payTime = new Timestamp(System.currentTimeMillis());
    }


}
