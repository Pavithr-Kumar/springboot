package com.zettamine.spring.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("data1")
@Primary
public class DataProvider1 implements DataProvider {

	@Override
	public int[] getData() {
		
		return new int[] {11,22,23,41,5,26,7};
	}

}
