package de.hochtaunusschule.gui;

import de.hochtaunusschule.NumberGenerator;
import de.hochtaunusschule.Operator;
import de.hochtaunusschule.OperatorsTester;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author BlueTeaWolf
 */

public class Controller {

    private List<Map.Entry<Long, Operator[]>> allResults;
    private int[] lastNumbers;

    @FXML
    private TextField tfCalculation;
    @FXML
    private ComboBox operatorslength;

    public void initialize() {
        operatorslength.setItems(FXCollections.observableArrayList(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
    }
    @FXML
    void btnGeneratePuzzle(ActionEvent event) {

        if (allResults == null || lastNumbers.length-1 != (int) operatorslength.getValue() || allResults.isEmpty()) {
            while (true) {
                long start = System.currentTimeMillis();
                NumberGenerator numberGenerator = new NumberGenerator();
                numberGenerator.generator((int) operatorslength.getValue());

                OperatorsTester operatorsTester = new OperatorsTester(numberGenerator.getNumbers());
                operatorsTester.generateOperators(0);
                if (operatorsTester.hasUniqueSolutions()) {
                    for (Map.Entry<Long, Operator[]> t : operatorsTester.getDuplicateTracker().pickAll()) {
                        System.out.println(t.getKey() + " " + Arrays.toString(t.getValue()));
                    }
                    System.out.println(Arrays.toString(numberGenerator.getNumbers()));
                    lastNumbers = numberGenerator.getNumbers();
                    allResults = operatorsTester.getDuplicateTracker().pickAll();
                    long end = System.currentTimeMillis();
                    System.out.println(end - start + " Milli");
                    break;
                }
            }
        }
        tfCalculation.setText(Arrays.toString(lastNumbers) + " = " + allResults.remove((int) (Math.random()*allResults.size())).getKey());
    }
}

