//HEAP DATA STRUCTURE
import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int key;
    Node left;
    Node right;

    Node()
    {
        key = 0;
        left = null;
        right = null;
    }

    Node(int value)
    {
        key = value;
        left = null;
        right = null;
    }
}

class Heap
{
    static Node createHeap(int[] arr)
    {
        Node root = new Node(arr[0]);
        int i = 1;    //ITERATOR FOR ARRAY
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node temp;
        while (!queue.isEmpty() && i < arr.length)
        {
            temp = queue.peek();
            if (temp.left == null)
            {
                temp.left = new Node(arr[i]);
                queue.add(temp.left);
                i++;
            }
            else if (temp.right == null)
            {
                temp.right = new Node(arr[i]);
                queue.add(temp.right);
                i++;
            }
            if (temp.left != null && temp.right != null)
            {
                queue.remove();
            }
        }
        System.out.println("Heap Created");
        return root;
    }

    static void inOrder(Node hrf)
    {
        if (hrf == null)
            return;
        printTree(hrf.left);
        System.out.print(hrf.key + " ");
        printTree(hrf.right);
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 9, 8, 7, 6, 5, 4};
        Node root = createHeap(arr);
        inOrder(root);
    }
}