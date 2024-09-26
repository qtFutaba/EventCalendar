import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable
{
    LocalDateTime endDateTime;
    String location;
    boolean complete;

    public Meeting(String meetingName, LocalDateTime start, LocalDateTime end, String location)
    {
        this.name=meetingName;
        this.dateTime=start;
        this.endDateTime=end;
        this.location=location;
    }

    @Override
    public void complete()
    {
        this.complete=true;
    }

    @Override
    public boolean isComplete()
    {
        return complete;
    }

    public LocalDateTime getEndDateTime()
    {
        return endDateTime;
    }

    public Duration getDuration()
    {
        return Duration.between(this.dateTime, this.endDateTime);
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
