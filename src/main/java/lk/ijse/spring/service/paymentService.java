package lk.ijse.spring.service;

import lk.ijse.spring.dto.paymentDTO;

import java.util.List;

public interface paymentService {
    void savePayment(paymentDTO dto);
    void deletePayment(String id);
    void updatePayment(paymentDTO dto);
    List<paymentDTO>getAllPayment();
}
