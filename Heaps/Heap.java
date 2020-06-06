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
    static Node heapify(Node hrf)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;

        while(!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            if(temp.key < temp.left.key || temp.key < temp.right.key)
            {
                if(temp.right == null)
                {
                    int swap = temp.left.key;
                    temp.left.key = temp.key;
                    temp.key = swap;
                }
                else
                {
                    Node larger = temp.left.key > temp.right.key ? temp.left.key : temp.right.key;
                    int swap = larger.key;
                    larger.key = temp.key;
                    temp.key = swap;
                }
            }
            q.add(temp.left);
            q.add(temp.right);
        }
        return hrf;
    }
    static Node insertNode(Node root, int value)
    {
        boolean isNodeInserted = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while(!q.isEmpty() && !isNodeInserted)
        {
            temp = q.peek();
            q.remove();
            if(temp.left == null && !isNodeInserted)
            {
                temp.left = new Node(value);
                isNodeInserted = true;
            }
            else
            {
                q.add(temp.left);
            }
            if(temp.right == null && !isNodeInserted)
            {
                temp.right = new Node(value);
                isNodeInserted = true;
            }
            else
            {
                q.add(temp.right);
            }
        }
        root = heapify(root);
        return root;
    }
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
        inOrder(hrf.left);
        System.out.print(hrf.key + " ");
        inOrder(hrf.right);
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 9, 8, 7, 6, 5, 4};
        Node root = createHeap(arr);
        inOrder(root);
        root = insertNode(root, 11);
        System.out.println();
        inOrder(root);
    }
}