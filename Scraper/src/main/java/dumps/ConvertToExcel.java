package dumps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import resource.Player;

public class ConvertToExcel {
	
	public ConvertToExcel()
	{
		
	}

	public boolean convertToExcel(ArrayList<Player> players)
	{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("LFG");
		
		Row header = sheet.createRow(0);
		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("Name");
		headerCell = header.createCell(1);
		headerCell.setCellValue("Class");
		headerCell = header.createCell(2);
		headerCell.setCellValue("Server");
		headerCell = header.createCell(3);
		headerCell.setCellValue("Faction");
		headerCell = header.createCell(4);
		headerCell.setCellValue("Current Guild");
		headerCell = header.createCell(5);
		headerCell.setCellValue("Ilvl");
		headerCell = header.createCell(6);
		headerCell.setCellValue("BattleTag");
		headerCell = header.createCell(7);
		headerCell.setCellValue("EP Progress");
		headerCell = header.createCell(8);
		headerCell.setCellValue("Comment");
		headerCell = header.createCell(9);
		headerCell.setCellValue("Wowprogress");
		headerCell = header.createCell(10);
		headerCell.setCellValue("Warcraft Logs");
		headerCell = header.createCell(11);
		headerCell.setCellValue("Raider IO");
		headerCell = header.createCell(12);
		headerCell.setCellValue("Armory");
		
		int i = 0;
		for (Player player: players)
		{
			i++;
			Row row = sheet.createRow(i);
			Cell playerCell = row.createCell(0);
			playerCell.setCellValue(player.getName());
			playerCell = row.createCell(1);
			playerCell.setCellValue(player.getClassName());
			playerCell = row.createCell(2);
			playerCell.setCellValue(player.getServer());
			playerCell = row.createCell(3);
			playerCell.setCellValue(player.getFaction());
			playerCell = row.createCell(4);
			playerCell.setCellValue(player.getCurrentGuild());
			playerCell = row.createCell(5);
			playerCell.setCellValue(player.getIlvl());
			playerCell = row.createCell(6);
			playerCell.setCellValue(player.getBattletag());
			playerCell = row.createCell(7);
			playerCell.setCellValue(player.getEpProgress());
			playerCell = row.createCell(8);
			playerCell.setCellValue(player.getWowprogressMessage());
			playerCell = row.createCell(9);
			playerCell.setCellValue(player.getWowprogressLink());
			playerCell = row.createCell(10);
			playerCell.setCellValue(player.getWarcraftLogsLink());
			playerCell = row.createCell(11);
			playerCell.setCellValue(player.getRaiderIOLink());
			playerCell = row.createCell(12);
			playerCell.setCellValue(player.getArmoryLink());
		}
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() -1) + "temp.xlsx";
		try
		{
			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();
		}
		catch (FileNotFoundException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
		
		
		return true;
	}
}
