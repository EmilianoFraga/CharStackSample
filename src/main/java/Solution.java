import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    private static InputStream solutionInputStream = System.in;
    
    public static void main(String[] args) {
        TextFormatter textFormatter = new TextFormatter();
        
        try(Scanner scanner = new Scanner(solutionInputStream)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine()
                        .chars()
                        .forEach(c -> textFormatter.process((char) c));
            }
        } finally {
        	// empty block
        }
        
        textFormatter.flush();
    }

    public static void setInputStream(InputStream is) {
        solutionInputStream = is;
    }
}

class TextFormatter {
    private final static String INDENT_SPACES = "  ";
    private final Deque<Character> openersStack;
    private int indentLevel;
    private final StringBuilder currentLineBuffer;
    
    public TextFormatter() {
        super();
        
        openersStack = new ArrayDeque<>();
        indentLevel = 0;
        currentLineBuffer = new StringBuilder();
    }

    public void process(char aChar) {
        if (isCharOutOfAcceptableRange(aChar))
            return;
        
        if (isCharIncreasingIndent(aChar)) {
            increaseIndent(aChar);
            return;
        }
        
        if (isCharDecreasingIndent(aChar)) {
            decreaseIndent(aChar);
            return;
        }

        insertCharIntoCurrentLine(aChar);
    }

    void flush() {
        flushCurrentLine();
    }

    private boolean isCharOutOfAcceptableRange(char aChar) {
        return (aChar < 0x20 || aChar > 0x7F);
    }

    private boolean isCharIncreasingIndent(char aChar) {
        switch (aChar) {
            case '(':
            case '{':
            case '[':
                return true;
        }
        
        return false;
    }

    private boolean isCharDecreasingIndent(char aChar) {
        switch (aChar) {
            case ')':
            case '}':
            case ']':
                return true;
        }
        
        return false;
    }

    private void increaseIndent(char openerChar) {
        flushCurrentLine();
        
        indentLevel++;

        printIndent();
        
        printContentionChar(openerChar);

        openersStack.push(openerChar);
    }

    private void decreaseIndent(char closerChar) {
        char openerChar = openersStack.pop();
        
        verifyContentionParity(openerChar, closerChar);

        flushCurrentLine();
        
        printIndent();
        
        printContentionChar(closerChar);
        
        indentLevel--;
    }

    private void insertCharIntoCurrentLine(char aChar) {
        currentLineBuffer.append((char)aChar);
    }

    private void verifyContentionParity(char openerChar, char closerChar) {
        boolean hasParity = false;
        
        switch (openerChar) {
            case '(':
                hasParity = closerChar == ')';
                break;
            case '{':
                hasParity = closerChar == '}';
                break;
            case '[':
                hasParity = closerChar == ']';
                break;
        }
        
        if (! hasParity)
            throw new IllegalStateException("Unmatched contentention characters: " + openerChar + " and " + closerChar);
    }

    private void printContentionChar(char aChar) {
        System.out.println((char)aChar);
    }

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++)
            System.out.print(INDENT_SPACES);
    }

    private void flushCurrentLine() {
        if (currentLineBuffer.length() < 1)
            return;
        
        printIndent();

        System.out.println(currentLineBuffer.toString().trim());

        currentLineBuffer.setLength(0);
    }
}
