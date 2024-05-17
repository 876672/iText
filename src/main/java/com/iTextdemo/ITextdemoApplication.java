package com.iTextdemo;

import com.itextpdf.layout.Document;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITextdemoApplication {

	public static void main(String[] args) throws FileNotFoundException {
       SpringApplication.run(ITextdemoApplication.class, args);
		
       final String DEST = "files/demo.pdf";
	    PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
	    Document document = new Document(pdf);
	    String line = "Hello word";
	    document.add(new Paragraph(line));
	    document.close();
		
	}

}
