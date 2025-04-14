# EP2 Aufgabenblatt 3

Kernthemen: Liste für lineare und Baum für assoziative Datenstruktur

## Organisatorisches
Abgabe Deadline: 01.04.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 7

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen. Führen Sie keine weiteren eigenen Klassen ein.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie *keine* der vorgegebenen Methodensignaturen. Sie dürfen eigene private Methoden (Helper) einführen, falls benötigt.
* Verändern Sie keine vorgegebenen Programmteile oder Dateien, die mit ```DO NOT EDIT``` gekennzeichnet sind.
* Verändern Sie keine vorgegebenen Variablendeklarationen oder Code-Fragmente, außer den return-Statements in Methoden, die Sie implementieren müssen.
* Sie dürfen zum Kopieren von Arrays die Methode ```System.arraycopy()``` benutzen.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
In diesem Aufgabenblatt werden Teile der Anwendung aus AB1 und AB2 weiterentwickelt. Alle Informationen zur Domäne können daher, 
wenn benötigt, dem [Angabeblatt von AB1](../AB1/angabe.md) entnommen werden. 

## Aufgabenstellung

Ziel dieser Aufgabe ist die Entwicklung eines dynamischen Eingabe/Ausgabe-Buffers, nun basierend auf einer
einfach-verketteten Liste, sowie eines Braille-Readers, mit dem Brailleschrift-Texte in ASCII-Texte übersetzt werden können.
Zur Übersetzung wird ein Braille-Decoder (das Gegenstück zum bereits entwickelten Encoder) benötigt, der für
diese Aufgabe mittels eines binären Suchbaums zu realisieren ist. Dies ist für ein kleines Alphabet nicht unbedingt
die performanteste Lösung (ein "reverse LUT" wäre hier deutlich schneller), hat aber hier den Zweck den Stoff aus
der Vorlesung zu festigen.

Dazu ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie der Kommentare im Quellcode anzupassen und zu 
vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit ```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [BrailleDecoder.java](../../src/AB3/BrailleDecoder.java)
* [BrailleLinkedList.java](../../src/AB3/BrailleLinkedList.java)
* [BrailleListBuffer.java](../../src/AB3/BrailleListBuffer.java)
* [BrailleReader.java](../../src/AB3/BrailleReader.java)
* [BrailleSymbolTree.java](../../src/AB3/BrailleSymbolTree.java)
* [Application.java](../../src/AB3/Application.java)
* [MCTestAB3.java](../../src/AB3/MCTestAB3.java)

Im Paket/Verzeichnis [Provided](../../src/AB3/Provided) erhalten Sie eine Bibliothek aus bereits implementierten 
Klassen, die Sie benutzen müssen, aber nicht verändern dürfen.

Darüber hinaus erhalten Sie wieder ein Paket/Verzeichnis [Interfaces](../../src/AB3/Interfaces) mit
Interface-Definitionen, die für Sie nicht relevant sind und die auch nicht verändert werden dürfen, 
da diese zur Überprüfung Ihrer Abgabe notwendig sind.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse [Application](../../src/AB3/Application.java).
Dort sind in der Methode ```Application.main()``` alle notwendigen Objekte zu erzeugen und aufzurufen, um die Funktionsweise
der Anwendung zu demonstrieren. So ist bereits ein Anwendungsfall vorgegeben (Schreiben von "Hello World" in den Buffer,
Ausgabe der Brailleschrift auf der Konsole, sowie die Rückübersetzung des Brailleschrift-Texts nach ASCII-Text).
Weitere Anwendungs- wie auch etwaige selbst entwickelte Testfälle sollen dort ebenfalls implementiert werden.

Neben dem [BrailleListBuffer.java](../../src/AB3/BrailleListBuffer.java) ist der [BrailleReader](../../src/AB3/BrailleReader.java)
das Kernstück der Anwendungslogik. Der Reader nutzt den [BrailleDecoder.java](../../src/AB3/BrailleDecoder.java), welcher wiederum
auf einem binären Suchbaum, dem [BrailleSymbolTree.java](../../src/AB3/BrailleSymbolTree.java) aufbaut.

Dieser Suchbaum basiert auf der Überlegung, dass die schon aus AB1 und AB2 bekannte Binärcodierung von Braille-Zeichen als Steuerwort
für das Traversieren des Baums verwendet werden kann. So wird ein Binärcode für ein Braille-Zeichen vom LSB zum MSB hin abgearbeitet
und bestimmt in der zugeordneten Baumebene die Richtung der Traversierung. Das LSB (Bit-Index 0) legt fest ob im Wurzelknoten
(niedrigste Baumebene) nach links (falls das Bit 0 ist) oder nach rechts (falls das Bit 1 ist) traversiert wird,
das Bit mit Index 1 nun dieselbe Vorgehensweise für die nächste Baumebene, usw. Der zu konstruierende und dann für die Suche zu verwendende
Baum hat daher eine Tiefe von 7 (6 Zwischenebenen + Blattebene). Da alle Zwischenknoten und die Wurzel nur Pfadinformation
bedeuten, wird das zu suchende Symbol (ASCII-Buchstabe) nur im Blattknoten vermerkt.

### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB3](../../src/AB3/MCTestAB3.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus. 
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.


### Teilaufgabe 2

Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft, auch jene Methoden die vom Beispielcode in ```Application.main()```
nicht aufgerufen werden.
Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei [Application.java](../../src/AB3/Application.java) 
Änderungen nach Belieben vornehmen. Diese Datei muss für
eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht zur Bewertung herangezogen.

#### Beispielausgabe

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB2/Application.java)

```java
public class Application {
    public static void main(String[] args) {

        // create a font
        BrailleFont font = new BrailleFont(3,2,'o','.', new BrailleEncoder());

        // create a linked list
        BrailleLinkedList list = new BrailleLinkedList();

        // create a list buffer
        BrailleListBuffer brailleListBuffer = new BrailleListBuffer(list);

        // write a message to the buffer
        String message = "Hello World";
        for(char c : message.toCharArray()) {
            brailleListBuffer.push(font.getBitmap(Character.toLowerCase(c)));   // we do not care for any other symbols due to specification
        }

        // get Braille text scanlines
        String[] lines= brailleListBuffer.renderScanlines(4);

        // write them to screen (just for fun)
        if(lines.length>0){
            Arrays.asList(lines).forEach(System.out::println);
        }

        // create a Braille Decoder
        BrailleDecoder decoder=new BrailleDecoder(new BrailleEncoder());

        // create a Braille reader
        BrailleReader reader=new BrailleReader(decoder);

        // translate the braille line back to ASCII
        String asciiText=reader.translate(lines, 'o', 4);

        // and write it to screen :)
        System.out.println(asciiText);

        // TODO: implementation of any developer specific tests (optional)
    }
}
```
folgende Ausgabe am Bildschirm:

```txt
o.    o.    o.    o.    o.    ..    .o    o.    o.    o.    oo    
oo    .o    o.    o.    .o    ..    oo    .o    oo    o.    .o    
..    ..    o.    o.    o.    ..    .o    o.    o.    o.    ..    
hello world
```



