class LinkedList {
    Node head;  

        // Empty Constructor
        LinkedList() {
        }

        LinkedList(Node node) {
            this.head = node;
        }

        static class Node {
            Node next;
            int data;

            // Empty constructor
            Node() {
            }

            Node(int data) {
                this.data = data;
            }

        }
        
        // Appends a node to the end of the list
        public void appendNode(Node node) {
            if (head == null) {
                this.head = node;
                return;
            } else {
                Node runner = this.head;
                while (runner.next != null) {
                    runner = runner.next;
                }
                runner.next = node;
            }
        }

        // Deletes a node with the matching value
        public void deleteNode(int value) {
            if (head == null) return;
            Node curr = this.head;
            if (curr.data == value) {
                this.head = this.head.next;
            } else {
                while (curr.next != null) {
                    if (curr.next.data == value) {
                        curr.next = curr.next.next;
                        return;
                    }
                    curr = curr.next;
                }
            }
        }

        // Prints all values of nodes in the LinkedList
        public void printLinkedList() {
            if (head == null) return;
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        LinkedList list = new LinkedList(node1);
        list.appendNode(node2);
        list.appendNode(node3);

        list.printLinkedList();
        list.deleteNode(2);
        list.printLinkedList();
    }
    
}


