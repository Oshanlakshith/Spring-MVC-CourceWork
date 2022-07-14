package lk.ijse.spring.service;

import lk.ijse.spring.dto.reservationDTO;

import java.util.List;

public interface reservationService {
    void saveReservation(reservationDTO dto);
    void updateReservation(reservationDTO dto);
    void deleteReservation(String id);
    reservationDTO searchReservation(String id);
    List<reservationDTO> reservation();
}
