class DoubleLinkedList23 {
    public Node head;
    public Node tail;
    public int size;

    public class Node {
        public PenerimaVaksin23 data;
        public Node next;
        public Node prev;

        public Node(PenerimaVaksin23 data) {
            this.data = data;
        }
    }

    public void enqueue(int noAntrian, String nama) {
        PenerimaVaksin23 newPenerima = new PenerimaVaksin23(nama, noAntrian);
        Node newNode = new Node(newPenerima);

        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public PenerimaVaksin23 dequeue() {
        if (head == null) {
            return null;
        }
        PenerimaVaksin23 data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        Node current = head;
        System.out.println("+++++++++++++++++++++++");
        System.out.println("Daftar Pengantri Vaksin");
        System.out.println("+++++++++++++++++++++++");
        if (current == null) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("| Nomor Antrian | Nama Penerima |");
            System.out.println("+++++++++++++++++++++++++++++++++");
            while (current != null) {
                System.out.printf("| %-13d | %-13s |%n", current.data.getNoAntrian(), current.data.getNama());
                current = current.next;
            }
        }
    }
}