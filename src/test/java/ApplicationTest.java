import fr.stephane.castrec.Application;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Created by SCA on 29/05/2017.
 */
public class ApplicationTest {

  @Test
  public void test1() {
    String[] s = new String[1];
    s[0] = "/Users/administrateur/Downloads/CMX/";
    try {
      Application.main(s);
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
  }
}
