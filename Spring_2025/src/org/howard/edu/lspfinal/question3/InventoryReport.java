package org.howard.edu.lspfinal.question3;

/**
 * InventoryReport handles how inventory reports are created.
 * It customizes the load, format, and print steps defined in the base Report class.
 */
public class InventoryReport extends Report {

    // Step 1: Load data specific to inventory
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
        // You could imagine this pulling from a database or CSV file
    }

    // Step 2: Format the inventory data in a way that makes sense
    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
        // For inventory, this might mean listing products, quantities, etc.
    }

    // Step 3: Output the inventory report
    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
        // Final step to simulate sending the report to the screen or printer
    }
}
