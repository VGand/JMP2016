package com.epam.adaptiterator;

/**
 * Created by Полина on 14.08.2016.
 */
public class Message {

    public Message(Integer messageId, String messageText) {
        this.messageId = messageId;
        this.messageText = messageText;
    }

    private Integer messageId;
    private String messageText;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (!getMessageId().equals(message.getMessageId())) return false;
        return !(getMessageText() != null ? !getMessageText().equals(message.getMessageText()) : message.getMessageText() != null);

    }

    @Override
    public int hashCode() {
        int result = getMessageId().hashCode();
        result = 31 * result + (getMessageText() != null ? getMessageText().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
