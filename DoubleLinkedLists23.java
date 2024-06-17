public class DoubleLinkedLists23 {
    Node23 head;
    int size;

    public DoubleLinkedLists23 (){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int item){
        if (isEmpty()) {
            head = new Node23(null, item, null);
        } else {
            Node23 newNode23 = new Node23(null, item, head);
            head.prev = newNode23;
            head = newNode23;
        }
        size++;
    }

    public void addLast(int item){
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node23 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node23 newNode23 = new Node23(current, item, null);
            current.next = newNode23;
            size++;
        }
    }

    public void add(int item, int index) throws Exception{
        if (isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        }else{
            Node23 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node23 newNode23 = new Node23(null, item, current);
                current.prev = newNode23;
                head = newNode23;
            } else {
                Node23 newNode23 = new Node23(current.prev, item, current);
                newNode23.prev = current.prev;
                newNode23.next = current;
                current.prev.next = newNode23;
                current.prev = newNode23;
            }
        }
        size++;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void print(){
        if (!isEmpty()) {
            Node23 tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void removeFirst() throws Exception{
        if (isEmpty()) {
            throw new Exception ("linked list masih kosong, tidak dapat dihapus");
        }else if(size == 1){
            removeLast();
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception{
        if (isEmpty()) {
            throw new Exception ("linked list masih kosong, tidak dapat dihapus");
        }else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node23 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove (int index) throws Exception{
        if (isEmpty() || index >= size) {
            throw new Exception("nilai indeks di luar batas");
        }else if (index == 0) {
            removeFirst();
        }else{
            Node23 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            }else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public int getFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        Node23 tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) throws Exception{
        if(isEmpty() || index >= size){
            throw new Exception ("nilai indeks diluar batas");
        }
        Node23 tmp = head;
        for (int i =0; i<index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
} 