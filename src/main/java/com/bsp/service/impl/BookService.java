package com.bsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsp.dao.IBookDAO;
import com.bsp.service.IBookService;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookDAO bookDao;

	public void setBookDao(IBookDAO bookDao) {
		this.bookDao = bookDao;
	}
	
}
