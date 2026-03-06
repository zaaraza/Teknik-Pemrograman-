// *************************************************************
// WeeklySales.java
//
// Sorts the sales staff in descending order by sales.
// ************************************************************
public class WeeklySales {
    public static void main(String[] args) {
        Salesperson[] salesStaff = new Salesperson[10];
        salesStaff[0] = new Salesperson("Raza", "Mulki", 9000);
        salesStaff[1] = new Salesperson("Haafiz", "Nayyara", 4935);
        salesStaff[2] = new Salesperson("Firon", "Fariz", 3000);
        salesStaff[3] = new Salesperson("Akmal", "Rizqillah", 2800);
        salesStaff[4] = new Salesperson("Nafidz", "Guntur", 1570);
        salesStaff[5] = new Salesperson("Nafis", "Cirebon", 3000);
        salesStaff[6] = new Salesperson("Ziddan", "Subang", 7300);
        salesStaff[7] = new Salesperson("Rama  ", "Kruw", 5000);
        salesStaff[8] = new Salesperson("Iqbal", "Cimahi", 2850);
        salesStaff[9] = new Salesperson("Kakang", "Kasep", 3000);

        Sorting.insertionSort(salesStaff); // descending

        System.out.println("\nRanking of Sales for the Week\n");
        for (Salesperson s : salesStaff)
            System.out.println(s);
    }
}