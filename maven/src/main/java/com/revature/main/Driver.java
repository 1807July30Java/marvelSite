package com.revature.main;

import com.revature.dao.HeroDAO;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HeroDAO test= new HeroDAO();
		System.out.println(test.getHeros());
	}

}
