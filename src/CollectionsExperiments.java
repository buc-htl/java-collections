import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collection: Super-Interface aller Collectionarten (Set, List,...) https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collection.html
 * <p>
 * Collections: Helper Klasse, die Methoden z.B. zum Sortieren bereit stellt  https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collections.html#addAll(java.util.Collection,T...)
 */
public class CollectionsExperiments {

    public static void runExamples() {

        List<String> names = new ArrayList<>();
        names.add("Zoe");
        names.add("Andreas");
        names.add("Martina");

        System.out.println(names);  //Elemente in der Reihenfolge ihrer Einfügung

        Collections.sort(names);

        System.out.println(names);  //Elemente sortiert

        //Elemente einer Liste nach dem letzten Buchstaben sortieren (gäbe einfachere Möglichkeiten, aber demonstriert gut einen Comparator)
        Collections.sort(names, new Comparator<String>() {
            //returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
            @Override
            public int compare(String o1, String o2) {
                char lastCharO1 = o1.charAt(o1.length() - 1);
                char lastCharO2 = o2.charAt(o2.length() - 1);
                if (lastCharO1 == lastCharO2) {
                    return 0;
                } else if (lastCharO1 < lastCharO2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

    }
}
