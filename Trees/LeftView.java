class LeftView
{
    static int max_level = 0;

    private void leftViewUtil(Node root, int level)
    {
        if (root == null)
        {
            return;
        }

        if (max_level < level)
        {
            System.out.println(root.key + " ");
            max_level = level;
        }
        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }

    private void rightViewUtil(Node root, int level)
    {
        if (root == null)
            return;
        if (max_level < level)
        {
            System.out.print(root.key + " ");
            max_level = level;
        }
        rightViewUtil(root.right, level + 1);
        rightViewUtil(root.right, level + 1);
    }

    private void leftView(Node root)
    {
        leftViewUtil(root, 1);
    }

    private void rightView(Node root)
    {
        rightViewUtil(root, 1);
    }

    public static void main(String[] args)
    {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        LeftView lf = new LeftView();
        //lf.leftView(root); 
        lf.rightView(root);
    }
}
