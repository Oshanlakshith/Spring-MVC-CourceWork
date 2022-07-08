package lk.ijse.spring.repo;

import lk.ijse.spring.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepo extends JpaRepository<customer,String> {
}
