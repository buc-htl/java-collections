package data;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int height;

    public Person(String firstName, String lastName, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeight() {
        return height;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + height + " cm)";
    }


    /**
     *  Ob zwei Referenzen dasselbe Objekt repräsentieren, stellt der Vergleichsoperator == fest. Er testet die Identität, nicht jedoch automatisch die inhaltliche Gleichheit.
     *  Wir kennen das von Strings (s1 == s2 vs s1.equals(s2))!
     *
     *  Die Klasse Object implementiert die Methode equals(). Da jede Klasse in Java von Object erbt, besitzt auch jede Klasse diese Methode. Die Standardimplementierung in Object testet
     *  lediglich die Referenzen, also ob zwei Variablen auf das gleiche Objekt zeigen. In diesem Fall ist das Ergebnis von == und .equals() gleich.
     *
     *  Wollen wir einen INHALTLICHEN Vergleich zwischen Objekten müssen wir equals überschreiben. Die Superklasse Object kann ja nicht wissen wann z.B. zwei Personen gleich sind.
     *
     *  Eine Implementierung von equals() sollte immer eine Implementierung von hashCode() bedeuten, denn wenn zwei Objekte equals()-gleich sind, müssen auch die Hashwerte gleich sein.
     *  Bei einer geerbten hashCode()-Methode aus Object ist das aber nicht in jedem Fall erfüllt.
     *
     *  Beim Einfügen in ein Set zuerst immer hashCode() und danach equals() aufgerufen. Wird in hashCode() festgestellt, dass die Objekte unterschiedlich sind
     *  braucht das aufwändigere equals() gar nicht mehr ausgeführt werden.
     *
     *  Man kann sich die Funktion automatisch von IntelliJ generieren lassen!
     *
     * @return true wenn o und this inhaltlich gleich sind
     */
     /*
    @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (height != person.height) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
    }

    /**
     *  Die Klasse Object implementiert die Methode hashCode(). Da jede Klasse in Java von Object erbt, besitzt auch jede Klasse diese Methode.
     *
     *  Die Methode hashCode() soll zu jedem Objekt eine möglichst eindeutige Integerzahl (sowohl positiv als auch negativ) liefern, die das Objekt identifiziert. Diese Ganzzahl heißt Hashcode
     *  beziehungsweise Hash-Wert, und hashCode() ist die Implementierung einer Hash-Funktion.
     *
     *  Nötig sind Hashcodes, wenn die Objekte in speziellen Datenstrukturen untergebracht werden, die nach dem Hashing-Verfahren arbeiten. Datenstrukturen mit Hashing-Algorithmen bieten einen
     *  effizienten Zugriff auf ihre Elemente. Es ist einfacher Zahlen zu vergleichen als ganze Objekte.
     *
     *  Die Default-Implementierung der Klasse Object liefert die interne Speicheradresse des Objekts als Hashwert zurück.
     *
     *  Man kann sich die Funktion automatisch von IntelliJ generieren lassen!
     *
     * @return den Hash-Wert des Objekts
     */
  /*
    @Override
        public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + height;
        return result;
    } */


    /**
     * Methode, die das Comparable Interface definiert und zwei Personen miteinander vergleicht.
     * <p>
     * In so gut wie allen Fällen sollte this.equals(person) auch true sein, wenn compareTo() 0 liefert.
     *
     * @param person Die Person, mit der ich die das aktuelle Objekt vergleichen möchte
     * @return eine negative Zahl wenn dieses Objekt kleiner ist als das übergebene Objekt, 0 wenn sie gleich sind und eine positive Zahl wenn dieses
     * Objekt größer ist.
     */
    @Override
    public int compareTo(Person person) {

        //System.out.println(this.firstName+" "+ person.firstName+" "+this.firstName.compareTo(person.firstName));

        //Wir wollen nach dem Vornamen sortieren und verwenden die compareTo Methode von String
        return this.firstName.compareTo(person.firstName);

    }

}
