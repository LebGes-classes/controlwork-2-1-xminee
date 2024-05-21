package HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMap1Test {
    private HashMap<String, Integer> map;


    @BeforeEach
    void setUp(){
        map = new HashMap<>(4);
    }

    @Test
    void resizing(){
        map.put("BMW m5 f90", 2019);
        map.put("Mazda cx5", 2022);
        map.put("Lambo huracan", 2023);
        map.put("Opel astra", 2004);
        Assertions.assertEquals(8, map.capaciti());
    }

    @Test
    void put(){
        map.put("BMW m5 f90", 2019);
        Assertions.assertTrue(map.containsValue(2019));
    }
    @Test
    void remove(){
        map.put("BMW m5 f90", 2019);
        map.remove("BMW m5 f90");
        Assertions.assertEquals(0, map.size());
    }


    @Test
    void clear(){
        map.put("BMW m5 f90", 2019);
        map.put("Mazda cx5", 2022);
        map.clear();
        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void getValue(){
        map.put("BMW m5 f90", 2019);
        Assertions.assertEquals(2019, map.get("BMW m5 f90"));
    }

    @Test
    void defaultCapacity(){
        HashMap<String, Integer> newMap = new HashMap<>();
        Assertions.assertEquals(16, newMap.getClass());
    }

    @Test
    void size(){
        map.put("BMW m5 f90", 2019);
        Assertions.assertEquals(1, map.size());
    }
}