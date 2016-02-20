/**
 * The CellPhone class represents a cell phone.
 */
public class CellPhone {

	/**
	 * Fields
	 */
	private String manufact;
	/**
	 * Manufacturer
	 */
	private String model;
	/**
	 * Model
	 */
	private double retailPrice;

	public String getManufact() {
		return this.manufact;
	}

	public void setManufact(String manufact) {
		this.manufact = manufact;
	}

	public String getModel() {
		return this.model;
	}

	public double getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * The constructor accepts arguments for
	 * the phone's manufacturer, model number,
	 * and retail price.
	 * @param man
	 * @param mod
	 * @param price
	 */
	public CellPhone(String man, String mod, double price) {
		// TODO - implement CellPhone.CellPhone
		setModel(mod);
                setManufact(man);
                setRetailPrice(price);
	}

	/**
	 * 
	 * @param mod
	 */
	public void setModel(String mod) {
		this.model = mod;
	}
}