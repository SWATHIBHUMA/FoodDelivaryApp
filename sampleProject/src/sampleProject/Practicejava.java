package sampleProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;

class Person{
	static String name;
	public Person(String name){
		this.name = name;
	}
}
public class Practicejava{
	
	public static void change(Person p) {
		p.name = "swetha";
	}
	
	public static void main(String[] args) throws IOException {
		
		Person p = new Person("Swathi");
		
		System.out.println(p.name);
		
		Practicejava.change(p);
		
		System.out.println(p.name);
	}	
}












































	//Largest repeating element in array
	//[1,2,3,4,5]
	//	Unique elements count
	//substring count
	//tapacademy
	//lps	
		
		
		
		
		
		
		
//int n = sc.nextInt();
//int[] arr=new int[n];
//for (int i = 0; i < arr.length; i++) {
//	arr[i]=sc.nextInt();
//}
//if(n==1) {
//	System.out.println(arr[0]);
//	System.exit(0);
//}
//int c=1, mc=0,res=-1;
//for(int i=0;i<arr.length-1;i++) {
//	if(arr[i]==arr[i+1]) {
//		c++;
//		
//	}
//	else if(c>=mc){
//		res=arr[i];
//		mc=c;
//		c=1;
//	}
//}
//if(c>1 && mc<=c) {
//	System.out.println(arr[n-1]);
//}
//else {
//	System.out.println(res);
//}
//
		
//		String s = "SWATHIswathi";
//		Character[] arr = new Character[s.length()];
//		for(int i=0;i<s.length();i++) {
//			arr[i] = s.charAt(i);
//		}
//		Arrays.sort(arr, new Comparator<Character>(){
//			public int compare(Character ch1, Character ch2) {
//				return Character.compare(Character.toLowerCase(ch1), Character.toLowerCase(ch2));
//			}
//		});
//		StringBuilder sb = new StringBuilder();
//		for(char ch:arr) {
//			sb.append(ch);
//		}
//		System.out.println(sb);
//		String s = "SWATHIswathi";
//		Character[] arr = new Character[s.length()];
//		for(int i=0;i<s.length();i++) {
//			arr[i] = s.charAt(i);
//		}
//		Arrays.sort(arr, new Comparator<Character>(){
//			public int compare(Character ch1, Character ch2) {
//				return Character.compare(Character.toLowerCase(ch1), Character.toLowerCase(ch2));
//			}
//		});
//		StringBuilder sb = new StringBuilder();
//		for(char ch:arr) {
//			sb.append(ch);
//		}
//		System.out.println(sb);

		
		
		
		
		
		
		
		
		
//static Scanner scanner = new Scanner(System.in);
//public static void insertData(Map<Integer, String> map){
//	System.out.println("Enter Student Id: ");
//	int id = scanner.nextInt();
//	System.out.println("Enter Student Name: ");
//	String name = scanner.next();
//	
//	Student s1 = new Student(id,name);
//	map.put(id,name);
////	if(s1.getStudentId()>25) {
////		if(s1.getStudentName().charAt(0) == 'A') {
////			System.out.println(s1.toString());
////		}
////		
////	}
//	
//	
//	
//}
//public static void main(String[] args) {
//	
//	System.out.println("Enter no of entries");
//	int n = scanner.nextInt();
//	for (int i = 0; i < n; i++) {
//		Map<Integer, String> map = new TreeMap<>();
//		Practicejava.insertData(map);
//	}
//	
//	
//}
//}
//
//class Student{
//int studentId;
//String studentName;
//public int getStudentId() {
//	return studentId;
//}
//public void setStudentId(int studentId) {
//	this.studentId = studentId;
//}
//public String getStudentName() {
//	return studentName;
//}
//public void setStudentName(String studentName) {
//	this.studentName = studentName;
//}
//public Student(int studentId, String studentName) {
//    this.studentId = studentId;
//    this.studentName = studentName;
//}
//@Override
//public String toString() {
//	return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
//}


//void display() {
//    System.out.println("Child's display method in main");
//}
//    public static void main(String[] args) {
//    	final Child parentReference = new Practicejava();
//        parentReference.display();
//    }
		
//		int curr_sum = 0, st=0,end=-1, mi=0,mj=8;
//		
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < arr.length; i++) {
//			
//			curr_sum+=arr[i];
//			//	Base Case
//			if(curr_sum-s==0) {
//				st=0;
//				end=i;
//				if(end-st+1<mj-mi) {
//					mi=st;
//					mj=end;
//				}
//			}
//			
//			if (map.containsKey(curr_sum-s)) {
//				st=map.get(curr_sum-s)+1;
//				end=i;
//				if(end-st+1<mj-mi) {
//					mi=st;
//					mj=end;
//				}
//			}
//			
//			map.put(curr_sum, i);
//			
//		}
//		
//		if(end==-1) {
//			System.out.println("Not Found");
//		}
//		else {
//			for (int i = mi; i <= mj; i++) {
//				System.out.print(arr[i]+" ");
//			}
//		}
		
		//int total = 0;
//		int c = 0;
//		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
//		
//		for (int windowSize = 2; windowSize <= arr.length; windowSize += 2) {
//			
//			int windowSum = 0;
//			for (int i = 0; i < windowSize; i++)
//				//windowSum += arr[i];
//				hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
//			//total += windowSum;
//			//check keys of hashmap
//			if(hm.get(0) == hm.get(1)) {
//				c+=1;
//			}
//			hm.clear();
//			for (int i = 1; i + windowSize <= arr.length; i++) {
//				windowSum = windowSum - arr[i - 1] + arr[i + windowSize - 1];
//				//total += windowSum;
//				hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
//			}
//			if(hm.get(0) == hm.get(1)) {
//				c+=1;
//			}
//			hm.clear();
//		}
//		System.out.println(c)

