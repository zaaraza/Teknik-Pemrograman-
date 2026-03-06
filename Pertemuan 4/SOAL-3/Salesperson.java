// *******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************
public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    // ------------------------------------------------------
    // Constructor: Sets up the sales person object with
    // the given data.
    // ------------------------------------------------------
    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    // -------------------------------------------
    // Returns the sales person as a string.
    // -------------------------------------------
    public String toString() {
        return String.format("%-10s %-8s %5d", lastName, firstName, totalSales);
    }

    // -------------------------------------------
    // Returns true if the sales people have
    // the same name.
    // -------------------------------------------
    public boolean equals(Object other) {
        return (lastName.equals(((Salesperson) other).getLastName()) &&
                firstName.equals(((Salesperson) other).getFirstName()));
    }

    // --------------------------------------------------
    // Order is based on total sales with the name
    // (last, then first) breaking a tie.
    // Negatif = this < other
    // Positif = this > other
    // --------------------------------------------------
    public int compareTo(Object other) {
        int result;
        Salesperson otherPerson = (Salesperson) other; // cast ke Salesperson

        // Bandingkan berdasarkan total sales
        result = this.totalSales - otherPerson.totalSales;

        // Jika sales sama (tie), gunakan nama belakang untuk memecah
        if (result == 0) {
            result = this.lastName.compareTo(otherPerson.lastName);

            // Jika nama belakang juga sama, gunakan nama depan
            if (result == 0)
                result = this.firstName.compareTo(otherPerson.firstName);
        }

        return result;
    }

    // -------------------------
    // First name accessor.
    // -------------------------
    public String getFirstName() {
        return firstName;
    }

    // -------------------------
    // Last name accessor.
    // -------------------------
    public String getLastName() {
        return lastName;
    }

    // -------------------------
    // Total sales accessor.
    // -------------------------
    public int getSales() {
        return totalSales;
    }
}