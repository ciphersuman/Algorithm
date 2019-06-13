import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<CompositeNode> q = new LinkedList<CompositeNode>();
        
        CompositeNode m = new CompositeNode(root,0,1);
        
        
        
        TreeMap<Integer,TreeSet<CompositeNode>> hm = new TreeMap<Integer,TreeSet<CompositeNode>>();
        
         q.add(m);
        
        useRecursion(q,hm);
        
        
        List <List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(Entry<Integer, TreeSet<CompositeNode>> entry : hm.entrySet())
        {
            
            TreeSet<CompositeNode> c = entry.getValue();
            List<Integer> temp = new ArrayList<Integer>();
            for(CompositeNode cn: c )
                
                temp.add(cn.node.val);
            
            
            result.add(temp);
        }
        
        return result;
        
    }
    
    
    public void useRecursion(Queue<CompositeNode> q, TreeMap<Integer,TreeSet<CompositeNode>> hm)
    {
        if(q.isEmpty())
            return;
        
        while(!q.isEmpty())
        {
            CompositeNode c = q.poll();
            if(hm.containsKey(c.val))
            {
                TreeSet<CompositeNode> l = hm.get(c.val);
                l.add(c);
                hm.put(c.val,l);
                
            }
            else
            {
                TreeSet<CompositeNode> l  = new TreeSet<CompositeNode> (new MyComparator());
                l.add(c);
                hm.put(c.val,l);
                
                
            }
            if(c.node.left!=null)
            {
            TreeNode left = c.node.left;
            CompositeNode compositeLeft = new CompositeNode(left,c.val-1,c.level+1);
            q.add(compositeLeft);
            }
            
            if(c.node.right!=null)
            {
            TreeNode right = c.node.right;
            
            CompositeNode compositeRight = new CompositeNode(right,c.val+1,c.level+1);
            
            
            q.add(compositeRight);
                
            }
            
            
            
        }
        
        useRecursion(q,hm);
        
        
        
    }
    
}