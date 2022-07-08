package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class driverDTO {
    private String DId;
    private String dname;
    private String daddress;
    private String dsalary;
    private String dteliphone;
    private String joindate;
}
