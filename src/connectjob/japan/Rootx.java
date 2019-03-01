package connectjob.japan;

import java.io.*;
import java.util.*;


public class Rootx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String[] tmp = br.readLine().split(" ");
         int N = Integer.parseInt(tmp[0]);
         int Q = Integer.parseInt(tmp[1]);
         
         String[] arr_Val = br.readLine().split(" ");
         int[] Val = new int[N + 1];
         for(int i_Val=0; i_Val<N; i_Val++)
         {
         	Val[i_Val + 1] = Integer.parseInt(arr_Val[i_Val]);
         }
         
         int[] u = new int[N-1];
         int[] v = new int[N-1];
         
         for(int i_u=0; i_u<N - 1; i_u++)
         {
            String[] tmp1 = br.readLine().split(" ");
         	u[i_u] = Integer.parseInt(tmp1[0]);
         	v[i_u] = Integer.parseInt(tmp1[1]);
         	
         }
         int[] V = new int[Q];
         int[] X = new int[Q];
         for(int i_V=0; i_V<Q; i_V++)
         {
            String[] tmp1 = br.readLine().split(" ");
         	V[i_V] = Integer.parseInt(tmp1[0]);
         	X[i_V] = Integer.parseInt(tmp1[1]);
         }

         int[] out_ = CountNodes(Val, v, N, Q, u, V, X);
         System.out.println(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         br.close();
    } 
    static int[] CountNodes(int[] Val, int[] v, int N, int Q, int[] u, int[] V, int[] X){
        int[] sumArr = new int[Q];
        for(int i=0;i<Q;i++){
            int edge = V[i];
            int vertex = X[i];
            
            sumArr[i] = getSum(v, u, Val, edge, vertex);
        }
        
        return sumArr;
    }
    
    static int getSum(int[] v, int[] u, int[] Val, int edge, int vertex){
        int cur = edge;
        int sum = 0;
        return sum(v, u, Val, cur, sum, vertex);
    }
    
    static int sum(int[] v, int[] u, int[] Val, int cur, int sum, int vertex){
        if(cur == 1){
        	if(Val[cur] <= vertex){
        		sum++;
        	}
            return sum;
        }
        
        for(int i=0;i<v.length; i++){
            if(cur == v[i]){
            	if(Val[cur] <= vertex){
            		sum++;
            	}
            	cur = u[i];
            	break;
            }
        }
        return sum(v, u, Val, cur, sum, vertex);
    }
   
}
