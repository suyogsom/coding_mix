package linked_list_problems;

public class linked_list {
	
	Node head;
	
	static class Node{
		Node next = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
  }
	
	public static linked_list insert(linked_list list, int data) { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
        return list; 
    } 

}
