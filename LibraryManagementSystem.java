import java.io.*;
import java.util.*;

public class LibraryManagementSystem {

	private static ArrayList<MediaItem> library = new ArrayList<>();
	
	public static void main(String[] args) {
		loadInventory("inventory.txt");
	
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		while(true)
		{
				System.out.println("\n===== Library =====");
				System.out.println("1. View All Items");
				System.out.println("2. Search");
				System.out.println("3. Checkout");
				System.out.println("4. Return");
				System.out.println("5. Sort");
				System.out.println("6. Exit");
				
				
				while(true) {
					try {
						System.out.print("Choose: ");
						choice = scanner.nextInt();
						scanner.nextLine();
						break;
					} catch (Exception e) {
						System.out.println("Invalid input. Enter a number.");
						scanner.nextLine();
					}
				}
				
				
				switch(choice) {
				case 1:
					displayAll();
					break;
				case 2:
					searchByTitle(scanner);
					break;
				case 3:
					checkOutItem(scanner);
					break;
				case 4:
					returnItem(scanner);
					break;
				case 5:
					sortByYear();
					break;
				case 6:
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("Invalid option.");
					
				}
				
			}
			
		}
		
		
		public static void loadInventory(String filename) {
			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				String line;
			
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					
					String type = data[0].trim();
					String id = data[1].trim();
					String title = data[2].trim();
					String creator = data[3].trim();
					int year = Integer.parseInt(data[4].trim());
					
					switch(type) {
					case "Book":
						library.add(new Book(id, title, creator, year,
								data[5].trim(), data[6].trim()));
						break;
						
					case "Magazine":
						library.add(new Magazine(id, title, creator, year,
								Integer.parseInt(data[5].trim()), data[6].trim()));
						break;
					
					case "DVD":
						library.add(new DVD(id, title, creator, year,
							Integer.parseInt(data[5].trim()), data[6].trim()));
						break;
					}
				}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
		
		public static void displayAll() {
			for (MediaItem item : library) {
				System.out.println(item.getItemDetails());
			}
		}
		
		public static void searchByTitle(Scanner scanner) {
			System.out.print("Enter title: ");
			String search = scanner.nextLine().toLowerCase();
			
			boolean found = false; //setting a boolean for found
			
			for (MediaItem item : library) {
				if (item.getTitle().equalsIgnoreCase(search)) {
					System.out.println(item.getItemDetails());
					found = true;
				}
				
			}
			
			if (!found) { //if not found, it prints msg
				System.out.println("Title not found.");
			}
		}
		
		public static void checkOutItem(Scanner scanner) {
			System.out.print("Enter item ID: ");
			String id = scanner.nextLine();
			
			for (MediaItem item : library) {
				if(item.getItemID().equalsIgnoreCase(id)) {
					item.checkOut();
					return;
				}
			}
			
			System.out.println("Item not found.");
		}
		
		public static void returnItem(Scanner scanner) {
			System.out.print("Enter item ID: ");
			String id = scanner.nextLine();
			
			for (MediaItem item : library ) {
				if (item.getItemID().equalsIgnoreCase(id)) {
					item.returnItem();
					return;
				}
			}
			
			System.out.println("Item not found.");
		}
		
		//sorting years w loop
		public static void sortByYear() {
			for (int i = 0; i < library.size() - 1; i++) {
				for (int j = i + 1; j < library.size(); j++) {
					
					if (library.get(i).getPublicationYear() > library.get(j).getPublicationYear()) {
						MediaItem temp = library.get(i);
						library.set(i,  library.get(j));
						library.set(j,  temp);
					}
				}
			}
			
			System.out.println("Sorted by year.");
		}
		
		
	
}
