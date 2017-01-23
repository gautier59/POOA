package drawing;

import java.util.Vector;

/**
 * Created by Quentin on 07/10/2016.
 */
public class ElementCounter {

    private Vector<Observable> observers = new Vector<>();

    int counter = 0;

    public void addObserver(Observable obs){
        observers.add(obs);
    }

    public void removeObserver(Observable obs){
        observers.remove(obs);
    }

    private void notifyObservers(){
        for (Observable obs : observers) {
            obs.update(counter);
        }
    }

    public void reset(){
        counter = 0;
        notifyObservers();
    }

    public void increment(){
        counter++;
        notifyObservers();
    }

    public void decrement(){
        counter--;
        notifyObservers();
    }
}
