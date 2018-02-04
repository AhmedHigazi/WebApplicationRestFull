/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedRest;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed Higazi
 */
 @XmlRootElement(name = "AhmedList")
public class CivilsRest {
 
    private List<CivilRest> civils;
    public void setC(List<CivilRest> l){this.civils = l;}
    public List<CivilRest> getCivils(){return this.civils;}
}
