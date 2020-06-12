package InClass2_Hash;

public class PurchaseOrder {
    private String transactionID;
    private int quantity;
    private double price;

	public PurchaseOrder(String transactionID, int quantity, double price) {
		if (transactionID == null) {
			throw new NullPointerException();
		}
		this.transactionID = transactionID;
		this.quantity = quantity;
		this.price = price;
	}
	
	public boolean equals(Object o) {
		if (o instanceof PurchaseOrder) {
			PurchaseOrder other = (PurchaseOrder) o;
			return transactionID.equals(other.transactionID) && quantity == other.quantity && price == other.price;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return String.format("%s (%d x $%.2f)", transactionID, quantity, price);
	}
	
	//TODO: Define the hashCode method below
    public int hashCode() {
    	return this.transactionID.hashCode();
    }
}
