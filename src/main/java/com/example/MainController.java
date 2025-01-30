package com.example;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField brandField;

    @FXML
    private TextField certField;

    @FXML
    private TextField climateField;

    @FXML
    private TextField fuelField;

    @FXML
    private TextField plateField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField yearField;

    ArrayList<Car> carList = new ArrayList<>();
    int actualCar = 0;

    @FXML
    private void initialize() {
        System.out.println("Megyen");       
        Solution sol = new Solution();
        carList = sol.fileToList();
        

        for(Car car: carList) {
            System.out.println(car.getBrand());            
        }
        showCar(0);

    }

    private void showCar(int index) {
        this.brandField.setText(carList.get(index).getBrand());
        this.certField.setText(carList.get(index).getCert().toString());
        this.climateField.setText(carList.get(index).getClimate()?"van":"nincs");
        this.fuelField.setText(carList.get(index).getFuel());
        this.plateField.setText(carList.get(index).getPlate());
        this.priceField.setText(carList.get(index).getPrice().toString());
        this.yearField.setText(carList.get(index).getYear().toString());
    }

    @FXML
    void onClickNextButton(ActionEvent event) {
        if(actualCar > (carList.size()-2)) {
            return;
        }
        showCar(++actualCar);
        
    }

    @FXML
    void onClickPreviousButton(ActionEvent event) {
        if(actualCar <1) {
            return;
        }
        showCar(--actualCar);
    }

    @FXML
    void onClickSaveButton(ActionEvent event) throws SQLException {
        System.out.println("Mentés");
        DataSource ds = new DataSource();
        ds.addCar(new Car(
            plateField.getText(),
            brandField.getText(),
            Integer.parseInt(yearField.getText()),
            fuelField.getText(),
            Double.parseDouble(priceField.getText()),
            climateField.getText().toLowerCase().equals("van"),
            java.time.LocalDate.parse(certField.getText())
        ));
    }
}
