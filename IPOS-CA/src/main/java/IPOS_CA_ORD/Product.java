package IPOS_CA_ORD;

/**
 * Represents a product in the system catalogue.
 */
public class Product {

    private final int productId;
    private final String description;
    private final String packageType;
    private final String unit;
    private final int unitsInPack;
    private final double packCost;
    private final int availability;
    private int quantityRequired;

    public Product(int productId, String description, String packageType,
                   String unit, int unitsInPack, double packCost, int availability) {
        this.productId = productId;
        this.description = description;
        this.packageType= packageType;
        this.unit = unit;
        this.unitsInPack = unitsInPack;
        this.packCost = packCost;
        this.availability = availability;
        this.quantityRequired = 0;
    }

    public int getProductId() { return this.productId; }
    public String getDescription() { return this.description; }
    public String getPackageType() { return this.packageType; }
    public String getUnit() { return this.unit; }
    public int getUnitsInPack() { return this.unitsInPack; }
    public double getPackCost() { return this.packCost; }
    public int getAvailability() { return this.availability; }
    public int getQuantityRequired(){return this.quantityRequired;}

    public void setQuantityRequired(int quantity){
        this.quantityRequired = quantity;
    }
}
