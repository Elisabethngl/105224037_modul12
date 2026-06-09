class WhatsAppSystem implements WhatsAppNotifier, Notifier {
    public void sendWhatsApp(String message) {
        System.out.println("[WhatsAppSystem] WhatsApp: " + message);
    }
    public void send(String message) {
        sendWhatsApp(message);
    }
}