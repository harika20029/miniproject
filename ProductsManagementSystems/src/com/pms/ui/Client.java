package com.pms.ui;

import java.util.List;
import java.util.Scanner;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.pms.exception.ProductNotFoundException;
import com.pms.pojo.Product;
import com.pms.service.IProductService;
import com.pms.service.ProductServiceImp;
import com.pms.util.DBUtil;

public class Client {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		
		IProductService service  = new ProductServiceImp();
		
		while(flag) {
			
			System.out.println("Welcome to PMS");
			System.out.println("1.ADD Product");
			System.out.println("2.UPDATE Product");
			System.out.println("3.DELETE Product");
			System.out.println("4.SELECT Product");
			System.out.println("5.SELECT All");
			System.out.println("0.EXIT");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter product Id : ");
				int pid1 = sc.nextInt();
				System.out.println("Enter Product Name : ");
				String pname1 = sc.next();
				System.out.println("Enter Product Price : ");
				int price1 = sc.nextInt();
				System.out.println("Enter Product manufacturing date : ");
				String dom1 = sc.next();
				Date date = Date.valueOf(dom1);
				Product pro1 = new Product();
				
				pro1.setPid(pid1);
				pro1.setPname(pname1);
				pro1.setPrice(price1);
				pro1.setDom(dom1);
				
				boolean isValid = ProductServiceImp.dataInputValidation(pro1);
				
				if(isValid == true) {
					
					int count1 = service.addPro(pro1);
					System.out.println(count1 + "   record inserted");
				}
				else {
					System.err.println(" Invalid Input , please Enter Correct data");
				}
				break;
			case 2:
				System.out.println("Enter product Id. : ");
				int pid2 = sc.nextInt();
				System.out.println("Enter Product Name : ");
				String pname2 = sc.next();
				System.out.println("Enter Product Price : ");
				int price2 = sc.nextInt();
				System.out.println("Enter Product manufacturing date : ");
				String dom2 = sc.next();
				
				Product pro2 = new Product();
				
				pro2.setPid(pid2);
				pro2.setPname(pname2);
				pro2.setPrice(price2);
				pro2.setDom(dom2);
				
				boolean isValid1 = ProductServiceImp.dataInputValidation(pro2);
				if(isValid1 == true) {
					int count2 = service.updatePro(pro2);
					System.out.println(count2 + "   record updated");
				}
				else {
					System.err.println(" Invalid Input , please Enter Correct data");
				}
				break;	
			case 3:
				System.out.println("Enter Pid to delete one record");
				int pid3 = sc.nextInt();
				int count3 = service.deleteProById(pid3);
				System.out.println(count3 +" record deleted");
				if(count3 == 0) {
					try {
						throw new ProductNotFoundException(); 
					}
					catch(Exception e) {
						System.err.println("pid not found , can't delete record");
					}
				}
				break;
			case 4:
				System.out.println("Enter Pid to select record");
				int pid4 = sc.nextInt();
				Product proObj = service.getProById(pid4);
				System.out.println(proObj);
				if(proObj == null) {
					try {
						throw new ProductNotFoundException(); 
					}
					catch(Exception e) {
							System.err.println("pid not found , can't search record");
					}
				}	
				break;
			case 5:
				List<Product> list=  service.getAll();
				for (Product product : list) {
					System.out.println(product);
				}
				break;
			case 0:
				flag = false;
				DBUtil.closeConncetion();
				System.out.println("Thank you vist again");
				break;		
			default:
				System.err.println("Invalid Option");
				break;
			}
		}
	}

}