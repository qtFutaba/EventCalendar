import java.time.LocalDateTime;

abstract class Event implements Comparable<Event>
{
    String name;
    LocalDateTime dateTime;

    public Event()
    {

    }

    String getName()
    {
        return name;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    void setName(String name)
    {
        this.name = name;
    }


    public int compareTo(Event event)
    {
        return this.dateTime.compareTo(event.getDateTime());
    }

    @Override
    public String toString()
    {
        return name;
    }
}
