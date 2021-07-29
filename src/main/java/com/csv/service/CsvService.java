package com.csv.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.csv.model.Pessoa;

@Service
public class CsvService {
	
	public List<Pessoa> pessoas = this.getPessoas();

	public void generateCSVResponse(HttpServletResponse response) throws IOException {
		
		String filename = "pessoas.csv";
		List<Pessoa> pessoas = this.getPessoas();
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			response.setContentType("text/csv");
			response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
					"attachment; filename=\""+filename+"\"");
			CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),
					CSVFormat.DEFAULT.withHeader("Nome", "Telefone", "Email", "Data"));
			
			for(Pessoa p: pessoas) {
				csvPrinter.printRecord(Arrays.asList(p.getNome(), p.getTelefone(), p.getEmail(), format.format(p.getData())));
			}
			
			csvPrinter.close();
			
		} finally {
			/*if(csvPrinter != null) {
				
			}*/
		}
	}

	private List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		
		Pessoa p1 = new Pessoa("Joao X Z", "00 0000-0000", "joao@email.com", new Date(System.currentTimeMillis()));
		Pessoa p2 = new Pessoa("Maria X Z", "00 0000-0000", "maria@email.com", new Date());
		Pessoa p3 = new Pessoa("Jose X Z", "00 0000-0000", "jose@email.com", new Date());
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		return pessoas;
	}

}
