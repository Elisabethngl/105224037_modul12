public class Main {
    public static void main(String[] args) {
        OrderService service1 = new OrderService(
            new OrderRepository(), new CreditCard(), new EmailSystem()
        );
        service1.placeOrder("ORD-001", 250000);

        OrderService service2 = new OrderService(
            new OrderRepository(), new GiftVoucher(), new WhatsAppSystem()
        );
        service2.placeOrder("ORD-002", 75000);
    }
}