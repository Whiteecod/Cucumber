package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    /**
     * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
     * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
     * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
     * bulup ve sonucun döndürülmesi için metod kullanınız.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Aranacak kelime");
        String arananKelime = scan.next();

        String donenSonuc = exceldenBul(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);


    }
    public static String  exceldenBul(String aranan) {
        String donecek="";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Sheet sheet=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);

        } catch (Exception e) {
        }
            for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
                if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(aranan)) {
                    for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                        donecek+= sheet.getRow(i).getCell(j) + " ";
                    }
                }
            }




        return donecek;
    }

}
