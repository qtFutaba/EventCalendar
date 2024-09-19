import java.util.Date;

abstract class Event implements Completable
{
    String name;
    Date dateTime;

    public Event()
    {

    }

    String getName()
    {
        return name;
    }

    Date getDate()
    {
        return dateTime;
    }

    void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }

    void setName(String name)
    {
        this.name = name;
    }

    int compareTo(Event event)
    {
        return 1;
    }


}
