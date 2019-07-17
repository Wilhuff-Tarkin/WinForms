/*
 * Copyright (c) Grzegorz Koziczak
 */

package winforms.controller;

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

    @FXML
    public ScrollPane scroll;

    @FXML
    public AnchorPane scrollPn;

    private Button start;
    private Button addition;
    private Button subtraction;
    private Button division;
    private Button multiplication;
    private Button readFile;

    @FXML
    private TextField operationsNumber;

    @FXML
    private TextField filePath;

    @FXML
    private Label result;

    @FXML
    private Label operationsTodo;

    private boolean operationSelected;
    private List<Entry> entryList;
    private String nameOfChoosenOperation;



    public String readFile(MouseEvent mouseEvent) {
        String path = filePath.getText();

        if (isValidPath(path)) {
            fileSelectorFeedback.setText("Patch correct!");
            entryList = ReadXML.readXML(path);
            System.out.println("File path selected = " + path);
        } else {
            fileSelectorFeedback.setText("File path not correct!");
        }
        return path;
    }


    private static boolean isValidPath(String providedPath) {
        File file = new File(providedPath);
        return file.exists();
    }

    public void startProcessing(MouseEvent mouseEvent) throws InterruptedException {

        try {
            if (operationSelected) {
                int operationsCounter = Integer.parseInt(operationsNumber.getText());
                operationsTodo.setText(operationsNumber.getText());
                System.out.println("operations = " + operationsCounter);
                performCalculations();
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please insert an integer " + ex);
        }
    }

    private void performCalculations() throws InterruptedException {

        StringBuilder stringBuilder = new StringBuilder();

        for (Entry e : entryList) {

            int totalResult = 0;
            int operationsCounter = Integer.parseInt(operationsNumber.getText());

            int a = e.getA();
            int b = e.getB();
            int tempB = b;
            stringBuilder.append("################################");
            stringBuilder.append("\n");
            stringBuilder.append("Performing calculations for ").append(e.getA()).append(" i ").append(e.getB());
            stringBuilder.append("\n");

            for (int i = 1; i <= operationsCounter; i++) {

                stringBuilder.append("\n");

                switch (nameOfChoosenOperation) {
                    case "mutliplication requested":
                        tempB = a * tempB;
                        break;
                    case "division requested":
                        if (tempB != 0) {
                            tempB = a / tempB;
                        } else stringBuilder.append("cannot divide by 0!");
                        stringBuilder.append("\n");

                        break;
                    case "addition requested":
                        tempB = a + tempB;
                        break;
                    case "subtraction requested":
                        tempB = a - tempB;
                        break;
                    default:
                }

                totalResult = tempB;
                stringBuilder.append("operation #" + i);
                stringBuilder.append("\n");

                System.out.println(totalResult);
                stringBuilder.append("Result = " + totalResult);
                stringBuilder.append("\n");
                TimeUnit.SECONDS.sleep(1);
            }

            result.setText(String.valueOf(stringBuilder));
            scroll.setContent(result);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void chooseMultiplication(MouseEvent mouseEvent) throws InterruptedException {
        operationSelected = true;
        operationSelectorFeedback.setText("mutliplication requested");
        nameOfChoosenOperation = operationSelectorFeedback.getText();
    }


    public void chooseDivision(MouseEvent mouseEvent) {
        operationSelected = true;
        operationSelectorFeedback.setText("division requested");
        nameOfChoosenOperation = operationSelectorFeedback.getText();
    }

    public void chooseAddition(MouseEvent mouseEvent) {
        operationSelected = true;
        operationSelectorFeedback.setText("addition requested");
        nameOfChoosenOperation = operationSelectorFeedback.getText();
    }

    public void chooseSubtraction(MouseEvent mouseEvent) {
        operationSelected = true;
        operationSelectorFeedback.setText("subtraction requested");
        nameOfChoosenOperation = operationSelectorFeedback.getText();
    }
}
