package boycott;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class ProductManager {
   
    public ArrayList<String> products;

    public ProductManager(String filePath) throws IOException {
        
        products = new ArrayList<>();
        loadProducts(filePath,products);
    }

    private void loadProducts(String filePath,ArrayList<String> product) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
             
                product.add(str.trim().toLowerCase()); // Store the lowercase version for comparison
            }
        }
    }

    public boolean containsProduct(String product) {
        return products.contains(normalizeInput(product));
    }

    public ArrayList<String> getRecommendations(String target,String filePath) throws IOException {
        ArrayList<String> recommendations = new ArrayList<>();
        ArrayList<String>  NonIsraeliProducts = new ArrayList<>();
        loadProducts(filePath,NonIsraeliProducts);
        int index = NonIsraeliProducts.indexOf(normalizeInput(target));
        if (index != -1) {
            for (int i = index+1; i < NonIsraeliProducts.size(); i++) {
                String item = NonIsraeliProducts.get(i);
                if (item.isEmpty()) {
                    break;
                } else {
                    recommendations.add(item);
                }
            }
        }
        return recommendations;
    }

    public static String normalizeInput(String input) {
        return input.trim().toLowerCase(); // Always trim and convert to lowercase
    }
}

