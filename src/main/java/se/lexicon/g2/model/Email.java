package se.lexicon.g2.model;

public class Email extends Notification {

    private String recipient;
    private String subject;
    private String content;

    //private byte[] files;

    public Email(String recipient, String subject, String content) {
        super();
        setRecipient(recipient);
        setSubject(subject);
        setContent(content);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        if (recipient == null) throw new IllegalArgumentException("Recipient Email is null.");
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String summary() {
        return super.toString() + " -> Email sent to: "  + recipient + " with subject:" + subject;
    }

}
