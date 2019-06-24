package winforms.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import winforms.service.ReadXML;

public class RootController implements Initializable {

    @FXML
    public Label fileSelectorFeedback;

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
    private Label userHint;

    boolean operationSelected;



    // zacznij od podania lokazliacji pliku
    //
    // sprawdzwa poprawnosc pliku i
    // pobiera z pliku wartosci a i b

    //todo trzeba przeazac liste obiektow do metod wykonujacych obliczenia
    //todo dodac loggery
    // todo poprawic albo usunac te hinty



        public String readFile (MouseEvent mouseEvent) throws InterruptedException {

        String path = filePath.getText();


        //todo z jakiegos powodu wyrzuca ok takze wtedy kiedy sciezka nie jest prawidlowa..

        if (isValidPath(path)) {
            fileSelectorFeedback.setText("ok!");
            ReadXML.readXML(path);
            System.out.println("sciezka do pliku to = " + path);
        }

        else {
            fileSelectorFeedback.setText("To nie jest własciwa nazwa pliku!");
            Thread.sleep(3000);
            fileSelectorFeedback.setText("Podaj prawidłową ścieżkę do pliku");

        }

        return path;

    }


    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
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
               setUserHint("najpierw wybierz operacje");
           }


        }catch (NumberFormatException ex) {
            System.out.println("to chyba nie jest int stary " + ex);
            //TODO logowanie bledu
        }




    }


    public void setUserHint(String newHint){
        userHint.setText("Najpierw wybierz operację!"); //przy tym sie krzaczy

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
