/*
 * This program create a hash table using array that holds the data 
aand using quadratic probing to resolve collision. 
There are 2 search method one is shearch with time complixty O(n), and the other search uses the same approuch as quadratic probing
to search more efficiently. 
 */
 
package prog3;

/**
 *
 * @author reem
 */
public class HashTable {
  private int tableSize=0;
  private Node[] table = null;
  private int[] keys;
  private int[] val;
  private double used =0.0;
  private boolean empty = true;
  
   public HashTable(int size) {
   tableSize=size;
   table = new Node[tableSize];
   used = 0.0;
   }
 
   public int hashFun(int key) {
   return key % tableSize;
   }
   
   public void insert(int key, int value){
      

   double factor =  (used/tableSize);
   if (factor*100 < 80){ // check load factor

       
   int hashVal = hashFun(key);
   boolean loop = true;
   Node n = new Node(key,value);    
    // exact position
   if(table[hashVal]==null)
   {
       table[hashVal] = n;
       loop=false;
   }
   // next avalb (first step in quad (H+(1)^2) )
     else if(table[hashVal+1]==null)
   {
       table[hashVal+1] = n;
       loop=false;
   }
   
   // find next aval using qudr (H+(i)^2)
   int hash = hashVal;
   int inc=2;
   while(loop){
             
       hashVal=((hash)+(inc*inc));
       

       
      // calculate new index 
       while (hashVal>tableSize-1){
         hashVal=hashVal-tableSize;
       }
         
         
       // insert if empty slot
       if(table[hashVal]==null)
        {
            table[hashVal] = n; // add node here
            loop=false;
        }
        
        // increment 
        inc++;
    } // end of while
   
       } //end of if
        else {
       //System.out.println("else");
       table = doubleArray();
       insert( key,  value);
       }
       
       //inc used
       used++;
       empty = false;
   }
   
   
public boolean isEmpty(){
return empty;
}   
   
public Node[] doubleArray(){
Node[] temp = new Node[tableSize*2];
tableSize = tableSize*2;
Node[] tempCopy = new Node[tableSize/2];

for(int i = 0; i<tableSize/2;i++)
{ tempCopy[i] = table[i];}

table = temp;
used = 0;
for(int i = 0; i<tableSize/2;i++){
    if(tempCopy[i]!=null){
    insert(tempCopy[i].key,  tempCopy[i].value);
    }
}
return table;
} 
   

   public void print() {
   System.out.println("\nHash Table:");
   for(int i =0;i<tableSize;i++){
       if(table[i]!=null)
       { 
           table[i].print();}
   }
}
   
   
   
public void print2index(int index) {
   System.out.println("\nHash Table:");
   for(int i =0;i<=index;i++){
       if(table[i]!=null)
           table[i].print();
   }
}
   
   
   
   // search with O(n)
    public int search(int key){
    int iter = 0;
    while(iter<table.length){
    if(table[iter]!=null){
     if(table[iter].key()==key)
       {
        return iter;       
       }
   }
    
          iter++;

   }
   return -1;
   
   }
   
  
  // this search method is more efficent  
   public int Search(int key){
   int Found = -1;
   int hashVal = hashFun(key);
   boolean loop = true;
   
   // exact position
   if(table[hashVal]!=null)
   {
       if(table[hashVal].key()==key){
       loop=false;
       Found = hashVal;
       table[hashVal].vis(key);
       }
       
   }
   // next avalb (first step in quad (H+(1)^2) )
    else if(table[hashVal+1]!=null)
   {
       if(table[hashVal+1].key()==key){
       loop=false;
       Found = hashVal+1;
       table[hashVal+1].vis(key);
       }
   }

   // find next aval using qudr (H+(i)^2)
   int hash = hashVal;
   int inc=2;
   boolean cont =true;
   while(loop){
   hashVal=((hash)+(inc*inc));
            System.out.println(hashVal+"f");

        // calculate new index 
        if (hashVal>tableSize-1){
         hashVal=hashVal%tableSize;
         System.out.println(hashVal+"g");
     if(table[hashVal]!=null){
         if(key==table[hashVal].vis()){
             cont = false;
             return Found;
         }}
        }
 
       // find here
       if(table[hashVal]!=null)
        {
            if(table[hashVal].key()==key){
            Found = hashVal;
            loop=false;}
        }
        
        // increment inc
        inc++;
        if(table[hashVal]!=null)
            table[hashVal].vis(key);
   }
   
   return Found;
   }

   
public void delete(int key){
int index = search(key);
if(index>=0)
    table[index]=null; 
}


public boolean exit (){
    int hashVal=0;
return (table[hashVal]==null);
}
}




   
