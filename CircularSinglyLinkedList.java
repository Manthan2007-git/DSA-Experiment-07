import java.util.Scanner;

public class Main {

    static class Node {
        int player;
        Node next;

        Node(int player) {
            this.player = player;
            this.next = null;
        }
    }

    static Node head = null;

    // Insert a player
    static void insert(int player) {
        Node newNode = new Node(player);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Player inserted successfully.");
    }

    // Delete a player
    static void delete(int player) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the first player is deleted
        if (head.player == player) {

            // Only one node
            if (head.next == head) {
                head = null;
            } else {
                Node temp = head;

                while (temp.next != head) {
                    temp = temp.next;
                }

                head = head.next;
                temp.next = head;
            }

            System.out.println("Player deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != head &&
               current.next.player != player) {
            current = current.next;
        }

        if (current.next == head) {
            System.out.println("Player not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Player deleted successfully.");
        }
    }

    // Traverse the circular linked list
    static void traverse() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.print("Players: ");

        do {
            System.out.print(temp.player + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Circular Singly Linked List ---");
            System.out.println("1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Traverse");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter player number: ");
                    int player = sc.nextInt();
                    insert(player);
                    break;

                case 2:
                    System.out.print("Enter player number to delete: ");
                    player = sc.nextInt();
                    delete(player);
                    break;

                case 3:
                    traverse();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}