package com.example.dairy.Samiul.User8;

import com.example.dairy.Samiul.User7.CampaignClass;
import com.example.dairy.Samiul.User7.ProductClass;
import com.example.dairy.Samiul.User7.SalesDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;

public class BuyingPortal {
    Customer user;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCombobox;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private Label priceLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private TextField customerNameTF;

    public void setter(Customer customer) {
        this.user = customer;
    }

    ObservableList<ProductClass> products = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        selectProductCombobox.getItems().addAll("Milk", "Cheese", "Yogurt", "Butter", "Cream");
        ProductClass product= new ProductClass("Milk", 160, 5, 10, "Milk is a nutrient-rich liquid produced by mammals and is widely consumed as a beverage or used in cooking and baking. It is a key source of calcium, protein, and essential vitamins like B12 and D, making it an important part of a balanced diet. Milk is available in various forms, including whole milk, skimmed milk, and flavored varieties.");
        ProductClass product2= new ProductClass("Cheese", 10, 5, 10,"Cheese is a versatile dairy product made by coagulating milk proteins (casein). It comes in a wide range of textures and flavors, from the sharpness of cheddar to the creaminess of brie. Cheese is not only a rich source of protein, calcium, and fat but is also an essential ingredient in countless dishes, snacks, and cuisines worldwide.");
        ProductClass product3= new ProductClass("Yogurt", 1040, 5, 10,"Yogurt is a creamy and tangy dairy product created through the fermentation of milk with beneficial bacteria. This process gives yogurt its distinct texture and taste. It is often consumed plain or flavored with fruits and sweeteners and is prized for its probiotics, which promote gut health, as well as its high calcium and protein content.");
        ProductClass product4= new ProductClass("Butter", 1450, 5, 10,"Butter is made by churning cream or milk to separate the butterfat from the buttermilk. Known for its rich flavor and creamy texture, butter is a staple in cooking, baking, and as a spread. It adds depth and richness to recipes, making it a favorite in many culinary traditions.");
        ProductClass product5= new ProductClass("Cream", 100, 5, 10,"Cream is the thick, high-fat portion of milk that rises to the top when milk is left to stand. It is used in cooking, baking, and as a topping for desserts and beverages. With its luxurious texture and rich taste, cream is available in different types, such as heavy cream, whipped cream, and sour cream, each with its unique culinary applications.");
        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    @javafx.fxml.FXML
    public void orderNowButton(ActionEvent actionEvent) {

        String name= customerNameTF.getText();
        int quantity = Integer.parseInt(quantityTF.getText());
        LocalDate deliveryDate = deliveryDatePicker.getValue();
        int orderValue= Integer.parseInt(priceLabel.getText());




        OrderClass order1= new OrderClass(name, quantity, deliveryDate, orderValue);

        orderFileWrite(order1);



    }

    public void orderFileWrite(OrderClass order) {
        System.out.println(order);
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("OrderData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.project.AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(order);

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dairy/Samiul/User8/customerDashboard.fxml"));
        root = fxmlLoader.load();

        CustomerDashboard adc = fxmlLoader.getController();
        adc.setter(this.user);

        Scene scene = new Scene(root);
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void productNameOnAction(ActionEvent actionEvent) {
        for (ProductClass p : products) {
            if (Objects.equals(p.getName(), selectProductCombobox.getValue())) {
                nameLabel.setText(p.getName());
                priceLabel.setText(Integer.toString(p.getPrice()));

                break;


            }
        }
    }
}
