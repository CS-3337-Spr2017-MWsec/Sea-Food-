package models.practice;

import java.util.Date;

public class GuestBookEntry {

    Integer id;

    String name;

    String message;
    Date date;
    
    
    
    public GuestBookEntry()
    {
    	
    }

    public GuestBookEntry( Integer id, String name, String message )
    {
        this.id = id;
        this.name = name;
        this.message = message;
    }
    
    public GuestBookEntry( Integer id, String name, String message, Date date )
    {
        this.id = id;
        this.name = name;
        this.message = message;
        this.date = date;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

}
