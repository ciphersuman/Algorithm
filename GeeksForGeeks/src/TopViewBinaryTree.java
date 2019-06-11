import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class TopViewBinaryTree {
	
	public static void main(String args[])
	{
		 HashMap<Integer,TreeNode> hm = new HashMap<Integer,TreeNode> ();
		 
		// topViewBnr(node.left, val-1, m);
		 
		TreeMap<Integer,List<TreeNode>> hm1 = new TreeMap<Integer,List<TreeNode>>();
		
		Set<Integer> s= hm.keySet();
		
		
		Iterator<Integer> it = s.iterator();
		
		while(it.hasNext())
		{
			int item = it.next();
			
			TreeNode tempnode=hm.get(item);
			
			int absckey = Math.abs(item);
			
			if(!hm1.containsKey(absckey))
			{
				
				ArrayList<TreeNode> l = new ArrayList<TreeNode>();
				l.add(tempnode);
				
				hm1.put(absckey, l);
			}
			else
			{
				List<TreeNode> l=hm1.get(absckey);
				l.add(tempnode);
				hm1.put(absckey, l);
			}
			
			
		}
		
		
		Set<Integer> s2 = hm1.keySet();
		Iterator<Integer>  it2 =s2.iterator();
		while(it2.hasNext())
		{
			int ii= it2.next();
			
			List l = hm1.get(ii);
			
			Iterator<TreeNode> it3 = l.iterator();
			
			while(it3.hasNext());
			{
				TreeNode node =it3.next();
				
				
				System.out.println(node.key+" ");
			}
			
			
			
		}
		
		
		 
	}
	
	
	
	 
	
	
	
	public static void topViewBnr(TreeNode node, int val,HashMap<Integer,TreeNode>m)
	{
		
		if(!m.containsKey(val))
			m.put(val, node);
		
		topViewBnr(node.left, val-1, m);
		topViewBnr(node.right, val+1, m);
		
	}
	
	 public static TreeNode stringToTreeNode(String input) {
	        input = input.trim();
	        input = input.substring(1, input.length() - 1);
	        if (input.length() == 0) {
	            return null;
	        }
	    
	        String[] parts = input.split(",");
	        String item = parts[0];
	        TreeNode root = new TreeNode(Integer.parseInt(item));
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);
	    
	        int index = 1;
	        while(!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int leftNumber = Integer.parseInt(item);
	                node.left = new TreeNode(leftNumber);
	                nodeQueue.add(node.left);
	            }
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int rightNumber = Integer.parseInt(item);
	                node.right = new TreeNode(rightNumber);
	                nodeQueue.add(node.right);
	            }
	        }
	        return root;
	    }

	
	
	
	
}



class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}
