package calc.example.calc.resource;

public class operations {
    public static double add(double operand1 ,double operand2){
        return operand1  + operand2;
    }
    public static double mul(double operand1 ,double operand2){
        return operand1  * operand2;
    }
    public static double div(double operand1 ,double operand2){
        return operand1  / operand2;
    }
    public static double min(double operand1 ,double operand2){
        return operand1  - operand2;
    }
    public static double pow(double operand1 ,double operand2){
        return Math.pow(operand1,operand2);
    }

}
