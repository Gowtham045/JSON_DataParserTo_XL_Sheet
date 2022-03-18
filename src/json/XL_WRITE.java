package json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_WRITE {

    public static void writeXL() {
        String[] columnHeadings = {"id", "name", "description", "image", "Regions", "Cities", "Harbors", "Rivers", "Wood", "Stone", "Coal", "Copper", "Obsidian", "Silver", "Ironwood", "Cold Iron", "Gold", "Haltwood", "Diamonds", "Sapphire", "Deep Crystal", "Ruby", "Ignium", "Ethereal Silica", "True Ice", "Twilight Quartz", "Alchemical Silver", "Adamantine", "Mithral", "Dragonhide", "Order", "Wonder"};
        String path = "C:\\Users\\new\\Desktop\\Results.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("JSON_DATA");
        XSSFRow row;
        XSSFRow row1;
        row = sheet.createRow(0);
        ArrayList<Cell> list = new ArrayList<>();
        CellStyle style = workbook.createCellStyle();
        for (int i = 0; i < columnHeadings.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnHeadings[i]);
            style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(style);
            list.add(cell);
        }
        sheet.createFreezePane(0, 1);
        JOptionPane.showMessageDialog(null, "XL headerCreated");
        for (int i = 0; i < Data.Details.size(); i++) {
            row1 = sheet.createRow(i + 1);
            Data data = Data.Details.get(i);
            row1.createCell(0).setCellValue(data.getId());
            row1.createCell(1).setCellValue(data.getName());
            row1.createCell(2).setCellValue(data.getDescription());
            row1.createCell(3).setCellValue(data.getImage());
            row1.createCell(4).setCellValue(data.getRegions());
            row1.createCell(5).setCellValue(data.getCities());
            row1.createCell(6).setCellValue(data.getHarbors());
            row1.createCell(7).setCellValue(data.getRivers());
            row1.createCell(8).setCellValue(data.getWood());
            row1.createCell(9).setCellValue(data.getStone());
            row1.createCell(10).setCellValue(data.getCoal());
            row1.createCell(11).setCellValue(data.getCopper());
            row1.createCell(12).setCellValue(data.getObsidian());
            row1.createCell(13).setCellValue(data.getSilver());
            row1.createCell(14).setCellValue(data.getIronwood());
            row1.createCell(15).setCellValue(data.getCold_Iron());
            row1.createCell(16).setCellValue(data.getGold());
            row1.createCell(17).setCellValue(data.getHartwood());
            row1.createCell(18).setCellValue(data.getDiamonds());
            row1.createCell(19).setCellValue(data.getSapphire());
            row1.createCell(20).setCellValue(data.getDeep_Crystal());
            row1.createCell(21).setCellValue(data.getRuby());
            row1.createCell(22).setCellValue(data.getIgnium());
            row1.createCell(23).setCellValue(data.getEthereal_Silica());
            row1.createCell(24).setCellValue(data.getTrue_Ice());
            row1.createCell(25).setCellValue(data.getTwilight_Quartz());
            row1.createCell(26).setCellValue(data.getAlchemical_Silver());
            row1.createCell(27).setCellValue(data.getAdamantine());
            row1.createCell(28).setCellValue(data.getMithral());
            row1.createCell(29).setCellValue(data.getDragonhide());
            row1.createCell(30).setCellValue(data.getOrder());
            row1.createCell(31).setCellValue(data.getWonder());
        }

//        try {
//            FileOutputStream out = new FileOutputStream(new File(path));
//            workbook.write(out);
//            out.close();
//            System.out.println("Excel created succesfully");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        JFileChooser saveFile = new JFileChooser();
        saveFile.setDialogTitle("Save File");
        saveFile.setSelectedFile(new File(path));
        if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File output = saveFile.getSelectedFile();
            try (FileOutputStream out = new FileOutputStream(output)) {
                workbook.write(out);
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(XL_WRITE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        XL_WRITE.writeXL();
    }
}
