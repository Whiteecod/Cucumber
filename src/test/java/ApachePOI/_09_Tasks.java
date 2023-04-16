package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 * Kullanıcıdan istediği kolon sayısını aldıktan sonra
 * aşağıdaki excelin 2.Sheet inden istediği kadar kolon miktarını alarak
 * bir fonksyonda ArrayListe çevirerek mainden yazdırınız
 * src/test/java/ApachePOI/resources/ApacheExcel2.xlsx
 */

public class _09_Tasks {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";

        Scanner scan = new Scanner(System.in);
        System.out.println("İstediğiniz bir sütun sayisini giriniz");
        int columnCnt = scan.nextInt();

        ArrayList <ArrayList<String> > donenSonuc = getData(path , sheetName , columnCnt);
        System.out.println("donenSonuc = " + donenSonuc);

    }
    public static ArrayList <ArrayList<String> > getData (String path, String sheetName, int colCnt) throws IOException {
        ArrayList <ArrayList<String> > tablo = new ArrayList<>();


        Sheet sheet=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {

        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows() ; i++) {
            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < colCnt ; j++) {
                satir.add(sheet.getRow(i).getCell(j).toString());
            }
            tablo.add(satir);
        }
        return tablo;
    }
}
