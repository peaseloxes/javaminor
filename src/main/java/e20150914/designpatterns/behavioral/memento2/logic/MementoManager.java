package e20150914.designpatterns.behavioral.memento2.logic;

import e20150914.designpatterns.behavioral.memento2.domain.Memento;
import e20150914.designpatterns.behavioral.memento2.domain.Original;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 9/16/15.
 */
public class MementoManager {
    @Setter
    @Getter
    private static String fileName;
    private Map<Integer, List<Memento>> mementos;

    public MementoManager(String fileName){
        this.fileName = fileName;
        mementos = new HashMap<>();

    }

    public void addOriginal(Original original) {
        mementos.put(original.getId(), new ArrayList<>());
        try {
            saveToDisk(mementos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(final Original original) throws IOException {
        mementos = loadFromDisk();
        Memento m = original.getMemento();
        mementos.get(original.getId()).add(m);
        saveToDisk(mementos);
    }

    public Memento load(Original o, int i) throws IOException {
        mementos = loadFromDisk();
        return mementos.get(o.getId()).get(i);
    }

    public Map<Integer, List<Memento>> loadFromDisk() throws IOException {
        ObjectInputStream is = null;
        try {
            File file = new File(fileName);
            is = new ObjectInputStream(
                    new FileInputStream(file));
            return (Map<Integer, List<Memento>>) is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(is!=null) {
                is.close();
            }
        }
        return null;
    }

    public void saveToDisk(final Map<Integer, List<Memento>> map) throws IOException {
        ObjectOutputStream os = null;
        try {
            File file = new File(fileName);
            os = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }
}
