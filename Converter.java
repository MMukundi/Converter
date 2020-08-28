package Converter;

import java.util.HashMap;
import java.util.Map;

// @FunctionalInterface
interface ConversionFunction<T>{
    public T convert(T t, String from, String to);
}
    // static Conversion<>
class Conversion<T>{
        // String type;
    String[] units = {};
    ConversionFunction<T> conversionFunc;
    Conversion(String[]u,ConversionFunction<T> cFunc){
        units = u;
        conversionFunc = cFunc;
    };
    public T convert(T t, String to){
        String from = to==units[0]?units[1]:units[0];
        return conversionFunc.convert(t, from, to);
    };
    public T convert(T t, String from,String to){
        return conversionFunc.convert(t, from, to);
    };
}

class Converter{
    static Converter Converter;
    // static HashMap<String[],Conversion> conversions;

    //Maps type to a conversion
    static HashMap<String,Conversion> conversions;
    static <T> void addConversion(Conversion<T> c,String[] units){
        conversions.put(units,c);
    }
    static <T> T convertTo(T val, String goalUnit){
        for(Map.Entry<String[],Conversion> entry:conversions.entrySet()){
            String[] possibleUnits =entry.getKey();
            for(String unit:possibleUnits){
                if(unit==goalUnit){
                    String from = goalUnit==possibleUnits[0]?possibleUnits[1]:possibleUnits[0];
                    return entry.getValue().convert(val, from, goalUnit);
                }
            }
        }
    }
    static convert
    public static void main(String[] args){
        
    }
    

}