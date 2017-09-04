package solution;

import java.nio.file.Files;
import java.util.Collections;
import java.util.Comparator;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/*

        N-ary tree:

                                       null
                                         
                        /                |                   \
                 /company              /references             ... 
             
                  /   \                 /     \
                 /     \               /       \
            /aboutus  /mission      /client 1  /client2 
              /
             /
          /team    




               to  Binary:
      
                           root            
                           /   
                          /                                   
                 /company          --->           /references  --->  ....   
                       /                                    / 
                      /                                    /                                                          
                  /aboutus  ---> /mission            /client1   --->  /client2  
                   /
                  /
              /team  


 */


public class NTree
{
	public Node root;
	
	public NTree(){}	
	
	public void addTreeNode(Node parent, Node newChild)
	{
			
		if(parent==null){
            return;
        }
        if(parent.child == null)
         {
            parent.child = newChild;            
            return;
         }

        Node temp = parent.child;

        while(temp.sibling != null)
        {
            temp = temp.sibling;
        }
        temp.sibling = newChild; 		
		
	}
	public void addParent(Node newNode)
	{
		if(root == null)
		{
			root = newNode;
			return;
		}
		
		Node temp = root;

		while(temp.sibling != null)
			temp = temp.sibling;
		
		temp.sibling = newNode;
	}
	 
	public Node find_parentNode(ArrayList<Node> nodes ,int parentID)
	{		
		for(int i= 0;i<nodes.size();i++)
        {
            if(nodes.get(i).getID() == parentID)
                return nodes.get(i);
        }

        return null;
	}
	
	public  void preorder(Node root)
	{
		
		   if (root == null) return;
		   
			 System.out.println(root.getData());
		   	 preorder(root.child);		   	
		   	 preorder(root.sibling);
		   
	}
	
	public static int count_slash(String s)
	{
		int count = 0;
		for( int i=0; i<s.length(); i++ ) 
		
		    if( s.charAt(i) == '/' ) 	
		    	count++;
	
	   return count;
	}
	public static int count_separators(String s)
	{
		int count = 0;
		for( int i=0; i<s.length(); i++ ) 		
		    if( s.charAt(i) == ';' ) 		   
		        count++;
		     
		
	   return count;
	}
	public static boolean isInteger(String s) 
	{
		if(s.isEmpty()) return false;
		
		for(int i=0;i<s.length();i++)
			if( !Character.isDigit( s.charAt(i)))
				return false;
		
		return true;
	}
	
	public static void display(ArrayList<Node> niza)
	{
		for(Node n:niza)
		{
			System.out.println(n.data);
		}
	}
	
	
	
	
	public static void main(String arg [])
	{
		try {
			
			List<String> input = Files.readAllLines(Paths.get("src\\data\\Navigation.csv"));
									
			
			NTree tree = new NTree();			
			ArrayList<Node> listNodes = new ArrayList<Node>();			
					
			
			
			
			for(int i = 1;i < input.size();i++)
			{								
				int n1 = count_separators(input.get(i)); // occurrences of ";"
														
				if(input.get(i).length() > 4 && n1 == 4) // verify
				{
					
					String [] row = input.get(i).split(";");					
					
					String isHidden = row[3].toUpperCase();
					String menuName = row[1];
					String parentID = row[2];
					int ID = Integer.parseInt(row[0]);
					String linkURL = row[4];					
					int n2 = count_slash(linkURL);
													
					
					if(menuName.length() > 0 && parentID.length()> 0 &&  isHidden.length()> 1 && linkURL.length()> 1)//verify
					{
																	
						if(!isInteger(parentID))// if parentID == NULL
							parentID = parentID.toUpperCase();
							
							
						if(parentID.equals("NULL")  &&  isHidden.equals("FALSE")&& n2 == 1) // level 1 parents
						{
							Node node = new Node(". " + menuName,ID,0,linkURL);														
							listNodes.add(node);
				
							tree.addParent(node);
							
						}
							
													
						
						else if(isInteger(parentID) && isHidden.equals("FALSE")) //deeper levels
						{
								
							int parent_ID = Integer.parseInt(row[2]);
							String value = ".";
							
							while( n2 > 1 )
							{
								value += "...";
								n2--;
						
							}
														
							listNodes.add(new Node(value + " " + menuName,ID,parent_ID,linkURL));
											
					     }
				     }

			      }
			}//end for loop
			
		
			
			//display(listNodes);
			
			
			Collections.sort(listNodes, new Comparator<Node>(){
				public int compare(Node o1, Node o2) {
				
				return o1.getLinkUrL().compareTo(o2.getLinkUrL());
			}
				
			});
			
			//System.out.println("---------");				
		
			//display(listNodes);
			
			
			
			for (int i = 0; i < listNodes.size(); i++) {
				
				if(listNodes.get(i).ID != 0)//if child
				{
					Node parent = tree.find_parentNode(listNodes, listNodes.get(i).getParentID());
		            tree.addTreeNode(parent, listNodes.get(i));
				}
	         
	        }
			
			
			
			
	        tree.preorder(tree.root);
		
			
			
			
		}//end try block
					
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

	}

		
	}
	
	

