package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cId;
    private String cname;
    private String address;
    private String licence;
    private String city;
    private  String houseNo;
    private String Number;

}
