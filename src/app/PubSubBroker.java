package src.app;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import src.interfaces.*;

public class PubSubBroker implements IPubSubBroker {
    private Map<String, List<ISub>> interestMap;

    public PubSubBroker() {
        interestMap = new HashMap<String, List<ISub>>();
    }

    public void send(String topic, Object message) {
        if (interestMap.containsKey(topic)) {
            List<ISub> subs = interestMap.get(topic);
            for (int i = 0; i < subs.size(); i++) {
                subs.get(i).receive(topic, message);
            }
        }
    }

    public void subscribe(String topic, ISub subscriber) {
        if (interestMap.containsKey(topic)) {
            interestMap.get(topic).add(subscriber);
        } else {
            List<ISub> lista = new ArrayList<ISub>();
            lista.add(subscriber);
            interestMap.put(topic, lista);
        }
    }

    public void unSubscribe(String topic, ISub subscriber) {
        if (interestMap.get(topic).size() == 1) {
            interestMap.remove(topic);
        } else {
            interestMap.get(topic).remove(subscriber);
        }
    }

    public void clear(String topic) {
        interestMap.remove(topic);
    }
}