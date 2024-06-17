import java.util.Scanner;

public class VaksinasiAntrian23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList23 antrian = new DoubleLinkedList23();

        while (true) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Menu Awal dan Penambahan Data");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.print("Nomor Antrian: ");
                    int noAntrian = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    System.out.print("Nama Penerima: ");
                    String nama = scanner.nextLine();
                    antrian.enqueue(noAntrian, nama);
                    break;
                case 2:
                    if (!antrian.isEmpty()) {
                        PenerimaVaksin23 removed = antrian.dequeue();
                        System.out.println(removed.getNama() + " telah selesai divaksinasi ");
                    } else {
                        System.out.println("Antrian kosong. Tidak ada data yang bisa dihapus.");
                    }
                    break;
                case 3:
                    System.out.println("Daftar Penerima Vaksin:");
                    antrian.printQueue();
                    System.out.println("Sisa antrian: " + antrian.size());
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}