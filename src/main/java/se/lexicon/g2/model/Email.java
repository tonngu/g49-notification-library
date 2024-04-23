package se.lexicon.g2.model;

public class Email extends Notification{

    private String recipient;
    private String subject;
    private String content;

    private byte[] files;

    @Override
    public String summary() {
        return null;
    }
}
