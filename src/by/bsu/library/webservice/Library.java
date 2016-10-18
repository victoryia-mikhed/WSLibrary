package by.bsu.library.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Veronika on 01.10.2016.
 */

@WebService
public class Library {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
}
