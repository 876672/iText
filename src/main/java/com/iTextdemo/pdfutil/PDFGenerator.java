package com.iTextdemo.pdfutil;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import java.io.IOException;
import org.slf4j.LoggerFactory;
import com.itextpdf.layout.Document;
import com.iTextdemo.model.AccountStatement;
import com.iTextdemo.model.Customer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class PDFGenerator {

	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

	public static ByteArrayInputStream CustomerPDFReport(List<Customer> customers,
			Optional<AccountStatement> accountStatements) throws IOException {

		System.out.println("accountStatements" + accountStatements);
		String imFile = "images/Bank-Download.png";
		ImageData data1 = ImageDataFactory.create(imFile);

		Image image = new Image(data1);
		image.scaleToFit(100f, 100f);

		image.setMarginBottom(20f);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(out);
		PdfDocument pdf = new PdfDocument(writer);
		pdf.setDefaultPageSize(PageSize.A3);

		try (Document document = new Document(pdf)) {
			PdfFont titleFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

			float[] columnWidth = { 200f, 40f, 400f };
			Table table1 = new Table(columnWidth);
			String[] data = { String.valueOf(accountStatements.get().getAccountId()),
					accountStatements.get().getAccountName(), accountStatements.get().getAddress(),
					accountStatements.get().getDate(), accountStatements.get().getAccountNumber(),
					accountStatements.get().getAccountDescription(), accountStatements.get().getBranch(),
					String.valueOf(accountStatements.get().getDrawingPower()),
					String.valueOf(accountStatements.get().getInterestRate()),
					String.valueOf(accountStatements.get().getModBalance()), accountStatements.get().getCifNo(),
					accountStatements.get().getIfsCode(), accountStatements.get().getMicrCode() };

			String[] tableHeaders = { "accountId", "accountName", "address", "date", "accountNumber",
					"accountDescription", "branch", "drawingPower", "interestRate", "modBalance", "cifNo", "ifsCode",
					"micrCode" };

			for (int i = 0; i < tableHeaders.length; i++) {
				table1.addCell(createCell(tableHeaders[i], true).setBorder(Border.NO_BORDER));
				table1.addCell(createCell(":", true).setBorder(Border.NO_BORDER).setFont(titleFont).setFontSize(18f));
				table1.addCell(createCell(data[i], true).setBorder(Border.NO_BORDER));

			}
			document.add(image);

			document.add(table1);

			document.add(new Paragraph("Customer Report").setFontColor(Color.RED));
			float[] columnWidths = { 100f, 200f, 300f };
			Table table = new Table(columnWidths);

			table.addCell(createCell("ID", true));
			table.addCell(createCell("First Name", true));
			table.addCell(createCell("Last Name", true));

			for (Customer customer : customers) {
				table.addCell(createCell(customer.getId().toString(), false));
				table.addCell(createCell(customer.getFirstName(), false));
				table.addCell(createCell(customer.getLastName(), false));
			}

			document.add(table);

			document.close();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

	private static Cell createCell(String content, boolean header) {
		Cell cell = new Cell().add(new Paragraph(content));
		return cell;
	}

	private static Cell createCell1(String content, float rowspan, float colspan) {
		Cell cell = new Cell().add(new Paragraph(content));
		cell.setWidth(rowspan);
		cell.setHeight(colspan);
		return cell;
	}

}
