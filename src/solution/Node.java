package solution;


public class Node {
	
	
	public String data;
	public int ID,parentID;
	public String linkUrL;
	
	public Node child,sibling;
	
	
	
	public Node(){}
	
	public Node(String data,int ID,int parentID,String linkUrL)
	{
		this.data = data;
		this.ID = ID;
		this.parentID = parentID;
		this.linkUrL = linkUrL;
	}	
	
}
