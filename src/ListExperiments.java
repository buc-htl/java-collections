import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Eine Liste steht für eine Sequenz von Daten, bei der die Elemente eine feste Reihenfolge besitzen.
 * Zusätzlich zu den Collection-Methoden enthält das List-Interface Methoden um die Elemente über einen Index, ähnlich zu einem Array,
 * zu manipulieren (siehe https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/List.html).
 * <p>
 * Eine Liste kann Duplikate enthalten.
 * <p>
 * Die Java API implementiert das List-Interface in den Klassen ArrayList und LinkedList
 */
public class ListExperiments {

    public static void runExamples() {

        // Als Datentyp soll immer der möglichst allgemeinste (i.e. weiter oben im UML-Diagramm, Basisklasse] Datentyp
        // verwendet werden. So bleibt der Code am flexibelsten!
        // Daher hat die Variable den Datentyp `List` und nicht `ArrayList`.

        List<Double> list = new ArrayList<>();  //neue ArrayList erzeugen
        list.add(1.1);  //Element hinzufügen
        list.add(3.42); //noch eins

        //Statt einer `ArrayList` können wir auch eine `LinkedList` verwendet.
        //Es handelt sich dabei ledigliche um eine andere Implementierung des `List` Interfaces.
        List<Double> anotherList = new LinkedList<>();
        anotherList.add(-344d);

        //Der Methode sum() ist es egal welche Liste es bekommt. Das Argumenet muss nur das Interface 'List' implementieren
        //und Einträge vom Typ Double haben.
        System.out.println("list:");
        sum(list);
        System.out.println("anotherList:");
        double summe = sum(anotherList);

        //eine neue Liste mit fixen Werten kann man folgendermaßen sehr einfach erzeugen.
        List<Integer> zahlen = new ArrayList<>(Arrays.asList(2, 1, 3));

    }


    public static double sum(List<Double> zahlen) {

        double sum = 0;

        //for-Schleife um alle Zahlen auszugeben
        for (int i = 0; i < zahlen.size(); i++) {
            System.out.println(zahlen.get(i));
        }

        //noch einfacher kann man mit einer for-each Schleife über alle Einträge iterieren
        for (double zahl : zahlen) {
            sum += zahl;
        }

        //Die Elemente können innerhalb einer Schleife gelesen, aber nicht geändert/gelöscht werden (dafür braucht es einen Iterator)!

        return sum;
    }

}
