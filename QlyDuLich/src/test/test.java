package test;

import java.awt.Color;
import java.io.FileNotFoundException;

import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;

import DAO.QlyToursDAO;
import GUI.QuanLyTour;
import Util.JDBCUtil;

public class test {

	public static void main(String[] args) {
		String path="src/PdfFiles/invoice.pdf";
		try {
			
			PdfWriter pdfWriter=new PdfWriter(path);
			PdfDocument pdfDocument=new PdfDocument(pdfWriter);
			pdfDocument.addNewPage();
			pdfDocument.setDefaultPageSize(PageSize.A4);
			
			Document document=new Document(pdfDocument);
			float threecol=490f;
			float twocol=285f;
			float twocol150=twocol+150f;
			float twocolumnWidth[]= {twocol150,twocol};
			float fullwidth[]= {threecol};
			Paragraph onesp=new Paragraph("\n");
			
			Table table=new Table(twocolumnWidth);
			table.addCell(new Cell().add(new Paragraph("Invoice")).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
			Table nestedtable=new Table(new float[] {twocol/2,twocol/2});
			nestedtable.addCell(getHeaderTextCell("Invoice No."));
			nestedtable.addCell(getHeaderTextCellValue("4262626"));
			nestedtable.addCell(getHeaderTextCell("Invoice Date"));
			nestedtable.addCell(getHeaderTextCellValue("7/4/2014"));
			
			
			
			table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));
			
			
			Border gb=new SolidBorder(1f/2f);
			Table divider=new Table(fullwidth);
			divider.setBorder(gb);
			
			
			
			
			
			document.add(table);
			document.add(onesp);
			document.add(divider);
			document.add(onesp);
			
			Table twoColTable=new Table(twocolumnWidth);
			twoColTable.addCell(getBillingandShippingCell("Billing Information"));
			twoColTable.addCell(getBillingandShippingCell("Shipping Information"));
			document.add(twoColTable.setMarginBottom(12f));
			
			Table twoColTable2=new Table(twocolumnWidth);
			twoColTable2.addCell(getCell10fLeft("Company", true));
			twoColTable2.addCell(getCell10fLeft("Name", true));
			twoColTable2.addCell(getCell10fLeft("Coding Error", false));
			twoColTable2.addCell(getCell10fLeft("Coding", false));
			document.add(twoColTable2);
			
			Table twoColTable3=new Table(twocolumnWidth);
			twoColTable3.addCell(getCell10fLeft("Name", true));
			twoColTable3.addCell(getCell10fLeft("Address", true));
			twoColTable3.addCell(getCell10fLeft("Arlyn Puttergill", false));
			twoColTable3.addCell(getCell10fLeft("8570 Gulseth Terra, 3224 Eastwood\nSpringfi, Ma, 01114", false));
			document.add(twoColTable3);
			
			float oneColoumnwidth[]= {twocol150};
			
			Table oneColTable1=new Table(oneColoumnwidth);
			oneColTable1.addCell(getCell10fLeft("Address", true));
			oneColTable1.addCell(getCell10fLeft("8570 Gulseth Terra, 3224 Eastwood\\nSpringfi, Ma, 01114", false));
			oneColTable1.addCell(getCell10fLeft("Email", true));
			oneColTable1.addCell(getCell10fLeft("qaz@gmail.com", false));
			document.add(oneColTable1.setMarginBottom(10f));
			
			
			Table tableDivider2=new Table(fullwidth);
			Border dgb=new DashedBorder(0.5f);
			document.add(tableDivider2.setBorder(dgb));
			
			Paragraph productPara=new Paragraph("Products");
			
			
			
			
			
			document.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static Cell getHeaderTextCell(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	}
	
	static Cell getHeaderTextCellValue(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
	}
	
	static Cell getBillingandShippingCell(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
	}
	
	static Cell getCell10fLeft(String textValue,Boolean isBold) {
		Cell myCell=new Cell().add(new Paragraph(textValue)).setFontSize(10f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
		return isBold?myCell.setBold():myCell;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
