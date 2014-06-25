package core;

import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Denis on 22.06.2014.
 */
public class BDCore {

    private static BDCore bdCore;

    public synchronized static void Init(){
        if (bdCore == null)
            bdCore = new BDCore();
    }

    private BDCore(){
        gotTasks = new ArrayList<Task>();
    }

    public synchronized static boolean performTransaction(BDTransaction transaction){
        Init();
        return transaction.process(bdCore);
    }

    private  ArrayList<Task> gotTasks;

    public Task getNextTask(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task = (Task)session.get(Task.class,new Integer(gotTasks.size()+1));
        gotTasks.add(task);
        return task;
    }

    public HistoryTask getNextHistoryTask(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        HistoryTask historytask = (HistoryTask)session.get(HistoryTask.class,new Integer(1));
        return historytask;
    }

    public void remove(Task task){
        if (gotTasks.contains(task)){
            gotTasks.remove(task);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void addCollection(Collection<ATask> task){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for(ATask o : task)
                session.save(o);
            session.getTransaction().commit();
            System.out.println("saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при работе с базой данных", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
