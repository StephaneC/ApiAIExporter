package fr.stephane.castrec.model.intent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by SCA on 29/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
  @JsonProperty("text")
  String text;

  @JsonProperty("meta")
  String meta;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getMeta() {
    return meta;
  }

  public void setMeta(String meta) {
    this.meta = meta;
  }
}
