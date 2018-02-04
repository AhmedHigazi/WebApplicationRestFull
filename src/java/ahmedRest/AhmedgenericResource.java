/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedRest;

import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ahmed Higazi
 */
@Path("ahmedgeneric")
public class AhmedgenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AhmedgenericResource
     */
    public AhmedgenericResource() {
    }

    /**
     * Retrieves representation of an instance of ahmedRest.AhmedgenericResource
     * @return an instance of java.lang.String
     */
    @Path("xmlName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CivilsRest getXmlName(@PathParam("name") String name) throws SQLException {
        Dbh d = new Dbh();
        CivilsRest re=d.retrieveName(name);
        return re;
    }
    
    @GET
         @Path("xmlId/{ID}")
    @Produces(MediaType.TEXT_XML)
    public CivilsRest getNamess(@PathParam("ID") int id) throws SQLException  {
        
         Dbh dbh = new Dbh();
         CivilsRest civils = dbh.retrieveByid(id);
        
        return civils;
    }  
    
     @GET
         @Path("jsonId/{ID}")
	 @Produces(MediaType.APPLICATION_JSON)
            public String retrieveCivil(@PathParam("ID") int id) throws java.sql.SQLException{
        CivilsRest ob ;
       Dbh dbh = new Dbh();
        ob = dbh.retrieveByid(id);
               Gson gson = new Gson();
        String nameJson = gson.toJson(ob);
        return nameJson; 
    } 
            
            
        @GET
         @Path("jsonName/{name}")
	 @Produces(MediaType.APPLICATION_JSON)
            public String retrieveCivil(@PathParam("name") String name) throws java.sql.SQLException{
        CivilsRest ob ;
       Dbh dbh = new Dbh();
        ob = dbh.retrieveName(name);
              Gson gson = new Gson();
        String nameJson = gson.toJson(ob);
        return nameJson; 
    }

}
