package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.List;
import java.text.DecimalFormat;
public class ETLPipeline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "data/products.csv";
		String outputFile = "data/transformed_products.csv";
		
		
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))){
			
				
			
			String line;
		
			boolean isHeader = true;
			DecimalFormat df = new DecimalFormat("#.##");
		
			bw.write("ProductID,Name,Price,Category,PriceRange");		
			bw.newLine();
		
			while ((line = br.readLine()) != null) {
				if(line.trim().isEmpty()) {
					continue;
				}
			
				String[] columns = line.split(",");
				
				if (columns.length < 4) {
					System.out.println("Skipping invalid row: "+ line);
					continue;
				}
				
				//Trim whitespace
				
				String productIdStr = columns[0].trim();
				String name = columns[1].trim().toUpperCase();
				String priceStr = columns[2].trim();
				String category = columns[3].trim();
				
				int productId;
				double price;
				
				
				try {
					productId = Integer.parseInt(productIdStr);
					price = Double.parseDouble(priceStr);
				} catch (NumberFormatException e) {
					System.out.println("Skipping row with invalid number format: "+ line);
					continue;
				}
				if (category.equals("Electronics")&& price > 500) {
					category = "Premium Electronics";
				}
			//Apply 10% discount
				if(category.equals("Electronics")) {
					price*=0.9;
				}
				
			//Determine Pirce range
				String priceRange;
				if(price<=10) {
					priceRange = "Low";
				}else if (price<= 100) {
					priceRange = "Medium";
				}else if (price<=500) {
					priceRange = "High";
				}else {
					priceRange = "Premium";
				}
			
			//Write transformed data to new csv file
			
				bw.write(productId + "," + name + "," + df.format(price)+ "," + category + "," + priceRange);
				bw.newLine();
			}
	
			System.out.println("ETL process completed. Transformed file saved as " + outputFile);
		} catch (FileNotFoundException e ) {
			System.out.println("Error: Input file not found. Please check the file location.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Unable to read/write file. ");
			e.printStackTrace();
		
		}
	}

}
