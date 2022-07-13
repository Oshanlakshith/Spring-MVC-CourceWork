package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class carDTO {
    private String carId;
    private String plateNo;
    private String DailyPrice;
    private String miladge;
    private String Model;
}
