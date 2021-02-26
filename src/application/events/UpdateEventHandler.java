package application.events;

import application.events.interfaces.UpdateListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateEventHandler {

    private List<UpdateListener> listeners = new ArrayList<UpdateListener>();

    public void addListener(UpdateListener listener) {
        listeners.add(listener);
    }

    public void Update(){

        for (UpdateListener listener : listeners){
            listener.Update();
        }
    }

    private static UpdateEventHandler instance = null;

    private UpdateEventHandler(){}

    public static UpdateEventHandler getInstance(){
        if (instance == null){
            instance = new UpdateEventHandler();
        }
        return instance;
    }

}
