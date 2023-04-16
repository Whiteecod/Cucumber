package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**  Soru 1:
 *  yeni excel (altalta.xls)
 *  Çarpım tablosunu excele yazdırınız.
 *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
 *  sıfırdan excel oluşturarak.
 *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
 */
/**  Soru 2:
 * yeni excel (yanyana.xls)
 *  Çarpım tablosunu excele yazdırınız.
 *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
 *  sıfırdan excel oluşturarak.
 *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
 */
public class _8_Tasks {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();  // hafızada bir workbook oluşturuldu
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // içinde sheet oluşturdum

        int size = 10;
        for (int i = 1; i <= size; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(i);
            for (int j = 1; j <= size; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(i * j);

            }
        }

        try {
            // Write the workbook to a file
            FileOutputStream out = new FileOutputStream("src/test/java/ApachePOI/resource/yeniyeni.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("Multiplication table successfully written to MultiplicationTable.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









