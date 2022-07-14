package lk.ijse.spring.repo;

import lk.ijse.spring.entity.reservasion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface resrvationRepo extends JpaRepository<reservasion,String> {
}
