package com.zettamine.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("data2")
public class DataProvider2 implements DataProvider {

	@Override
	public int[] getData() {
		
		return new int[] {1,2,3,4,5,6,7};
	}

}
