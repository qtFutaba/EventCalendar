import java.time.LocalDateTime;

public class Deadline extends Event implements Completable
{
    boolean complete;

    public Deadline(String deadlinename, LocalDateTime deadlinetime)
    {
        this.name=deadlinename;
        this.dateTime=deadlinetime;
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
}
