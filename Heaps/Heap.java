//https://www.youtube.com/watch?v=t0Cq6tVNRBA
//MIN-HEAP DATA STRUCTURE

import java.util.Arrays;

class Heap
{
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];

    private void addItem(int item)
    {
        items[size] = item;
        size++;
        heapifyUp();
    }

    private int getLeftChild(int parentIndex)
    {
        return 2*parentIndex + 1;
    }

    private int getRightChild(int parentIndex)
    {
        return 2*parentIndex + 2;
    }

    private int getParentIndex(int childIndex)
    {
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index)
    {
        return 2*index+1 < size ;
    }

    private boolean hasRightChild(int index)
    {
        return 2*index +2 < size;
    }

    private boolean hasParent(int index)
    {
        return (index-1)/2 >=0;
    }

    private int leftChild(int index)
    {
        return items[getLeftChild(index)];
    }
    private int rightChild(int index)
    {
        return items[getRightChild(index)];
    }
    private int parent(int index)
    {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo)
    {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity()
    {
        if(size == capacity)
        {
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }

    public int peek()
    {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int pull()
    {
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item)
    {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp()
    {
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index])
        {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown()
    {
        int index = 0;
        while(hasLeftChild(index))
        {
            int smallerChildIndex = getLeftChild(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index))
            {
                smallerChildIndex = rightChild(index);
            }
            if(items[index] > items[smallerChildIndex])
            {
                swap(index, smallerChildIndex);
            }
            else
            {
                break;
            }
            index = smallerChildIndex;
        }
    }

    public static void main(String[] args)
    {
        Heap root = new Heap();
        for(int i=0;i< 7;i++)
        {
            root.addItem(i*10);
        }
        System.out.println(Arrays.toString(root.items));
        root.addItem(1);
        System.out.println(Arrays.toString(root.items));
    }
}