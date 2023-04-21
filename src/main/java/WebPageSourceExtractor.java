import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class WebPageSourceExtractor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Enter part id: ");
            input = s.next();
            if (input.equals("bye"))
                break;
            String url = "https://www.bricklink.com/v2/catalog/catalogitem.page?P=" + input;
            try {
                // Use Jsoup to connect to the URL and retrieve the HTML source code
                Document doc = Jsoup.connect(url).get();
                Elements attributesElements = doc.select("a");
                for (Element element : attributesElements)
                    if (element.toString().contains("catalogList"))
                        System.out.println("Category: " + element.text());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
