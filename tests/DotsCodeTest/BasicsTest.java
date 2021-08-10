package DotsCodeTest;

import DotsCode.Basics;
import DotsCode.MappedBasics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.*;

public class BasicsTest {
    public static Double[] generateRandom() {
        Random rand = new Random();
        Double[] d = new Double[10];
        for (int i = 0; i < 10; i++) {
            d[i] = rand.nextDouble();
        }
        return d;
    }

    @Test
    void testBasics(Double[] d) {
        Basics inBase = new Basics(Arrays.asList(d));
        printList(Arrays.asList(d));
        System.out.print("\n");
        var BaseOut = inBase.getOutPut();
        Arrays.sort(d);
        //Max
        print("max Actual:", inBase.getOutPut().get("max"));
        print("max Expected:", d[d.length - 1]);
        Assertions.assertEquals(BaseOut.get("max"), d[d.length - 1], 0.01);
        //Min
        print("min Actual:", inBase.getOutPut().get("min"));
        print("min Expected:", d[0]);
        //Sum
        double exSum = Arrays.asList(d).stream().reduce(0.0, (ele1, ele2) -> ele1 + ele2);
        print("sum Actual:", inBase.getOutPut().get("sum"));
        print("sum Expected:", exSum);
        Assertions.assertEquals(exSum, BaseOut.get("sum"), 0.01);
        //mean
        print("min Actual:", inBase.getOutPut().get("mean"));
        print("min Expected:", exSum / 10);
        Assertions.assertEquals(exSum / 10, BaseOut.get("mean"), 0.01);
    }

    @Test
    void testMappedBasics() {
        Map<String, Basics> BricKiln = new HashMap<>();
        final String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alpha.length() - 1; i++) {
            Basics bAsics = new Basics(Arrays.asList(generateRandom()));
            BricKiln.put(alpha.substring(i, i + 1), bAsics);
        }
        MappedBasics mbAsics = new MappedBasics(BricKiln);

    }

    @Test
    boolean testUnitMappedBasics(Basics base , )

    void print(String Message, Double valuesToPrint) {
        final DecimalFormat def = new DecimalFormat("#.###");
        System.out.print(" " + Message + " " + def.format(valuesToPrint) + "\n");

    }

    void printList(List<Double> pList) {
        final DecimalFormat def = new DecimalFormat("#.###");
        for (Double d : pList) {
            System.out.printf(def.format(d) + " ");
        }
    }


}
