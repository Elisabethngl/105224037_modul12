class EmailSystem implements EmailNotifier, Notifier {
    public void sendEmail(String message) {
        System.out.println("[EmailSystem] Email: " + message);
    }
    public void send(String message) {
        sendEmail(message);
    }
}