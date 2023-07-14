package com.pms.service;

import java.util.List;
import com.pms.dao.ProductDAO;
import com.pms.pojo.Product;

public class ProductServiceImp implements IProductService {
	private	ProductDAO  dao = new ProductDAO();
	@Override
	public int addPro(Product pro) {
		
		return dao.addPro(pro);
	}

	@Override
	public int updatePro(Product pro) {
		
		return dao.updatePro(pro);
	}

	@Override
	public int deleteProById(int pid) {
		
		return dao.deleteProById(pid);
	}

	@Override
	public Product getProById(int pid) {
		
		return dao.getProById(pid) ;
	}

	@Override
	public List<Product> getAll() {
		
		return dao.getAll();
	}
	public static boolean dataInputValidation(Product pro) {
		boolean flag = false ;
		if(pro.getPid() > 9
				&& pro.getPname().length() >= 4
				&& pro.getPrice() > 2
				&& pro.getDom() != null) {
			flag = true;
			
		}
		return flag ;
	}

}
