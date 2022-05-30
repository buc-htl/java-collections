import java.util.ArrayList;


/**
 * Die Klasse SpeakingList soll genauso wie eine ArrayList funktionieren, aber immer eine
 * Meldung auf der Konsole ausgeben, wenn ein Element hinzugefügt wird
 * (zugegebenermaßen ein wenig sinnloser Anwendungsfall, aber es bleibt so ein einfaches Beispiel).
 * <p>
 * Dazu erbt die Klasse von ArrayList. Der gespeicherte Datentyp soll aber dynamisch bleiben und
 * erst beim Erzeugen festgelegt werden.
 * Als Platzhalter für den Datentyp nehmen wir den Buchstaben "T" (steht für "Typ").
 * Üblich sind auch E (Element), K (Key/Schlüssel), V (Value/Wert).
 * Von komplizierteren Platzhaltern ist abzuraten, da sie sonst leicht mit
 * einem konkreten Datentyp verwechselt werden und nicht als Platzhalter gesehen werden.
 *
 * @param <T> Der Datentyp, der in der ArrayList gespeichert wird
 */
public class SpeakingList<T> extends ArrayList<T> {

    public static void runExamples() {
        SpeakingList<Integer> sl1 = new SpeakingList();
        sl1.add(3);
        sl1.add(5);

        SpeakingList<String> sl2 = new SpeakingList<>();
        sl2.add("Semmel");
        sl2.add("Brot");
    }

    // Statt dem konkreten Datentyp wird der Platzhalter T verwendet
    @Override
    public boolean add(T t) {
        System.out.println("Es wird hinzugefügt: " + t.toString());
        return super.add(t);
    }
}
