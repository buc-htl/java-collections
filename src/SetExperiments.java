import data.Person;
import data.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * Ein Set ist eine (meist) ungeordnete Sammlung von Elementen. Jedes Element darf nur einmal vorkommen.
 * <p>
 * Die Java API stellt uns folgende Implementierungen zu Verfügung:
 * HashSet: Schnelle Mengenimplementierung durch Hashing-Verfahren (ähnlich `HashMap`)
 * TreeSet: Mengen werden durch balancierte Binärbäume realisiert, die eine Sortierung ermöglichen.
 * LinkedHashSet: Schnelle Mengenimplementierung unter Beibehaltung der Einfügereihenfolge
 */
public class SetExperiments {


    public static void runExamples() {

        Set<Person> p = simpleSetDemo();
        duplicateDemo(p);
        changeElementDemo();
    }


    public static Set<Person> simpleSetDemo() {
        /** Simple Set Demo **/
        System.out.println("\n=== Simple Set Demo ===\n");

        Person p1 = new Person("Susanne", "Sonnenschein", 162);
        Person p2 = new Person("Susanne", "Mondlicht", 181);

        Set<Person> people = new HashSet<>();

        people.add(p1); //liefert true zurück, weil p1 noch nicht im Set ist
        people.add(p2); //liefert true zurück
        people.add(p2); //liefert false zurück, da p2 bereits im Set ist

        System.out.println(people);    //ein Set hat keine doppelten Einträge, die Reihenfolge ist unbestimmt

        return people;
    }

    /**
     * Demonstriert wie Sets mit Duplikaten umgehen.
     * Verwendet equals() und hashCode() -> siehe Klasse Person
     */
    public static void duplicateDemo(Set<Person> people) {

        /** Set - Duplicates Demo **/
        System.out.println("\n=== Set - Duplicates Demo ===\n");
        System.out.println(people);

        Person p3 = new Person("Susanne", "Mondlicht", 181);    //hat genau die gleichen Attribute wie p2!

        //Wenn wir nun p3 zum Set hinzufügen wollen, wird es hinzugefügt oder als Duplikat erkannt?
        System.out.println(people.add(p3));
        System.out.println(people);

        //Dieses Verhalten kann erwünscht sein, oft ist das aber nicht. Wodurch wird bestimmt ob ein Objekt bereits im Set ist?
        //Entferne die Kommentare der Methode hashCode() und der Methode equals() in der Klasse Person und starte das Programm nochmals!
        //Unterschied bemerkt? Lies dazu auch die Java API Dokumentation der add Methode eines Hashsets.

        System.out.println("Entferne p3 vom Set");
        people.remove(p3);
        System.out.println(people);
    }

    /**
     * Demonstiert was passiert wenn wir Element eines Hashsets nach dem Hinzufügen ändern.
     */
    private static void changeElementDemo() {
        System.out.println("\n=== Change Element Demo ===\n");
        Point point1 = new Point(2, 5);
        Point point2 = new Point(17, 32);
        Point point3 = new Point(17, 32);
        Set<Point> points = new HashSet<>();
        System.out.println("point1 hinzufügen: " + points.add(point1));
        System.out.println("point2 hinzufügen: " + points.add(point2));
        System.out.println("point3 hinzufügen: " + points.add(point3));     //wird Punkt 3 hinzugefügt?
        System.out.println(points);

        //Wir ändern point2. Was ist das Ergebnis wenn wir das Set fragen, ob point2 im Set ist?
        point2.setX(100);
        System.out.println("x von point2 auf " + point2.getX() + " geändert");
        System.out.println("beinhaltet das Set point2? " + points.contains((point2)));

        //wird point2 hinzugefügt, obwohl wir ihn bereits in das set hinzugefügt haben?
        System.out.println("point2 hinzufügen: " + points.add(point2));
        System.out.println(points);

        //...equals() entscheidet ob ein Objekt bereits im Set ist oder nicht.
        //Schlussfolgerung: In einem Set gespeicherte Elemente müssen unverändert bleiben. Einerseits sind sie nach einer Änderung vielleicht
        // nicht wiederzufinden, und andererseits können Elemente auf diese Weise doppelt in der Menge vorkommen, was der Philosophie
        // der Schnittstelle widerspricht.
    }

}
