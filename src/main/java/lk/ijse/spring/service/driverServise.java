package lk.ijse.spring.service;

import lk.ijse.spring.dto.driverDTO;

import java.util.List;

public interface driverServise {
    void saveDriver(driverDTO dto);
    void updateDriver(driverDTO dto);
    driverDTO searchDriver(String id);
    void deleteDrivers(String id);
    List<driverDTO> getAllDrivers();
}
