public class java_linkedlist {
    static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // Head of the list
    Node head = null;

    // Insert at end
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Insert at beginning
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node by value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found in the list.");
        } else {
            current.next = current.next.next;
        }
    }

    // Display the list
    public void printList() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
        java_linkedlist list = new java_linkedlist();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.printList();

        list.deleteByValue(20);
        list.printList();

        list.deleteByValue(100); // Not in list
    }
}
// tree set in java navigable set implementation based in the it provide the unique to store the element  tree mai sthe self blancing hgh trre it hdgbj after so nanat retablibe so many deletion and inseration' it store in tree map in dumping value
// linked hashset is the class in java that implementate the java interface that implement hashset mapp but implement the doublely linked list it is simmilar to hash set but it so handles with entry of double linked list it has the unigue linked hashset insertion of the order that means the order add in this is preversed