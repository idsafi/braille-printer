# EP2 Aufgabenblatt 2

Kernthemen: Datenabstraktion mit linearer Datenstruktur über Array

## Organisatorisches
Abgabe Deadline: 25.03.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 5

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen. Führen Sie keine weiteren eigenen Klassen ein.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie keine der vorgegebenen Methodensignaturen. Sie dürfen aber eigene private Methoden (Helper) einführen, falls benötigt.
* Verändern Sie keine vorgegebenen Programmteile oder Dateien, die mit ```DO NOT EDIT``` gekennzeichnet sind.
* Sie dürfen zum Kopieren von Arrays die Methode ```System.arraycopy()``` benutzen.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
In diesem Aufgabenblatt wird die Anwendung aus AB1 weiterentwickelt. Alle Informationen zur Domäne können daher, 
wenn benötigt, dem [Angabeblatt von AB1](../AB1/angabe.md) entnommen werden. 

## Aufgabenstellung

Ziel dieser Aufgabe ist die Erweiterung bzw. die Verbesserung der in AB1 entwickelten Komponenten zur
Verarbeitung von Braille-Schrift um einen dynamischen (atmenden) Eingabe/Ausgabe-Buffer. Dieser Buffer soll im 
Unterschied zu AB1 in der Lage sein, seine Größe bei Bedarf automatisch zu erweitern, um einem Überlauf des Buffers und 
dem damit einhergehenden Datenverlust entgegenzuwirken. Der Buffer soll auch das Einfügen sowie das Löschen
einzelner Braille-Zeichen an beliebigen Positionen innerhalb der gespeicherten Zeichenkette ermöglichen. Um mit dem 
Arbeitsspeicher möglichst effizient umzugehen, soll der Buffer bei Unterschreiten eines vorgegebenen Füllgrades seine
Größe auch wieder reduzieren können.

Dazu ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie den Kommentaren im Quellcode anzupassen und zu 
vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit ```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [BrailleLineBuffer.java](../../src/AB2/BrailleLineBuffer.java)
* [AdvancedLinePrinter.java](../../src/AB2/AdvancedLinePrinter.java)
* [Application.java](../../src/AB2/Application.java)
* [MCTestAB2.java](../../src/AB2/MCTestAB2.java)

Alle anderen Dateien dürfen nicht verändert werden. Darüber hinaus findet Sie bei manchen Klassendefinitionen eine
```implements```-Klausel. Was diese genau bewirkt, muss noch nicht bekannt sein. Das Konzept dahinter wird erst später
im Lauf der Lehrveranstaltung behandelt. Da die Klausel aber für die Verarbeitung der Beispielabgabe notwendig ist,
darf sie nicht verändert oder entfernt werden.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse [Application](../../src/AB2/Application.java).
Dort sind in der Methode ```Application.main()``` alle notwendigen Objekte zu erzeugen und aufzurufen, um die Funktionsweise
der Anwendung zu demonstrieren. So sind bereits ein Anwendungsfall (Ausgabe von "Hello World" in den Buffer,
Ändern des Bufferinhalts zum Text "hear my word", sowie die Ausgabe auf die Konsole, gefolgt von der Ausgabe "OK") vorgegeben.
Weitere Anwendungs- wie auch etwaige selbst entwickelte Testfälle sollen dort ebenfalls implementiert werden.

Das Kernstück der Anwendungslogik ist das Brailleschrift-Ausgabegerät [AdvancedLinePrinter](../../src/AB2/AdvancedLinePrinter.java).
Dieser stellt Methoden zur Verfügung, mit denen ASCII-codierte Textzeichen in Brailleschrift ausgegeben werden können. Aufgrund der Beschaffenheit
der Brailleschrift (jedes Zeichen wird mittels einer Matrix (3 Zeilen x 2 Spalten) aus Punkten und Leerstellen dargestellt)
wird eine Textzeile in Brailleschrift dabei auf mehrere Bildschirmtextzeilen mit ASCII-Symbolen für Punkte und Leerstellen
abgebildet. Dazu verwendet der AdvancedLinePrinter die Klasse [BrailleLineBuffer.java](../../src/AB2/BrailleLineBuffer.java),
um ausgabefähige Symbole in mehrzeiliger Braille-Notation zu erhalten, verwendet der [AdvancedLinePrinter](../../src/AB2/AdvancedLinePrinter.java)
die bereits aus AB1 bekannte Klasse [BrailleFont](../../src/AB2/BrailleFont.java). 

Die Klasse [BrailleLineBuffer.java](../../src/AB2/BrailleLineBuffer.java) realisert den geforderten dynamischen Ausgabe-Buffer
mit Funktionalität zum Bearbeiten des Bufferinhalts: 
* Anfügen eines Zeichens an den bestehenden Inhalt
* Einfügen eines Zeichens in den bestehenden Inhalt
* Löschen eines Zeichens aus dem bestehenden Inhalt

### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Für dieses Aufgabenblatt wird der MC-Test bereits so bereitgestellt,
wie dies auch bei den Tests erfolgen wird. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB2](../../src/AB2/MCTestAB2.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus. 
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.


### Teilaufgabe 2

Entfernen Sie Kommentarzeichen bei mit ```TODO: uncomment declaration``` gekennzeichneten Deklarationen. 
Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft. Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei Application.java Änderungen nach Belieben vornehmen. Diese Datei muss für
eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht zur Bewertung herangezogen.

#### Beispielausgabe

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB2/Application.java)

```java
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LineBuffer lineBuffer = new BrailleLineBuffer(3, 1.5, 0.3);
        AdvancedLinePrinter lp = new AdvancedLinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                4,
                lineBuffer
        );

        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());
        lp.printString("Hello");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString(" World");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        System.out.println("modifying buffer...");
        lp.deleteCharacter(2);
        lp.insertCharacter(2, 'a');
        lp.deleteCharacter(3);
        lp.insertCharacter(3, 'r');
        lp.deleteCharacter(4);
        lp.deleteCharacter(8);
        lp.insertCharacter(5, 'm');
        lp.insertCharacter(6, 'y');
        lp.insertCharacter(7, ' ');
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString("OK");
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
    }
}
```
folgende Ausgabe am Bildschirm:

```txt
buffer size: 3,  characters in buffer: 0
buffer size: 5,  characters in buffer: 5
buffer size: 12,  characters in buffer: 11
modifying buffer...
buffer size: 12,  characters in buffer: 12
o.    o.    o.    o.    ..    oo    oo    ..    .o    o.    o.    oo
oo    .o    ..    oo    ..    ..    .o    ..    oo    .o    oo    .o
..    ..    ..    o.    ..    o.    oo    ..    .o    o.    o.    ..
buffer size: 3  characters in buffer: 0
buffer size: 3  characters in buffer: 2
o.    o.
.o    ..
o.    o.
```
### Zusatzaufgabe

Überlegen Sie sich folgende Frage (diese wird in der Übung diskutiert):

* Entspricht Ihre Implementierung vom ```LineBuffer``` ([BrailleLineBuffer.java](../../src/AB2/BrailleLineBuffer.java)) der einer Map (wie in der Vorlesung besprochen)?

Begründen Sie Ihre Antwort mit den entsprechenden fachlichen Argumenten.
   



