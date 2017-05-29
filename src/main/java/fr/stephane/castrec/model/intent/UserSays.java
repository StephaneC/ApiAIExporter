package fr.stephane.castrec.model.intent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by SCA on 29/05/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSays {
  public List<Data> getData() {
    return data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  @JsonProperty("data")
  List<Data> data;

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(Data d : data){
      sb.append(d.text);
    }
    return sb.toString();
  }



}
