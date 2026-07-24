import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Laptop", "Electronics"),
                new Product(101, "Phone", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Book", "Education"),
                new Product(104, "Watch", "Accessories")
        };

        System.out.println("Linear Search:");

        Product result1 = SearchEngine.linearSearch(products, 102);

        if (result1 != null) {
            System.out.println("Product Found: " + result1.productName);
        } else {
            System.out.println("Product Not Found");
        }

        Arrays.sort(products, Comparator.comparingInt(product -> product.productId));

        System.out.println();

        System.out.println("Binary Search:");

        Product result2 = SearchEngine.binarySearch(products, 104);

        if (result2 != null) {
            System.out.println("Product Found: " + result2.productName);
        } else {
            System.out.println("Product Not Found");
        }
    }
}