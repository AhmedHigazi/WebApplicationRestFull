/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedRest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
/**
 *
 * @author Ahmed Higazi
 */
public class RestTest {
      
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    public String  getNames() {
       return (service.path("civils").accept(MediaType.TEXT_XML).get(String.class));
    }
    
    public String  getNamesJson() {
      return (service.path("civils").path("json").accept(MediaType.APPLICATION_JSON).get(String.class));
    }
    private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/AhmedWebApplicationRestFull/resources").build();
  }
}
