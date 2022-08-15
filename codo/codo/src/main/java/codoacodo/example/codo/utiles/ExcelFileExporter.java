//package com.codo.acodo.utiles;
//
//
//    import java.util.List;
//    import java.util.TreeSet;
//
//    import com.codo.acodo.entity.Ingresante;
//    import com.codo.acodo.entity.PackFormDTO.PreguntaFormulario;
//    import com.codo.acodo.entity.PackFormDTO.Respuesta;
//    import org.apache.poi.ss.usermodel.*;
//    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//public class ExcelFileExporter {
//
//        public static XSSFWorkbook  ingresantesExcelExpoter(TreeSet<PreguntaFormulario>preguntas, List<Ingresante>ingresantes) {
////            try(Workbook workbook = new XSSFWorkbook()){
//            XSSFWorkbook  workbook = new XSSFWorkbook();
//                Sheet sheet = workbook.createSheet("ing");
//
//                Row row = sheet.createRow(0);
//                CellStyle headerCellStyle = workbook.createCellStyle();
//                headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
//                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//                // Creating header
//
//                Cell cell = row.createCell(0);
//                cell.setCellValue("id");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(1);
//                cell.setCellValue("mail");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(2);
//                cell.setCellValue("celu");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(3);
//                cell.setCellValue("tDoc");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(4);
//                cell.setCellValue("numDoc");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(5);
//                cell.setCellValue("apellido");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(6);
//                cell.setCellValue("nombre");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(7);
//                cell.setCellValue("fNacimiento");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(8);
//                cell.setCellValue("genero");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(9);
//                cell.setCellValue("nacionalidad");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(10);
//                cell.setCellValue("provincia");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(11);
//                cell.setCellValue("localidadResi");
//                cell.setCellStyle(headerCellStyle);
//
//                cell = row.createCell(12);
//                cell.setCellValue("domicilio");
//                cell.setCellStyle(headerCellStyle);
//                int indice=13;
//                if (!preguntas.isEmpty()){
//                    for (PreguntaFormulario p: preguntas ) {
//
//                        cell = row.createCell(indice);
//                        cell.setCellValue(p.getEnunciado());
//                        cell.setCellStyle(headerCellStyle);
//                        indice++;
//                    }
//                }
//
//
//                // Creating data rows for each customer
//                int indiceFilas=1;
//                for (Ingresante in:ingresantes) {
//                    Row dataRow = sheet.createRow(indiceFilas);
//
//                    dataRow.createCell(0).setCellValue(in.getId());
//                    System.out.println(in.getId());
//                    dataRow.createCell(1).setCellValue(in.getMail());
//                    System.out.println(in.getMail());
//                    dataRow.createCell(2).setCellValue(in.getCelu());
//                    System.out.println(in.getCelu());
//                    dataRow.createCell(3).setCellValue(in.gettDoc());
//                    System.out.println(in.gettDoc());
//                    dataRow.createCell(4).setCellValue(in.getNumDoc());
//                    dataRow.createCell(5).setCellValue(in.getApellido());
//                    dataRow.createCell(6).setCellValue(in.getNombre());
//                    dataRow.createCell(7).setCellValue(in.getfNacimiento());
//                    dataRow.createCell(8).setCellValue(in.getGenero());
//                    dataRow.createCell(9).setCellValue(in.getNacionalidad());
//                    dataRow.createCell(10).setCellValue(in.getProvincia());
//                    dataRow.createCell(11).setCellValue(in.getLocalidadResi());
//                    dataRow.createCell(12).setCellValue(in.getDomicilio());
//                    int indiceCol=12;
//                    for (Respuesta r: in.getRespuestas()) {
//                        indiceCol++;
//                        if (r.getRespuesta()!=null){
//                            dataRow.createCell(indiceCol).setCellValue(r.getRespuesta());
//                        }else{
//                            dataRow.createCell(indiceCol).setCellValue(" ");
//                        }
//                        System.out.println(r.getRespuesta());
//                    }
//                    indiceFilas++;
//                }
//
//                System.out.println( "rompio fuera del for");
//
//
////                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////                System.out.println("paso el buout");
////                workbook.write(outputStream);
////                outputStream.close();
////                System.out.println("finalizo bien");
//
//                return workbook;
////            } catch (IOException ex) {
////                System.out.println("se metio en el cath");
////                ex.printStackTrace();
////                return null;
////            }
//        }
//    }

