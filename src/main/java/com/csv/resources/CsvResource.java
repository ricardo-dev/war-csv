package com.csv.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csv.service.CsvService;

@RestController
@RequestMapping("/csv")
public class CsvResource {
	
	@Autowired
	private CsvService csvService;
	
	@RequestMapping(value="/relatorio", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void gerarCsv(HttpServletResponse response) throws IOException {
		csvService.generateCSVResponse(response);
	}
}
