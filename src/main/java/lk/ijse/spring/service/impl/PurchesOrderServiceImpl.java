package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.PurchasOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PurchesOrderServiceImpl implements PurchasOrderService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
        Orders order = mapper.map(dto, Orders.class);
        if (!ordersRepo.existsById(dto.getOrderId())) {

            System.out.println("Impl Id"+dto.getOrderId());
            ordersRepo.save(order);

            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No items added for the order..!");

            for (OrderDetails orderDetail : order.getOrderDetails()) {
                Car car = carRepo.findById(orderDetail.getCarId()).get();
                car.setCarQty(car.getCarQty() - orderDetail.getQty());
                carRepo.save(car);
            }
        } else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOrderId() + " Already Exist.!");
        }
    }

    @Override
    public void deleteOrder(String oid) {

    }

    @Override
    public void updateOrder(OrdersDTO dto) {

    }

    @Override
    public OrdersDTO searchOrder(String oid) {
        return null;
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return mapper.map(ordersRepo.findAll(), new TypeToken<List<OrdersDTO>>() {
        }.getType());    }
}
