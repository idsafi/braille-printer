package src.AB3;
// Bitte beantworten Sie die Multiple-Choice-Fragen.

public class MCTestAB3 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTestAB3 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "n sei eine Referenz auf einen Knoten (Typ 'Node') in einer einfach verketteten Liste\n" +
                                "mit mindestens einem existierenden Nachfolger (in der Objektvariablen 'next').\n" +
                                "Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von n\n" +
                                "aus einer Liste, ändern sonst aber nichts?",

                        new Choice(false, "n.next.next.next = n.next.next;                                               (1A)"),
                        new Choice(false, "n.next.next = n.next;                                                         (1B)"),
                        new Choice(false, "Node g = n.next; n.next = g.next;                                             (1C)"),
                        new Choice(false, "n.next = n.next.next;                                                         (1D)"),
                        new Choice(false, "Node k = n.next.next; k.next = n;                                             (1E)")
                ),

                new Question(
                        "v sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                                "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                                "    STree v = new STree(); v.add(7); v.add(8); v.add(4);\n" +
                                "Welche der folgenden Aussagen treffen auf v zu?",

                        new Choice(false, "Der Knoten mit Wert 8 ist ein Blattknoten.                                    (2A)"),
                        new Choice(false, "Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (2B)"),
                        new Choice(false, "Der Knoten mit Wert 7 hat zumindest ein Kind.                                 (2C)"),
                        new Choice(false, "Der Knoten mit Wert 7 ist die Wurzel.                                         (2D)"),
                        new Choice(false, "Der Knoten mit Wert 8 ist Elter von dem mit Wert 7.                           (2E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle
            " 1. n sei eine Referenz auf einen Knoten (Typ 'Node') in einer einfach verketteten Liste\n" +
                    "    mit mindestens einem existierenden Nachfolger (in der Objektvariablen 'next').\n" +
                    "    Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von n\n" +
                    "    aus einer Liste, ändern sonst aber nichts?\n" +
                    "    \n" +
                    "    XXXXXXXXX n.next.next.next = n.next.next;                                               (1A)\n" +
                    "    XXXXXXXXX n.next.next = n.next;                                                         (1B)\n" +
                    "    XXXXXXXXX Node g = n.next; n.next = g.next;                                             (1C)\n" +
                    "    XXXXXXXXX n.next = n.next.next;                                                         (1D)\n" +
                    "    XXXXXXXXX Node k = n.next.next; k.next = n;                                             (1E)\n" +
                    "\n" +
                    " 2. v sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                    "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                    "        STree v = new STree(); v.add(7); v.add(8); v.add(4);\n" +
                    "    Welche der folgenden Aussagen treffen auf v zu?\n" +
                    "    \n" +
                    "    XXXXXXXXX Der Knoten mit Wert 8 ist ein Blattknoten.                                    (2A)\n" +
                    "    XXXXXXXXX Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (2B)\n" +
                    "    XXXXXXXXX Der Knoten mit Wert 7 hat zumindest ein Kind.                                 (2C)\n" +
                    "    XXXXXXXXX Der Knoten mit Wert 7 ist die Wurzel.                                         (2D)\n" +
                    "    XXXXXXXXX Der Knoten mit Wert 8 ist Elter von dem mit Wert 7.                           (2E)\n" +
                    "\n";

    public static final long UID = 1775028487904325L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}
