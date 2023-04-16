package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        // dosyanın yolunu değişkene atalım
        String path= "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // JavaDosya okuma işlemcisine dosyanın yolunu veriyoruz:
        // böylece program ile dosya arasında bağlantı oluşturuldu.
        FileInputStream dosyaOkumaBaglantisi= new FileInputStream(path);

        // Dosya okuma işlemcisi üzerinden çalışma kitabini alıyorum
        // Hafızada workBook u alıp oluşturdum
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        // istediğim isimde ki çalişma sayfasini aldıyorum
        Sheet ccalismaSayfasi = calismaKitabi.getSheet("Sheet1"); // getSheetAt(0); isim bilmiyor isek böyle alabliriz

        // istenen satiri aliyorum
        Row satir = ccalismaSayfasi.getRow(0);

        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
    }
}
