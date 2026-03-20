package IPOS_CA_ORD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static IPOS_CA_ORD.DraftOrderController.orderInFocus;

public class catalogueController implements Initializable {

    @FXML
    private TableView<Product> catalogueProducts = new TableView<>();

    @FXML
    private TableColumn<Product, Integer> prodID = new TableColumn<>();
    @FXML
    private TableColumn<Product, String> description= new TableColumn<>();
    @FXML
    private TableColumn<Product, String> packType= new TableColumn<>();
    @FXML
    private TableColumn<Product, String> unit= new TableColumn<>();
    @FXML
    private TableColumn<Product, Integer> unitsInPack = new TableColumn<>();
    @FXML
    private TableColumn<Product, Double> packCost = new TableColumn<>();
    @FXML
    private TableColumn<Product, Integer> availability = new TableColumn<>();

    @FXML
    private Button addProductBttn;

    @FXML
    private Spinner<Integer> quantityEntered = new Spinner<>();

    @FXML
    private TextField searchTextField = new TextField();

    @FXML
    public void onProductSelection(MouseEvent mouseEvent) {

        Product selectedProduct = catalogueProducts.getSelectionModel().getSelectedItem();

        if (selectedProduct != null){
            addProductBttn.setDisable(false);
            quantityEntered.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, selectedProduct.getAvailability(), 1));
        }



    }

    @FXML
    public void onAddProductButton(ActionEvent event) throws IOException {

        Product selectedProduct = catalogueProducts.getSelectionModel().getSelectedItem();

        selectedProduct.setQuantityRequired(quantityEntered.getValue());

        DraftOrderController.orderInFocus.addProduct(selectedProduct);

        OrderController.orderController.populateProductTable();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prodID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        description.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        packType.setCellValueFactory(new PropertyValueFactory<Product, String>("packageType"));
        unit.setCellValueFactory(new PropertyValueFactory<Product, String>("unit"));
        unitsInPack.setCellValueFactory(new PropertyValueFactory<Product, Integer>("unitsInPack"));
        packCost.setCellValueFactory(new PropertyValueFactory<Product, Double>("packCost"));
        availability.setCellValueFactory(new PropertyValueFactory<Product, Integer>("availability"));

        quantityEntered.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 200, 1));


        populateCatalogueProducts();
    }

    protected void populateCatalogueProducts(){

        ArrayList<Product> n = new ArrayList<>();
        n.add(new Product(10000001, "Paracetamol", "box", "Caps", 20,
                0.10, 10345));
        n.add(new Product(10000002, "Aspirin", "box", "Caps", 20,
                0.50, 12453));
        n.add(new Product(10000003, "Analgin", "box", "Caps", 10,
                1.20, 4235));
        n.add(new Product(10000004, "Celebrex, caps 100 mg", "box", "Caps", 10,
                10.00, 3420));
        n.add(new Product(10000005, "Celebrex, caps 200 mg", "box", "Caps", 10,
                18.50, 1450));
        n.add(new Product(10000006, "Retin-A Tretin, 30 g", "box", "Caps", 20,
                25.00, 2013));
        n.add(new Product(10000007, "Lipitor TB, 20 mg", "box", "Caps", 30,
                15.50, 1562));
        n.add(new Product(10000008, "Claritin CR, 60g", "box", "Caps", 20,
                19.50, 2540));

        n.add(new Product(20000004, "Iodine tincture", "bottle", "ml", 100,
                0.30, 22134));
        n.add(new Product(20000005, "Rhynol", "bottle", "ml", 200,
                2.50, 1908));

        n.add(new Product(30000001, "Ospen", "box", "caps", 20,
                10.50, 809));
        n.add(new Product(30000002, "Amopen", "box", "caps", 30,
                15.00, 1304));

        n.add(new Product(40000001, "Vitamin C", "box", "caps", 30,
                1.20, 3258));
        n.add(new Product(40000002, "Vitamin B12", "box", "caps", 30,
                1.30, 2673));


        ObservableList<Product> prods = FXCollections.observableArrayList();
        prods.addAll(n);

        FilteredList<Product> filteredProducts = new FilteredList<>(prods, predicate -> true);

        searchTextField.textProperty().addListener((observable, oldValue, newValue)->
        {
            filteredProducts.setPredicate(prod -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String description = newValue.toLowerCase();

                if (prod.getDescription().toLowerCase().indexOf(description) != -1){
                    return true;
                }

                return false;
            });
        });

        catalogueProducts.setItems(filteredProducts);
    }
}
