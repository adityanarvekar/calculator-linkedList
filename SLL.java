/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorbig;

/**
 *
 * @author aditya
 */
public class SLL {
    private SLLNode first;
    private SLLNode last;
    private boolean borrow;
    static String number1 ="", number2="";
    public SLL(){
        this.first =null;
        
        }
    public SLL(String nodeSll) {
            String[] bignum=nodeSll.split("");
        for (String bignum1 : bignum) {
           this.insertAtFront(new SLLNode(bignum1, null));
        }   
    }
    public SLL(SLLNode nodeSll) {
           this.insertAtFront(nodeSll);  
    }
   
   public void printFirstToLast(){
       for(SLLNode curr=first; curr!=null; curr=curr.succ){
           System.out.println(curr.element+" ");
       }
   }
   public void insertAtFront(SLLNode node){
       node.succ = this.first;
       this.first = node;
   }
   public SLLNode getFirst(){
       return this.first;
   }
   public void insertAfter(String obj, SLLNode node) {
        for(SLLNode here = this.first; here!=null;here = here.succ) {
            if(here.element.equals(obj)) {
                node.succ = here.succ;
                here.succ = node;
                return;
            }
        }
    }
   
   public SLL add(SLL second) {
       SLL resultList = null;
       SLLNode result = null;
       SLLNode prev = null; 
       SLLNode temp = null; 
       int carry = 0, sum;
       int position = this.indexOf(new SLLNode(".", null));
       SLLNode curr = this.first;
       SLLNode curr2 = second.first;
       while(this!=null && curr!=null && curr2!=null) {
           if(curr.element.equals(".")) {
               if (this != null) { 
                curr = curr.succ; 
            } 
            if (second != null) { 
                curr2 = curr2.succ; 
            }
           }
           else {
                sum = carry + (Integer.parseInt(curr.element) + Integer.parseInt(curr2.element));
                carry = (sum >= 10) ? 1 : 0;
           sum = sum % 10;
           temp = new SLLNode(sum+"",null);
           if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp; 
           if (this != null) { 
                curr = curr.succ; 
            } 
            if (second != null) { 
                curr2 = curr2.succ; 
            }
       }
      }
        if (carry > 0) { 
            temp.succ = new SLLNode(carry+"",null); 
        }
       resultList.insertAfterIndex(position-1,new SLLNode(".",null));
       return resultList;
   }
   
   public SLL subtractLinkedList(SLL l2) {
        SLLNode prev = null;
        SLLNode result = null;
        SLL resultList = null;
        SLLNode curr = this.first;
       SLLNode curr2 = l2.first;
       int position = this.indexOf(new SLLNode(".", null));
       while(this!=null && curr!=null && curr2!=null) {
       if (this == null && l2 == null && borrow == false) 
            return null;
       if(curr.element.equals(".")) {
           curr = curr.succ;
           curr2 = curr2.succ;
       }
       
       int d1 = Integer.parseInt(curr.element);
       int d2 = Integer.parseInt(curr2.element);
       int sub = 0;
       
       if(borrow) {
           d1--;
           borrow = false;
       }
       if(d1<d2) {
           borrow = true;
           d1 = d1+10;
       }
       sub = d1-d2;
       
       SLLNode temp = new SLLNode(sub+"", null);
       if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
                if (this != null) { 
                curr = curr.succ; 
                } 
                if (l2 != null) { 
                curr2 = curr2.succ; 
                }
       }
       resultList.insertAfterIndex(position-1,new SLLNode(".",null));
       return resultList; 
   }
   
   public SLL multipleLinkedList(SLL second,int numberLength) {
       SLL resultList = null;
       SLLNode prev = null;
       SLLNode result = null;
       SLLNode curr = this.first;
       SLLNode curr2 = second.first;
       SLLNode tempSucc = this.first;
       int count = 0;
       int carry = 0;
       boolean checkCarry = false;
       boolean first = true;
       SLL holdingArray[] = new SLL[this.getCount()];
       while(curr2!=null) { //number 2
           while(curr2!=null && curr!=null) { //number 1
               int num1 = Integer.parseInt(curr.element);
               int num2 = Integer.parseInt(curr2.element);
               int mul = num1*num2;
               
               if(checkCarry) {
                   mul = mul + carry;
                   checkCarry = false;
                   carry = 0;
               }
               if(mul>9){
                   checkCarry = true;
                   carry = mul/10;
                   mul = mul%10;
               }
               tempSucc = curr;
               tempSucc = tempSucc.succ;
               if(tempSucc!=null){
                   SLLNode temp = new SLLNode(mul+"", null);
                if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
           result = null;
               }
               else{
                SLLNode temp = new SLLNode(mul+"", null);
                if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
           result = null;
           temp = new SLLNode(carry+"", null);
                if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
           result = null;
           first = false;
           carry = 0;
           checkCarry = false;
               }
               
           if(this!=null){
               curr = curr.succ;
               if(curr!=null && curr.element.equals(".")){
                   curr = curr.succ;
               }
           }
           }
           if(second!=null){
           curr = this.first;
           curr2 = curr2.succ;
           if(curr2!=null && curr2.element.equals(".")){
               curr2 = curr2.succ;
           }
           int zeroCount = resultList.getCount();
           for(int i=0;i<numberLength-zeroCount;i++){
               SLLNode temp = new SLLNode(0+"", null);
                if (result == null) { 
                result = temp;
                
                    resultList.insertAtFront(result);
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
           result = null;
           }
           holdingArray[count] = resultList;
           //System.out.println("---------"+count);
           //resultList.printFirstToLast();
           resultList = null;
           count++;
           if(!first) {
                   for(int i = 0;i<count;i++){
                   SLLNode temp = new SLLNode(0+"", null);
                if (result == null) { 
                result = temp;
                if(resultList == null) {
                    resultList = new SLL(result);
                }
                else {
                    resultList.insertAtFront(result);
                }
                
            } else { 
                prev.succ = temp; 
            } 
           prev = temp;
           result = null;
               }
               }
           }
       }
       resultList = addMultiply(holdingArray);
       return resultList;
   }
   
   
   public static SLL addMultiply(SLL holdingArray[]) {
       SLL resultList = null;
       int tempSum = 0;
       SLL sum = null;
       for(int i = 0;i<holdingArray.length-1;i++){
           if(i==0){
               int tempLength = holdingArray[0].getCount();
               String tempString = "";
               for(int j=0;j<tempLength;j++){
                   tempString = tempString+"0";
               }
               sum = new SLL(tempString);
           }
           SLL add1 = new SLL(sum.toString2());
           SLL add2 = new SLL(holdingArray[i].toString3());
           sum = add1.add(add2);
       }
       
       //System.out.println(sum.toString2());
       resultList = sum;
       return resultList;
   }
   
   public static String reverseString(String str) {
       String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
   }
   
   
   public int indexOf(SLLNode node){
       int i=0;
        for(SLLNode curr=first; curr!=null; curr=curr.succ){
           if(curr.element.equals(node.element)){
               return i;
           }
           else{
               i++;
           }
           
       }
        return -100;
   }
    public void insertAfterIndex(int index, SLLNode node){
       int i=0;
       for(SLLNode here=this.first;here!=null;here=here.succ){
           if(i==index){
               node.succ = here.succ;
               here.succ = node;
               return;
           }
           else{
               i++;
           }
           
       }
   }
   public int getCount() 
    { 
        SLLNode temp = first; 
        int count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.succ; 
        } 
        return count; 
    } 
   
   public String toString2() {
       String value = "";
           for(SLLNode curr=first; curr!=null; curr=curr.succ){
           value = value + curr.element;
       }
           return reverseString(value);
   }
   
   public String toString3() {
       String value = "";
           for(SLLNode curr=first; curr!=null; curr=curr.succ){
           value = value + curr.element;
       }
           return value;
   }
   
   
   
      boolean areIdentical(SLL listb) 
    { 
        SLLNode a = this.first, b = listb.first; 
        while (a != null && b != null) 
        { 
            if(a.element.equals(".")){
                
            }
            else{
                if (Integer.parseInt(a.element)!=Integer.parseInt(b.element)) 
                return false; 
            }
  
            a = a.succ; 
            b = b.succ; 
        } 
        return (a == null && b == null); 
    } 
   
      
      
      
      ///////////////// <  //////////////
        boolean isLessThan(SLL listb,double powerNumber) 
    { 
        double pointDecimal = powerNumber;
        boolean pointSpotted = false;
        double num1 = 0, num2 = 0, num3 = 0, num4 = 0;
        SLLNode curr = this.first;
        SLLNode curr2 = listb.first;
        while(curr!=null && curr2!=null) {
            if(curr.element.equals(".")) {
                curr = curr.succ;
                curr2 = curr2.succ;
                pointSpotted = true;
            }
            if(!pointSpotted) {
            num1 = Double.parseDouble(curr.element)*Math.pow(10, powerNumber) + num1;
            num2 = Double.parseDouble(curr2.element)*Math.pow(10, powerNumber) + num2;
            curr = curr.succ;
            curr2 = curr2.succ;
            powerNumber--;
            }
            else {
                num3 = Double.parseDouble(curr.element)/Math.pow(10, pointDecimal) + num1;
                num4 = Double.parseDouble(curr2.element)/Math.pow(10, pointDecimal) + num2;
                curr = curr.succ;
                curr2 = curr2.succ;
                pointDecimal--;
            }
        }
        if(num1<num2){
            return true;
        }
        else if(num3<num4){
            return true;
        }
        return false;
    }
   
         ///////////////// >  //////////////
        boolean isGreaterThan(SLL listb,double powerNumber) 
        {
        double pointDecimal = powerNumber;
        boolean pointSpotted = false;
        double num1 = 0, num2 = 0, num3 = 0, num4 = 0;
        SLLNode curr = this.first;
        SLLNode curr2 = listb.first;
        while(curr!=null && curr2!=null) {
            if(curr.element.equals(".")) {
                curr = curr.succ;
                curr2 = curr2.succ;
                pointSpotted = true;
            }
            if(!pointSpotted) {
            num1 = Double.parseDouble(curr.element)*Math.pow(10, powerNumber) + num1;
            num2 = Double.parseDouble(curr2.element)*Math.pow(10, powerNumber) + num2;
            curr = curr.succ;
            curr2 = curr2.succ;
            powerNumber--;
            }
            else {
                num3 = Double.parseDouble(curr.element)/Math.pow(10, pointDecimal) + num1;
                num4 = Double.parseDouble(curr2.element)/Math.pow(10, pointDecimal) + num2;
                curr = curr.succ;
                curr2 = curr2.succ;
                pointDecimal--;
            }
        }
        if(num1>num2){
            return true;
        }
        else if(num3>num4){
            return true;
        }
        return false;
    }
   
   
   public void reverse() {
    SLLNode pointer = this.first;
    SLLNode previous = null, current = null;

    while (pointer != null) {
      current = pointer;
      pointer = pointer.succ;

      // reverse the link
      current.succ = previous;
      previous = current;
      this.first = current;
    }

  }
}
