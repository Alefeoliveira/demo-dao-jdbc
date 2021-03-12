package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1 : Seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("==== TEST 2 : Seller sellerFindByDepartment ====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findDepartment(department);
		
		for(Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("==== TEST 3 : Seller sellerFindByAll ====");
		
		list = sellerDao.findAll();
		for(Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("==== TEST 4 : Seller sellerInsert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("inserted! new id ="+newSeller.getId());
		
		System.out.println("==== TEST 5 : Seller sellerUpdate ====");
		seller = sellerDao.findById(1);
		seller.setName("martha waine");
		sellerDao.update(seller);
		System.out.println("update completed");
	}

}
