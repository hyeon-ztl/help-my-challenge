package com.ssafy.mvc.model.dto;

public class Message {
	int messageId;
	int goalId;
	String receiver;
	String sender;
	String senderNickname;
	String content;
	String sentDate;
	String openDate;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int messageId, String receiver, String sender, String senderNickname, int goalId, String content, String sentDate,
			String openDate) {
		this.messageId = messageId;
		this.receiver = receiver;
		this.sender = sender;
		this.senderNickname = senderNickname;
		this.goalId = goalId;
		this.content = content;
		this.sentDate = sentDate;
		this.openDate = openDate;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSenderNickName() {
		return senderNickname;
	}

	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", receiver=" + receiver + ", sender=" + sender + ", goalId="
				+ goalId + ", content=" + content + ", sentDate=" + sentDate + ", openDate=" + openDate + "]";
	}
	
}
