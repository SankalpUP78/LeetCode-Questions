//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        while(curr!=null)
        {
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        Node res=new Node(0);
        Node ans=res;
        Node curr1=reverse(first);
        Node curr2=reverse(second);
        int sum=0;
        int carry=0;
        while(curr1!=null&&curr2!=null)
        {
            sum=curr1.data+curr2.data;
            sum=sum+carry;
            carry=sum/10;
            Node t=new Node(sum%10);
            res.next=t;
            res=res.next;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        while(curr1!=null)
        {
            sum=curr1.data+carry;
            carry=sum/10;
            Node t=new Node(sum%10);
            res.next=t;
            res=res.next;
            curr1=curr1.next;
        }
         while(curr2!=null)
        {
            sum=curr2.data+carry;
            carry=sum/10;
            Node t=new Node(sum%10);
            res.next=t;
            res=res.next;
            curr2=curr2.next;
        }
        if(carry!=0)
        {
            Node t=new Node(carry);
            res.next=t;
            res=res.next;
        }
        return reverse(ans.next);
    }
}