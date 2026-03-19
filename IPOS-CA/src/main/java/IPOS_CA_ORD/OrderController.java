package IPOS_CA_ORD;

import gui.iposca.IPOS_CA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private Button createDraftOrder;

    @FXML
    private Button continueWithOrder;

    @FXML
    private TableView<Order> draftOrderTable = new TableView<>();
    @FXML
    private TableColumn<Order, Integer> ordID = new TableColumn<>("OrderID");
    @FXML
    private TableColumn<Order, LocalDateTime> dateAndTime = new TableColumn<>("DateAndTime");
    @FXML
    private TableColumn<Order, Integer> noOfProducts = new TableColumn<>("NoOfProducts");
    @FXML
    private TableColumn<Order, Double> total = new TableColumn<>("OrderTotal");

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

    private Order orderInFocus;

    private static final ArrayList<Order> draftOrders = new ArrayList<>();

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent fxmlLoader;

        stage = (Stage) loginButton.getScene().getWindow();
        fxmlLoader = FXMLLoader.load(IPOS_CA.class.getResource("draftOrderPage.fxml"));

        Scene scene = new Scene(fxmlLoader, 920, 670);
        stage.setTitle("Draft orders");
        stage.setScene(scene);
        stage.show();

//        setUpDraftOrderTable();
//

//
//        System.out.println(ord.getOrderID());
//
//        populateDraftOrderTable();

    }

    @FXML
    protected void onDraftOrderClick(ActionEvent event) throws IOException {

        if (event.getSource() == createDraftOrder){
            Order ord = new Order();
            orderInFocus = ord;
            OrderController.draftOrders.add(ord);

        }

        Stage stage;
        Parent fxmlLoader;

        stage = (Stage) createDraftOrder.getScene().getWindow();
        fxmlLoader = FXMLLoader.load(IPOS_CA.class.getResource("mainOrderPage.fxml"));

        Scene scene = new Scene(fxmlLoader, 920, 670);
        stage.setTitle("Order portal");
        stage.setScene(scene);
        stage.show();

        setUpProductTable();

    }

    @FXML
    protected void onMouseClickedOnOrderList(MouseEvent event) throws IOException {

        orderInFocus = draftOrderTable.getSelectionModel().getSelectedItem();

        if (orderInFocus != null){
            this.continueWithOrder.setDisable(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ordID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderID"));
        dateAndTime.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("creationDateAndTime"));
        noOfProducts.setCellValueFactory(new PropertyValueFactory<Order, Integer>("noOfProducts"));
        total.setCellValueFactory(new PropertyValueFactory<Order, Double>("orderTotal"));

        Order ord = new Order();
        OrderController.draftOrders.add(ord);

        populateDraftOrderTable();

    }

    protected void setUpDraftOrderTable(){

        draftOrderTable.getColumns().add(ordID);
        draftOrderTable.getColumns().add(dateAndTime);
        draftOrderTable.getColumns().add(noOfProducts);
        draftOrderTable.getColumns().add(total);



    }

    protected void populateDraftOrderTable(){
        ObservableList<Order> orderList = FXCollections.observableArrayList();

        orderList.addAll(draftOrders);

        draftOrderTable.setItems(orderList);
    }

    protected void setUpProductTable(){
        prodID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
        description.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        packType.setCellValueFactory(new PropertyValueFactory<Product, String>("packageType"));
        unitsInPack.setCellValueFactory(new PropertyValueFactory<Product, Integer>("unitsInPack"));
        packCost.setCellValueFactory(new PropertyValueFactory<Product, Double>("packCost"));
        quantityRequired.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantityRequired"));

    }

    protected void populateProductTable(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.addAll(orderInFocus.getOrderProducts());
        productTable.setItems(productList);
    }

}
