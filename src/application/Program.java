package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("TEST 1: FIND SELLER BY ID");
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
		System.out.println("\nTEST 2: FIND SELLER BY DEPARTMENT");
		Department dep = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTEST 3: FIND ALL SELLERS");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTEST 4: INSERT SELLER");
		Seller newSeller = new Seller(null, "Pedro Melo", "pedro@gmail.com", sdf.parse("05/10/1999"), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\nTEST 5: UPDATE SELLER");
		seller = sellerDao.findById(6);
		seller.setName("Severina Deodata");
		seller.setEmail("severina@gmail.com");
		seller.setBirthDate(sdf.parse("20/06/1952"));
		seller.setBaseSalary(5350.0);
		seller.setDepartment(dep);
		sellerDao.update(seller);
		System.out.println("Updated!");
	}

}
