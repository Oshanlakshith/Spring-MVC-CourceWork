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
public class OrderDetails {
    @Id
    private String orderId;
    @Id
    private String carId;
    private int qty;
    private String price;

    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "CarId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car car;
}
