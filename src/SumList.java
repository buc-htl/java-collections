import java.util.ArrayList;

/**
 * SumList addiert automatisch alle Zahlen, die zur Liste hinzugefügt werden.
 * <p>
 * Da sie eine "spezielle" Liste ist erbt sie von ArrayList.
 * Da nur SumList mit Integer werden erzeugt werden können,
 * erbt sie von ArrayList<Integer>.
 */
public class SumList extends ArrayList<Integer> {

    public static void runExamples() {
        SumList l = new SumList();
        l.add(4);
        l.add(9);
        l.add(2);
        System.out.println(l.getSum());
    }

    private int sum = 0;

    /**
     * Die Methode add von ArrayList wird überschrieben.
     * <p>
     * Mit super.add() rufen wir die Methode der Elternklasse auf.
     */
    @Override
    public boolean add(Integer zahl) {
        sum += zahl;
        return super.add(zahl);
    }

    public int getSum() {
        return sum;
    }


}
