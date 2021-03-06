package com.example.currencycalculator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class InfoSceneController implements Initializable {
    @FXML
    Label exchangeRate;
    @FXML
    TableView<Currency> c1table;
    @FXML
    TableView<Currency> c2table;
    @FXML
    TableColumn<Currency, String> columncurrency1;
    @FXML
    TableColumn<Currency, Double> currency1inFIAT;
    @FXML
    TableColumn<Currency, String> columncurrency2;
    @FXML
    TableColumn<Currency, Double> currency2inFIAT;
    @FXML
    Label leftfiattableheader;
    @FXML
    Label rightfiattableheader;
    GetPriceClass getPriceClass = new GetPriceClass(CurrencyCalculator.base1);
    GetPriceClass getPriceClass2 = new GetPriceClass(CurrencyCalculator.base2);

    Map<String,Double> map = GetPriceClass.getcurrency("usd");

    //creates a list with objects of type Currency. They have a name and a value called currency

    ObservableList<Currency> list = FXCollections.observableArrayList(
            new Currency("usd", map.get("USD")*getPriceClass.price),
            new Currency("yen", map.get("JPY")*getPriceClass.price),
            new Currency("cny", map.get("CNY")*getPriceClass.price)
    );
    ObservableList<Currency> list2 = FXCollections.observableArrayList(
            new Currency("usd", map.get("USD")*getPriceClass2.price),
            new Currency("yen", map.get("JPY")*getPriceClass2.price),
            new Currency("cny", map.get("CNY")*getPriceClass2.price)
    );

    @Override
    public void initialize(URL url, ResourceBundle rb){
        columncurrency1.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency1inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("currency"));
        columncurrency2.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        currency2inFIAT.setCellValueFactory(new PropertyValueFactory<Currency, Double>("currency"));
        c1table.setItems(list);
        c2table.setItems(list2);

    }
    public void exchangeratelabel(String currency1, String currency2, double exchangerate) throws IOException {
        exchangeRate.setText("1 "+currency1+" = "+exchangerate+" "+currency2);
    }


}
