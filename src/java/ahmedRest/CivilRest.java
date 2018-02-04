/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedRest;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Ahmed Higazi
 */
public class CivilRest {
    
    private int id;
    private String fname;
    private String lname;
    private int nnumber ;
   

    public void setId(int x){this.id=x;}
    public void setFname(String x){this.fname=x;}
    public void setLname(String x){this.lname=x;}
    public void setNnumber(int x){this.nnumber=x;}
    
    
    @XmlElement(name = "id")
    public int getId(){return this.id;}
    @XmlElement(name = "fname")
    public String getFname(){return this.fname;}
    @XmlElement(name = "Lname")
    public String getLname(){return this.lname;}
        
     @XmlElement(name = "Nnumber")
     public int getNnumber(){return this.nnumber;}
}
