import java.time.LocalDateTime;

public class Meeting extends Event implements Completable
{
    LocalDateTime endDateTime;
    String location;

    @Override
    public void complete()
    {
        super.complete();

    }

    @Override
    public boolean isComplete()
    {
        return super.isComplete();
    }

    public LocalDateTime getDateTime()
    {
        return endDateTime;
    }

    public int getDuration()
    {
        return 0;
    }

    public String getLocation()
    {
        return location;
    }

    void setEndDateTime(LocalDateTime endDateTime)
    {
        this.endDateTime = endDateTime;
    }

    void setLocation(String location)
    {
        this.location = location;
    }
}
