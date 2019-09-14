package resource;

public class Player {
	private String name;//got it, main page
	private String className;//got it, individual page
	private String server;//got it, individual page
	private String race;//got it, individual page
	private String battletag;//got it, individual page
	private String faction;//got it, main page
	private String currentGuild;//got it, main page
	private String ilvl;//got it, main page
	private String uldirProgress;
	private String bodProgress;
	private String epProgress;
	private String warcraftLogsLink;//system generated
	private String raiderIOLink;//system generated
	private String wowprogressLink;//system generated
	private String wowprogressMessage;//got it, individual page
	private String armoryLink;//system generated
	
	public Player()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getCurrentGuild() {
		return currentGuild;
	}

	public void setCurrentGuild(String currentGuild) {
		this.currentGuild = currentGuild;
	}

	public String getIlvl() {
		return ilvl;
	}

	public void setIlvl(String ilvl) {
		this.ilvl = ilvl;
	}

	public String getUldirProgress() {
		return uldirProgress;
	}

	public void setUldirProgress(String uldirProgress) {
		this.uldirProgress = uldirProgress;
	}

	public String getBodProgress() {
		return bodProgress;
	}

	public void setBodProgress(String bodProgress) {
		this.bodProgress = bodProgress;
	}

	public String getEpProgress() {
		return epProgress;
	}

	public void setEpProgress(String epProgress) {
		this.epProgress = epProgress;
	}

	public String getWarcraftLogsLink() {
		return warcraftLogsLink;
	}

	public void setWarcraftLogsLink(String warcraftLogsLink) {
		this.warcraftLogsLink = warcraftLogsLink;
	}

	public String getRaiderIOLink() {
		return raiderIOLink;
	}

	public void setRaiderIOLink(String raiderIOLink) {
		this.raiderIOLink = raiderIOLink;
	}

	public String getWowprogressLink() {
		return wowprogressLink;
	}

	public void setWowprogressLink(String wowprogressLink) {
		this.wowprogressLink = wowprogressLink;
	}

	public String getWowprogressMessage() {
		return wowprogressMessage;
	}

	public void setWowprogressMessage(String wowprogressMessage) {
		this.wowprogressMessage = wowprogressMessage;
	}

	public String getBattletag() {
		return battletag;
	}

	public void setBattletag(String battletag) {
		this.battletag = battletag;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	public String getArmoryLink() {
		return armoryLink;
	}

	public void setArmoryLink(String armoryLink) {
		this.armoryLink = armoryLink;
	}

	public String toString()
	{
	
		return "Player Name: " + this.name + "\n"
				+ "Player Class: " + this.className + "\n"
				+ "Player Server: " + this.server + "\n"
				+ "Player Faction: " + this.faction + "\n"
				+ "Player Current Guild: " + this.currentGuild + "\n"
				+ "Player iLvl: " + this.ilvl + "\n"
				+ "Player BTag: " + this.battletag + "\n"
				+ "Player EP Progress: " + this.epProgress + "\n"
				+ "Player comment: " + this.wowprogressMessage + "\n"
				+ "Player Wowprogress Page: " + this.wowprogressLink + "\n"
				+ "Player Warcraftlogs Page: " + this.warcraftLogsLink + "\n"
				+ "Player Raider IO Page: " + this.raiderIOLink + "\n"
				+ "Player Armory Page: " + this.armoryLink + "\n"
				;
		
	}
}
