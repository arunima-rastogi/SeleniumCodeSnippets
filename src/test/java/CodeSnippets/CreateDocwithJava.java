package CodeSnippets;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateDocwithJava {
	public static void main(String[] args) {

		try {
			//Create a docx file 
			FileOutputStream out = new FileOutputStream(new File("c:\\SRTemp\\documentToCreate.docx"));

			XWPFDocument document = new XWPFDocument();
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			run.setText("Welcome to my channel. Chillyfacts.com created word document. Test test");

			// create table
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRowOne = table.getRow(0);
			tableRowOne.getCell(0).setText("col 1, row one");
			tableRowOne.addNewTableCell().setText("col 2, row one");
			tableRowOne.addNewTableCell().setText("col 3, row one");
			// create second row
			XWPFTableRow tableRowTwo = table.createRow();
			tableRowTwo.getCell(0).setText("col 1, row two");
			tableRowTwo.getCell(1).setText("col 2, row two");
			tableRowTwo.getCell(2).setText("col 3, row two");
			// create third row
			XWPFTableRow tableRowThree = table.createRow();
			tableRowThree.getCell(0).setText("col 1, row three");
			tableRowThree.getCell(1).setText("col 2, row three");
			tableRowThree.getCell(2).setText("col 3, row three");
			
			XWPFRun paragraphOneRunThree = paragraph.createRun();
			// paragraphOneRunThree.setStrike(true);
			paragraphOneRunThree.setFontSize(30);
			paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
			paragraphOneRunThree.setText(" Font Styles");
			document.write(out);
			out.close();
			System.out.println("createparagraph.docx written successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
