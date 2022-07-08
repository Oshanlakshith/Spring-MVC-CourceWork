package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class reservasion {
    @Id
    private String reservationId;
    private String palteNo;
    private String ReservasionDate;
    private String pickupdate;
    private String pickupLocation;
    private String NoOfDays;
    private String cancelation;
}
