package com.example.jxls;

import java.io.FileNotFoundException;

import com.example.jxls.service.CommonService;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		CommonService service = new CommonService();
		
		service.createClientReport();
		
		service.createClientReportWithConditions();
	}

}
