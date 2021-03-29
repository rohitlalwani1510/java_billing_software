/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbillingsoftware;

/**
 *
 * @author rohit
 */
public
        class ItemObject {
    private String id,name,cost,active;
    public ItemObject(String id, String name, String cost, String active)
    {
        this.id=id;
        this.name=name;
        this.cost=cost;
        this.active=active;
    }
    public String getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getCost()
    {
        return cost;
    }
    public String isActive()
    {
        if(active.equals("1"))
            return "true";
        return "false";
    }
}
