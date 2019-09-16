package dumps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import resource.Player;

public class ConvertToHTML {

	
	public ConvertToHTML()
	{
		
	}
	
	public boolean convertToHTML(ArrayList<Player> players)
	{
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() -1) + "template.html";
		File htmlTemplateFile = new File(fileLocation);
		
		try {
			Document doc = Jsoup.connect(fileLocation).get();
			System.out.println(doc.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
}
