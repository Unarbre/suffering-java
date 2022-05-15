package grx.dod.demo.tp.datastructures.generic.Formes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Datatype {

    public String type;
    private final HashMap<String, Object> map;

    public Datatype(HashMap<String, Object> map, String type) {
        this.map = map;
        this.type = type;
    }

    public HashMap<String, Object> getValues() {
        return map;
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public String getString(String key) {
        return (String) this.map.get(key);
    }


    public HashSet<String> getStringHashSet(String key) {
        return (HashSet<String>) this.map.get(key);
    }

    public int getInteger(String key) {
        return Integer.parseInt(this.map.get(key).toString());
    }

    public double getDouble(String key) {
        return Double.parseDouble(this.map.get(key).toString());
    }


    public void update(String key, Object value) {
        this.map.put(key, value);
    }

    @Override
    public String toString() {
        return "Datatype{" +
                "type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}
