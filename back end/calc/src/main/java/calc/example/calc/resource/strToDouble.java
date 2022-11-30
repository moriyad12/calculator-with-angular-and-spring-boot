package calc.example.calc.resource;

public class strToDouble {
        private String screen ;
        private double operand1;
        private double operand2;
        private char operation;
        private int inx;

        public String getScreen() {
            return screen;
        }
        public void setScreen(String screen) {
            this.screen = screen;
        }
        public void setOperand2(double operand2) {
            this.operand2 = operand2;
        }
        public double getOperand2() {
            return operand2;
        }

        public double getOperand1() {
            return operand1;
        }

        public void setOperand1(double operand1) {
            this.operand1 = operand1;
        }

        public char getOperation() {
            return operation;
        }

        public void setOperation(char operation) {
            this.operation = operation;
        }
        public void change() {

            for (int i = 1; i < this.screen.length(); i++) {
                if(screen.charAt(i)=='+')
                {
                    inx =i;
                    break;
                }
                else if(screen.charAt(i)=='-'&&screen.charAt(i-1)!='E')
                {
                    inx =i;
                    break;
                }
                else if(screen.charAt(i)=='*')
                {
                    inx =i;
                    break;
                }
                else if(screen.charAt(i)==':')
                {
                    inx =i;
                    break;
                }
                else if(screen.charAt(i)=='^')
                {
                    inx =i;
                    break;
                }

                else
                {inx=-1;}
            }
            if(inx>0)
            {String x=screen.substring(0,inx);
                String y=screen.substring(inx+1,screen.length());
                operand1=Double.parseDouble(x);
                if(y.length()>2)
                {if(y.charAt(y.length()-2)=='^'||y.charAt(y.length()-3)=='^')
                {
                    if(y.charAt(y.length()-2)=='^')
                    {
                        y=y.substring(0,y.length()-2);
                        operand2=Double.parseDouble(y);
                        operand2=operand2*operand2;
                    }
                    else
                    {
                        y=y.substring(0,y.length()-3);
                        operand2=Double.parseDouble(y);
                        operand2=Math.sqrt(operand2);
                    }

                }
                else if(y.charAt(1)==':')
                {
                    y=y.substring(2,y.length());
                    operand2=Double.parseDouble(y);
                    operand2=1/operand2;
                }
                else if(y.charAt(y.length()-1)=='~')
                {
                    y=y.substring(0,y.length()-1);
                    operand2=Double.parseDouble(y);
                    operand2/=100;
                }
                else{
                operand2=Double.parseDouble(y);}}
                else if(y.charAt(y.length()-1)=='~')
                {
                    y=y.substring(0,y.length()-1);
                    operand2=Double.parseDouble(y);
                    operand2/=100;
                }
                else {
                    operand2=Double.parseDouble(y);
                }
                operation=screen.charAt(inx);}
            else {
                if(screen.charAt(screen.length()-1)=='~')
                {
                    String y=screen.substring(0,screen.length()-1);
                    operand1=Double.parseDouble(y);
                    operand2=Double.parseDouble(y);
                    operation='?';
                    operand1/=100;
                }
                else{
                operand1=Double.parseDouble(screen);
                operand2=Double.parseDouble(screen);
                operation='?';}
            }
        }
    }

