/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorbig;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author aditya
 */
public class FXMLDocumentController implements Initializable {
    
    static String number1 ="", number2="";
    int decimalLocation=0;
    @FXML
    private Label signLabel;
    
    @FXML
    private TextField number1Txt;
    
    @FXML
    private TextField number2Txt;
    
    @FXML
    private TextField resultTxt;
    
    @FXML
    private void handleQuitAction(ActionEvent event){
    System.exit(1);
}
    
    @FXML
    private void handleComputeAction(ActionEvent event) {
        
     
        number1 = number1Txt.getText();
        number2 = number2Txt.getText();
        String operationToPerform=signLabel.getText();
        
        if (!number1.contains("-") && !number2.contains("-")) {
            curateInput(number1, number2);
            SLL op1= new SLL(number1);
            SLL op2= new SLL(number2);
            switch (operationToPerform) {
                case "-":
                    {
                        boolean boo=checkGreaterThan(op1,op2,number1);
                        if(boo){
                            subtractionLinkedList(op1,op2,"");
                        }
                        else{
                            subtractionLinkedList(op2,op1,"-");
                        }       break;
                    }
                case "+":
                    additionLinkedList(op1,op2,"");
                    break;
                case "*":
                    multiplicationLinkedList(op1,op2,"",number1);
                    break;
                case ">":
                    {
                        boolean boo=checkGreaterThan(op1,op2,number1);
                        if(boo){
                            resultTxt.setText("TRUE");
                        }
                        else{
                            resultTxt.setText("FALSE");
                        }       break;
                    }
                case "<":
                    {
                        boolean boo=checkLesserThan(op1,op2,number1);
                        if(boo){
                            resultTxt.setText("TRUE");
                        }
                        else{
                            resultTxt.setText("FALSE");
                        }       break;
                    }
                case "==":
                    {
                        boolean boo=checkIdentical(op1,op2);
                        if(boo){
                            resultTxt.setText("TRUE");
                        }
                        else{
                            resultTxt.setText("FALSE");
                        }       break;
                    }
                default:
                    break;
            }
            
            
        }
        
        ////////////////////////////////////////////////////////////////////////
        else if(number1.contains("-") && !number2.contains("-")){
            number1 = number1.replace("-", "");
            curateInput(number1, number2);
            SLL op1= new SLL(number1);
            SLL op2= new SLL(number2);
            boolean boo=checkGreaterThan(op1,op2,number1);
            
            if(boo){
                switch (operationToPerform) {
                    case "-":
                        additionLinkedList(op1,op2,"-");
                        break;
                    case "+":
                        subtractionLinkedList(op1,op2,"-");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"-",number1);
                        break;
                    case ">":
                        resultTxt.setText("FALSE");
                        break;
                    case "<":
                        resultTxt.setText("TRUE");
                        break;
                    case "==":
                        resultTxt.setText("FALSE");
                        break;
                    default:
                        break;
                }
                
            }
            else{
                switch (operationToPerform) {
                    case "+":
                        subtractionLinkedList(op2,op1,"");
                        break;
                    case "-":
                        additionLinkedList(op1,op2,"-");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"-",number1);
                        break;
                    case ">":
                        resultTxt.setText("FALSE");
                        break;
                    case "<":
                        resultTxt.setText("TRUE");
                        break;
                    case "==":
                        resultTxt.setText("FALSE");
                        break;
                    default:
                        break;
                }
            }
        }
        
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        else if(!number1.contains("-") && number2.contains("-")){
            number2 = number2.replace("-", "");
            curateInput(number1, number2);
            SLL op1= new SLL(number1);
            SLL op2= new SLL(number2);
            
            boolean boo=checkGreaterThan(op1,op2,number2);
            if(boo){
                switch (operationToPerform) {
                    case "-":
                        additionLinkedList(op1,op2,"");
                        break;
                    case "+":
                        subtractionLinkedList(op1,op2,"");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"-",number2);
                        break;
                    case ">":
                        resultTxt.setText("TRUE");
                        break;
                    case "<":
                        resultTxt.setText("FALSE");
                        break;
                    case "==":
                        resultTxt.setText("FALSE");
                        break;
                    default:
                        break;
                }
            }
            else{
                switch (operationToPerform) {
                    case "+":
                        subtractionLinkedList(op2,op1,"-");
                        break;
                    case "-":
                        additionLinkedList(op1,op2,"");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"-",number2);
                        break;
                    case ">":
                        resultTxt.setText("TRUE");
                        break;
                    case "<":
                        resultTxt.setText("FALSE");
                        break;
                    case "==":
                        resultTxt.setText("FALSE");
                        break;
                    default:
                        break;
                }
            }
        }
        
        
        ////////////////////////////////////////////////////////////////////////////
        
        
         else if(number1.contains("-") && number2.contains("-")){
            number1 = number1.replace("-", "");
            number2 = number2.replace("-", "");
            curateInput(number1, number2);
            SLL op1= new SLL(number1);
            SLL op2= new SLL(number2);
            
            boolean boo=checkGreaterThan(op1,op2,number1);
            if(boo){
                switch (operationToPerform) {
                    case "-":
                        subtractionLinkedList(op1,op2,"-");
                        break;
                    case "+":
                        additionLinkedList(op1,op2,"-");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"",number2);
                        break;
                    case ">":
                        resultTxt.setText("FALSE");
                        break;
                    case "<":
                        resultTxt.setText("TRUE");
                        break;
                    case "==":
                        boolean boo2=checkIdentical(op1,op2);
                        if(boo2){
                            resultTxt.setText("TRUE");
                        }
                        else{
                            resultTxt.setText("FALSE");
                        }       break;
                    default:
                        break;
                }
            }
            else{
                switch (operationToPerform) {
                    case "+":
                        additionLinkedList(op1,op2,"-");
                        break;
                    case "-":
                        subtractionLinkedList(op2,op1,"");
                        break;
                    case "*":
                        multiplicationLinkedList(op1,op2,"",number2);
                        break;
                    case ">":
                        resultTxt.setText("TRUE");
                        break;
                    case "<":
                        resultTxt.setText("FALSE");
                        break;
                    case "==":
                        boolean boo2=checkIdentical(op1,op2);
                        if(boo2){
                            resultTxt.setText("TRUE");
                        }
                        else{
                            resultTxt.setText("FALSE");
                        }       break;
                    default:
                        break;
                }
            }
         }    
    }
     
    
    @FXML
    private void changeSignLabel(ActionEvent event) {
       signLabel.setText(((Button)event.getSource()).getText());
       
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {

            @Override
            public TextFormatter.Change apply(TextFormatter.Change t) {

                if (t.isReplaced()) 
                    if(t.getText().matches("[^0-9]"))
                        t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
                

                if (t.isAdded()) {
                    if (t.getControlText().contains(".")) {
                        if (t.getText().matches("[^0-9]")) {
                            t.setText("");
                        }
                    } else if (t.getText().matches("[^0-9.]")) {
                        t.setText("");
                    }
                }

                return t;
            }
        };
        
        
       // number1Txt.setTextFormatter(new TextFormatter<>(filter));
       // number2Txt.setTextFormatter(new TextFormatter<>(filter));
    }    
    
    
    public void additionLinkedList(SLL first, SLL second, String finalSign){
        
        SLL result = first.add(second);
        resultTxt.setText(finalSign+result.toString2());
        
    }
    
    public void subtractionLinkedList(SLL first, SLL second, String finalSign){
         SLL result = first.subtractLinkedList(second);
         resultTxt.setText(finalSign+result.toString2());
    }
    
    public void multiplicationLinkedList(SLL first, SLL second, String finalSign,String one){
        SLL result = first.multipleLinkedList(second,one.length()*2);
        decimalLocation=(one.length()-1-one.indexOf("."))*2;
        if(decimalLocation%2==0){
                        result.insertAfterIndex(decimalLocation-1, new SLLNode(".", null));
                    }
                    else{
                        result.insertAfterIndex(decimalLocation, new SLLNode(".", null));
                    }
                    String curStr=finalSign+result.toString2();
                    resultTxt.setText(curStr);
    }
    
    public boolean checkGreaterThan(SLL first, SLL second, String ran){
        first.reverse();
        second.reverse();
        boolean res = first.isGreaterThan(second, Double.parseDouble(ran.indexOf(".")+""));
        first.reverse();
        second.reverse();
            if(res){
                  return true;
            }
            else{
                  return false;
            }
    }
    
    public boolean checkLesserThan(SLL first, SLL second, String ran){
        first.reverse();
        second.reverse();
        boolean res = first.isLessThan(second, Double.parseDouble(ran.indexOf(".")+""));
        first.reverse();
        second.reverse();
            if(res){
                  return true;
            }
            else{
                  return false;
            }
    }
    
     public boolean checkIdentical(SLL first, SLL second){
        first.reverse();
        second.reverse();
        boolean res = first.areIdentical(second);
        first.reverse();
        second.reverse();
            if(res){
                  return true;
            }
            else{
                  return false;
            }
    }
    
    
    
    
    public static void curateInput(String num1,String num2) {
        String num1Array[] = new String[2], num2Array[] = new String[2];
        if(num1.contains(".")) {
           
        }
        else{
            num1=num1+".00".trim();
        }
        if(num2.contains(".")) {
           
        }
        else{
            num2=num2+".00".trim();
        }
         String[] num1Temp = num1.trim().split("\\.");
         num1Array[0] = num1Temp[0];
         num1Array[1] = num1Temp[1];
            
         String num2Temp[] = num2.split("\\.");
         num2Array[0] = num2Temp[0];
         num2Array[1] = num2Temp[1];
        
        if(num1Array[0].length()>num2Array[0].length()) {
            int appendZero = num1Array[0].length() - num2Array[0].length();
            String temp = num2Array[0];
            for(int i=0;i<appendZero;i++) {
                temp = "0"+temp.trim(); 
            }
            num2Array[0] = temp;
        }
        else if(num2Array[0].length()>num1Array[0].length()) {
            int appendZero = num2Array[0].length() - num1Array[0].length();
            String temp = num1Array[0];
            for(int i=0;i<appendZero;i++) {
                temp = "0"+temp.trim();
            }
            num1Array[0] = temp;
        }
        if(num1Array[1].length()>num2Array[1].length()) {
            int appendZero = num1Array[1].length() - num2Array[1].length();
            String temp = num2Array[1];
            for(int i=0;i<appendZero;i++) {
                temp = temp+"0".trim();
            }
            num2Array[1] = temp;
        }
        else if(num2Array[1].length()>num1Array[1].length()) {
            int appendZero = num2Array[1].length() - num1Array[1].length();
            String temp = num1Array[1];
            for(int i=0;i<appendZero;i++) {
                temp = temp+"0".trim();
            }
            num1Array[1] = temp;
        }
        number1 = num1Array[0]+"."+num1Array[1];
        number2 = num2Array[0]+"."+num2Array[1];
    }
    public boolean curateOperation(String num1Txt, String num2Txt, String event) {
        
        String signNumber1 = num1Txt.charAt(0)+"";
        String signNumber2 = num1Txt.charAt(0)+"";
        
        boolean result = false;
        String operation = "+";
        if(signNumber1.equals("-")) {
            if(event.equals("+")){
                operation = "-";
            }
            else if(event.equals("-")){
                operation = "+";
            }
        }
        if(operation.equals("-")){
        if(signNumber2.equals("-")) {
                operation = "+";
            }
        else{
            operation = "-";
        }
        }
        else {
            if(signNumber2.equals("+")){
                operation = "+";
            }
            else {
                operation = "-";
            }
        }
        if(operation.equals("-")){
            result = false;
        }
        else{
            result = true;
        }
        return result;    
    }
}

