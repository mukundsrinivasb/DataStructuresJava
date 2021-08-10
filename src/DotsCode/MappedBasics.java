package DotsCode;

import java.util.Map;

public class MappedBasics {
    private Map<String, Basics> BasicInp;
    private Map<String, Map<String, Double>> BasicOut;

    public MappedBasics(Map<String, Basics> inP) {
        for(String s:inP.keySet()){
            BasicInp.put(s,inP.get(s));
        }
    }

    public Map<String, Map<String, Double>> getList() {
        Map<String, Map<String, Double>> retVal;
        for (String s : BasicInp.keySet()) {
            BasicOut.put(s, BasicInp.get(s).getOutPut());
        }
        return BasicOut;
    }

    public Map<String,Double> getOp(String s){
        Map<String,Map<String,Double>> inList = getList();
        return inList.get(s);
    }
}
