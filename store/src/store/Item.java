package store;

public class Item {
    /* COMPLETE ITEM CLASS */
    
        private int itemNumber;
	private String itemName;
	private double itemPrice;
	private double itemCost;

        
        public Item(Item item) {
            this(item.itemNumber,item.itemName,item.itemPrice);
        } 
        
    public Item(int itemNumber, String itemName, double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
        
        @Override
        public String toString() {
        return "                - Number:"+itemNumber+"\n                - Name:"+itemName+"\n                - Price:"+itemPrice+" SAR";
    }

    
}
