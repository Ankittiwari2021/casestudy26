package com.gl.casestudy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {
	 public static Double totalCalculation (Applicant applicant) {
		 Double marks1=applicant.getSubject1Mark();
		 Double marks2=applicant.getsubject2Mark();
		 Double marks3=applicant.getSubject3Mark();
		 if (marks1<50 || marks2<50 || marks3<50) {
			 return 0.0;
		 }
		 else {
			 Double total=marks1+marks2+marks3;
			 return total;
		 }
	 }
	 
	 public static Double percentageCalculation (Double total) {
		 Double per= (total/300)*100;
		 DecimalFormat df = new DecimalFormat("0.0");
		 String persentage=df.format(per);
		 return Double.parseDouble(persentage) ;
	 }
	public static void main(String[] args) {
		Integer id=100;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the applicants:");
		System.out.println("===================:");
		Integer n=Integer.parseInt(sc.nextLine());
		List<Applicant> applicantList=new ArrayList<Applicant>();
		for (int i=0;i<n;i++)
		{
			System.out.println("Enter the applicant details");
			String str=sc.nextLine();
			String[] arr = str.split(",");
			String name=arr[0];
			Double marksubject1=Double.parseDouble(arr[1]);
			Double marksubject2=Double.parseDouble(arr[2]);
			Double marksubject3=Double.parseDouble(arr[3]);
			try {
				if(marksubject1>100 || marksubject1<0 || marksubject2>100 || marksubject2<0 || marksubject3>100 || marksubject3<0 ) {
					throw new MarksException("\nInvalid marks; should be between 0 and 100\n");
				}
			}
			catch (MarksException e) {
				System.out.println(e.getMessage());
				continue;
			}
			Applicant a=new Applicant(name,marksubject1,marksubject2,marksubject3,0.0,0.0);
			a.setId(++id);
			Double total=totalCalculation(a);
			Double percentage=percentageCalculation(total);
			a.setTotal(total);
			if (total==0.0)
				continue;
			a.setPercentage(percentage);
			applicantList.add(a);
	}
		System.out.println("Output format");
		applicantList.forEach((applicant)->System.out.println(applicant));
		

}
}