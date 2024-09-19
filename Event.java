import java.time.LocalDateTime;

abstract class Event implements Completable
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

    LocalDateTime getLocalDateTime()
    {
        return dateTime;
    }

    void setLocalDateTimeTime(LocalDateTime dateTime)
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
