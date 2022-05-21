package de.hochtaunusschule;

import de.hochtaunusschule.gui.MainFX;

import java.util.Arrays;
import java.util.Map;

/**
 * @author BlueTeaWolf
 */
public class Main {

    public static void main(String[] args) {

        MainFX.main(args);
    }

//        while (true) {
//            NumberGenerator numberGenerator = new NumberGenerator();
//            numberGenerator.generator(15);
//            long start = System.currentTimeMillis();
//
//            OperatorsTester operatorsTester = new OperatorsTester(numberGenerator.getNumbers());
//            operatorsTester.generateOperators(0);
//            if(operatorsTester.hasUniqueSolutions()){
//                System.out.println(Arrays.toString(numberGenerator.getNumbers()));
//                for (Map.Entry<Long, Operator[]> t : operatorsTester.getDuplicateTracker().pickAll()){
//                    System.out.println(t.getKey() + " " + Arrays.toString(t.getValue()));
//                }
//                System.out.println(Arrays.toString(numberGenerator.getNumbers()));
//            }
//            long end = System.currentTimeMillis();
//            System.out.println(end - start + " Milli");
//            break;
//        }
//    }

}
