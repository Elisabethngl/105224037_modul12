class SMSSystem implements SMSNotifier, Notifier {
    public void sendSMS(String message) {
        System.out.println("[SMSSystem] SMS: " + message);
    }
    public void send(String message) {
        sendSMS(message);
    }
}