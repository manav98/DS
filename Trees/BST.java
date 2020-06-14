class Node
{
    int key;
    Node parent;
    Node left;
    Node right;

    Node(int value)
    {
        key = value;
        left = right = null;
    }
}

public class BST
{
    Node root;

    BST()
    {
        root = null;
    }

    void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    Node findMinRecursive(Node root)
    {
        if (root.left == null)
        {
            return root;
        }
        return (findMinRecursive(root.left));
    }

    Node findMinIterative(Node root)
    {
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    Node findMax(Node root)
    {
        while (root.right != null)
        {
            root = root.right;
        }
        return root;
    }

    Node insertNode(Node root, int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            if (value == root.key)
            {
                return root;
            }
            else if (value < root.key)
            {
                if (root.left == null)
                {
                    root.left = new Node(value);
                    root.left.parent = root;
                }
                else
                {
                    insertNode(root.left, value);
                }
            }
            else
            {
                if (root.right == null)
                {
                    root.right = new Node(value);
                    root.right.parent = root;
                }
                else
                {
                    insertNode(root.right, value);
                }
            }
        }
        return root;
    }

    Node findNode(Node root, int value)
    {
        if (root == null)
        {
            return root;
        }
        if (root.key == value)
        {
            return root;
        }
        if (value < root.key)
        {
            return (findNode(root.left, value));
        }
        else
        {
            return (findNode(root.right, value));
        }
    }

    Node findSucessor(Node root, int value)
    {
        Node sucessor;
        Node curr = findNode(root, value);
        if (curr.right != null)
        {
            return (findMinIterative(curr.right));
        }
        sucessor = curr.parent;
        while (sucessor != null && sucessor.right == curr)
        {
            curr = sucessor;
            sucessor = curr.parent;
        }
        return sucessor;
    }

    Node findPredecessor(Node root, int value)
    {
        Node t;
        Node curr = findNode(root, value);
        if (curr.left != null)
        {
            return findMax(curr.left);
        }
        t = curr.parent;
        while (t != null && t.left == curr)
        {
            curr = t;
            t = curr.parent;
        }
        return t;
    }

    Node deleteNode(Node root, int value)
    {
        if (root == null)
        {
            return root;
        }
        Node curr = findNode(root, value);
        if (curr.left == null && curr.right == null)
        {
            if (curr.parent.left == curr)
            {
                curr.parent.left = null;
            }
            else
            {
                curr.parent.right = null;
            }
        }
        else if (curr.left == null && curr.right != null)
        {
            if (curr.parent.left == curr)
            {
                curr.parent.left = curr.right;
            }
            else
            {
                curr.parent.right = curr.right;
            }
        }
        else if (curr.left != null && curr.right == null)
        {
            if (curr.parent.right == curr)
            {
                curr.parent.right = curr.left;
            }
            else
            {
                curr.parent.left = curr.left;
            }
        }
        else
        {
            Node prev = findPredecessor(root, curr.key);
            curr.key = prev.key;
            deleteNode(curr.left, prev.key);
        }
        return root;
    }

    public static void main(String[] args)
    {
        BST tree = new BST();
        tree.root = tree.insertNode(tree.root, 52);
        tree.root = tree.insertNode(tree.root, 37);
        tree.root = tree.insertNode(tree.root, 74);
        tree.root = tree.insertNode(tree.root, 65);
        tree.root = tree.insertNode(tree.root, 16);
        tree.root = tree.insertNode(tree.root, 44);
        tree.root = tree.insertNode(tree.root, 28);
        tree.root = tree.insertNode(tree.root, 21);
        tree.root = tree.insertNode(tree.root, 91);
        tree.root = tree.insertNode(tree.root, 83);
        tree.inOrder(tree.root);
        System.out.println("Minimum element is: " + tree.findMinRecursive(tree.root).key);
        System.out.println("Maximum element is: " + tree.findMax(tree.root).key);
        int value = 52;
        System.out.println("Value exists? " + tree.findNode(tree.root, value));
        value = 21;
        System.out.println("Previous element of " + value + " is: " + tree.findPredecessor(tree.root, value).key);
        System.out.println("Next element of" + value + " is: " + tree.findSucessor(tree.root, value).key);
        System.out.println("\n\n\n\n\n\n");
        tree.root = tree.deleteNode(tree.root, 37);
        tree.inOrder(tree.root);
    }
}