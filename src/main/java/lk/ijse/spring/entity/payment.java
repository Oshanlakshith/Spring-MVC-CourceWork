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
public class payment {
    @Id
    private String pcid;
    private String payDate;
    private String paymentMethod;
    private String pTotalpay;
    private String pTeliphone;
}
