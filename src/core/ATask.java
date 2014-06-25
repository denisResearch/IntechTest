package core;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Denis on 22.06.2014.
 */
@MappedSuperclass
public class ATask{
    @Column(name="task_a")
    protected int a;
    @Column(name="task_b")
    protected int b;
    @Column(name="task_c")
    protected int c;
    @Column(name="task_action")
    protected int action;
    @Column(name="task_added")
    protected Date added;
}
