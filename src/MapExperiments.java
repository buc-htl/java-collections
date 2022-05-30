import data.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Ein assoziativer Speicher ("Map") verbindet einen Schlüssel mit einem Wert. Java bietet für Datenstrukturen dieser Art die allgemeine Schnittstelle Map
 * mit wichtigen Operationen wie put(key, value) zum Aufbau einer Assoziation und get(key) zum Erfragen eines assoziierten Wertes.
 * <p>
 * Mit maps kann man immer schnell vom Schlüssel auf den Wert schließen. Umgekehrt ist es weniger effizient und braucht länger.
 */
public class MapExperiments {

    public static void runExamples() {
        simpleHashMapOperations();
        iterations();
        testDifferentMapTypes();
    }


    private static void simpleHashMapOperations() {
        System.out.println("\n=== Hash Map Operations ===\n");

        //Eine Map, die als key einen String hat und als Schlüssel ein double. Da Collections nur Objekte speichern können, verwenden wir die zum primitiven Typ double
        //dazugehörige Java Klasse Double. Java übernimmt alle Umwandlungen automatisch.
        //
        //Natürlich kann man auch eigene Objekte speichern.
        Map<String, Double> priceMap = new HashMap<String, Double>();

        //Elemente hinzufügen
        priceMap.put("Zucchini", 1.2);
        priceMap.put("Brot", 4.8);

        //Um wieder ein Element auszulesen, deklariert Map die Operation get(key). Das Argument identifiziert das zu findende Objekt über den Schlüssel,
        // indem das Objekt aus der Datenstruktur herausgesucht wird, das im Sinne von equals() mit dem Anfrageobjekt gleich ist. Wenn das Objekt nicht vorhanden ist,
        // ist die Rückgabe null. Allerdings kann auch null der mit einem Schlüssel assoziierte Wert sein, da null als Wert durchaus erlaubt ist.
        double price = priceMap.get("Zucchini");
        System.out.println("Preis einer Zucchini: " + price);

        //Neben get() kann auch mit einer anderen Methode das Vorhandensein eines Schlüssels getestet werden: containsKey() überprüft, ob ein Schlüssel in der Tabelle vorkommt,
        // und gibt dann ein true zurück
        System.out.println("Gibt es einen Schlüssel \"Brot\"? " + priceMap.containsKey("Brot"));

        //Es lässt sich auch nur nach den Werten ohne Schlüssel suchen. Dies ist allerdings wesentlich langsamer,
        // da alle Werte der Reihe nach durchsucht werden müssen. Die Klasse bietet hierzu containsValue() an.
        System.out.println("Gibt es einen Wert \"4.8\"? " + priceMap.containsValue(4.8));

        //Zum Löschen eines Elements gibt es remove()
        System.out.println(priceMap);
        System.out.println("Lösche Eintrag mit dem Schlüssel \"Brot\"");
        priceMap.remove("Brot");
        System.out.println(priceMap);

        //Anzahl der Werte in einer Hashmap
        System.out.println("Gespeicherte Werte: " + priceMap.size());

        //ist die Hashmap leer?
        System.out.println("Ist sie leer? " + priceMap.isEmpty());

        //Inhalt der ganzen Map löschen
        priceMap.clear();
        System.out.println("Alle Inhalte gelöscht.");
        System.out.println(priceMap);
    }


    private static void iterations() {
        System.out.println("\n=== Hash Map Iterations ===\n");
        Person p1 = new Person("Susanne", "Sonnenschein", 162);
        Person p2 = new Person("Susanne", "Mondlicht", 181);

        //Wir erstellen eine Map, die als Schlüssel eine Person hat und als Wert das Lieblingsfach
        Map<Person, String> map = new HashMap<>();
        map.put(p1, "GGP");
        map.put(p2, "Deutsch");

        //keySet() liefert die Menge der Schlüssel.
        for (Person key : map.keySet()) {
            System.out.println("Key = " + key + "(V= " + map.get(key) + ")");
        }

        //values() liefert die Menge der Werte.
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }

        //wenn man key und value benötigt, wäre auch möglich...
        for (Map.Entry<Person, String> entry : map.entrySet()) {
            Person key = entry.getKey();
            String subject = entry.getValue();
            System.out.println(key + "/" + subject);
        }

    }


    private static void testDifferentMapTypes() {
        System.out.println("\n=== Test differernt map types ===\n");

        /* To test use HashMap, LinkedHashMap or TreeMap */
        Map<String, String> map = new HashMap();          // keine sichtbare Ordnung
//    	Map<String, String> map = new LinkedHashMap<>();  // merkt sich die Reihenfolge, in der die Elemente in die Map gegeben werden
//      Map<String, String> map = new TreeMap<>(); // benützt das normale "compareTo"
//      Map<String, String> map = new TreeMap<>((a,b) -> b.compareToIgnoreCase(a)); // Reverse-Sortiert

        map.put("Anna", "A");
        map.put("Carmen", "C");
        map.put("Boris", "B");


        System.out.println("map.size():                 " + map.size());                 // 3
        System.out.println("map.toString():             " + map.toString());             // {Carmen=C, Boris=B, Anna=A}

        System.out.println("map.containsKey(\"B\"):       " + map.containsKey("B"));       // true
        System.out.println("map.containsValue(\"Boris\"): " + map.containsValue("Boris")); // true

        System.out.println("map.get(\"Anna\"):            " + map.get("Anna"));            // A
        System.out.println("map.remove(\"Anna\"):         " + map.remove("Anna"));     // A
        System.out.println("map.put(\"Carmen\", \"CX\"):    " + map.put("Carmen", "CX"));    // C - replaced with CX
        System.out.println("map.toString():             " + map.toString());             // {Carmen=CX, Boris=B}

        System.out.println("map.isEmpty():              " + map.isEmpty());              // false

        System.out.println("map.keySet():               " + map.keySet());                   // [Carmen, Boris]
        System.out.println("map.values():               " + map.values());                   // [CX, B]
        System.out.println();

        System.out.print("for (String key: map.keySet()): ");
        for (String key : map.keySet()) {
            System.out.print("(" + key + ": " + map.get(key) + ") ");                        // (Carmen: CX) (Boris: B)
        }
        System.out.println();

        System.out.print("for (Entry<String, String> entry: map.entrySet()): ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("(" + key + ": " + value + ") ");                               // (Carmen: CX) (Boris: B)
        }
        System.out.println();


        Map<String, String> map2 = new HashMap<>();
        map2.put("Otto", "O");
        map2.put("Roman", "R");

        map.putAll(map2);

        System.out.println("map.toString() nach putAll: " + map.toString());

        map.clear();
        System.out.println("map.isEmpty()  nach clear:  " + map.isEmpty());       // true
    }


}
