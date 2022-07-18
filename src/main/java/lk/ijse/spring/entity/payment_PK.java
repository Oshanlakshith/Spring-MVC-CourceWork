package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
@Data
public class payment_PK implements Serializable {
    private String cId;
}
