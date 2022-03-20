package Service;

public class Calculator {
    public static String result(Double num1,Double num2,String operator){
        switch (operator){
            case "add":
                return num1+num2+"";
            case "sub":
                return num1-num2+"";
            case "mul":
                return num1*num2+"";
            default:
                try{
                    if(num2 ==0){
                        throw new Exception();
                    }
                    return num1/num2+"";
                }catch (Exception e){
                    return "Can not division 0";
                }
        }
    }
    public static String operator(String operator){
        switch (operator){
            case "add":
                return "+";
            case "sub":
                return "-";
            case "mul":
                return "*";
            default:
                return "/";
        }
    }
}
