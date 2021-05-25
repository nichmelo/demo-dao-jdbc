package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Department department = new Department(1, "Games");
		
		Seller seller = new Seller(21, "Nicholas", "nicholas@gmail.com", sdf.parse("22/02/1996"), 3500.0, department);
		
		System.out.println(seller);
	}

}
