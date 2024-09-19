public interface Completable
{
    default void complete()
    {

    }
    default boolean isComplete()
    {
        return true;
    }
}
