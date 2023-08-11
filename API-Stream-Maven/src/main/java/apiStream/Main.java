package apiStream;

import apiStream.domain.enums.CustomerType;
import apiStream.services.CustomerService;
import apiStream.services.OrderService;
import apiStream.services.ProductService;
import apiStream.services.impl.CustomerServiceImpl;
import apiStream.services.impl.OrderServiceImpl;
import apiStream.services.impl.ProductServiceImpl;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import static apiStream.services.impl.ProductServiceImpl.*;

public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();




        String option;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.print("""

                    ⟡ MENU ⟡
                    1. List of products higher than $5.00
                    2. List of products for category Frezee
                    3. List of products with 10%% of discount
                    4. List of product ordered by a client Level 2
                    5. List of minimun price of beaked products
                    6. List of lastest orders
                    7. Total order in 2023-02-02
                    8. Average price in 2023-04-28
                    9. Data map
                    10. Maximun price per category
                    11. Use of runAsync
                    12. Use of SupplyAsync, thenAccept, thenApply, exceptionally and thenRun
                    13. Exit
                    Choose your option""");
            option = sc.next();

            switch (option) {

                case "1":
                    System.out.println("\nList of products higher than $5.00 of category beaked");
                    System.out.println(productService.getHigherProducts());
                    break;

                case "2":
                    System.out.println("\nList of orders for category Frezee");
                    System.out.println(productService.getProductsFreeze());
                    break;
                case "3":
                    System.out.println("\nList of products with 10%% of discount");
                    System.out.println(productService.getProductsDiscount());
                    break;
                case "4":
                    System.out.println("\nList of product ordered by a client Level 2");
                    System.out.println(orderService.getListOrderByDate());
                case "5":
                    System.out.println("\nList minimun price of beaked products");
                    System.out.println(productService.getProductsMinPrice());
                    break;
                case "6":
                    System.out.println("\nList of recent orders");
                    System.out.println(orderService.getRecentOrder());
                    break;
                case "7":
                    System.out.println("\nTotal order in 2023-02-02: $"
                            + orderService.getTotalPriceOrder());
                    break;
                case "8":
                    System.out.println("\nAverage price in 2023-04-28: $"
                            + orderService.getAverageOrder());
                    break;
                case "9":
                    System.out.println("\nData map");
                    System.out.println(orderService.getMapOrder());
                    break;
                case "10":
                    System.out.println("\nMaximun price per category");
                    System.out.println(productService.getProductsMaxPricePerCategory());
                    break;
                case "11":
                    System.out.println("\nUse of runAsync");
                    CompletableFuture.runAsync(()->longProcess());
                    sleepThread(7000);
                case "12":
                    System.out.println("\nUse of SupplyAsync, thenAccept, thenApply, exceptionally and thenRun ");
                    System.out.println(Thread.currentThread());
                    CompletableFuture.supplyAsync(()->processType(CustomerType.LEVEL3))
                            .thenApply((String type) -> processType2(type))
                            .exceptionally(error -> {
                                System.err.println("Exception " + error.getMessage());
                                return "Variable Error" ;
                            } )
                            .thenApply((String type) -> processType3(type))
                            .thenAccept(System.out::println)
                            .thenRun(Main::launchException);

                case "13":
                    option = "13";
                    break;

            default:
                System.out.println("""

                        I ∧,,,∧   ~ ┏━━━━━━━━┓
                        (  ̳• · • ̳)   ~ ♡  Invalid Option   ♡
                        /       づ  ~ ┗━━━━━━━━┛    \s""");

            }

        }while (!option.equals("15"));


    }

    // 12. Use of SupplyAsync, thenAccept, thenApply, exceptionally and thenRun
    public static String processType (CustomerType type) {
        System.out.println(Thread.currentThread());
        return type + " -You have fast delivery";
    }

    public static String processType2 (String type) {
        System.out.println(Thread.currentThread());
        return type + " -You have 10% in all products";
    }
    public static String processType3 (String type) {
        System.out.println(Thread.currentThread());
        return type + " -You have free delivery ";
    }

    public static void launchException(){
        throw new RuntimeException("Exception");
    }


}
