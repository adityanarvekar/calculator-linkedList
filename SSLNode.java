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
class SLLNode {
    protected String element;
    protected SLLNode succ;
    public SLLNode (String ele,SLLNode n){
        element = ele;
        succ =n;
    }
}