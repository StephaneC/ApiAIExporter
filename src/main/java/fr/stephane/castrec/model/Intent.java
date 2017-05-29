package fr.stephane.castrec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.stephane.castrec.model.intent.Response;
import fr.stephane.castrec.model.intent.UserSays;

import java.util.List;

/**
 * Created by SCA on 29/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intent {

  @JsonProperty("userSays")
  List<UserSays> userSays;

  @JsonProperty("responses")
  List<Response> responses;

  @JsonProperty("name")
  String name;


  public List<UserSays> getUserSays() {
    return userSays;
  }

  public void setUserSays(List<UserSays> userSays) {
    this.userSays = userSays;
  }

  public List<Response> getResponses() {
    return responses;
  }

  public void setResponses(List<Response> responses) {
    this.responses = responses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
