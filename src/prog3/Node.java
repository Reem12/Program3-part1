/*
 * This program create a hash table using array that holds the data 
and using quadratic probing to resolve collision.
There are 2 search method one is shearch with time complixty O(n), and the other search uses the same approuch as quadratic probing
to search more efficiently.
 */
package prog3;

/**
 *
 * @author reem
 */
public class Node {
   
    public int key;
    public int value;
    public int vis=0;
 
    public Node(int k, int v){
    key=k;
    value=v;
    vis=0;
     }

    public int key(){
    return key;
    }
    public int value(){
    return value;
    }
    
    public void print(){
       System.out.println(key()+" : "+value() );
    }
    public int vis(){
    return vis;
    }
    
    public void vis(int input){
    vis=input;
    }
    
    
    
}


