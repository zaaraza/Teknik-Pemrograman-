
//********************************************************************
// Commission.java
//
// Represents an hourly employee who also earns commission on sales.
//********************************************************************

public class Commission extends Hourly {
    private double totalSales; // total sales made by this employee
    private double commissionRate; // commission rate (decimal form, e.g. 0.20 = 20%)

    // -----------------------------------------------------------------
    // Sets up a commission employee using the specified information.
    // Parameters: name, address, phone, social security number,
    // hourly pay rate, commission rate
    // -----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = commRate;
        totalSales = 0;
    }

    // -----------------------------------------------------------------
    // Adds the specified sales amount to this employee's total sales.
    // -----------------------------------------------------------------
    public void addSales(double sales) {
        totalSales += sales;
    }

    // -----------------------------------------------------------------
    // Computes and returns the pay for this commission employee,
    // which is the hourly pay (from parent) plus commission on sales.
    // Resets totalSales to 0 after payment.
    // -----------------------------------------------------------------
    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0;
        return payment;
    }

    // -----------------------------------------------------------------
    // Returns information about this commission employee as a string.
    // -----------------------------------------------------------------
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}