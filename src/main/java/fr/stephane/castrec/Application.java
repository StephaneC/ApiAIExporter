package fr.stephane.castrec;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.stephane.castrec.model.Intent;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Stéphane Castrec on 29/05/2017.
 */
public class Application {

  static List<Intent> intents;
  static ObjectMapper mapper;

  public static void main(String[] args) throws IOException {
    if(args == null || args[0].isEmpty()){
      System.out.print("Error: first argument empty. Should be a folder");
      return;
    }

    // serialization
    mapper = new ObjectMapper();
    intents = new LinkedList<>();

    //read intents
    try (Stream<Path> paths = Files.walk(Paths.get(args[0]+"/intents/"))) {
      paths
          .filter(Files::isRegularFile)
          .forEach(path -> {
            try {
              parseFile(path);
            } catch (IOException e) {
              System.out.println("Error parsing " + path.getFileName());
              System.out.println(e);
            }
          });
    }

    System.out.println("Found " + intents.size() + " intents");

    //create csv from intents
    createCsv();

  }

  private static void createCsv() throws IOException {
    String csvFile = "intent.csv";
    FileWriter writer = new FileWriter(csvFile);

    //columns title
    CSVUtils.writeLine(writer, Arrays.asList("Name", "Action", "User says", "Response"));

    //create input for each intent
    intents.stream().forEach(intent -> {
      try {
        createIntentLine(intent, writer);
      } catch (Exception e) {
        System.out.print("Error createIntentLine " + intent.getName() + " ");
        System.out.println(e);
      }
    });
    writer.flush();
    writer.close();
  }

  private static void createIntentLine(Intent intent, FileWriter writer) throws IOException {
    int max = intent.getUserSays().size();
    if(intent.getResponses().get(0) != null
        && intent.getResponses().get(0).getMessages() != null
        && !intent.getResponses().get(0).getMessages().isEmpty()
        && !intent.getResponses().get(0).getMessages().get(0).getSpeech().isEmpty()
        && max < intent.getResponses().get(0).getMessages().get(0).getSpeech().size()){
      max = intent.getResponses().get(0).getMessages().get(0).getSpeech().size();
    }
    String userSays = null;
    String response = null;

    for(int i = 0; i<max; i++){
      if(intent.getUserSays().size() > i
          && intent.getUserSays().get(i) != null
          && intent.getUserSays().size() > i
          && intent.getUserSays().get(i).getData() != null) {
        userSays = intent.getUserSays().get(i).toString();
      } else {
        userSays = "";
      }
      if(!intent.getResponses().get(0).getMessages().isEmpty()
          && intent.getResponses().get(0).getMessages().get(0).getSpeech() != null
          && !intent.getResponses().get(0).getMessages().get(0).getSpeech().isEmpty()
          && intent.getResponses().get(0).getMessages().get(0).getSpeech().size() > i
          && intent.getResponses().get(0).getMessages().get(0).getSpeech().get(i) != null) {
        response = intent.getResponses().get(0).getMessages().get(0).getSpeech().get(i);
      } else {
        response = "";
      }
      String action =  intent.getResponses().get(0).getAction();
      if(action == null){
        action = "";
      }
      //Improve if multiple responses. Not see in my tests.
      CSVUtils.writeLine(writer, Arrays.asList(intent.getName(),
          action,
          userSays,
          response));
    }
  }

  static public void parseFile(Path path) throws IOException{
    Intent intent = mapper.readValue(path.toFile(), Intent.class);

    intents.add(intent);
  }


  /**
   * agent model
   */
  protected class Agent {

  }

}
