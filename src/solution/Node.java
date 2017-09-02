package solution;


public class Node {
	
	
	public String data;
	public int ID,parentID;

	
	public Node child,sibling;
	
	
	
	public Node(){}
	
	public Node(String data,int ID,int parentID)
	{
		this.data = data;
		this.ID = ID;
		this.parentID = parentID;
		
	}	
	
}
