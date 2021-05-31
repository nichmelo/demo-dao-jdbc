package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("TEST 1: FIND DEPARTMENT BY ID");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\nTEST 2: FIND ALL DEPARTMENTS");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		/*System.out.println("\nTEST 3: INSERT DEPARTMENT");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());*/
		
		System.out.println("\nTEST 4: UPDATE DEPARTMENT");
		dep = departmentDao.findById(8);
		dep.setName("Music");
		departmentDao.update(dep);
		System.out.println("Updated!");
		

		System.out.println("\nTEST 3: DELETE DEPARTMENT");
		System.out.print("Enter department id to delete: ");
		int id = sc.nextInt();
		departmentDao.delete(id);
		System.out.println("Deleted!");
		
		sc.close();
	}

}
