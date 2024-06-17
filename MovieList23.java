public class MovieList23 {
    NodeFilm23 head;
    NodeFilm23 tail;

    public void tambahDataAwal(Film23 film) {
        NodeFilm23 newNode = new NodeFilm23(film);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void tambahDataAkhir(Film23 film) {
        NodeFilm23 newNode = new NodeFilm23(film);
    
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void tambahDataIndexTertentu(int urutan, Film23 film) {
        NodeFilm23 newNode = new NodeFilm23(film);
    
        if (head == null) {
            head = tail = newNode;
            return;
        }
    
        if (urutan <= 1) {
            tambahDataAwal(film);
            return;
        }
    
        NodeFilm23 current = head;
        int counter = 1;
        while (current.next != null && counter < urutan - 1) {
            current = current.next;
            counter++;
        }
    
        if (current.next == null) {
            tambahDataAkhir(film);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void hapusDataPertama() {
        if (head == null) {
            System.out.println("Data film kosong");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void hapusDataTerakhir() {
        if (head == null) {
            System.out.println("Data film kosong");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void hapusDataTertentu(int filmId) {
        NodeFilm23 current = head;
        while (current != null) {
            if (current.film.id == filmId) {
                if (current == head) {
                    hapusDataPertama();
                } else if (current == tail) {
                    hapusDataTerakhir();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Film dengan ID " + filmId + " tidak ditemukan");
    }

    public void cetak() {
        NodeFilm23 current = head;
        int counter = 1;
        while (current != null) {
            System.out.printf("Film ke-%-4d%n", counter);
            System.out.printf("ID Film      : %d%n", current.film.id);
            System.out.printf("Judul Film   : %s%n", current.film.judul);
            System.out.printf("Rating Film  : %.1f%n", current.film.rating);
            System.out.println();
            current = current.next;
            counter++;
        }
    }

    public void cariIDFilm(int idCari) {
        NodeFilm23 current = head;
        int nodeCounter = 1;
        boolean found = false;

        while (current != null) {
            if (current.film.id == idCari) {
                found = true;
                break;
            }
            current = current.next;
            nodeCounter++;
        }

        if (found) {
            System.out.printf("Data ID Film: %d berada di node ke-%d%n", idCari, nodeCounter);
            System.out.println("IDENTITAS:");
            System.out.printf("ID Film      : %d%n", current.film.id);
            System.out.printf("Judul Film   : %s%n", current.film.judul);
            System.out.printf("Rating Film  : %.1f%n", current.film.rating);
        } else {
            System.out.printf("Film dengan ID %d tidak ditemukan%n", idCari);
        }
    }

    public void urutDataRatingFilm_DESC() {
        if (head == null) {
            return;
        }
    
        NodeFilm23 sorted = null;
        NodeFilm23 current = head;
    
        while (current != null) {
            NodeFilm23 next = current.next;
            if (sorted == null || sorted.film.rating < current.film.rating) {
                current.next = sorted;
                if (sorted != null) {
                    sorted.prev = current;
                }
                sorted = current;
                sorted.prev = null;
            } else {
                NodeFilm23 temp = sorted;
                while (temp.next != null && temp.next.film.rating > current.film.rating) {
                    temp = temp.next;
                }
                current.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = current;
                }
                temp.next = current;
                current.prev = temp;
            }
            current = next;
        }
        head = sorted;
        tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
    } 
    
    public void keluar() {
        System.out.println("Terima kasih!");
    }
}
        

    
