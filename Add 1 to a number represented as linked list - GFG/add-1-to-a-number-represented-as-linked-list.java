//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head)
    {
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    // 9 9 9
    public static Node addOne(Node head) 
    { 
        Node curr=reverse(head);
        int carry=0;
        int sum;
        int c=0;
        Node res=new Node(0);
        Node ans=res;
        while(curr!=null||carry==1)
        {
            sum=0;
            if(c==0&&curr!=null)
            {
                sum=curr.data+1;
                curr=curr.next;
                c++;
            }
            else if(curr!=null)
            {
                sum=curr.data;
                curr=curr.next;
            }
            sum=sum+carry;
            carry=sum/10;
            Node t=new Node(sum%10);
            res.next=t;
            res=res.next;
        }
        return reverse(ans.next);
    }
}
