
public class Item {
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String itemDamageType;	
	private Boolean canAttack;
	private int itemAtkBonus;
	private int numDice; // if 1d6 +3 this is the 1
	private int numDiceSides; // if 1d6 +3 this is the 6
	private int diceResultMod; // if 1d6 +3 this is the +3
	
	/**
	 * Default constructor
	 */
	public Item(){
		setItemName("Name");
		setItemDescription("Description");
		setItemDamageType("Damage Type");
		setItemAtkBonus(0);
		setCanAttack(false);
		setNumDice(0);
		setNumDiceSides(0);
		setDiceResultMod(0);
		setItemType("Misc");
	}
	

	/**
	 * Non-weapon type constructor
	 * @param name The name of the item.
	 * @param desc The description of the item.
	 */
	public Item(String name, String desc){
		setItemName(name);
		setItemDescription(desc);
		setItemDamageType("None");
		setCanAttack(false);
		setItemAtkBonus(0);
		setNumDice(0);
		setNumDiceSides(0);
		setDiceResultMod(0);
		setItemType("Tool");
	}
	
	/**
	 * Weapon type constructor
	 * @param name The name of the item.
	 * @param desc The description of the item.
	 * @param dType The damage type of the item
	 * @param aBonus The attack bonus of the item
	 * @param nDice The number of dice to roll. (if 1d6 +3 this would be 1)
	 * @param sDice The number of sides of the dice rolled. (if 1d6 +3 this would be 6)
	 * @param mDice The modifier of the attack roll (if 1d6 +3 this would be 3)
	 */
	public Item(String name, String desc, String dType, int aBonus, int nDice, int sDice, int mDice){
		setItemName(name);
		setItemDescription(desc);
		setItemDamageType(dType);
		setCanAttack(true);
		setItemAtkBonus(aBonus);
		setNumDice(nDice);
		setNumDiceSides(sDice);
		setDiceResultMod(mDice);
		setItemType("Weapon");
	}
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public Boolean getCanAttack() {
		return canAttack;
	}

	public void setCanAttack(Boolean canAttack) {
		this.canAttack = canAttack;
	}

	public int getNumDice() {
		return numDice;
	}

	public void setNumDice(int numDice) {
		this.numDice = numDice;
	}

	public int getNumDiceSides() {
		return numDiceSides;
	}

	public void setNumDiceSides(int numDiceSides) {
		this.numDiceSides = numDiceSides;
	}

	public int getDiceResultMod() {
		return diceResultMod;
	}

	public void setDiceResultMod(int diceResultMod) {
		this.diceResultMod = diceResultMod;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemDamageType() {
		return itemDamageType;
	}

	public void setItemDamageType(String itemDamageType) {
		this.itemDamageType = itemDamageType;
	}

	public int getItemAtkBonus() {
		return itemAtkBonus;
	}

	public void setItemAtkBonus(int itemAtkBonus) {
		this.itemAtkBonus = itemAtkBonus;
	}
}
