package src.AB3;
import src.AB3.Provided.BrailleEncoder;
import src.AB3.Provided.BrailleFont;
import src.AB3.Provided.ListNode;
import src.AB3.Provided.TreeNode;

import java.util.Arrays;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the AdvancedLinePrinter, configured with a BrailleLineBuffer, a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
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