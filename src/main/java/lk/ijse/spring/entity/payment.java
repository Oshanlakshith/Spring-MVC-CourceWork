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
@IdClass(payment_PK.class)
public class payment {
    @Id
    private String cId;
    private String payDate;
    private String paymentMethod;
    private String pTotalpay;
    private String pTeliphone;

    @ManyToOne
    @JoinColumn(name = "CustomerId",referencedColumnName = "cId",insertable = false,updatable = false)
    private Customer customer;

}
