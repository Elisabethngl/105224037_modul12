class CreditCard implements PaymentMethod, Refundable {
    public void pay(double amount) {
        System.out.println("[CreditCard] Bayar Rp" + amount + " via Credit Card");
    }
    public void refund(double amount) {
        System.out.println("[CreditCard] Refund Rp" + amount + " ke kartu kredit");
    }
}