package fr.stephane.castrec.model.intent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by SCA on 29/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
  int type;
  @JsonProperty("speech")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  List<String> speech;


  public List<String> getSpeech() {
    return speech;
  }

  public void setSpeech(List<String> speech) {
    this.speech = speech;
  }

}