package com.example.jxls.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.jxls.common.Report;
import com.example.jxls.dao.CommonDao;

public class CommonService {

	private CommonDao dao;

	public CommonService() {
		dao = new CommonDao();
	}

	private void createCommonClientReport(String templateName, String outputName) throws FileNotFoundException {
		Report report = new Report();

		OutputStream outStream = new FileOutputStream(outputName);

		Map<String, Object> data = new HashMap<>();
		data.put("createdAt", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		data.put("clients", dao.getAllClients());

		report.createDocument(outStream, templateName, data);
	}

	public void createClientReport() throws FileNotFoundException {
		createCommonClientReport("clientsTemplate", "target/clients.xls");
	}

	public void createClientReportWithConditions() throws FileNotFoundException {
		createCommonClientReport("clientsMarkInactiveTemplate", "target/clientsMarkInactive.xls");
	}
}
