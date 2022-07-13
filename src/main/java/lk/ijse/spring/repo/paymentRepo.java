package lk.ijse.spring.repo;

import lk.ijse.spring.entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentRepo extends JpaRepository<payment,String> {
}
