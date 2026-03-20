package IPOS_CA_ORD;

import gui.iposca.IPOS_CA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static IPOS_CA_ORD.DraftOrderController.orderInFocus;

public class OrderController implements Initializable {

    static OrderController orderController;

    @FXML
    private TableView<Product> productTable = new TableView<>();
    @FXML
    private TableColumn<Product, Integer> prodID = new TableColumn<>("ProductID");
    @FXML
    private TableColumn<Product, String> description = new TableColumn<>("Description");
    @FXML
    private TableColumn<Product, String> packType = new TableColumn<>();
    @FXML
    private TableColumn<Product, Integer> unitsInPack = new TableColumn<>();
    @FXML
    private TableColumn<Product, Double> packCost = new TableColumn<>();
    @FXML
    private TableColumn<Product, Integer> quantityRequired = new TableColumn<>();

    @FXML
    private Button addProduct;

    @FXML
    private Label orderTotal = new Label();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orderController = this;
        prodID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        description.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        packType.setCellValueFactory(new PropertyValueFactory<Product, String>("packageType"));
        unitsInPack.setCellValueFactory(new PropertyValueFactory<Product, Integer>("unitsInPack"));
        packCost.setCellValueFactory(new PropertyValueFactory<Product, Double>("packCost"));
        quantityRequired.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantityRequired"));

        populateProductTable();
    }

    protected void populateProductTable(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.addAll(orderInFocus.getOrderProducts());
        productTable.setItems(productList);
        orderTotal.setText(Double.toString(orderInFocus.getOrderTotal()));
    }

    @FXML
    protected void onAddProductButton(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(IPOS_CA.class.getResource("cataloguePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 670);
        stage.setTitle("Select product");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void onRemoveProductButton(ActionEvent event) throws IOException {

        Product prod = productTable.getSelectionModel().getSelectedItem();

        if (prod != null){
            orderInFocus.removeProduct(prod);
            populateProductTable();
        }
    }
}
