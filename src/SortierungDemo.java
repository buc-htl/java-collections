import data.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortierungDemo {


    /**
     * Demonstriert wie wir eine Reihenfolge in Sets festlegen können.
     * (Anmerkung: Das gleiche Prinzip gilt dann auch für TreeMaps...)
     * <p>
     * Jede Klasse, die das Comparable Interface implementiert, kann auch automatisch von Collections.sort() und Arrays.sort() sortiert werden
     */
    public static void sortOrderDemo() {
        System.out.println("\n=== Sort Order Demo ===\n");

        Person p1 = new Person("Clara", "Lucia", 162);
        Person p2 = new Person("Jose", "Gonzalez", 181);
        Person p3 = new Person("Bob", "Marley", 177);
        Person p4 = new Person("Damian", "Marley", 179);

        //In einem HashSet ist die Reihenfolge unbestimmt. Bei einem Treeset gibt es hingegen eine Ordnung.
        // In einem Treeset werden Daten in einem ausbalancierten Binärbaum gespeichert. Wenn wir ein Element herausnehmen, befinden sich kleinere
        //Elemente im linken Teilbaum (den linken "Kindern" und allen weiteren Knoten), alle größeren im rechten.
        //mehr Infos: http://openbook.rheinwerk-verlag.de/javainsel/16_002.html#u16.2.4

        //Das Treeset muss also von seinen gespeicherten Elementen wissen, wann es größer, kleiner oder gleich als ein anderes Element ist.

        /** Möglichkeit 1: Die Klasse der gespeicherten Elemente implementiert das Comparable Interface (siehe Klasse Person)  **/
        System.out.println("Sortiert mit Comparable Interface...\n");
        Set<Person> personen1 = new TreeSet<>();
        personen1.addAll(Arrays.asList(p1, p2, p3, p4));

        System.out.println(personen1);

        /** Möglichkeit 2: Eine eigene Klasse, die das Comparator Interface implementiert. **/
        // Wir implementieren die Klasse nicht wie gewohnt in einem eigenen File (könnten wir auch), sondern als statische innere Klasse (siehe weiter unten!).
        System.out.println("\nSortiert mit Comparator Interface in einer statischen inneren Klasse...\n");
        Set<Person> personen2 = new TreeSet<>(new ComparatorPerson());
        personen2.addAll(Arrays.asList(p1, p2, p3, p4));

        System.out.println(personen2);

        //Warum sind jetzt nur 3 Elemente im Set?
        //Gibt die Vergleichsmethode compare() 0 zurück, so sind die Elemente gleich, und gleiche Elemente sind in der Menge nicht erlaubt – equals(…) wie beim Hashset wird dabei nicht gefragt!

        /** Möglichkeit 3: Anonyme Klasse - eine Klasse ohne Namen weil direkt nur ein Objekt erzeugt wird  **/
        System.out.println("\nSortiert mit Comparator Interface in einer anonymen Klasse...\n");

        Set<Person> personen3 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                //sortieren nach Größe
                return person1.getHeight() - person2.getHeight();
            }
        });
        personen3.addAll(Arrays.asList(p1, p2, p3, p4));

        System.out.println(personen3);

        //Diese Möglichkeiten eine Ordnung zu definieren, kann nicht nur bei Sets verwendet werden! z.B. Collections.sort()....um Listen zu sortieren, Arrays.sort()...um Arrays zu sortieren

    }


    private static class ComparatorPerson implements Comparator<Person> {


        @Override
        public int compare(Person person1, Person person2) {
            //Wir sortieren diesmal nach Nachnamen...
            return person1.getLastName().compareTo(person2.getLastName());
        }
    }
}
