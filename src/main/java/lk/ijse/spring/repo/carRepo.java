package lk.ijse.spring.repo;

import lk.ijse.spring.entity.car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepo extends JpaRepository<car, String> {

}
