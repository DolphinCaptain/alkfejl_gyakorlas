package alkfejl.DAO;

import alkfejl.config.ConfigurationHelper;
import alkfejl.model.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOimpl implements DAO {

    @Override
    public List<Order> getOrders() {
        String path = ConfigurationHelper.getValue("db.url");
        List<Order> result = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(path);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM TEST ORDER BY DELIVERY") //
        ) {

            while (rs.next()) {
                result.add(new Order(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("TITLE"),
                        rs.getInt("PORTION"),
                        LocalDate.parse(rs.getString("DELIVERY")),
                        rs.getString("PAYMENT")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;

    }


    @Override
    public Order save(Order order) {
        String path = ConfigurationHelper.getValue("db.url");
        String sqlCommand = "INSERT INTO TEST (NAME, TITLE, PORTION, DELIVERY, PAYMENT) VALUES (?,?,?,?,?)";
        try (Connection c = DriverManager.getConnection(path);
             PreparedStatement stmt = c.prepareStatement(sqlCommand, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, order.getCustomer());
            stmt.setString(2, order.getTiltle());
            stmt.setInt(3, order.getPortion());
            stmt.setString(4, order.getDelivery().toString());
            stmt.setString(5, order.getPayment());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                return null;
            }

            if (order.getCustomer()==null){
                return null;

            };




            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                order.setID(genKeys.getInt(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return order;
    }
}