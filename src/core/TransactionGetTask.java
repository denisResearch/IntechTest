package core;

/**
 * Created by Denis on 25.06.2014.
 */
public class TransactionGetTask implements BDTransaction {

    private Task task;
    public Task getTask(){
        return task;
    }

    @Override
    public boolean process(BDCore core) {
        task = core.getNextTask();
        if (task!=null)
        return true;
        else return false;
    }
}
