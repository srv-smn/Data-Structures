// deleting a node in LL require storing of previos node 
import java.util.*;
class LinkedList
{
 static Node head ; // head 
  
  static class Node // defining a node 
  {
    int data ;
    Node next; // properties of node 
    
    public Node(int _data)  // constructor to init node 
    {
      data = _data ;
      next = null;
    } 
  }
  
  public  static void main(String args[])
  {
    head = new Node(1);
    Node n1 = new Node(2);
    Node n2 = new Node(4);
    head.next = n1;
    n1.next = n2; // creating and connecting node to each other 
    System.out.println("initial printing");
    printList();
    push(0);
    System.out.println("printing after push operation");
    printList();
    insertAfter(n1,3);
    System.out.println("printing after insert operation");
    printList();
    append(50);
    System.out.println("printing after append operation");
    printList();
    deleteNode(50);
     System.out.println("printing after delete operation");
    printList();
    
    
    deleteNodeAtPosition(2);
     System.out.println("printing after delete operation at pos");
     printList();
    System.out.println("printing length of Linked List" + getCount());
    System.out.println("printing length of Linked List via recursion" + getCount(head));
    System.out.println("Searching element in itterative way " + search(40));
    System.out.println("Searching element in recursive way " + search(head,40));
    System.out.println("Get the value of Nth node" + getNth(2));
    System.out.println("Get the value of Nth node from last " + getNthFromLast(2));
    System.out.println("Get the value of middle node: " + middle());
    System.out.println("find the occurance of a particular number in the list " + count(100));
    System.out.println("Does Linklist contains loop: " + loop(head));
    append(3);
    append(1);
    append(0);
    printList();
    System.out.println("Check Palindrom: " + isPalindrom(head));
    removeDuplicates();
    System.out.println("after deletion");
    printList();
    moveToFront();
    System.out.println("Moving last node to front");
    printList();
    reverse();
    System.out.println("after reverse");
    printList();
    
  }
  
  public static void printList()   // function to print list 
    
  {
    Node n= head;
    while(n.next != null)
    {
      System.out.println(n.data);
      n= n.next;
    
    }
    System.out.println(n.data);
  }
  
  public static void push(int _data)
  {
    // This method will insert a new node at the beginning of the node 
    Node n = new Node(_data);
      n.next = head ;
      head = n ;   
  }
  
  public static void insertAfter(Node _new , int _new_data)
  {
    if(_new == null)
    {
      System.out.println("Node argument can not be null ");
    }
    else 
    {
      Node new_node = new Node(_new_data);
      new_node.next = _new.next;
      _new.next = new_node;
      
    }
    
  }
  
  public static void append(int new_data)
  { // inserting a new node at the end 
    Node new_node = new Node(new_data);
    if(head == null)
    {
      head = new_node;
      return;
    }
    Node c = head ;
    while(c.next!= null)
    {
      c= c.next;
    }
    c.next = new_node;
  }
  
  public static void deleteNode(int key) // delete node where key is found 
  {// In this method as we are deleting a node based on data so we need to keep track of the previous node 
   Node h = head;
   Node prev = null ;
   while(h != null && h.data !=key)
   {
     prev = h ;
     h = h.next;   
   }
   if(h== null)
    return;
   if(h.data == key)
   {
     prev.next = h.next;   
   }
  }
  
  public static void deleteNodeAtPosition(int pos)
  {
    if(head == null)
      return;
    if(pos==0){
      head = head.next;
      return;
      
    }
    Node h = head ;
      for(int ctr=0;h!=null && ctr <pos-1; ctr++)
    {
     h = h .next; 
    }
    
    if(h==null)
      return ;
     else
      h.next = h.next.next;

  }
  
  public static void deleteList() // deleting the list
  {
    head = null;   
  }
  
  public static int getCount() // length of Link List via itterration 
  {int count =0;
    Node h = head ;
    while(h!= null)
    {
      count ++;
      h = h.next;
    }
  return count;
  }
  
  public static int getCount(Node h)// getting length of List via recursive method 
  {
    if(h== null)
      return 0;
    else
    {
      h = h.next;
      return 1 + getCount(h);
      
    }   
  }
  public static boolean search(int x) // searching element in itterative way 
  {
    Node h = head ;
    if(h == null)
      return false ;
    
    while(h!= null)
    {
      if(h.data == x)
        return true ; 
      h= h.next;
    }
    return false ;  
  }
   
  public static boolean search(Node n , int x)// searching element in recursive way 
  {
    if(n== null){
      return false;
    }
      else if(n.data==x){
        return true ;
      } 
      else {
        n=n.next;
        return false || search(n,x);
      }
}
  
  public static int getNth(int index) // get the value of Nth node 
  {
    Node n = head;
    int count =0; 
    while( n!= null)
    {
      if(count == index)
        return n.data;
      count ++;
      n=n.next;
      
    }
      return 0;
  }
  public static int getNthFromLast(int index) // get the value of Nth node from last 
  {
    Node h = head ;
    int len =0;
    while(h != null )
    {
      h=h.next;   
      len++;
    }
    
    if(len < index)
      return 0;
    h = head;  // the formula used here is last index - desired index +1 is equal to desired index from last , in this case loop should start from 0
    for(int ctr =1; ctr < len - index+1 ; ctr++)
    {
     h = h.next;
    }
    return(h.data);
  }
  
  public static int middle() //https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
  {
    Node fst = head;
    Node slw = head ;
    if(head != null)
    {
      while(fst != null && fst.next != null)
      {
        fst = fst.next.next;
        slw = slw.next;
      }
      return slw.data;
    }
    return 0;  
  }
  
  public static int count(int num) // count the number of occurance of a number in a linked list 
  {
   int count = 0;
   Node h = head ;
   while(h != null)
   {
    if(h.data == num)
      count++ ;
    h= h.next;
   }
    return count;
  }
  
  public static boolean loop(Node h) // find if there is a loop in the List
  {
    HashSet<Node> hs = new HashSet<Node>();
    
    while(h!= null)
    {
      if(hs.contains(h))
        return true;
        
      hs.add(h);
      h=h.next;
    }
    return false;
  }
  
  
  public static int lengthOfLoop(Node h)// find the length of the loop 
  {
    HashMap<Node, Integer> hm = new HashMap<Node, Integer>();
    int ctr = 0;
    while(h!= null)
    {
      if(hm.containsKey(h))
      {
        int diff = ctr - hm.get(h);
        return diff;
    
      }
      hm.put(h,ctr);
      ctr++;
      h = h.next;
    }
    return 0;
  }
  
  public static boolean isPalindrom(Node h) // to chech if the linklist is palindrom
  {
    Node slow = h;
    String s="";
    while(slow!= null)
    {
      s= s+slow.data;
      slow = slow.next;
    }
    StringBuffer sb = new StringBuffer(s);
    sb = sb.reverse();
    String s1 = new String(sb);
    System.out.println("S   "+s);
    System.out.println("S1  "+s1);
    if(s.equals(s1))
      return true;
    return false;  
  }
   public static void removeDuplicates() // removing duplicates // compare it with node.next to avoid overhead of remembering previous node 
   {
     Node h = head;
     Node ptr1 =head;
     while(h!= null)
     {
       ptr1 = h;
         while(ptr1.next != null)
         {
           if(h.data == ptr1.next.data)
           {
             ptr1.next = ptr1.next.next;
             
           }
           else
             ptr1=ptr1.next;
           }
         h=h.next;
    }
     
   }
    public static void moveToFront() // moving the last node to front of the list 
     {
       Node h = head;
       Node lh = null;
       if(h!= null && h.next == null)
         return;
       while(h.next!= null)
       {
         lh =h;
         h=h.next;
       }
       lh.next = null;
       h.next = head;
       head = h;
     }
    public static void reverse()// reverse the link list
    {
      Node current = head;
      Node prev = null;
      Node next = null;
      while(current!=null)
      {
        next = current.next;
        current.next = prev;
        prev = current;
        current=next;
      
      }
      head = prev;
    }
  
}