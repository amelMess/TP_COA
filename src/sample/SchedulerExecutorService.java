package sample;

/**
 * Created by messadene on 17/01/17.
 */
public interface SchedulerExecutorService {

    void schedule(Update u, int i);

    void call();
}
