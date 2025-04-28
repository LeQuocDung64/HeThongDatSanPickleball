package com.example.pickleball.controller;

import com.example.pickleball.entity.Product;
import com.example.pickleball.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/scrape")
    public String scrapeProducts() {
        try {
            String htmlContent = new String(Files.readAllBytes(Paths.get("src/main/resources/static/datDoDung.html")));
            Document doc = Jsoup.parse(htmlContent);

            String scriptContent = doc.select("script").stream()
                .map(element -> element.html())
                .filter(script -> script.contains("const products ="))
                .findFirst()
                .orElseThrow(() -> new IOException("Không tìm thấy mảng products trong file HTML"));

            Pattern pattern = Pattern.compile("const products = \\[(.*?)\\];", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(scriptContent);
            if (!matcher.find()) {
                throw new IOException("Không thể trích xuất mảng products");
            }

            String productsArray = matcher.group(1);
            String[] productEntries = productsArray.split("\\},\\s*\\{");

            for (String entry : productEntries) {
                entry = entry.replaceAll("[\\{\\}\\]\\[]", "").trim();
                if (entry.isEmpty()) continue;

                Integer id = null;
                String name = null;
                Integer price = null;
                String category = null;
                String image = null;
                Boolean isNew = false;

                String[] attributes = entry.split(",\\s*");
                for (String attr : attributes) {
                    String[] keyValue = attr.split(":\\s*");
                    if (keyValue.length < 2) continue;

                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    switch (key) {
                        case "id":
                            id = Integer.parseInt(value);
                            break;
                        case "name":
                            name = value.replaceAll("'", "").trim();
                            break;
                        case "price":
                            price = Integer.parseInt(value);
                            break;
                        case "category":
                            category = value.replaceAll("'", "").trim();
                            break;
                        case "image":
                            image = value.replaceAll("'", "").trim();
                            break;
                        case "isNew":
                            isNew = Boolean.parseBoolean(value);
                            break;
                    }
                }

                if (id == null || name == null || price == null || category == null) {
                    continue;
                }

                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setCategory(category);
                product.setImage(image);
                product.setIsNew(isNew);

                productRepository.save(product);
            }

            return "Dữ liệu sản phẩm đã được lưu vào database!";
        } catch (IOException e) {
            return "Lỗi khi đọc file HTML: " + e.getMessage();
        }
    }
}