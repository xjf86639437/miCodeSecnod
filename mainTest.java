package miCodeSecnod;

import java.util.HashMap;

public class mainTest 
{
	
	  public static void main(String []args)
	  {
		Node a = new Node();  
		Node b = new Node();  
		Node c = new Node();  
		Node d = new Node();
		a.setVal(1);
		a.setNext(b);
		a.setAnother(c);           
		
		b.setVal(2);
		b.setNext(c);
		b.setAnother(d);
		
		c.setVal(3);
		c.setNext(d);
		c.setAnother(a);
		
		d.setVal(4);
		d.setNext(null);
		d.setAnother(null);
		
		mainTest test = new mainTest();
		
		test.outNode(test.copyNode(a));
	  }
	  
	  public void outNode(Node p)
	  {
		  Node head = p;
		  while(head!=null)
		  {
			  System.out.print(head.getVal());
			  head = head.getNext();
		  }
		  System.out.println("------");
		  Node head2 = p;
		  while(head2!=null)
		  {
			  Node temp = head2;
			  if(temp.getAnother()!=null)
			  {                                               //只输出一层，解决环的情况下死循环
				  System.out.print(temp.getVal());
				  System.out.print(temp.getAnother().getVal());
				  System.out.println("------");
			  }
			  head2 = head2.getNext();
		  }
		  
	  }
	  
	  public Node copyNode(Node p)
	  {
		  Node head = p;
		  Node result = new Node();
		  if(null == head )
		  {
			  return result;
		  }
		  result.setVal(head.getVal());
		  Node resultHead = result;
		  HashMap<Node,Node> map = new HashMap<Node, Node>();
		  map.put(head, result); 
		  while(head.getNext()!=null)           //第一次遍历
		  {
			  Node next = head.getNext();
			  Node temp = new Node();
			  temp.setVal(next.getVal());
			  result.setNext(temp);
			  map.put(next, temp);
			  result = result.getNext();
			  head = head.getNext();
			 
		  }
		  Node head2 = p;
		  Node resultHead2 = resultHead;
		  while(head2!=null) 					//第二次遍历
		  {
			  if(head2.getAnother()!=null)
			  {
				  resultHead2.setAnother(map.get(head2.getAnother()));
			  }
			  else
			  {
				  resultHead2.setAnother(null);
			  }
			  head2=head2.getNext();
			  resultHead2 = resultHead2.getNext();
		  }
		  
		  return resultHead;
	  }
	  
}
