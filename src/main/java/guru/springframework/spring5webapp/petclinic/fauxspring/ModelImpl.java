package guru.springframework.spring5webapp.petclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelImpl implements Model{

    final Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        //do nothing
    }

    public Map<String, Object> getMap() {
        return map;
    }
}