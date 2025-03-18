//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0; 
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1])
                    curr[j] = prev[j];
                else
                    curr[j] = (prev[j] || prev[j - arr[i - 1]]);
            }
            for (int j=0; j<=sum; j++) {
                prev[j] = curr[j];
            }
        }
        return prev[sum];
    }
}