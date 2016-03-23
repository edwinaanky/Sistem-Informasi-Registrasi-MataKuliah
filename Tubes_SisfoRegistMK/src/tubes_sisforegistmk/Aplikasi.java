/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author desmoncode
 */
public class Aplikasi {

    Orang userAktif = null;
    private ArrayList<Dosen> daftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> daftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> daftarMatakuliah = new ArrayList<Matakuliah>();

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }

    public void menuSatuAdmin(Kelas k) {
        daftarKelas.add(k);
    }

    public void menuDuaAdmin(Matakuliah mk) {
        daftarMatakuliah.add(mk);
    }

    public Dosen getDosen(int id) {
        return daftarDosen.get(id);
    }

    public Mahasiswa getMahasiswa(int id) {
        return daftarMahasiswa.get(id);
    }

    public Kelas getKelas(int id) {
        return daftarKelas.get(id);
    }

    public Matakuliah getMatakuliah(int id) {
        return daftarMatakuliah.get(id);
    }

    public void deleteDosen(int id) {
        daftarDosen.remove(id);
    }

    public void deleteMahasiswa(int id) {
        daftarMahasiswa.remove(id);
    }

    public void deleteKelas(int id) {
        daftarKelas.remove(id);
    }

    public void deleteMatakuliah(int id) {
        daftarMatakuliah.remove(id);
    }

    public void menuTigaAdmin(Kelas k, Matakuliah mk) {
        k.setMatakuliah(mk);
    }

    public void menuSatuMhs(Mahasiswa m, Kelas k) {

        int jumlah = 0;
        int jml = 0;
        if (m.getJumlahSks() < m.getMaxSks()) {
            if (k.getJmlMhs() < k.getMaxMhs()) {
                jumlah = k.getJmlMhs();
                jumlah++;
                m.addKelas(k);
                jml = m.getJumlahKelas();
                jml = m.getJumlahSks() + k.getMatakuliah().getSks();
                m.setJumlahSks(jml);
            } else {
                System.out.println("Tidak dapat mengambil kelas karena penuh");
            }

        } else {
            System.out.println("Tidak dapat menambahkan kelas karena jumlah sks tidak dapat melebihi " + m.getMaxSks() + " sks");
        }
    }

    public void menuEmpatAdmin(Kelas k, Dosen d) {
        k.setDosen(d);
    }

    public void menuDuaMhs(Mahasiswa m, Kelas k) {
        m.removeKelas(k);
    }

    public ArrayList<Kelas> menuTigaMhs(Mahasiswa m) {
        return m.getAllKelas();
    }

    public void createFile() {
        Mahasiswa mhs = new Mahasiswa(1301141264, 24, "graham", "graham", "Graham Desmon S", "Pria", "PBB", "080888");
        Mahasiswa mhs1 = new Mahasiswa(1301141263, 24, "desmon", "desmon", "Desmon Simanjuntak", "Pria", "PBB", "080888");
        daftarMahasiswa.add(mhs);

        daftarMahasiswa.add(mhs1);

        Dosen d = new Dosen(1, "ICM", "Dosen tetap", "Kurniawan Nur Ramadhani, ST., MT.", "Pria", "abc", "+6282222");
        Dosen d1 = new Dosen(2, "ICM", "Dosen tetap", "DODY QORI UTAMA, S.T., M.T.", "Pria", "abcd", "+62822223");
        daftarDosen.add(d);
        daftarDosen.add(d1);

        Admin admin = new Admin(123, "admin", "admin", "Desmon", "Pria", "Bumi", "0888888");
        admin.setUsernameAdmin("admin");
        admin.setPasswordAdmin("admin");
        try (FileOutputStream fos1 = new FileOutputStream("mahasiswa.txt");
                ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
                FileOutputStream fos2 = new FileOutputStream("dosen.txt");
                ObjectOutputStream obj2 = new ObjectOutputStream(fos2);
                FileOutputStream fos3 = new FileOutputStream("admin.txt");
                ObjectOutputStream obj3 = new ObjectOutputStream(fos3);) {

            obj1.writeObject(daftarMahasiswa);

            obj2.writeObject(daftarDosen);

            obj3.writeObject(admin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menu() {
        if (userAktif == null) {
            System.out.println("APLIKASI REGISTRASI MATA KULIAH");
            System.out.println();
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("0. Keluar Aplikasi");

            System.out.print("Pilih Menu : ");
        } else if (userAktif instanceof Admin) {
            System.out.println();
            System.out.println("11. Tambah Matakuliah");
            System.out.println("12. Hapus Matakuliah");
            System.out.println("13. Cari Matakuliah");
            System.out.println("14. Lihat Daftar Matakuliah");
            System.out.println("15. Tambah Kelas");
            System.out.println("16. Hapus Kelas");
            System.out.println("17. Cari Kelas");
            System.out.println("18. Atur Kelas");
            System.out.println("19. Lihat Daftar Kelas");
            System.out.println("0. Log Out");
            System.out.print("Pilih Menu : ");
        } else if (userAktif instanceof Mahasiswa) {
            System.out.println();
            System.out.println("21. Pilih Kelas");
            System.out.println("22. Remove Kelas");
            System.out.println("23. Show All Kelas");
            System.out.println("0. Log Out");
            System.out.print("Pilih Menu : ");
        }

    }

    public void mainMenu() throws IOException {

        File file1 = new File("mahasiswa.txt");
        File file2 = new File("dosen.txt");
        File file3 = new File("admin.txt");
        if ((file1.exists()) && (file2.exists()) && (file3.exists())) {
            createFile();

        } else {
            createFile();

        }

        int pilihan1 = 1;
        int pilihan2 = 1;
        int pilihan3 = 1;
        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            menu();

            try {
                int menu1 = angka.nextInt();
                String username;
                String password;
                switch (menu1) {
                    case 1:

                        System.out.print("Masukkan Username Admin : ");
                        username = huruf.next();

                        System.out.print("Masukkan Password Admin : ");
                        password = huruf.next();
                        Admin admin = null;

                        try (FileInputStream fis = new FileInputStream(file3);
                                ObjectInputStream ois = new ObjectInputStream(fis);) {

                            admin = (Admin) ois.readObject();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if ((admin != null) && (admin.getUsernameAdmin().equals(username)) && (admin.getPasswordAdmin().equals(password))) {
                            System.out.println("Selamat Datang Admin");
                            userAktif = admin;
                            username = br.readLine();
                            while (pilihan2 != 0) {
                                menu();
                                try {
                                    int menu2 = angka.nextInt();
                                    String kode;
                                    String namaMatkul;
                                    int sks;
                                    int nomor;
                                    String namaKelas;
                                    int maxMhs;
                                    switch (menu2) {
                                        case 11:
                                            System.out.print("Masukkan Kode Mata Kuliah : ");
                                            kode = huruf.next();
                                            System.out.print("Masukkan Nama Mata Kuliah : ");
                                            namaMatkul = br.readLine();
                                            System.out.print("Masukkan Jumlah SKS : ");
                                            sks = angka.nextInt();
                                            Matakuliah mk = new Matakuliah(kode, namaMatkul, sks);
                                            menuDuaAdmin(mk);
                                            System.out.print("Berhasil Ditambahkan");
                                            namaMatkul = br.readLine();
                                            break;

                                        case 12:
                                            System.out.println("Daftar MataKuliah");
                                            int i = 0;
                                            int j = 0;
                                            for (Matakuliah list1 : daftarMatakuliah) {
                                                System.out.print(i + " " + list1.getKode() + " " + list1.getNamaMatkul());

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan Nomor matakuliah yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                deleteMatakuliah(nomor);
                                                System.out.print("Berhasil Di hapus");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 13:
                                            boolean ketemu = false;
                                            i = 0;
                                            j = 0;
                                            for (Matakuliah list1 : daftarMatakuliah) {
                                                System.out.print(i + " " + list1.getKode() + " " + list1.getNamaMatkul());

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan Kode Matakuliah yang ingin dicari : ");
                                                kode = huruf.next();
                                                for (Matakuliah list1 : daftarMatakuliah) {
                                                    if (list1.getKode() == kode) {
                                                        System.out.println("Kode Matakuliah : " + list1.getKode());
                                                        System.out.println("Nama Matakuliah : " + list1.getNamaMatkul());
                                                        System.out.println("Jumlah SKS : " + list1.getSks());

                                                        ketemu = true;
                                                    }
                                                }
                                                if (ketemu == false) {
                                                    System.out.println("Tidak ditemukan matakuliah dengan kode " + kode);
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.print("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;
                                        case 14:
                                            System.out.println("Daftar MataKuliah");
                                            i = 0;
                                            j = 0;
                                            for (Matakuliah list1 : daftarMatakuliah) {
                                                System.out.println(i + " " + list1.getKode() + " " + list1.getNamaMatkul());
                                                i++;
                                                j = 1;
                                            }
                                            if (j == 0) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;
                                        case 15:
                                            Matakuliah mat;
                                            Dosen dos;
                                            System.out.print("Masukkan Nama Kelas : ");
                                            namaKelas = br.readLine();
                                            System.out.print("Masukkan Jumlah Maksimal Mahasiswa : ");
                                            maxMhs = angka.nextInt();
                                            Kelas k = new Kelas(namaKelas, maxMhs);
                                            menuSatuAdmin(k);
                                            System.out.println("Berhasil ditambahkan, silahkan mengeset kelas dan matakuliah terlebih dahulu");
                                            System.out.print("Apakah anda ingin mengeset kelas dan matakuliah ? (Y/N) : ");
                                            kode = huruf.next();

                                            if ("Y".equals(kode) || "y".equals(kode)) {
                                                if (daftarMatakuliah.isEmpty() || daftarDosen.isEmpty()) {
                                                    System.out.println();
                                                    System.out.println("Daftar Matakuliah atau Dosen masih kosong, Silahakan melakukan input terlebih dahulu");
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    System.out.println("Daftar MataKuliah");
                                                    i = 0;
                                                    j = 0;
                                                    for (Matakuliah list1 : daftarMatakuliah) {
                                                        System.out.println(i + " " + list1.getKode() + " " + list1.getNamaMatkul());

                                                        i++;
                                                        j = 1;
                                                    }
                                                    System.out.println();
                                                    System.out.println("Daftar Dosen");
                                                    i = 0;
                                                    j = 0;
                                                    for (Dosen list1 : daftarDosen) {
                                                        System.out.println(i + " " + list1.getNik() + " " + list1.getName());

                                                        i++;
                                                        j = 1;
                                                    }
                                                    System.out.println();
                                                    System.out.print("Nomor Matakuliah yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    mat = getMatakuliah(nomor);
                                                    menuTigaAdmin(k, mat);
                                                    System.out.print("Nomor Dosen yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    dos = getDosen(nomor);
                                                    menuEmpatAdmin(k, dos);
                                                    System.out.println("Berhasil Di Set");
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.println("silahkan melakukan set kelas dan matakuliah pada menu ke 17");
                                                namaMatkul = br.readLine();
                                            }

                                            break;

                                        case 16:
                                            System.out.println("Daftar Kelas");
                                            int l = 0;
                                            int m = 0;
                                            for (Kelas list1 : daftarKelas) {
                                                System.out.print(l + " " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul());

                                                l++;
                                                m = 1;
                                            }
                                            System.out.println();
                                            if (m != 0) {
                                                System.out.print("Masukkan Nomor kela yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                deleteKelas(nomor);
                                                System.out.println("Berhasil Dihapus");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 17:
                                            boolean ada = false;
                                            System.out.print("Masukkan Nama Kelas : ");
                                            namaKelas = huruf.next();
                                            System.out.print("Masukkan Nama Matakuliah : ");
                                            namaMatkul = huruf.next();
                                            for (Kelas list1 : daftarKelas) {
                                                if ((list1.getNamaKelas() == namaKelas) && (list1.getMatakuliah().getNamaMatkul() == namaMatkul)) {
                                                    System.out.println("Nama Kelas : " + list1.getNamaKelas());
                                                    System.out.println("Nama Matakuliah : " + list1.getMatakuliah().getNamaMatkul());

                                                    ada = true;
                                                }
                                            }
                                            if (ada == false) {
                                                System.out.println("Tidak ditemukan");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;

                                        case 18:
                                            Kelas kel;

                                            System.out.println("Daftar Kelas");
                                            l = 0;
                                            m = 0;
                                            if (daftarKelas.isEmpty()) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            } else {
                                                for (Kelas list1 : daftarKelas) {
                                                    if ((list1.getMatakuliah() != null) && (list1.getDosen() != null)) {
                                                        System.out.println(l + " " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getNik());
                                                    } else if (list1.getMatakuliah() == null && list1.getDosen() != null) {
                                                        System.out.println(l + " " + list1.getNamaKelas() + " (Belum ada matkul)" + " " + list1.getDosen().getNik());
                                                    } else if (list1.getDosen() == null && list1.getMatakuliah() != null) {
                                                        System.out.println(l + " " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " (Belum ada dosen)");
                                                    } else {
                                                        System.out.println(l + " " + list1.getNamaKelas() + " (Beluma ada matkul)" + " (Belum ada dosen)");
                                                    }
                                                    l++;
                                                    m = 1;
                                                }

                                                System.out.println();
                                                System.out.print("Masukkan nomor kelas yang ingin diatur : ");
                                                nomor = angka.nextInt();
                                                kel = getKelas(nomor);
                                                if (daftarMatakuliah.isEmpty() || daftarDosen.isEmpty()) {
                                                    System.out.println();
                                                    System.out.println("Daftar Matakuliah atau Dosen masih kosong, Silahakan melakukan input terlebih dahulu");
                                                    
                                                } else {
                                                    System.out.println("Daftar MataKuliah");
                                                    i = 0;
                                                    j = 0;
                                                    for (Matakuliah list1 : daftarMatakuliah) {
                                                        System.out.println(i + " " + list1.getKode() + " " + list1.getNamaMatkul());
                                                        namaMatkul = br.readLine();
                                                        i++;
                                                        j = 1;
                                                    }
                                                    System.out.println();
                                                    i = 0;
                                                    j = 0;
                                                    for (Dosen list1 : daftarDosen) {
                                                        System.out.println(i + " " + list1.getNik() + " " + list1.getName());

                                                        i++;
                                                        j = 1;
                                                    }
                                                    System.out.println();
                                                    System.out.print("Nomor Matakuliah yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    mat = getMatakuliah(nomor);
                                                    menuTigaAdmin(kel, mat);
                                                    System.out.print("Nomor Dosen yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    dos = getDosen(nomor);
                                                    menuEmpatAdmin(kel, dos);
                                                    System.out.println("Berhasil di set");
                                                    namaMatkul = br.readLine();
                                                }
                                            }

                                            break;

                                        case 19:
                                            l = 0;
                                            m = 0;
                                            for (Kelas list1 : daftarKelas) {
                                                if ((list1.getMatakuliah() != null) && (list1.getDosen() != null)) {
                                                    System.out.println(l + " " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getNik());
                                                } else if (list1.getMatakuliah() == null && list1.getDosen() != null) {
                                                    System.out.println(l + " " + list1.getNamaKelas() + " (Belum ada matkul)" + " " + list1.getDosen().getNik());
                                                } else if (list1.getDosen() == null && list1.getMatakuliah() != null) {
                                                    System.out.println(l + " " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " (Belum ada dosen)");
                                                } else {
                                                    System.out.println(l + " " + list1.getNamaKelas() + " (Beluma ada matkul)" + " (Belum ada dosen)");
                                                }
                                                l++;
                                                m = 1;
                                            }
                                            if (m == 0) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;

                                        case 0:
                                            System.out.println("TERIMA KASIH");
                                            userAktif = null;
                                            pilihan2 = 0;
                                            namaMatkul = br.readLine();
                                            break;

                                        default:
                                            System.out.println("Menu tidak ada");
                                            namaMatkul = br.readLine();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Menu Salah");
                                }
                            }
                        } else {
                            System.out.println("Usernama atau Password salah");
                            username = br.readLine();
                        }
                        break;

                    case 2:
                        boolean ada = false;
                        Mahasiswa mah = null;
                        int i = -1;
                        ArrayList<Mahasiswa> daftarMahasiswa = null;
                        try (FileInputStream fis = new FileInputStream(file1);
                                ObjectInputStream ois = new ObjectInputStream(fis);) {

                            daftarMahasiswa = (ArrayList<Mahasiswa>) ois.readObject();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.print("Masukkan Username Mahasiswa : ");
                        username = huruf.next();
                        System.out.print("Masukkan Password Mahasiswa : ");
                        password = huruf.next();

                        for (Mahasiswa list4 : daftarMahasiswa) {
                            if ((list4.getUsernameMhs().equals(username)) && (list4.getPasswordMhs().equals(password))) {
                                ada = true;
                                i++;
                            }
                        }
                        mah = getMahasiswa(i);
                        if (ada == true) {
                            System.out.println("Selamat Datang " + mah.getName());
                            userAktif = mah;
                            username = br.readLine();
                            while (pilihan3 != 0) {
                                menu();
                                try {
                                    int menu3 = angka.nextInt();
                                    String kode;
                                    String namaMatkul;
                                    int sks;
                                    int nomor;
                                    String namaKelas;
                                    int maxMhs;
                                    switch (menu3) {
                                        case 21:
                                            System.out.println("Dafar Kelas");
                                            int l = 0;
                                            int m = 0;
                                            for (Kelas list1 : daftarKelas) {
                                                System.out.print(l + ". " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getName());

                                                l++;
                                                m = 1;
                                            }
                                            System.out.println();
                                            if (m != 0) {
                                                System.out.print("Masukkan Nomor Kelas yang ditambahkan : ");
                                                nomor = angka.nextInt();
                                                menuSatuMhs(mah, getKelas(nomor));
                                                System.out.println("Berhasil ditambahkan");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 22:
                                            System.out.println("Dafar Kelas");
                                            l = 0;
                                            m = 0;
                                            for (Kelas list1 : menuTigaMhs(mah)) {
                                                System.out.print(l + ". " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getName());

                                                l++;
                                                m = 1;
                                            }
                                            System.out.println();
                                            if (m != 0) {
                                                System.out.print("Masukkan Nomor Kelas yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                menuDuaMhs(mah, menuTigaMhs(mah).get(i));
                                                System.out.println("Berhasil dihapus");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 23:
                                            System.out.println("Dafar Kelas");
                                            l = 0;
                                            m = 0;
                                            for (Kelas list1 : menuTigaMhs(mah)) {
                                                System.out.print(l + ". " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getName());

                                                l++;
                                                m = 1;
                                            }
                                            if (m == 0) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;

                                        case 0:
                                            System.out.println("TERIMA KASIH");
                                            userAktif = null;
                                            pilihan3 = 0;
                                            namaMatkul = br.readLine();
                                            break;

                                        default:
                                            System.out.println("Menu tidak ada");
                                            namaMatkul = br.readLine();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Menu Salah");
                                }
                            }
                        } else {
                            System.out.println("Usernama atau Password salah");
                            username = br.readLine();
                        }

                        break;

                    case 0:
                        System.out.println("TERIMA KASIH");
                        pilihan1 = 0;
                        userAktif = null;
                        break;

                    default:
                        System.out.println("Menu tidak ada");
                }
            } catch (InputMismatchException e) {
                System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
            }
        }
    }
}
