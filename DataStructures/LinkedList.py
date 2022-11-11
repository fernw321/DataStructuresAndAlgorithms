# Node class
class Node:
    # class constructor
    def __init__(self, data):
        self.data = data
        self.next = None

# LinkedList class
class LinkedList:
    # class constructor
    def __init__(self):
        self.head = None

    # append a node with a given value to the end of the list
    def appendNode(self, data):
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            return

        temp = self.head
        while (temp.next):
            temp = temp.next
        temp.next = new_node


    # print all the values of the nodes in the list
    def printList(self):
        temp = self.head
        while (temp):
            print(temp.data,end=" ")
            temp = temp.next

# Start of code execution
if __name__ == '__main__':

    list = LinkedList()
    list.appendNode(1)
    list.appendNode(2)
    list.appendNode(3)
    list.printList


