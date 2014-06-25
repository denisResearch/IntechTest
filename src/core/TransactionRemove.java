package core;

/**
 * Created by Denis on 25.06.2014.
 */
public class TransactionRemove implements BDTransaction {

    Task task;
    public TransactionRemove(Task task){
        this.task = task;
    }

    @Override
    public boolean process(BDCore core) {
        core.remove(task);
        return true;
    }
}
