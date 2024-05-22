import java.util.Arrays;

/**************************************************
Problem Set: Problem Set 1: UA Sort and Merge
Name: Brandon Evans
Date: 9/1/23
**************************************************/

public class UASortAndMerge {

	public static int inv;
	
	public static void main(String[] args) {
		
		int[] num = {1,5,7,3,5,8,10,2};
		
		UASortAndMerge a = new UASortAndMerge();
		
		a.MergeSort(num, 0, num.length-1, 2);
		//System.out.println(Arrays.toString(num));
	}
	
	
	public void Merge(int [] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int L[] = new int[n1+1];
		int R[] = new int[n2+1];
		
		for(int i = 0; i<n1;i++) {
			L[i] = A[p + i];
		}
		
		for(int j = 0; j<n2; j++) {
			R[j] = A[q + 1 + j];
		}
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		
		for(int k = p; k<=r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}
		}
	}
	
	public void MergeSort(int [] A, int p, int r, int h) {
			if(p < h) {
				int q = (int) Math.floor((p+r)/2);
				
				System.out.printf("%15s %n", "Array=" + Arrays.toString(A));
				
				InsertionSort(A, p, q);
				
				System.out.print("Ins Sort:  " + "[p=" + p +", r=" + r +", Inv=" + inv +"]  ");
				
				InsertionSort(A, q + 1, r);
				
				
				System.out.printf("%15s %n", "Finish=" + Arrays.toString(A));
				
				Merge(A,p,q,r);
			}
			
		}
	
	public void InsertionSort(int [] A, int p, int r) {
		for(int j = 1; j<A.length; j++) {
			int key = A[j];
			
			 inv = 0;
			
			int i = j - 1;
			
			while(i > 0 && A[i] > key) {
				inv++;
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
	}
	
	}
