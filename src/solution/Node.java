package solution;


public class Node {
	
	
	String data;
	int ID,parentID;
	String linkUrL;
	
	public Node child,sibling;
	
	
	
	public Node(){}
	
	public Node(String data,int ID,int parentID,String linkUrL)
	{
		this.data = data;
		this.ID = ID;
		this.parentID = parentID;
		this.linkUrL = linkUrL;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getLinkUrL() {
		return linkUrL;
	}

	public void setLinkUrL(String linkUrL) {
		this.linkUrL = linkUrL;
	}	
	
}
