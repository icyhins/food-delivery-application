package silver.bittiger.cs504.food.payment.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPaymentInfoBO {

    private String firstName;

    private String lastName;

    private String creditCardNum;

    private LocalDate expiryDate;

    private String cvvCode;

    @JsonCreator
    public UserPaymentInfoBO(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("creditCardNum") String creditCardNum,
            @JsonProperty("expiryDate") String expiryDate,
            @JsonProperty("cvvCode") String cvvCode
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNum = creditCardNum;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-DD-yyyy", Locale.ENGLISH);
        this.expiryDate = LocalDate.parse(expiryDate,formatter);
        this.cvvCode = cvvCode;
    }
}
