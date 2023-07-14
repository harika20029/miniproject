package com.pms.service;

import java.util.List;

import com.pms.pojo.Product;

public interface IProductService {
	public int addPro(Product pro);
	public int updatePro(Product pro);
	public int deleteProById(int pro);
	public Product getProById(int pro);
	public List<Product> getAll();

}
