package controllers;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

@Controller
public class ProductsController {

    private final ProductService productService;

    // We use DI through the controller’s constructor parameters to get the service bean from the Spring context.
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            /*
                You can use the model class as a parameter of the controller’s action directly.
                Spring knows to create the instance based on the request attributes.
                The model class needs to have a default constructor to allow Spring to create
                the instance before calling the action method.
             */
            @RequestParam String name, // We can use 'Product p' instead of the 2 line params
            @RequestParam double price,
            Model model
    ) {
        // We build a new Product instance and add it to the list by calling the service use case method.
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        // We get the list of products and send it to the view.
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
