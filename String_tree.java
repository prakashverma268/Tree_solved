public class String_tree {
    static class Tree
	{
	    int data;
	    Tree left, right;
	};
	static String str;
	 
	
	static Tree newNode(int data)
	{
	    Tree n = new Tree();
	    n.data = data;
	    n.left = n.right = null;
	    return (n);
	}
	 
	
	static void treeToString(Tree root)
	{

	    if (root == null)
	        return;
	 
	    
	    str += (Character.valueOf((char)
	           (root.data + '0')));
	 
	
	    if (root.left == null && root.right == null)
	        return;
	 
	    
	    str += ('(');
	    treeToString(root.left);
	    str += (')');
	 
	    if (root.right != null)
	    {
	        str += ('(');
	        treeToString(root.right);
	        str += (')');
	    }
	}
	 
	
	public static void main(String[] args)
	{
	    
	    Tree root = newNode(1);
	    root.left = newNode(2);
	    root.right = newNode(3);
	    root.left.left = newNode(4);
	    root.left.right = newNode(5);
	    root.right.right = newNode(6);
	    str = "";
	    treeToString(root);
	    System.out.println(str);
	}
	
}
