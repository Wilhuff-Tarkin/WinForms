package winforms.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.lang.model.element.NestingKind;
import java.net.URL;
import java.util.ResourceBundle;

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
    private TextField oparationsNumber;

    @FXML
    private TextField filePath;

    @FXML
    private TextField result;

    @FXML
    private TextField operationsTodo;









// wystartuje jezeli ma dobry plik i liczbe operacji
    public void startProcessing (MouseEvent mouseEvent) {

        //String operations = oparationsNumber.getText();
      //  System.out.println("operations = " + operations);

        try{
            int operations = Integer.parseInt(oparationsNumber.getText());
            System.out.println("operations = " + operations);
        }catch (NumberFormatException ex) {
            System.out.println("to chyba nie jest int stary " + ex);
            //TODO logowanie bledu
        }


    }


    // sprawdzwa poprawnosc pliku i
    // pobiera z pliku wartosci a i b
    public void setFile (MouseEvent mouseEvent) {



    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
