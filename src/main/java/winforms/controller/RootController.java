package winforms.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import winforms.service.ReadXML;

public class RootController implements Initializable {

    int a = 0;
    int b = 0;

    @FXML
    private Button start;

    @FXML
    private Button exponentiation;

    @FXML
    private Button subtraction;

    @FXML
    private Button division;

    @FXML
    private Button multiplication;

    @FXML
    private Button setFile;

    @FXML
    private TextField operationsNumber;

    @FXML
    private TextField filePath;

    @FXML
    private Label result;

    @FXML
    private Label operationsTodo;

    @FXML
    private static Label userHint;



    // zacznij od podania lokazliacji pliku
    //
    // sprawdzwa poprawnosc pliku i
    // pobiera z pliku wartosci a i b
        public String setFile (MouseEvent mouseEvent) {

        String path = filePath.getText();
        ReadXML.readXML(path);

        System.out.println("sciezka do pliku to = " + path);

        return path;

    }


// wystartuje jezeli ma dobry plik i liczbe operacji
    public void startProcessing (MouseEvent mouseEvent) {

        //String operations = oparationsNumber.getText();
      //  System.out.println("operations = " + operations);

        try{
            int operations = Integer.parseInt(operationsNumber.getText());
            operationsTodo.setText(operationsNumber.getText());
            System.out.println("operations = " + operations);

        }catch (NumberFormatException ex) {
            System.out.println("to chyba nie jest int stary " + ex);
            //TODO logowanie bledu
        }


    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
