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

    public void addKelas(Kelas k) {
        daftarKelas.add(k);
    }

    public void addMatakuliah(Matakuliah mk) {
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

    public void menuSatuAdmin(Matakuliah mk) {
        addMatakuliah(mk);
    }

    public void menuDuaAdmin(int id) {
        deleteMatakuliah(id);
    }

    public Matakuliah menuTigaAdmin(String kode) {
        for (Matakuliah list1 : daftarMatakuliah) {
            if (list1.getKode().equals(kode)) {
                return list1;
            }
        }
        return null;
    }

    public ArrayList<Matakuliah> menuEmpatAdmin() {
        return daftarMatakuliah;
    }

    public void menuLimaAdmin(Kelas k) {
        addKelas(k);
    }

    public void menuEnamAdmin(int id) {
        deleteKelas(id);
    }

    public Kelas menuTujuhAdmin(String namaKelas, String namaMatkul) {
        for (Kelas list1 : daftarKelas) {
            if ((list1.getNamaKelas().equals(namaKelas)) && (list1.getMatakuliah().getNamaMatkul().equals(namaMatkul))) {
                return list1;
            }
        }
        return null;
    }

    public ArrayList<Kelas> menuDelapanAdmin() {
        return daftarKelas;
    }

    public void menuSembilanAdmin(Kelas k, Matakuliah mk) {
        k.setMatakuliah(mk);
    }

    public void menuSembilannAdmin(Kelas k, Dosen d) {
        k.setDosen(d);
    }

    public void menuSepuluhAdmin(Dosen d) {
        addDosen(d);
    }

    public void menuSebelasAdmin(int id) {
        deleteDosen(id);
    }

    public Dosen menuDuaBelasAdmin(long nik) {
        for (Dosen list1 : daftarDosen) {
            if (list1.getNik() == nik) {
                return list1;
            }
        }
        return null;
    }

    public ArrayList<Dosen> menuTigaBelasAdmin() {
        return daftarDosen;
    }

    public void menuEmpatBelasAdmin(Mahasiswa mhs) {
        addMahasiswa(mhs);
    }

    public void menuLimaBelasAdmin(int id) {
        deleteMahasiswa(id);
    }

    public Mahasiswa menuEnamBelasAdmin(long nim) {
        for (Mahasiswa list1 : daftarMahasiswa) {
            if (list1.getNim() == nim) {
                return list1;
            }
        }
        return null;
    }

    public ArrayList<Mahasiswa> menuTujuhBelasAdmin() {
        return daftarMahasiswa;
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
            System.out.println("20. Tambah Dosen");
            System.out.println("21. Hapus Dosen");
            System.out.println("22. Cari Dosen");
            System.out.println("23. Lihat Daftar Dosen");
            System.out.println("24. Tambah Mahasiswa");
            System.out.println("25. Hapus Mahasiswa");
            System.out.println("26. Cari Mahasiswa");
            System.out.println("27. Lihat Daftar Mahasiswa");
            System.out.println("0. Log Out");
            System.out.print("Pilih Menu : ");
        } else if (userAktif instanceof Mahasiswa) {
            System.out.println();
            System.out.println("31. Pilih Kelas");
            System.out.println("32. Remove Kelas");
            System.out.println("33. Show All Kelas");
            System.out.println("0. Log Out");
            System.out.print("Pilih Menu : ");
        }

    }

    public void mainMenu() throws IOException {

        File file1 = new File("mahasiswa.txt");
        File file2 = new File("dosen.txt");
        File file3 = new File("admin.txt");
        File file4 = new File("matakuliah.txt");
        File file5 = new File("kelas.txt");
        if ((file1.exists()) && (file2.exists()) && (file3.exists())) {
            //createFile();

        } else {
            createFile();

        }

        int pilihan1 = 1;

        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            menu();

            try {
                int pilihan2 = 1;
                int pilihan3 = 1;
                int menu1 = angka.nextInt();
                String username;
                String password;
                switch (menu1) {
                    case 1:
                        Admin admin = null;
                        System.out.print("Masukkan Username Admin : ");
                        username = huruf.next();

                        System.out.print("Masukkan Password Admin : ");
                        password = huruf.next();

                        if (file1.exists()) {
                            try (FileInputStream fis = new FileInputStream(file1);
                                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                                daftarMahasiswa = (ArrayList<Mahasiswa>) ois.readObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (file2.exists()) {
                            try (FileInputStream fis = new FileInputStream(file2);
                                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                                daftarDosen = (ArrayList<Dosen>) ois.readObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (file3.exists()) {
                            try (FileInputStream fis = new FileInputStream(file3);
                                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                                admin = (Admin) ois.readObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (file4.exists()) {
                            try (FileInputStream fis = new FileInputStream(file4);
                                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                                daftarMatakuliah = (ArrayList<Matakuliah>) ois.readObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (file5.exists()) {
                            try (FileInputStream fis = new FileInputStream(file5);
                                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                                daftarKelas = (ArrayList<Kelas>) ois.readObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
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
                                    String name;
                                    long nik;
                                    String kk;
                                    String status;
                                    String jenisKelamin;
                                    String alamat;
                                    String telepon;
                                    long nim;
                                    int maxSks;
                                    String usernameMhs;
                                    String passwordMhs;
                                    switch (menu2) {
                                        case 11:
                                            System.out.print("Masukkan Kode Mata Kuliah : ");
                                            kode = huruf.next();
                                            System.out.print("Masukkan Nama Mata Kuliah : ");
                                            namaMatkul = br.readLine();
                                            System.out.print("Masukkan Jumlah SKS : ");
                                            sks = angka.nextInt();
                                            Matakuliah mk = new Matakuliah(kode, namaMatkul, sks);
                                            menuSatuAdmin(mk);
                                            System.out.print("Berhasil Ditambahkan");
                                            try (FileOutputStream fos = new FileOutputStream("matakuliah.txt");
                                                    ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                obj.writeObject(daftarMatakuliah);
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                            namaMatkul = br.readLine();
                                            break;

                                        case 12:
                                            System.out.println("Daftar MataKuliah");
                                            int i = 0;
                                            int j = 0;
                                            for (Matakuliah list1 : daftarMatakuliah) {
                                                System.out.println(i + " " + list1.getKode() + " " + list1.getNamaMatkul());

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan Nomor matakuliah yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                if ((nomor + 1) > daftarMatakuliah.size()) {
                                                    System.out.println("Tidak ada nomor");
                                                } else {
                                                    menuDuaAdmin(nomor);
                                                    try (FileOutputStream fos = new FileOutputStream("matakuliah.txt");
                                                            ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                        obj.writeObject(daftarMatakuliah);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    System.out.print("Berhasil Di hapus");
                                                }
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

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan Kode Matakuliah yang ingin dicari : ");
                                                kode = huruf.next();
                                                if (menuTigaAdmin(kode) != null) {
                                                    System.out.println("Kode Matakuliah : " + menuTigaAdmin(kode).getKode());
                                                    System.out.println("Nama Matakuliah : " + menuTigaAdmin(kode).getNamaMatkul());
                                                    System.out.println("Jumlah SKS : " + menuTigaAdmin(kode).getSks());
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    System.out.println("Tidak ditemukan matakuliah dengan kode " + kode);
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.print("Kosong");
                                                namaMatkul = br.readLine();
                                            }

                                            break;
                                        case 14:
                                            System.out.println("Daftar MataKuliah");
                                            i = 0;
                                            j = 0;
                                            for (Matakuliah list1 : menuEmpatAdmin()) {
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
                                            menuLimaAdmin(k);
                                            try (FileOutputStream fos = new FileOutputStream("kelas.txt");
                                                    ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                obj.writeObject(daftarKelas);
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
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
                                                    if ((nomor + 1) > daftarMatakuliah.size()) {
                                                        System.out.println("Tidak ada nomor");
                                                        namaMatkul = br.readLine();
                                                        break;
                                                    } else {
                                                        mat = getMatakuliah(nomor);
                                                        menuSembilanAdmin(k, mat);
                                                    }
                                                    System.out.print("Nomor Dosen yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    if ((nomor + 1) > daftarDosen.size()) {
                                                        System.out.println("Tidak ada nomor");
                                                        namaMatkul = br.readLine();
                                                        break;
                                                    } else {
                                                        dos = getDosen(nomor);
                                                        menuSembilannAdmin(k, dos);
                                                    }

                                                    System.out.println("Berhasil Di Set");
                                                    try (FileOutputStream fos = new FileOutputStream("kelas.txt");
                                                            ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                        obj.writeObject(daftarKelas);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
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
                                                System.out.print("Masukkan Nomor kelas yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                if ((nomor + 1) > daftarKelas.size()) {
                                                    System.out.println("Tidak ada nomor");
                                                } else {
                                                    menuEnamAdmin(nomor);
                                                    try (FileOutputStream fos = new FileOutputStream("kelas.txt");
                                                            ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                        obj.writeObject(daftarKelas);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    System.out.println("Berhasil Dihapus");
                                                }
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

                                            if (menuTujuhAdmin(namaKelas, namaMatkul) != null) {
                                                System.out.println("Nama Kelas : " + menuTujuhAdmin(namaKelas, namaMatkul).getNamaKelas());
                                                System.out.println("Nama Matakuliah : " + menuTujuhAdmin(namaKelas, namaMatkul).getMatakuliah().getNamaMatkul());
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Tidak ditemukan");
                                                namaMatkul = br.readLine();
                                            }

                                            break;

                                        case 18:
                                            Kelas kel;

                                            System.out.println("Daftar Kelas");
                                            l = 0;
                                            m = 0;
                                            if (menuDelapanAdmin().isEmpty()) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            } else {
                                                for (Kelas list1 : menuDelapanAdmin()) {
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
                                                if ((nomor + 1) > daftarKelas.size()) {
                                                    System.out.println("Tidak ada kelas");
                                                    namaMatkul = br.readLine();
                                                    break;
                                                } else {
                                                    kel = getKelas(nomor);
                                                }
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

                                                    if ((nomor + 1) > daftarMatakuliah.size()) {
                                                        System.out.println("Tidak ada nomor");
                                                        namaMatkul = br.readLine();
                                                        break;
                                                    } else {
                                                        mat = getMatakuliah(nomor);
                                                        menuSembilanAdmin(kel, mat);
                                                    }
                                                    System.out.print("Nomor Dosen yang ingin di set pada kelas : ");
                                                    nomor = angka.nextInt();
                                                    if ((nomor + 1) > daftarDosen.size()) {
                                                        System.out.println("Tidak ada nomor");
                                                        namaMatkul = br.readLine();
                                                        break;
                                                    } else {
                                                        dos = getDosen(nomor);
                                                        menuSembilannAdmin(kel, dos);
                                                    }
                                                    System.out.println("Berhasil di set");
                                                    try (FileOutputStream fos = new FileOutputStream("kelas.txt");
                                                            ObjectOutputStream obj = new ObjectOutputStream(fos);) {
                                                        obj.writeObject(daftarKelas);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    namaMatkul = br.readLine();
                                                }
                                            }

                                            break;

                                        case 19:
                                            l = 0;
                                            m = 0;
                                            for (Kelas list1 : menuDelapanAdmin()) {
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

                                        case 20:
                                            System.out.print("Masukkan Nama Dosen : ");
                                            name = br.readLine();
                                            System.out.print("Masukkan NIK Dosen : ");
                                            nik = angka.nextLong();
                                            System.out.print("Masukkan Kelompok Keahlian Dosen : ");
                                            kk = br.readLine();
                                            System.out.print("Masukkan Status Dosen : ");
                                            status = br.readLine();
                                            System.out.print("Masukkan Jenis Kelamin Dosen : ");
                                            jenisKelamin = br.readLine();
                                            System.out.print("Masukkan Alamat Dosen : ");
                                            alamat = br.readLine();
                                            System.out.print("Masukkan Telepon Dosen : ");
                                            telepon = br.readLine();
                                            Dosen d = new Dosen(nik, kk, status, name, jenisKelamin, alamat, telepon);
                                            if (menuDuaBelasAdmin(nik) == null) {
                                                menuSepuluhAdmin(d);
                                                try (FileOutputStream fos2 = new FileOutputStream("dosen.txt");
                                                        ObjectOutputStream obj2 = new ObjectOutputStream(fos2);) {
                                                    obj2.writeObject(daftarDosen);
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                System.out.print("Berhasil Ditambahkan");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Sudah ada");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 21:
                                            System.out.println("Daftar Dosen");
                                            i = 0;
                                            j = 0;
                                            for (Dosen list1 : daftarDosen) {
                                                System.out.println(i + " " + list1.getNik() + " " + list1.getName());

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan nomor Dosen yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                if ((nomor + 1) > daftarDosen.size()) {
                                                    System.out.println("Tidak ada nomor");
                                                } else {
                                                    menuSebelasAdmin(nomor);
                                                    try (FileOutputStream fos2 = new FileOutputStream("dosen.txt");
                                                            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);) {
                                                        obj2.writeObject(daftarDosen);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    System.out.print("Berhasil Di hapus");
                                                }
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 22:

                                            i = 0;
                                            j = 0;
                                            for (Dosen list1 : daftarDosen) {

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan NIK Dosen yang ingin dicari : ");
                                                nik = angka.nextLong();
                                                if (menuDuaBelasAdmin(nik) != null) {
                                                    System.out.println("NIK Dosen : " + menuDuaBelasAdmin(nik).getNik());
                                                    System.out.println("Nama Dosen : " + menuDuaBelasAdmin(nik).getName());
                                                    System.out.println("Nomor Telepon : " + menuDuaBelasAdmin(nik).getTelepon());
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    System.out.println("Tidak ditemukan NIK dosen " + nik);
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.print("Kosong");
                                                namaMatkul = br.readLine();
                                            }

                                            break;

                                        case 23:
                                            System.out.println("Daftar Dosen");
                                            i = 0;
                                            j = 0;
                                            for (Dosen list1 : menuTigaBelasAdmin()) {
                                                System.out.println(i + " " + list1.getNik() + " " + list1.getName());
                                                i++;
                                                j = 1;
                                            }
                                            if (j == 0) {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            namaMatkul = br.readLine();
                                            break;

                                        case 24:

                                            System.out.print("Masukkan Nama Mahasiswa : ");
                                            name = br.readLine();
                                            System.out.print("Masukkan NIK Mahasiswa : ");
                                            nim = angka.nextLong();
                                            System.out.print("Masukkan Jumlah SKS Maksimal Mahsiswa : ");
                                            maxSks = angka.nextInt();
                                            System.out.print("Masukkan Username Mahasiswa : ");
                                            usernameMhs = br.readLine();
                                            System.out.print("Masukkan Password Mahasiswa : ");
                                            passwordMhs = br.readLine();
                                            System.out.print("Masukkan Jenis Kelamin Mahasiswa : ");
                                            jenisKelamin = br.readLine();
                                            System.out.print("Masukkan Alamat Dosen : ");
                                            alamat = br.readLine();
                                            System.out.print("Masukkan Telepon Dosen : ");
                                            telepon = br.readLine();
                                            Mahasiswa mhs = new Mahasiswa(nim, maxSks, usernameMhs, passwordMhs, name, jenisKelamin, alamat, telepon);
                                            if (menuEnamBelasAdmin(nim) == null) {
                                                menuEmpatBelasAdmin(mhs);
                                                try (FileOutputStream fos2 = new FileOutputStream("mahasiswa.txt");
                                                        ObjectOutputStream obj2 = new ObjectOutputStream(fos2);) {
                                                    obj2.writeObject(daftarMahasiswa);
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                System.out.print("Berhasil Ditambahkan");
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Sudah ada");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 25:
                                            System.out.println("Daftar Mahasiswa");
                                            i = 0;
                                            j = 0;
                                            for (Mahasiswa list1 : daftarMahasiswa) {
                                                System.out.println(i + " " + list1.getNim() + " " + list1.getName());

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan nomor Mahasiswa yang ingin dihapus : ");
                                                nomor = angka.nextInt();
                                                if ((nomor + 1) > daftarMahasiswa.size()) {
                                                    System.out.println("Tidak ada nomor");
                                                } else {
                                                    menuLimaBelasAdmin(nomor);
                                                    try (FileOutputStream fos2 = new FileOutputStream("mahasiswa.txt");
                                                            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);) {
                                                        obj2.writeObject(daftarMahasiswa);
                                                    } catch (Exception e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    System.out.print("Berhasil Di hapus");
                                                }
                                                namaMatkul = br.readLine();
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 26:
                                            i = 0;
                                            j = 0;
                                            for (Dosen list1 : daftarDosen) {

                                                i++;
                                                j = 1;
                                            }
                                            System.out.println();
                                            if (j != 0) {
                                                System.out.print("Masukkan NIM Mahasiswa yang ingin dicari : ");
                                                nim = angka.nextLong();
                                                if (menuEnamBelasAdmin(nim) != null) {
                                                    System.out.println("NIM Mahasiswa : " + menuEnamBelasAdmin(nim).getNim());
                                                    System.out.println("Nama Mahasiswa : " + menuEnamBelasAdmin(nim).getName());
                                                    System.out.println("Username Mahasiswa : " + menuEnamBelasAdmin(nim).getUsernameMhs());
                                                    System.out.println("Password Mahasiswa : " + menuEnamBelasAdmin(nim).getPasswordMhs());
                                                    System.out.println("Nomor Telepon : " + menuEnamBelasAdmin(nim).getTelepon());
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    System.out.println("Tidak ditemukan NIM Mahasiswa " + nim);
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.print("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 27:
                                            System.out.println("Daftar Mahasiswa");
                                            i = 0;
                                            j = 0;
                                            for (Mahasiswa list1 : menuTujuhBelasAdmin()) {
                                                System.out.println(i + " " + list1.getNim() + " " + list1.getName());
                                                i++;
                                                j = 1;
                                            }
                                            if (j == 0) {
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

                        System.out.print(
                                "Masukkan Username Mahasiswa : ");
                        username = huruf.next();

                        System.out.print(
                                "Masukkan Password Mahasiswa : ");
                        password = huruf.next();

                        for (Mahasiswa list4 : daftarMahasiswa) {
                            if ((list4.getUsernameMhs().equals(username)) && (list4.getPasswordMhs().equals(password))) {
                                ada = true;
                                i++;
                            }
                        }
                        mah = getMahasiswa(i);
                        if (ada
                                == true) {
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
                                        case 31:
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
                                                if ((nomor + 1) > daftarKelas.size()) {
                                                    System.out.println("Tidak ada nomor");
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    menuSatuMhs(mah, getKelas(nomor));
                                                    System.out.println("Berhasil ditambahkan");
                                                    namaMatkul = br.readLine();
                                                }
                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 32:
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
                                                if ((nomor + 1) > menuTigaMhs(mah).size()) {
                                                    System.out.println("Tidak ada nomor");
                                                    namaMatkul = br.readLine();
                                                } else {
                                                    menuDuaMhs(mah, menuTigaMhs(mah).get(i));
                                                    System.out.println("Berhasil dihapus");
                                                    namaMatkul = br.readLine();
                                                }

                                            } else {
                                                System.out.println("Kosong");
                                                namaMatkul = br.readLine();
                                            }
                                            break;

                                        case 33:
                                            System.out.println("Dafar Kelas");
                                            l = 0;
                                            m = 0;
                                            for (Kelas list1 : menuTigaMhs(mah)) {
                                                System.out.println(l + ". " + list1.getNamaKelas() + " " + list1.getMatakuliah().getNamaMatkul() + " " + list1.getDosen().getName());

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
                        System.out.println(
                                "TERIMA KASIH");
                        pilihan1 = 0;
                        userAktif = null;
                        username = br.readLine();
                        break;

                    default:
                        System.out.println(
                                "Menu tidak ada");
                }
            } catch (InputMismatchException e) {
                System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
            }
        }
    }
}
