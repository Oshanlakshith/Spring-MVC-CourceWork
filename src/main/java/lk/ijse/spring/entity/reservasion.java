package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@IdClass(reservation_PK.class)
public class reservasion {
    @Id
    private String reservationId;
    @Id
    private String cId;
    @Id
    private String DId;
    private String palteNo;
    private String ReservasionDate;
    private String pickupdate;
    private String time;
    private String pickupLocation;
    private String yourLocation;
    private String NoOfDays;
    private String TotalCost;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "cId",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "DriverId",referencedColumnName = "DId",insertable = false,updatable = false)
    private Driver driver;

}
