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
public class driver {
    @Id
    private String DId;
    private String dname;
    private String daddress;
    private String dsalary;
    private String dteliphone;
    private String joindate;
}
