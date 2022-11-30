package calc.example.calc.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
@RestController
public class controller implements Serializable {
    @CrossOrigin
    @GetMapping("/{form}")
    public String hello(@PathVariable String form){
        String exp=form;
        boolean check=false;
        char c = 0;
        System.out.println(form);
        if((exp.charAt(exp.length()-1)>'9'||exp.charAt(exp.length()-1)<'0')&&exp.charAt(exp.length()-1)!='~')
        { check=true;
            c=exp.charAt(exp.length()-1);
            exp=exp.substring(0,exp.length()-1);}
        strToDouble std =new strToDouble();
        std.setScreen(exp);
        std.change();
        double op1=std.getOperand1();
        double op2=std.getOperand2();
        char ope= std.getOperation();
        exp=calc.cal(op1,op2,ope) ;
        if(check)
        { exp+= Character.toString(c);}
        System.out.println(exp);
        return exp;
    }
}
