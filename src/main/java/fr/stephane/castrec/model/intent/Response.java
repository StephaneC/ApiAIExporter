package fr.stephane.castrec.model.intent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SCA on 29/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
  @JsonProperty("action")
  String action;

  @JsonProperty("messages")
  List<Message> messages;
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public List<Message> getMessages() {
    if(messages == null){
      return new LinkedList<>();
    }
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}
