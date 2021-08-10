package DotsCode;

import java.util.*;

public class Basics {
    private List<Double> InPut;
    private Map<String, Double> outPut = new HashMap<>();

    /**
     * Create a Basics object
     * @param input The input List of double
     */
    public Basics(List<Double> input) {
        InPut = input;
        getMinMax();
        getSumMean();
    }


    public void getMinMax() {
        Double[] inArr = InPut.toArray(new Double[InPut.size()]);
        Arrays.sort(inArr);
        outPut.put("max", inArr[inArr.length - 1]);
        outPut.put("min", inArr[0]);

    }

    void getSumMean() {
        double s = InPut.stream().reduce(0.0, (el1, el2) -> el1 + el2);
        outPut.put("sum", s);
        outPut.put("mean", (s / InPut.size()));
    }

    public Map<String, Double> getOutPut() {
        return outPut;
    }

}




