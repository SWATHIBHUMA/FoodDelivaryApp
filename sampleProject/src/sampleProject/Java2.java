package sampleProject;

import java.util.Scanner;

public class Java2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int c=1,mc=0,s=0,mi=0,mj=0;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]<=arr[i+1]) {
				c++;
			}
			else if(c>=mc) {
				mc=c;
				c=1;
				if(i-s+1>mj-mi) {
					mi=s;
					mj=i;
				}
				s=i+1;
			}
		}
		if(c>1 && c>mc) {
			for (int i = s; i < arr.length; i++) {
				System.out.println(arr[i]+" ");
			}
		}
		else {
			for (int i = mi; i <= mj; i++) {
				System.out.println(arr[i]+" ");
				
			}
		}
	}
}