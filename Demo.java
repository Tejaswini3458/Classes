package com.testpakage.test;
class Employee
{
	 int eid;
     String ename;
     String eaddr;
     float esal;
     
	void setData(int eid,String ename,String eaddr,float esal)
	{
     this.eid=eid;
     this.ename=ename;
     this.eaddr=eaddr;
     this.esal=esal;
	}
	void getData()
	{
		System.out.println("----Employee Details----");
		System.out.println("--------------------------");
		System.out.println("Employee EID :"+ eid);
		System.out.println("Employee Name :"+ename);
		System.out.println("Employee Address :"+eaddr);
		System.out.println("Employee salary  :"+esal);
	}
	
}	
public class Demo {

	public static void main(String[] args) {
		Employee emp = new Employee();
 		emp.setData(10, "Ram", "Nagpur", 40000);
	    emp.getData();
      
     }

}

