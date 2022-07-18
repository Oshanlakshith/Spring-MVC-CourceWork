package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(orderItem_PK.class)
public class orderDetails {
    @Id
    private String oid;
    @Id
    private String carId;
    private String date;
    private String price;

    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car car;
}
