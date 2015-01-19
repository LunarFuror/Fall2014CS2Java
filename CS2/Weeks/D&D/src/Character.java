
public class Character {
	//Add int's for each stat
	//prefix all with char to avoid issues with keywords (charName etc)
	//maybe an array for the inventory and skills.
	//may just add a class Skills with all the skills but that'll be a lot of stuff
	//might be better to add classes for each "class" (rogue, fighter etc) with the skills IN them and find a way to inherit those classes
	
	private int charStr;
	private int charDex;
	private int charCon;
	private int charInt;
	private int charWis;
	private int charCha;
	private int charAC;
	private int charInit;
	private int charInitMod;
	private int charSpeed;
	private int charExp;
	private int charLevel;
	private int charLevel2; // just in case
	private int charMaxHP;
	private int charCurHP;
	private int charTempHP;
	private int charDeathSuccess;
	private int charDeathFail;
	private int time;
	private int charSaveStrMod;
	private int charSaveDexMod;
	private int charSaveConMod;
	private int charSaveIntMod;
	private int charSaveWisMod;
	private int charSaveChaMod;
	private int charCopper;
	private int charSilver;
	private int charGold;
	private int charPlatinum;
	private int charElectrum;
	private int charHitDice;
	private Boolean inInitiative;
	private String charBackground;
	private String charPersonality;
	private String charIdeals;
	private String charBonds;
	private String charFlaws;
	private String timeType;
	private String moveType;
	private String charName;
	
//	private String charClass; //maybe make ENUM
//	private String charClass2; //just in case
//	private String charRace; //maybe make ENUM
//	private String charAlignment; //maybe make ENUM
	
	public Character(){
		
	}
}
