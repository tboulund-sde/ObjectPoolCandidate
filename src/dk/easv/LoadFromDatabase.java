package dk.easv;

import java.util.concurrent.ExecutorService;

public class LoadFromDatabase implements Runnable {

    private ExecutorService es;

    public LoadFromDatabase(ExecutorService es)
    {
        this.es = es;
    }

    @Override
    public void run() {
        DummyDbConnection connection = new DummyDbConnection();
        System.out.println("Loading data from database with connection with id: " + connection.getId());
        connection.load();
        es.submit(this);
    }
}
