/*
 * This program create a hash table using array that holds the data 
aand using quadratic probing to resolve collision.
There are 2 search method one is shearch with time complixty O(n), and the other search uses the same approuch as quadratic probing
to search more efficiently.
 */
package prog3;

import java.util.Scanner;

/**
 *
 * @author reem
 */
public class Prog3 {

    /**
     * @param args the command line arguments
     */
    static int input1;
    public static void main(String[] args) {
      HashTable h =new HashTable(50);

        input1 = -1;
        while(input1 != 0)
        {
        System.out.println("\nWhat would like to do?");
        System.out.println("press  1 to insert a key" );
        System.out.println("press  2 to Search for key");
        System.out.println("press  3 to delete key");
        System.out.println("press  0 to exist.");
        
        System.out.print("> ");

        Scanner input = new Scanner(System.in);
        input1=input.nextInt();
        
        switch(input1)
       {
            case 1:
                System.out.println("Enter Key and Value ");
                Scanner input2= new Scanner(System.in);
                 System.out.print("Key   : ");
                 int key = input2.nextInt();
                 System.out.print("Value : ");
                 int value = input2.nextInt();
                h.insert(key,value);
                h.print();
                break;
            case 2:
                  if(!h.isEmpty()){
                 System.out.println("Enter Key ");
                 Scanner input3= new Scanner(System.in);
                int inp = input3.nextInt();
                int f = h.search(inp); 
                if(f>=0)
                {      
                    //System.out.println(f+ " is found ");
                h.print2index(f);
                
                }
                else{
                       System.out.println(inp+" was NOT found ");
                    }
                  }
                  else {
                 System.out.println("The hashTable is empty please add nodes then you can use the search. Thank you for understanding");
                  }
                break;
          
            case 3:
                if(!h.isEmpty()){
                System.out.println("Enter Key ");
                Scanner input4= new Scanner(System.in);
                h.delete(input4.nextInt());
                h.print();}
                else{
                System.out.println("The hashTable is empty please add nodes then you can use the delete. Thank you for understanding");
                }
               break;
            case 0: 
                h.exit();
                break;
            default:
                System.out.println("Wrong Entry \n");
                break;
        }       
                
                
     }
    }
    
}
