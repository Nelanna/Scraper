package scraper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import resource.Player;

public class Scraper {
	static ArrayList<Player> players = new ArrayList<Player>();
	static int playerNumber = 1;
	
	public static void main(String args[]){
		System.out.println("Starting......");
		Document doc;
		System.out.println("Gathering Data....");
		try {
			doc = Jsoup.connect("https://www.wowprogress.com/gearscore/us/?lfg=1&raids_week=2&lang=en&sortby=ts").get();
			Element table = doc.select("table").get(0);
			Elements rows = table.select("tr");
		
			parseTable(rows);
			for (int i=0;i<5;i++)
			{
				doc = Jsoup.connect("https://www.wowprogress.com/gearscore/us/char_rating/next/"+ i + "/lfg.1/raids_week.2/lang.en/sortby.ts#char_rating").get();
				Element tableNext = doc.select("table").get(0);
				Elements rowsNext = tableNext.select("tr");
				parseTable(rowsNext);
			}
			System.out.println("Gathering Data Complete....");
			System.out.println("Begin Excel Dump.....");
			ConvertToExcel converter = new ConvertToExcel();
			if (converter.convertToExcel(players))
			{
				System.out.println("Excel Dump Complete....");
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done......");
	}
	
	private static void parseTable(Elements rows)
	{
		int i = 0;
		for (Element row: rows)
		{
			//skip header
			if (i == 0)
			{
				i++;
				continue;
			}
			playerNumber++;
			Document individualPage = new Document("nothing");
			Document WarcraftLogsPage = new Document("nothing2");
			
			//Since no two websites handle server names the same need to do some manip of server name for additional urls
			String serverNameForRaiderIO;
			serverNameForRaiderIO = row.select("td").get(3).text();
			serverNameForRaiderIO = serverNameForRaiderIO.replace("'", "");
			serverNameForRaiderIO = serverNameForRaiderIO.replace(" ", "-");
			 
			String serverNameForWowprogressPage;
			serverNameForWowprogressPage = row.select("td").get(3).text();
			serverNameForWowprogressPage = serverNameForWowprogressPage.replace("'", "-");
			serverNameForWowprogressPage = serverNameForWowprogressPage.replace(" ", "-");
			
			String serverNameForArmory;
			serverNameForArmory = row.select("td").get(3).text();
			serverNameForArmory = serverNameForArmory.replace("'", "");
			serverNameForArmory = serverNameForArmory.replace(" ", "-");
			
			try {
				 individualPage = Jsoup.connect("https://www.wowprogress.com/character/us/" + serverNameForWowprogressPage + "/" + row.select("td").get(0).text()).get();
				 WarcraftLogsPage = Jsoup.connect("https://www.warcraftLogs.com/character/us/" + serverNameForRaiderIO + "/" + row.select("td").get(0).text()).get();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
			Player player = new Player();
			player.setName(row.select("td").get(0).text());
			player.setClassName(WarcraftLogsPage.select("#character-class").attr("class"));
			player.setServer(row.select("td").get(3).text());	
			player.setBattletag(individualPage.select(".profileBattletag").text());
			if (row.select("a").get(1).attr("title").contains("Horde"))
			{
				player.setFaction("Horde");
			}
			else 
			{
				player.setFaction("Alliance");
			}
			player.setCurrentGuild(row.select("a").get(1).text());
			player.setIlvl(row.select("td").get(4).text());
			try
			{
				int mythic = 0;
				Element tierTable = individualPage.select("#tiers_details").get(0);
				Elements tierRows = tierTable.select("table").get(0).select("tr");
				for (Element e: tierRows)
				{
					if (e.text().contains("Mythic"))
					{
						mythic++;
					}
				}
				player.setEpProgress(mythic + "/8M");	
			}
			catch (IndexOutOfBoundsException e)
			{
				player.setEpProgress("Failed to Parse");
			}
			
			player.setWarcraftLogsLink("https://www.warcraftlogs.com/character/us/" + serverNameForRaiderIO + "/" + player.getName());
			player.setArmoryLink("https://www.worldofwarcraft.com/en-us/character/us/" + serverNameForArmory + "/" + player.getName());
			player.setRaiderIOLink("www.raider.io/characters/us/" + serverNameForRaiderIO + "/" + player.getName());
			player.setWowprogressLink("https://www.wowprogress.com/character/us/" + serverNameForWowprogressPage + "/" + player.getName());
			player.setWowprogressMessage(individualPage.select(".charCommentary").text());
			
			
			players.add(player);
			i++;	
		}
	}
}
