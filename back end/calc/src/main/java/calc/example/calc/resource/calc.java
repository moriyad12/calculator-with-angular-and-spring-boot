package calc.example.calc.resource;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class calc {
    public static String cal(double o1,double o2,char op){
        if(op=='+')
            o1 =operations.add(o1,o2);
        else if(op=='-')
            o1 =operations.min(o1,o2);
        else if(op==':')
            o1 =operations.div(o1,o2);
        else if(op=='*')
            o1 =operations.mul(o1,o2);
        else if(op=='^')
            o1 =operations.pow(o1,o2);

        if((int)o1==o1)
            return Integer.toString((int)o1);
       // if(Math.abs(o1)>=1)
            return Double.toString(o1);
      }
}
