import java.util.Date;

public class Meeting extends Event implements Completable
{
    Date endDateTime;
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

    public Date getEndDateTime()
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

    void setEndDateTime(Date endDateTime)
    {
        this.endDateTime = endDateTime;
    }

    void setLocation(String location)
    {
        this.location = location;
    }
}
