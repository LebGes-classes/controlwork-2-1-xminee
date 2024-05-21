import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("BMW x6 M", 2019);
        map.put("Mercedes-Benz G-Class", 2023);
        map.put("Lambo URUS", 2022);
        map.remove("Bmw x5 M");
        System.out.println(map.size());
    }
}