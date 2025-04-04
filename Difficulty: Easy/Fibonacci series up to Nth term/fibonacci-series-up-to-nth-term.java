//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public void find(int arr[] , int n , int m , int j)
    {
        if(n < 2) return ;
        arr[j] = (int) ((arr[j-1] + arr[j-2]) % m);
        find(arr , n-1, m ,j+1);
    }
    int[] Series(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int m = 1000000007;
        find(arr , n , m , 2);
        
        return arr;
    }
}