package com.iTextdemo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iTextdemo.model.AccountStatement;
import com.iTextdemo.model.Customer;
import com.iTextdemo.pdfutil.PDFGenerator;
import com.iTextdemo.repository.AccountStatRepository;
import com.iTextdemo.repository.CustomerRepository;

@RestController
@RequestMapping("/rest/api")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired 
	AccountStatRepository accountStatRepository;
	
	
	@GetMapping("/generate-pdf")
	public  ResponseEntity<InputStreamResource> customerReport( ) throws IOException {
		
   List<Customer>customers	= (List) customerRepository.findAll();
  Optional<AccountStatement> accountStatements =  accountStatRepository.findById("1");
  
    System.out.println("accountStatements" +accountStatements);
                   
	ByteArrayInputStream bis	= PDFGenerator.CustomerPDFReport(customers,accountStatements);
	
	System.out.println("bis" +bis);
	 HttpHeaders headers = new HttpHeaders();
     headers.add("Content-Disposition", "inline; filename=customers.pdf");

     return ResponseEntity
             .ok()
             .headers(headers)
             .contentType(MediaType.APPLICATION_PDF)
             .body(new InputStreamResource(bis));
}

}
