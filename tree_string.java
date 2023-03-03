import java.util.Stack;

public class tree_string {

	static class Tree
	  {
	    int data;
	    Tree left, right;
	  };
	 
	  
	  static Tree newTree(int data)
	  {
	    Tree t = new Tree();
	    t.data = data;
	    t.left = t.right = null;
	    return (t);
	  }
	 
	 
	  static void preOrder(Tree node)
	  {
	    if (node == null)
	      return;
	    System.out.printf("%d ", node.data);
	    preOrder(node.left);
	    preOrder(node.right);
	  }
	 
	  
	  static int findIndex(String str, int si, int ei)
	  {
	    if (si > ei)
	      return -1;
	 
	   
	    Stack<Character> s = new Stack<>();
	    for (int i = si; i <= ei; i++)
	    {
	 
	    
	      if (str.charAt(i) == '(')
	        s.add(str.charAt(i));
	 
	   
	      else if (str.charAt(i) == ')')
	      {
	        if (s.peek() == '(')
	        {
	          s.pop();
	 
	       
	          if (s.isEmpty())
	            return i;
	        }
	      }
	    }
	 
	  
	    return -1;
	  }
	 
	  
	  static Tree treeFromString(String str, int si, int ei)
	  {
	 
	   
	    if (si > ei)
	      return null;
	 
	    int num = 0;
	     
	      while(si <= ei && str.charAt(si) >= '0' && str.charAt(si) <= '9')
	    {
	      num *= 10;
	      num += (str.charAt(si) - '0');
	      si++;
	    }
	    si--;
	  
	    Tree root = newTree(num);
	    int index = -1;
	 
	   
	    if (si + 1 <= ei && str.charAt(si+1) == '(')
	      index = findIndex(str, si + 1, ei);
	 
	    if (index != -1)
	    {
	 
	    
	      root.left = treeFromString(str, si + 2, index - 1);
	 
	    
	      root.right
	        = treeFromString(str, index + 2, ei - 1);
	    }
	    return root;
	  }
	 
	
	  public static void main(String[] args)
	  {
	    String str = "4(2(3)(1))(6(5))";
	    Tree root = treeFromString(str, 0, str.length() - 1);
	    preOrder(root);
	  }
	
}
