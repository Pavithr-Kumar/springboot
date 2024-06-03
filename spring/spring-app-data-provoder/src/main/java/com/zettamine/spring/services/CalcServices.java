package com.zettamine.spring.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zettamine.spring.dao.DataProvider;
@Service
public class CalcServices {
	@Autowired
	@Qualifier("data2")
	private DataProvider dataProvider;
	
	public int findMax() {
		return Arrays.stream(dataProvider.getData()).max().getAsInt();
		
	}
	
	

}
