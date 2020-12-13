import java.math.BigDecimal;

public class GroceryItem {
	private String itemName;
	private String desc;
	private BigDecimal itemPrice;

	public GroceryItem(){
	}

	public GroceryItem(String itemName, String desc, BigDecimal itemPrice){
		this.itemName = itemName;
		this.desc = desc;
		this.itemPrice = itemPrice;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public void setItemPrice(BigDecimal itemPrice){
		this.itemPrice = itemPrice;
	}

	public String getItemName(){
		return itemName;
	}

	public String getDesc(){
		return desc;
	}

	public BigDecimal getItemPrice(){
		return itemPrice;
	}
}