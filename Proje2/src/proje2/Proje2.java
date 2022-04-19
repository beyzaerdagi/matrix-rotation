package proje2;

/**
 * @file Proje2
 * @description Olusturulan bir matrisi istenilen yonde istendigi kadar dondurme
 * @assigment 2.proje
 * @date 10.12.2020
 * @author BEYZANUR ERDAĞI beyzanur.erdagi@stu.fsm.edu.tr
 */
import java.util.Scanner;

public class Proje2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = {5, 5, -1, 100, 2};
        // 1,3,4. seceneklere basinca matrisin elemanlarinin sayilarinin degismemesi icin matrisi basta olusturdum.
        int[][] matris = new int[array[0]][array[1]];
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                matris[i][j] = (int) (Math.random() * array[3]);
            }
        }
        // 5. secenege basınca programdan cikmasi icin menuKontrol tanimladim.
        boolean menuKontrol = true;
        while (menuKontrol) {
            System.out.println("1.Uygulamayi calistir");
            System.out.println("2.Matris oluştur");
            System.out.println("3.Direction");
            System.out.println("4.Step number");
            System.out.println("5.Exit");
            System.out.print("Secenek: ");
            String tmp = in.next();
            // secenegi string olarak alip kontrolleri oyle yaptim.
            boolean numaraKontrolSecenek = true;
            while (numaraKontrolSecenek) {
                if (!numaraKontrol(tmp)) {
                    System.out.println("Lütfen menü rakamları dışında bir şey girmeyiniz.");
                    System.out.print("Secenek: ");
                    tmp = in.next();
                } else if (StringToNumber(tmp) > 5 || StringToNumber(tmp) < 1) {
                    System.out.println("Lütfen menü rakamları dışında bir şey girmeyiniz.");
                    System.out.print("Secenek: ");
                    tmp = in.next();
                } else {
                    numaraKontrolSecenek = false;
                }
            }
            // kontrolden sonra integer a cevirdim.
            int secenek = StringToNumber(tmp);

            if (secenek == 5) {
                menuKontrol = false;
                System.out.println("Iyi gunler..");
            } else if (secenek == 2) {  // 2.secenekte matris degisecegi icin burda yeni bir matris olusturdum.
                matrisOlusturma(array);
                matris = new int[array[0]][array[1]];
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j < matris[i].length; j++) {
                        matris[i][j] = (int) (Math.random() * array[3]);
                    }
                }
            } else if (secenek == 3) {
                yonBelirleme(array);
            } else if (secenek == 4) {
                adetBelirleme(array);
            }
            if (secenek == 1) {
                printArray(array);
                System.out.println("Oluşturulan matris:");
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j < matris[i].length; j++) {
                        System.out.print(matris[i][j] + "\t");
                    }
                    System.out.println();
                }
                System.out.println();
                matrisDondurme(array, matris);
            }
        }
    }

    public static void matrisOlusturma(int[] array) {
        Scanner in = new Scanner(System.in);

        System.out.print("Matrisin satır boyutunu giriniz: ");
        String tmp = in.next();
        boolean numaraKontrolSatir = true;
        while (numaraKontrolSatir) {
            if (!numaraKontrol(tmp)) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin satır boyutunu giriniz: ");
                tmp = in.next();
            } else if (StringToNumber(tmp) == 1) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin satır boyutunu giriniz: ");
                tmp = in.next();
            } else if (StringToNumber(tmp) == 0) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin satır boyutunu giriniz: ");
                tmp = in.next();
            } else {
                numaraKontrolSatir = false;
            }
        }
        array[0] = StringToNumber(tmp);

        System.out.print("Matrisin sütun boyutunu giriniz: ");
        tmp = in.next();
        boolean numaraKontrolSutun = true;
        while (numaraKontrolSutun) {
            if (!numaraKontrol(tmp)) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin sütun boyutunu giriniz: ");
                tmp = in.next();
            } else if (StringToNumber(tmp) == 1) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin sütun boyutunu giriniz: ");
                tmp = in.next();
            } else if (StringToNumber(tmp) == 0) {
                System.out.println("Lütfen 1 den büyük bir sayı giriniz..");
                System.out.print("Matrisin sütun boyutunu giriniz: ");
                tmp = in.next();
            } else {
                numaraKontrolSutun = false;
            }
        }
        array[1] = StringToNumber(tmp);

        System.out.print("0 ile kaç aralığında olacağını giriniz: ");
        tmp = in.next();
        boolean numaraKontrolAralik = true;
        while (numaraKontrolAralik) {
            if (!numaraKontrol(tmp)) {
                System.out.println("Lütfen 0 dan büyük bir sayı giriniz..");
                System.out.print("0 ile kaç aralığında olacağını giriniz: ");
                tmp = in.next();
            } else if (StringToNumber(tmp) == 0) {
                System.out.println("Lütfen 0 dan büyük bir sayı giriniz..");
                System.out.print("0 ile kaç aralığında olacağını giriniz: ");
                tmp = in.next();
            } else {
                numaraKontrolAralik = false;
            }
        }
        array[3] = StringToNumber(tmp);
    }

    public static void yonBelirleme(int[] array) {
        Scanner in = new Scanner(System.in);

        System.out.print("Döndürme yönünü giriniz(-1,1): ");
        String tmp = in.next();
        boolean numaraKontrolYon = true;
        while (numaraKontrolYon) {
            if (!yonNumaraKontrol(tmp)) {
                System.out.println("Lütfen 1 veya -1 giriniz..");
                System.out.print("Döndürme yönünü giriniz(-1,1): ");
                tmp = in.next();
            } else {
                numaraKontrolYon = false;
            }
        }
        boolean yonKontrol = true;
        while (yonKontrol) {
            if (!yonKontrol(StringToNumber(tmp))) {
                System.out.print("Döndürme yönünü giriniz(-1,1): ");
                tmp = in.next();
            } else {
                yonKontrol = false;
            }
        }
        array[2] = StringToNumber(tmp);
    }

    public static void adetBelirleme(int[] array) {
        Scanner in = new Scanner(System.in);

        System.out.print("Kaç adet döndürüleceğini giriniz: ");
        String tmp = in.next();
        boolean numaraKontrolAdet = true;
        while (numaraKontrolAdet) {
            if (!numaraKontrol(tmp)) {
                System.out.println("Lütfen 0 dan büyük bir sayı giriniz..");
                System.out.print("Kaç adet döndürüleceğini giriniz: ");
                tmp = in.next();
            } else {
                numaraKontrolAdet = false;
            }
        }
        array[4] = StringToNumber(tmp);
    }

    public static void matrisDondurme(int[] array, int[][] matris) {
        // matrisin cerceve kismindaki sayilari donucegi icin o sayilari bir arrayde tuttum.
        int[] tmpArray = new int[(array[1] * 2) + ((array[0] - 2) * 2)];
        int sayi = 0;
        // ilk olarak 0.satirdaki sayilari ekledim.
        for (int i = 0; i < array[1]; i++) {
            tmpArray[sayi] = matris[0][i];
            sayi++;
        }
        // daha sonra sonuncu sutundaki sayilari ekledim.
        for (int i = 1; i < matris.length; i++) {
            tmpArray[sayi] = matris[i][array[1] - 1];
            sayi++;
        }
        // daha sonra sonuncu satirdaki sayilari ekledim.
        for (int i = array[1] - 2; i >= 0; i--) {
            tmpArray[sayi] = matris[array[0] - 1][i];
            sayi++;
        }
        // daha sonra 0. sutundaki sayilari ekledim.
        for (int i = matris.length - 2; i > 0; i--) {
            tmpArray[sayi] = matris[i][0];
            sayi++;
        }
        int[] temp = new int[tmpArray.length];
        int idx = 0;
        // olusturdugum arrayi belirlenen yonde istenen adim kadar yerlerini degistirdim.
        if (array[2] < 0) {
            for (int i = tmpArray.length - array[4]; i < tmpArray.length; i++) {
                temp[idx] = tmpArray[i];
                idx++;
            }
            for (int i = 0; i < tmpArray.length - array[4]; i++) {
                temp[idx] = tmpArray[i];
                idx++;
            }
        } else {
            for (int i = array[4]; i < tmpArray.length; i++) {
                temp[idx] = tmpArray[i];
                idx++;
            }
            for (int i = 0; i < array[4]; i++) {
                temp[idx] = tmpArray[i];
                idx++;
            }
        }
        int tmp = 0;
        // arrayin elemanlarinin yerlerini degistirdikten sonra elemanlari ayni sekilde matrise geri ekledim.
        for (int i = 0; i < array[1]; i++) {
            matris[0][i] = temp[tmp];
            tmp++;
        }
        for (int i = 1; i < matris.length; i++) {
            matris[i][array[1] - 1] = temp[tmp];
            tmp++;
        }
        for (int i = array[1] - 2; i >= 0; i--) {
            matris[array[0] - 1][i] = temp[tmp];
            tmp++;
        }
        for (int i = matris.length - 2; i > 0; i--) {
            matris[i][0] = temp[tmp];
            tmp++;
        }
        // en son olarak dondurulmus halini yazdim.
        System.out.println("Döndürülmüş hali:");
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean yonKontrol(int sayi) {
        // yon isterken -1 den kücük sayilari kabul etmemesi icin bu methodu olusturdum.
        boolean kontrol = true;
        while (kontrol) {
            if (sayi != 1 && sayi != -1) {
                System.out.println("Lütfen 1 veya -1 giriniz..");
                return false;
            } else {
                kontrol = false;
            }
        }
        return true;
    }

    public static boolean numaraKontrol(String tmp) {
        // istedigim satir sutun aralik ve adet sayilarinin rakam disinda bir sey girilmemesi icin bu methodu olusturdum.
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) > 57 || tmp.charAt(i) < 48) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    public static boolean yonNumaraKontrol(String tmp) {
        // yon isterken -1 sayisini kabul etmek icin 45(-) ve 1 den buyuk bir sayi girilmemesi icin 49(1) bu methodu olusturdum.
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) > 49 || tmp.charAt(i) < 45) {
                if (tmp.charAt(i) == '0') {  // 48(0) 49 ve 45 araliginda oldugu icin ve kabul etmemek icin yaptim.
                    return false;
                } else {
                    return false;
                }
            } else if (tmp.charAt(i) == '.') { // 46(.) 49 ve 45 araliginda oldugu icin ve kabul etmemek icin yaptim.
                return false;
            } else if (tmp.charAt(i) == '/') { // 47(/) 49 ve 45 araliginda oldugu icin ve kabul etmemek icin yaptim.
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public static void printArray(int[] array) {
        // kullanicinin olusturulan diziyi daha rahat gormesi icin bu methodu yaptim.
        String msg = "{";
        for (int i = 0; i < array.length; i++) {
            msg += array[i] + (i < array.length - 1 ? ", " : "");
        }
        msg += "}";
        System.out.println("Oluşturulan dizi: " + msg);
    }

    public static int StringToNumber(String tmp) {
        // String olarak alinan sayilari integer a cevirmek icin bu methodu yaptim.
        int toplam = 0;
        int basamak = 1;
        boolean eksiMi = false;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) == '-') { // yonde "-1" i kabul etmek icin "-" ise devam etmesi icin yaptim.
                eksiMi = true;
                continue;
            }
            toplam += (tmp.charAt(i) - '0') * basamak;
            basamak *= 10;
        }
        return eksiMi ? -toplam : toplam; // sayi "-1" ise yon icin -toplam olarak yaptim.
    }
}
