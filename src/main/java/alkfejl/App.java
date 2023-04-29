package alkfejl;

import alkfejl.DAO.DAOimpl;
import alkfejl.model.Order;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application implements Initializable {

    private static Stage stage;
    @FXML
    private TableView<Order> tableView;
    @FXML
    private TableColumn<Order, String> customerCol;
    @FXML
    private TableColumn<Order, String> titleCol;
    @FXML
    private TableColumn<Order, Number> portionCol;
    @FXML
    private TableColumn<Order, String> paymentCol;

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return loader;
    }


    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        App.loadFXML("/fxml/main.fxml");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void addNewOrder(ActionEvent actionEvent) throws IOException {
        App.loadFXML("/fxml/newOrder.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomer()));
        titleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTiltle()));
        portionCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getPortion()));
        paymentCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPayment()));

        tableView.getItems().setAll(new DAOimpl().getOrders());

    }


}
