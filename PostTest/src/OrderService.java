class OrderService {
    private OrderRepository repository;
    private PaymentMethod paymentMethod;
    private Notifier notifier;

    public OrderService(OrderRepository repository, PaymentMethod paymentMethod, Notifier notifier) {
        this.repository = repository;
        this.paymentMethod = paymentMethod;
        this.notifier = notifier;
    }

    public void placeOrder(String orderId, double amount) {
        repository.save(orderId);
        paymentMethod.pay(amount);
        notifier.send("Pesanan " + orderId + " berhasil!");
    }
}