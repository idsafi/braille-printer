# EP2 Aufgabenblatt 1

Kernthemen: Objekt- vs. Klassen-Methode, Data-Hiding, Konstruktor, Datensatz

## Organisatorisches
Abgabe Deadline: 18.03.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 5

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen.
* Führen Sie keine weiteren eigenen Klassen ein.
* Verändern Sie keine Methodensignaturen, außer an mit ```@TODO``` gekennzeichneten Stellen, 
an denen Sie die Access Modifier (und nur diese!) anpassen sollen.
* Achten Sie darauf, ob für eine Methode Einschränkungen existieren oder nicht. Handeln Sie entsprechend.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
### Brailleschrift

Brailleschrift ist eine Schriftart, die bereits 1825 vom Franzosen Louis Braille entwickelt wurde, und
die blinden Menschen das Lesen von geschriebenen Texten ermöglicht. Einzelne Symbole, wie Buchstaben,
Ziffern, aber auch Sonderzeichen, werden dabei mit sogenannten Braillezellen dargestellt.
Eine [Braillezelle](#braillezelle) ist eine geometrische Anordnung von Punkten, typischerweise in Form
eine Matrix mit 2 Spalten und 3 Zeilen.

Heutzutage existieren verschiedene Varianten der Brailleschrift, die sich in erster Linie in der Anzahl der darstellbaren
Zeichen, Silben und Symbole unterscheiden. Für diese Übung wird eine vereinfachte Form der sogenannten *Basisschrift*
herangezogen. Mehr allgemeine Informationen zum Thema Brailleschrift findet sich beispielsweise in
der [Wikipedia](https://de.wikipedia.org/wiki/Brailleschrift).


### Braillezelle

Eine Braillezelle ist der Grundbaustein der Brailleschrift und entspricht in den meisten Fällen einem Buchstaben.
Da die Brailleschrift eine Blindenschrift ist, bestehen ihre Symbole nicht aus grafischen Strichen, Bögen und Punkten,
sondern vielmehr aus einer Anordnung von ertastbaren Punkten in einem vorgegebenen Raster.

Für die Braille-Basisschrift hat dieses Raster (bzw. diese Matrix) die Ausprägung 2x3, also 2 Spalten und 3 Zeilen.
Dabei kann je nach Zeichen in jeder Zelle des Rasters ein Punkt gesetzt sein, oder auch nicht.
Ein nicht gesetzter Punkt entspricht damit einer leeren Zelle im Raster. Für einen systematischen Aufbau der
einzelnen Zeichen werden nun alle Zellen des Rasters durchnummeriert. Dazu gilt folgendes Schema:

|         |  Spalte 1  | Spalte 2 |
|---------|:----------:|:--------:|
| Zeile 1 |     1      |    4     |
| Zeile 2 |     2      |    5     |
| Zeile 3 |     3      |    6     |

Dem ASCII-Buchstabe '*r*' entspricht beispielsweise die Braillezelle mit einem Punkt an Position 1, 2, 3, und 5.
Da die Ausgabe in dieser Lehrveranstaltung auf einem normalen Bildschirm in der Konsole erfolgt, wird hier ein
gesetzter Punkt durch das Zeichen 'o' dargestellt, ein nicht gesetzter durch '.':

```txt
o.
oo
o.
```

#### Braille Binary Encoding
Bei genauerer Betrachtung wird klar, dass Braillezellen effizient in einzelnen Bytes gespeichert werden können.
Dazu wird dem Index jeder Position (1-6) ein Bit (0-5) im Byte zugeordnet. So kann die hier angegebene Braillezelle
des ASCII Buchstabens 'r' in ein Byte mit dem Wert ```0b010111``` encodiert werden:
da die Positionen 1, 2, 3, und 5 einen Punkt enthalten, werden die Bits 0,1,2 und 4 gesetzt.

Eine systematisierte Tabelle mit allen Braillezellen der Basisschrift kann zum Beispiel
im Artikel zur Brailleschrift der Wikipedia unter
[Systematik des Punktaufbaus](https://de.wikipedia.org/w/index.php?title=Brailleschrift#Systematik_des_Punkteaufbaus)
gefunden werden.



## Aufgabenstellung

Für diese Aufgabe ist eine Anwendung zu entwickeln, die Texte im ASCII-Format in Braille-Schrift, 
eine Form von Blindenschrift, übersetzen und ausgeben kann. In der Realität würde die Ausgabe von
Brailleschrifttexten auf eigenen Geräten, sogenannten Braillezeilen oder Brailledisplays, stattfinden.
Für den Zweck dieser Übung wird ein derartiges Ausgabegerät mittels einer eigenen Klasse (```LinePrinter```) emuliert,
wodurch alle Ausgaben auf der Konsole (Standard Out) anstelle einer echten ertastbaren Braillezeile erfolgen werden.

Dazu ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie den Kommentaren im Quellcode anzupassen und zu vervollständigen.
Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit ```@TODO``` gekennzeichnet. 

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [BrailleEncoder.java](../../src/AB1/BrailleEncoder.java)
* [BrailleFont.java](../../src/AB1/BrailleFont.java)
* [LinePrinter.java](../../src/AB1/LinePrinter.java)
* [Application.java](../../src/AB1/Application.java)

Alle anderen Dateien dürfen nicht verändert werden. Darüber hinaus findet Sie bei manchen Klassendefinitionen eine 
```implements```-Klausel. Was diese genau bewirkt, muss noch nicht bekannt sein. Das Konzept dahinter wird erst später 
im Lauf der Lehrveranstaltung behandelt. Da die Klausel aber für die Verarbeitung der Beispielabgabe notwendig ist,
darf sie nicht verändert oder entfernt werden. 

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse [Application](../../src/AB1/Application.java). 
Dort sind in der Methode {@code Application.main()} alle notwendigen Objekte zu erzeugen und aufzurufen, um die Funktionsweise
der Anwendung zu demonstrieren. So ist bereits ein Anwendungsfall (Ausgabe von "Hello World" in der Konsole) vorgegeben.
Weitere Anwendungs- wie auch etwaige selbst entwickelte Testfälle sollen dort ebenfalls implementiert werden.

Das Kernstück der Anwendungslogik ist das Brailleschrift-Ausgabegerät [LinePrinter](../../src/AB1/LinePrinter.java). Dieser stellt Methoden
zur Verfügung, mit denen ASCII-codierte Textzeichen in Brailleschrift ausgegeben werden können. Aufgrund der Beschaffenheit
der Brailleschrift (jedes Zeichen wird mittels einer Matrix (3 Zeilen x 2 Spalten) aus Punkten und Leerstellen dargestellt)
wird eine Textzeile in Brailleschrift dabei auf mehrere Bildschirmtextzeilen mit ASCII-Symbolen für Punkte und Leerstellen
abgebildet. Um ausgabefähige Symbole in mehrzeiliger Braillenotation zu erhalten, verwendet der [LinePrinter](../../src/AB1/LinePrinter.java)
die Klasse [BrailleFont](../../src/AB1/BrailleFont.java). Eine weitere wesentliche Eigenschaft des Lineprinters ist, dass ausgegeben Zeichen
nicht sofort auf den Bildschirm ausgegeben werden, sondern in einen Buffer geschrieben werden. Dieser Buffer kann zu einem
beliebigen Zeitpunkt durch Aufruf der Methode {@Code LinePrinter.flush()} am Bildschirm ausgegeben (und damit geleert) werden. Die 
Größe des Buffers wird über die Anzahl der maximal aufnehmbaren Symbole, deren Breite (in Spalten), 
sowie der Breite des Abstandes (spacing), ebenfalls in Spalten, zwischen den einzelnen Symbolen berechnet.

Die Klasse BrailleFont repräsentiert den vom [LinePrinter](../../src/AB1/LinePrinter.java) druckbaren Zeichensatz. Dabei enthält ein
BrailleFont-Objekt für vordefinierte Zeichen aus dem Quellalphabet (ASCII) -für diese Aufgabe die Kleinbuchstaben 'a'-'z' sowie
das Leerzeichen- entsprechende für die Bildschirmausgabe aufbereitete mehrzeilige "Bitmaps" aus dem Zielalphabet (Braille Basisschrift).
Diese Bitmaps werden vom BrailleFont-Objekt während dessen Konstruktion vorberechnet und lokal gespeichert.

Die Klasse [BrailleEncoder](../../src/AB1/BrailleEncoder.java) realisiert einen ASCII nach Braille-Binärcode Encoder, der vom BrailleFont genutzt wird um die Bitmaps
für alle im Font enthaltenen Zeichen zu berechnen.

### Teilaufgabe 1
Zur Beantwortung der Multiple-Choice-Fragen können Sie Ihre Antwort eintragen, indem Sie ein 'x' in die
eckigen Klammern vor einer Aussage schreiben, wenn diese Ihrer Meinung nach zutrifft. Zur Verdeutlichung hier ein Beispiel:

* Welche der folgenden Aussagen treffen für EP2 zu?
- [ ] In EP2 werden die physikalischen Grundlagen der Quantencryptographie gelehrt.
- [x] AB1 ist das erste Aufgabenblatt der EP2 Übungen.

Beantworten Sie nun nachfolgende Fragen gewissenhaft. Lesen Sie bei Bedarf dazu auch im Skriptum nach. 

* Frage 1: Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?
- [x] Klassenmethoden haben keinen Zugriff auf Objektvariablen.
- [ ] Aufrufe von 'this(...)' sind in Klassenmethoden möglich.


* Frage 2: Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?
- [x] Datenkapselung und Data-Hiding sind für Datenabstraktion hilfreich aber nicht zwingend nötig.
- [ ] Datenabstraktion verhindert Änderungen von Objektzuständen.

### Teilaufgabe 2

Passen Sie alle Access Modifier an, die mittels @TODO in der vorausgehenden Zeile gekennzeichnet sind.
Betrachten Sie dazu die vorgegebenen Methoden sowie deren Dokumentation und schränken Sie Sichtbarkeiten und
Zugriffsmöglichkeiten durch Verwendung von ```public``` oder ```private``` weitestgehend ein.

Betrachten Sie dazu nur die vorgegebenen Klassen und Methoden und entscheiden Sie anhand der vorgegebenen bzw.
beschriebenen Zugriffe.

### Teilaufgabe 3

Vervollständigen Sie den Lookup-Table ```brailleLUT``` in der Klasse [BrailleEncoder](../../src/AB1/BrailleEncoder.java), sodass
dieser das gesamte Alphabet in Kleinbuchstaben ```[a-z]``` enthält.

### Teilaufgabe 4

Implementieren Sie die mit @TODO gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft. Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei Application.java Änderungen nach Belieben vornehmen. Diese Datei muss für
eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht zur Bewertung herangezogen.

### Beispielausgabe

Bei korrekter Implementierung aller ```@TODOs``` bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB1/Application.java)

```java
public class Application {
    public static void main(String[] args) {
        LinePrinter lp=new  LinePrinter(
                                new BrailleFont(
                                    3, 2,
                                    'o', '.',
                                    new BrailleEncoder() ),
                                20,
                                4
                            );
        lp.printString("Hello World");
        lp.flush();
    }
}
```
folgende Ausgabe am Bildschirm:

```txt
o.    o.    o.    o.    o.    ..    .o    o.    o.    o.    oo
oo    .o    o.    o.    .o    ..    oo    .o    oo    o.    .o
..    ..    o.    o.    o.    ..    .o    o.    o.    o.    ..
```



