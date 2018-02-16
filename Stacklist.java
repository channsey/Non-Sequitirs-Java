/**
 * Might add a tail in here later
 * @author CYC
 * @param <E> This works for all pointers to the best of my knowledge
 */
public class StackList <E> {
	private static StackNode head;
	public static int length;
	StackList(StackNode start) {
    	head = start;
    	length = 0;
	}
	void push(E pushy) {
    	if (isEmpty())
        	head = new StackNode(pushy);
    	else {
        	//StackNode temp = head;
        	head.next = new StackNode(pushy);
        	head.next.prev = head;
        	head = head.next;
    	}
    	length++;
	}
	void pop() {
    	if (!isEmpty()){
        	if (length > 1) {
            	StackNode temp = head.prev;
            	head.prev.next = null;
            	head = temp;
        	}
        	else {
            	head = null;
        	}
        	length--;
    	}
	}
	boolean isEmpty() {
    	return (length == 0);
	}
}
//----------------------------------------------------------------------------------------------------------
/**
 * Make own LinkedList class?
 * @author cyc
 * @param <E> should work for all objects
 */
public class CYCQueue<E> {
	private static CYCNode front;
	private static CYCNode back;
	public static int length;
	CYCQueue(E q) {
    	back = new CYCNode(q);
    	length = 0;
	}
	void enqueue(E q) {
    	if (isEmpty()) {
        	front = new CYCNode(q);
        	back = front;
    	}
    	else {
        	back.prev = new CYCNode(q);
        	back.prev.next = back;
        	back = back.prev;
    	}
    	length++;
	}
	void dequeue() {
    	if (!isEmpty()) {
        	if (length > 1) {
            	front.prev.next = null;
            	front = front.prev;
            	length--;
        	}
        	else {
            	front = null;
            	back = null;
        	}
    	}
	}
	boolean isEmpty() {
    	return (length == 0);
	}
}
//---------------------------------------------------------------------------------------------------------------------------
public class CYCNode<E> {
	protected E content;
	protected CYCNode next;
	protected CYCNode prev;
	CYCNode(){
    	content = null;
    	next = null;
    	prev = null;
	}
	CYCNode(E e) {
    	content = e;
    	next = null;
    	prev = null;
	}	 
	E getContent() {
    	return content;
	}
}
//----------------------------------------------------------------
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;
/**
 *
 * @author r85q558
 */
public class JavaApplication1 {
public static void main(String args[])
	{
   	int cPosition = 1;
   	String cName;
   	Client cReference;
   	boolean done = false;
   	CYCQueue<Client> cQueue;
   	cQueue = new CYCQueue(null);
   	String[] choices = {"add client to list", "next", "list full?", "list empty?", "end day"};
   	while (!done) {
        	int choice = JOptionPane.showOptionDialog(
                	null,
                	"Click a choice",
                	"Stack Operations Menu",
                	JOptionPane.YES_NO_CANCEL_OPTION,
                	JOptionPane.QUESTION_MESSAGE,
                	null,
                	choices,
                	choices[0]);
        	try{
            	switch (choice){
            	case 0:
                   	 
                        	cName = JOptionPane.showInputDialog(
                                	"Enter the client's name");
                        	cReference = new Client(cName);
                        	cQueue.enqueue(cReference);
                        	cReference.position = cPosition;
                        	cPosition++;
                        	JOptionPane.showMessageDialog(
                            	null,
                            	cName + "'s position is_" + cReference.position + ".");
                   	 
                    	break;              	 
            	case 1:
                    	if (cQueue.isEmpty()){
                        	JOptionPane.showMessageDialog(
                            	null,
                            	"No clients to help right now");
                    	}
                    	else{
                        	JOptionPane.showMessageDialog(null,
                            	"The first in line is: "
                                	+ ((Client) cQueue.getFront().getContent()).getName()
                                	+ " & this client is number_ "
                                	+ ((Client) cQueue.getFront().getContent()).getPosition() + ".");
                        	cQueue.dequeue();
                    	}
                    	break;
            	case 2:
                    	JOptionPane.showMessageDialog(
                            	null,
                            	"The queue is never full!");
                   	 
                    	break;
            	case 3:
                    	if (cQueue.isEmpty()){
                        	JOptionPane.showMessageDialog(
                            	null,
                            	"The queue is empty!");
                    	}
                    	else {
                        	JOptionPane.showMessageDialog(
                            	null,
                            	"The queue is not empty!");
                    	}
                    	break;
               	 
            	case 4:
                    	done = true;
                    	break;
            	default:
                    	JOptionPane.showMessageDialog(
                            	null,
                            	"Invalid selection; try again!");
            	} //end switch
        	} // end try // end try
        	catch (NoSuchElementException e){
            	JOptionPane.showMessageDialog(
                    	null,
                    	"The Stack is Empty",
                    	"",
                    	JOptionPane.ERROR_MESSAGE);
           	 
        	} // end catch
       	 
   	} // end while
	}
    
}
