package src.AB2;

public class MCTestAB2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTestAB2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "d sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                                "und Werte vom Typ 'String' sind (und 'null' sein können).  X und E seien zwei\n" +
                                "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                                "folgenden Aufruf-Sequenzen liefert 'd.get(X)' den String in E als Ergebnis?",

                        new Choice(false, "d.put(X, E); d.put(X, X); d.put(d.get(X), d.get(E));                          (1A)"),
                        new Choice(false, "d.put(X, E); d.put(X, X); d.put(E, X);                                        (1B)"),
                        new Choice(false, "d.put(X, E); d.put(d.get(E), d.get(X)); d.put(E, X);                          (1C)"),
                        new Choice(false, "d.put(d.get(X), d.get(E)); d.put(X, X); d.put(E, E);                          (1D)"),
                        new Choice(false, "d.put(X, X); d.put(d.get(X), d.get(E)); d.put(E, E);                          (1E)")
                ),

                new Question(
                        "b sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                                "Nach welchen der folgenden Aufruf-Sequenzen liefert 'b.peek()' die Zahl 5 als Ergebnis?",

                        new Choice(false, "b.push(4); b.push(b.pop()); b.push(5);                                        (2A)"),
                        new Choice(false, "b.push(5); b.push(4); b.push(b.pop());                                        (2B)"),
                        new Choice(false, "b.push(5); b.push(4); b.push(8);                                              (2C)"),
                        new Choice(false, "b.push(4); b.push(5); b.push(b.pop());                                        (2D)"),
                        new Choice(false, "b.push(4); b.push(b.peek()); b.push(5);                                       (2E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle
            " 1. d sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                    "    und Werte vom Typ 'String' sind (und 'null' sein können).  X und E seien zwei\n" +
                    "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                    "    folgenden Aufruf-Sequenzen liefert 'd.get(X)' den String in E als Ergebnis?\n" +
                    "    \n" +
                    "    XXXXXXXXX d.put(X, E); d.put(X, X); d.put(d.get(X), d.get(E));                          (1A)\n" +
                    "    XXXXXXXXX d.put(X, E); d.put(X, X); d.put(E, X);                                        (1B)\n" +
                    "    XXXXXXXXX d.put(X, E); d.put(d.get(E), d.get(X)); d.put(E, X);                          (1C)\n" +
                    "    XXXXXXXXX d.put(d.get(X), d.get(E)); d.put(X, X); d.put(E, E);                          (1D)\n" +
                    "    XXXXXXXXX d.put(X, X); d.put(d.get(X), d.get(E)); d.put(E, E);                          (1E)\n" +
                    "\n" +
                    " 2. b sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                    "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'b.peek()' die Zahl 5 als Ergebnis?\n" +
                    "    \n" +
                    "    XXXXXXXXX b.push(4); b.push(b.pop()); b.push(5);                                        (2A)\n" +
                    "    XXXXXXXXX b.push(5); b.push(4); b.push(b.pop());                                        (2B)\n" +
                    "    XXXXXXXXX b.push(5); b.push(4); b.push(8);                                              (2C)\n" +
                    "    XXXXXXXXX b.push(4); b.push(5); b.push(b.pop());                                        (2D)\n" +
                    "    XXXXXXXXX b.push(4); b.push(b.peek()); b.push(5);                                       (2E)\n" +
                    "\n";

    public static final long UID = 1775027874324078L;

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

