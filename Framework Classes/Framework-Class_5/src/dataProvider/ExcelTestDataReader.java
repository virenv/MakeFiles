package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestDataReader {
	private String testDataFilePath;
	private FileInputStream fileStream;
	private XSSFWorkbook testDataWorkbook;
	private XSSFSheet testDataSheet;
	private int rowEnd = 0;
	
	public ExcelTestDataReader(String testDataFile) throws IOException {
		testDataFilePath = testDataFile;
		fileStream = new FileInputStream(new File(testDataFilePath));
		testDataWorkbook = new XSSFWorkbook(fileStream);
		testDataSheet = testDataWorkbook.getSheet("Sheet1");
		rowEnd = testDataSheet.getLastRowNum();
	}
	
	public String GetTestData(String testName, String key) {
		String value = "";
		for (int i = 0; i <= rowEnd; i++) {
			String testCaseName = GetCellDataAsString(testDataSheet.getRow(i).getCell(0));

			if (testCaseName.equalsIgnoreCase(testName)) {
				int j = 0;
				String colName = GetCellDataAsString(testDataSheet.getRow(0).getCell(j));

				while (!colName.isEmpty()) {
					colName = GetCellDataAsString(testDataSheet.getRow(0).getCell(j));
					if (colName.equalsIgnoreCase(key)) {
						value = GetCellDataAsString(testDataSheet.getRow(i).getCell(j));
						break;
					}
					j++;
				}
				break;
			}
		}
		return value;
	}
	
	private String GetCellDataAsString(XSSFCell cell) {
		String value = "";
		if (cell != null) {
			@SuppressWarnings("deprecation")
			CellType cellType = cell.getCellTypeEnum();
			switch (cellType) {
			case BLANK:
				value = "";
				break;
			case BOOLEAN:
				value = (cell.getBooleanCellValue()) ? "true" : "false";
				break;
			case ERROR:
				value = cell.getErrorCellString();
				break;
			case FORMULA:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				value = Double.toString(cell.getNumericCellValue());
				break;
			case STRING:
			default:
				value = cell.getStringCellValue();
			}
		}
		return value.trim();
	}
	
}
