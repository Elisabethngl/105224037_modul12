class GiftVoucher implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("[GiftVoucher] Bayar Rp" + amount + " via Gift Voucher");
    }
}