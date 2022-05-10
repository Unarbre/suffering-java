package grx.dod.demo.tp.datastructures.generic;

import java.util.HashMap;

public class Datatype {

    String type;
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

    @Override
    public String toString() {
        return "Datatype{" +
                "type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}
