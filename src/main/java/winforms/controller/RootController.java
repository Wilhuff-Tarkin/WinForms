package winforms.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import winforms.model.Entry;
import winforms.service.ReadXML;

public class RootController implements Initializable {

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
    private Button readFile;

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

    boolean operationSelected;

    // zacznij od podania lokazliacji pliku
    //
    // sprawdzwa poprawnosc pliku i
    // pobiera z pliku wartosci a i b

    //todo trzeba przeazac liste obiektow do metod wykonujacych obliczenia
    //todo dodac loggery
    // todo poprawic albo usunac te hinty



        public String readFile (MouseEvent mouseEvent) {

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
           if (operationSelected) {
               int operations = Integer.parseInt(operationsNumber.getText());
               operationsTodo.setText(operationsNumber.getText());
               System.out.println("operations = " + operations);
           }
           else {
                userHint.setText("Najpierw wybierz operację!"); //przy tym sie krzaczy
           }


        }catch (NumberFormatException ex) {
            System.out.println("to chyba nie jest int stary " + ex);
            //TODO logowanie bledu
        }


    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void performMultiplication(MouseEvent mouseEvent) {

            operationSelected = true;



    }

    public void performDivision(MouseEvent mouseEvent) {

        operationSelected = true;


    }

    public void performExponentiation(MouseEvent mouseEvent) {

        operationSelected = true;


    }

    public void performSubtraction(MouseEvent mouseEvent) {
        operationSelected = true;


    }
}
