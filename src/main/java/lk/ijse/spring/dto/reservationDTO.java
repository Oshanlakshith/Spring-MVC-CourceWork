package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class reservationDTO {
    private String reservationId;
    private String cId;
    private String DId;
    private String cModel;
    private String ReservasionDate;
    private String pickupdate;
    private String time;
    private String pickupLocation;
    private String yourLocation;
    private String NoOfDays;
    private String TotalCost;

}
