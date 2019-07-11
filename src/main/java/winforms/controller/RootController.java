package winforms.controller;


import com.sun.org.apache.bcel.internal.generic.SWITCH;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import winforms.model.Entry;
import winforms.service.ReadXML;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class RootController implements Initializable {

    @FXML
    public Label fileSelectorFeedback;

    @FXML
    public Label operationSelectorFeedback;
    public ScrollPane scroll;
    public AnchorPane scrollPn;

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

    private boolean operationSelected;
    private List<Entry> entryList;
    private String nameOfChoosenOperation;
    private String report;
    StringBuilder stringBuilderHeader;








    // zacznij od podania lokazliacji pliku
    //
    // sprawdzwa poprawnosc pliku i
    // pobiera z pliku wartosci a i b

    //todo trzeba przeazac liste obiektow do metod wykonujacych obliczenia
    //todo dodac loggery



        public String readFile (MouseEvent mouseEvent) throws InterruptedException {

        String path = filePath.getText();


        //todo wlasciwe operacje

        if (isValidPath(path)) {
            fileSelectorFeedback.setText("sciezka ok!");
            entryList = ReadXML.readXML(path);
            System.out.println("sciezka do pliku to = " + path);
        }

        else {
            fileSelectorFeedback.setText("Podaj prawidłową ścieżkę do pliku");
        }

            return path;

    }


    public static boolean isValidPath(String providedPath) {
        File file = new File(providedPath);
        return file.exists();
    }

    public void startProcessing (MouseEvent mouseEvent) throws InterruptedException {


        try{
           if (operationSelected) {
               int operationsCounter = Integer.parseInt(operationsNumber.getText());
               operationsTodo.setText(operationsNumber.getText());
               System.out.println("operations = " + operationsCounter);

               switch (nameOfChoosenOperation) {
                   case "wybrano mnozenie":
                       performMultiplication();
                   break;
                   case "wybrano dzielenie":
                       performDivision();
                       break;
                   case "wybrano potegowanie":
                       performExponentiation();
                       break;
                   case "wybrano odejmowanie":
                       performSubtraction();
                       break;
                   default:
               }

               }




           else {
               setUserHint("najpierw wybierz operacje");
               //todo logowanie
           }


        }catch (NumberFormatException ex) {
            System.out.println("to chyba nie jest int stary " + ex);
            //TODO logowanie bledu
        }




    }

    private void performSubtraction() {
    }

    private void performExponentiation() {
    }

    private void performDivision() {
    }

    private void performMultiplication() throws InterruptedException {


        StringBuilder stringBuilder = new StringBuilder();

        for (Entry e: entryList) {

            int totalResult = 0;
            int operationsCounter = Integer.parseInt(operationsNumber.getText());

            int a = e.getA();
            int b = e.getB();
            int tempB = b;
            stringBuilder.append("################################");
            stringBuilder.append("\n");
            stringBuilder.append("wykonuje obliczenia dla ").append(e.getA()).append(" i ").append(e.getB());
            stringBuilder.append("\n");

            for (int i = 1; i <= operationsCounter ; i++) {

                stringBuilder.append("\n");
                tempB = a * tempB;
              //  result.setText(String.valueOf(tempB));
                totalResult = tempB;
                stringBuilder.append("iteracja " + i);
                stringBuilder.append("\n");

                System.out.println(totalResult);
                stringBuilder.append("wynik " + totalResult);
                stringBuilder.append("\n");
                TimeUnit.SECONDS.sleep(1);
            }


            //todo logger,

            result.setText(String.valueOf(stringBuilder));
            scroll.setContent(result);
        }

    }


    public void setUserHint(String newHint){
        userHint.setText("Najpierw wybierz operację!"); //przy tym sie krzaczy

    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void chooseMultiplication(MouseEvent mouseEvent) throws InterruptedException {

        operationSelected = true;
        operationSelectorFeedback.setText("wybrano mnozenie");
        nameOfChoosenOperation = operationSelectorFeedback.getText();

    }



    public void chooseDivision(MouseEvent mouseEvent) {

        operationSelected = true;
        operationSelectorFeedback.setText("wybrano dzielenie");
        nameOfChoosenOperation = operationSelectorFeedback.getText();



    }

    public void chooseExponentiation(MouseEvent mouseEvent) {

        operationSelected = true;
        operationSelectorFeedback.setText("wybrano potegowanie");
        nameOfChoosenOperation = operationSelectorFeedback.getText();


    }

    public void chooseSubtraction(MouseEvent mouseEvent) {
        operationSelected = true;
        operationSelectorFeedback.setText("wybrano odejmowanie");
        nameOfChoosenOperation = operationSelectorFeedback.getText();


    }
}
