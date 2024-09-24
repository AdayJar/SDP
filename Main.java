import java.util.ArrayList;
import java.util.List;

// 1. Single Responsibility Principle (SRP)
// Интерфейс для обработки оплаты
interface PaymentMethod {
    boolean processPayment(double amount);
}

// Конкретный класс для оплаты кредитной картой
class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Реальная логика оплаты
        return true;
    }
}

// Конкретный класс для оплаты через PayPal
class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Реальная логика оплаты
        return true;
    }
}

// Интерфейс для отправки уведомлений
interface Notifier {
    void sendNotification(String message);
}

// Конкретный класс для отправки уведомлений по электронной почте
class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// Интерфейс для добавления и обработки товаров в заказе
interface Item {
    double getPrice();
}

// Пример товара в заказе
class Product implements Item {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

// 2. Open/Closed Principle (OCP) и 5. Dependency Inversion Principle (DIP)
// Класс OrderProcessor
class OrderProcessor {
    private PaymentMethod paymentMethod;
    private Notifier notifier;
    private List<Item> items;

    public OrderProcessor(PaymentMethod paymentMethod, Notifier notifier) {
        this.paymentMethod = paymentMethod;
        this.notifier = notifier;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void processOrder() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        System.out.println("Processing order. Total amount: $" + total);

        // Использование принципа DIP: мы работаем с абстракцией PaymentMethod
        if (paymentMethod.processPayment(total)) {
            System.out.println("Payment successful. Completing the order...");
            notifier.sendNotification("Your order has been processed successfully! Total: $" + total);
        } else {
            System.out.println("Payment failed. Order not completed.");
            notifier.sendNotification("Your payment failed. Please try again.");
        }
    }
}

// Использование класса, демонстрирующее все принципы SOLID
public class Main {
    public static void main(String[] args) {
        // Используем конкретные реализации PaymentMethod и Notifier
        PaymentMethod paymentMethod = new CreditCardPayment();
        Notifier notifier = new EmailNotifier();

        // Создаем OrderProcessor с использованием конкретных реализаций
        OrderProcessor orderProcessor = new OrderProcessor(paymentMethod, notifier);

        // Добавляем товары в заказ
        orderProcessor.addItem(new Product("Laptop", 1200.0));
        orderProcessor.addItem(new Product("Mouse", 25.0));
        orderProcessor.addItem(new Product("Keyboard", 45.0));

        // Обрабатываем заказ
        orderProcessor.processOrder();
    }
}
