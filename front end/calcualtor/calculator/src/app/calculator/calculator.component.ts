import { HttpClient } from '@angular/common/http';
import { SelectorMatcher } from '@angular/compiler';
import { ANALYZE_FOR_ENTRY_COMPONENTS, Component, OnInit } from '@angular/core';
import { delay } from 'rxjs';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("");
  }
  title = 'calculator';
  screen: String ="0";
  
  write(text :string){
    if(this.screen=="Infinity"||this.screen=="cant divide by zero"||this.screen=="NaN")
    {
      this.screen="0";
    }
    if(text==".")
    { var check=1;
     for(var i=0;i<this.screen.length;i++)
     {
      if(this.screen.charAt(i)=='.')
      {
        check=0;
      }
      else if((this.screen.charAt(i)>'9'||this.screen.charAt(i)<'0'))
      {
        check=1;
      }
     }
     if(check==1)
     {
      this.screen += text;
     }
     
    }
    else {
    this.screen += text;}
    if(this.screen.length>1&&this.screen.charAt(0)=='0'&&(this.screen.charAt(1)<='9'&&this.screen.charAt(1)>='0'))
     {
      this.screen=this.screen.substring(1);
     }
  }
   writeop(text :string){
    if(this.screen=="Infinity"||this.screen=="cant divide by zero"||this.screen=="NaN")
    {
      this.screen="0";
    }
    if((this.screen.charAt(this.screen.length-1)>'9'||this.screen.charAt(this.screen.length-1)<'0')&&this.screen.charAt(this.screen.length-1)!='.')
     {
      this.screen= this.screen.slice(0, -1);
     }
    this.write(text);
  this.equal();
  }
  writeop_(text:string){
    if(this.screen=="Infinity"||this.screen=="cant divide by zero"||this.screen=="NaN")
    {
      this.screen="0";
    }
    if((this.screen.charAt(this.screen.length-1)>'9'||this.screen.charAt(this.screen.length-1)<'0')&&this.screen.charAt(this.screen.length-1)!='.')
     {
      this.screen= this.screen.slice(0, -1);
     }
    for(var i=this.screen.length-1;i>=0;i--)
    {
      if((this.screen.charAt(i)>'9'||this.screen.charAt(i)<'0')&&this.screen.charAt(i)!='.')
      {
        this.screen=this.screen.substring(0,i+1) + text + this.screen.substring(i+1);
        break;
      }
      if(i==0)
      {this.screen=text+this.screen;
        }

    }
    this.equal();
  }
  clear(){
    this.screen="0";
  }
  back(){
    if(this.screen=="Infinity"||this.screen=="cant divide by zero"||this.screen=="NaN")
    {
      this.screen="0";
    }
   this.screen= this.screen.slice(0, -1);
   if(this.screen=='')
   {
    this.screen="0";
   }
  }
  swap(){
    if(this.screen=="Infinity"||this.screen=="cant divide by zero"||this.screen=="NaN")
    {
      this.screen="0";
    }
    for(var i=this.screen.length-1;i>=0;i--)
    {
      if(this.screen.charAt(i)=='+')
      {
        this.screen=this.screen.substring(0,i) + '-' + this.screen.substring(i+1);
        break;
      }
      else if(this.screen.charAt(i)=='-'&&this.screen.charAt(i-1)!='E')
      { if(i>0)
        this.screen=this.screen.substring(0,i) + '+' + this.screen.substring(i+1);
        else 
        this.screen=this.screen.substring(i+1);
        break;
      }
      if(i==0&&this.screen!="0")
      {this.screen='-'+this.screen;}
    }
  }
  equal(){
    if(this.screen.substring(this.screen.length-2,this.screen.length)==":0"||this.screen.substring(this.screen.length-3,this.screen.length-1)==":0")
    {this.screen="cant divide by zero";}
    else
    {
    this.calculate();}
  }

  calculate(){
   this.http.get("http://localhost:8080/" + this.screen,{responseType:"text"}).subscribe(result=>{this.screen=result});
  }

}
