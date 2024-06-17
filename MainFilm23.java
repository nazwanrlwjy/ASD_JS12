import java.util.Scanner;

public class MainFilm23 {
    public static void main(String[] args) {
        MovieList23 movieList = new MovieList23();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=============================");
            System.out.println("   DATA FILM LAYAR LEBAR ");
            System.out.println("=============================");
            System.out.println("         Menu:");
            System.out.println("-----------------------------");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.println("=============================");
            System.out.print("Masukkan pilihan (1-10): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan Data Film Posisi Awal");
                    System.out.print("ID Film          : ");
                    int idAwal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Film       : ");
                    String judulAwal = scanner.nextLine();
                    System.out.print("Rating Film      : ");
                    String ratingInputAwal = scanner.nextLine();
                    double ratingAwal = Double.parseDouble(ratingInputAwal.replace(',', '.'));
                    movieList.tambahDataAwal(new Film23(idAwal, judulAwal, ratingAwal));
                    break;
                case 2:
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    System.out.print("ID Film          : ");
                    int idAkhir = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Judul Film       : ");
                    String judulAkhir = scanner.nextLine();
                    System.out.print("Rating Film      : ");
                    String ratingInputAkhir = scanner.nextLine();
                    double ratingAkhir = Double.parseDouble(ratingInputAkhir.replace(',', '.'));
                    movieList.tambahDataAkhir(new Film23(idAkhir, judulAkhir, ratingAkhir));
                    break;
                case 3:
                    System.out.println("Masukkan Data Film pada Urutan Tertentu");
                    System.out.print("ID Film          : ");
                    int idTertentu = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Film       : ");
                    String judulTertentu = scanner.nextLine();
                    System.out.print("Rating Film      : ");
                    String ratingInputTertentu = scanner.nextLine();
                    double ratingTertentu = Double.parseDouble(ratingInputTertentu.replace(',', '.'));
                    System.out.print("Film ini akan dimasukkan setelah urutan ke-: ");
                    int urutan = scanner.nextInt();
                    movieList.tambahDataIndexTertentu(urutan, new Film23(idTertentu, judulTertentu, ratingTertentu));
                    break;
                case 4:
                    movieList.hapusDataPertama();
                    break;
                case 5:
                    movieList.hapusDataTerakhir();
                    break;
                case 6:
                    System.out.print("Masukkan ID Film yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    movieList.hapusDataTertentu(idHapus);
                    break;
                case 7:
                    System.out.println("Cetak Data");
                    movieList.cetak();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang ingin dicari: ");
                    int idCari = scanner.nextInt();
                    movieList.cariIDFilm(idCari);
                    break;
                case 9:
                    movieList.urutDataRatingFilm_DESC();
                    System.out.println("Data film telah diurutkan secara descending berdasarkan rating.");
                    movieList.cetak();
                    break;
                case 10:
                    movieList.keluar();
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 10);

        scanner.close(); 
    }
}
