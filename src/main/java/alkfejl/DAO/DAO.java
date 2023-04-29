package alkfejl.DAO;

import alkfejl.model.Order;

import java.util.List;

public interface DAO {
    List<Order> getOrders();
    Order save(Order order);

}
