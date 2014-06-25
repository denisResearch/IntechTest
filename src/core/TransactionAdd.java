package core;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Denis on 25.06.2014.
 */
public class TransactionAdd implements BDTransaction{

    Collection<ATask> tasks;

    public TransactionAdd(Task task){
        tasks = new ArrayList<ATask>();
        tasks.add(task);
    }

    public TransactionAdd(ArrayList<Task> tasks){
        this.tasks = new ArrayList<ATask>();
        for (Task t : tasks)
            this.tasks.add(t);
    }

    public TransactionAdd(HistoryTask historyTask){
        tasks = new ArrayList<ATask>();
        tasks.add(historyTask);
    }

    @Override
    public boolean process(BDCore core) {
        core.addCollection(tasks);
        return true;
    }
}
