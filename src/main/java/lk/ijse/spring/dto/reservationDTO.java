package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class reservationDTO {
    private String reservationId;
    private String palteNo;
    private String ReservasionDate;
    private String pickupdate;
    private String pickupLocation;
    private String NoOfDays;
    private String cancelation;
}
