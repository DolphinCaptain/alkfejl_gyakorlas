package alkfejl.controller;

import alkfejl.App;
import alkfejl.DAO.DAOimpl;
import alkfejl.model.Order;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addOrder implements Initializable {

    @FXML
    public TextField name;
    @FXML
    public ComboBox<String> title;
    @FXML
    public ComboBox<Integer> portion;
    @FXML
    public DatePicker delivery;
    @FXML
    public ToggleGroup payment;

    public void onCreateOrder(ActionEvent actionEvent) throws IOException {

        String name= this.name.getText();
        String title=this.title.getValue();
        int portion=this.portion.getValue();
        var delivery=this.delivery.getValue();
        String payment= ((RadioButton)this.payment.getSelectedToggle()).getText();

        var order=new DAOimpl().save(new Order(name,title,portion,delivery,payment));
        onCancel(actionEvent);
    }

    public void onCancel(ActionEvent actionEvent) throws IOException {
        App.loadFXML("/fxml/main.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] titles = {"Grand Moff", "Captain", "Clone", "Others"};
        title.setItems(FXCollections.observableArrayList(titles));
        title.getSelectionModel().select(0);


        Integer[] portions = {1, 2, 3, 4, 5, 6};
        portion.setItems(FXCollections.observableArrayList(portions));
        portion.getSelectionModel().select(0);
    }
}
