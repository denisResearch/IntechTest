package core;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by Denis on 19.06.2014.
 */

@Entity
@Table(name="tasks")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Task extends ATask {

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "task_id", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "MySequence")
    @Column(name="task_id")
    private int id;

    public Task(){
        a = 0;
        b = 0;
        c = 0;
        action = 0;
        added = new Date(0);
    }

    public Task(int a,int b,int c,int action){
        this.a = a;
        this.b = b;
        this.c = c;
        this.action = action;
        added = new Date(1);
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public void setC(int c){
        this.c = c;
    }

    public void setAction(int action){
        this.action = action;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getC(){
        return c;
    }

    public int getAction(){
        return action;
    }

    public Date getAdded(){ return added;}
}
