package codoacodo.example.codo.utiles;

import codoacodo.example.codo.Entities.AlumnoEntities.FormAlumPack.PreguntaAlum;
import codoacodo.example.codo.Entities.AlumnoEntities.TestAlumPack.TestAMateria;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.FormDTO;
import codoacodo.example.codo.Entities.DTOS.PackFormDTO.PreguntaDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.MateriaTestDTO;
import codoacodo.example.codo.Entities.DTOS.PacktestDto.TestDTO;
import codoacodo.example.codo.Entities.Ingresante;
import codoacodo.example.codo.Entities.editabilidad.RutasExcel;
import codoacodo.example.codo.repositories.RutasExcelRepository;
import codoacodo.example.codo.serviceIMPL.RutaExcelServiceIMPLE;
import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;



public class ExcelFileExporter {

@Async("threadPoolExecutor")
public String ingresantesExcelExpoter(TestDTO testDTO, FormDTO formDTO, List<Ingresante> ingresantes) {
//            try(Workbook workbook = new XSSFWorkbook()){

            XSSFWorkbook  workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("ing");

                Row row = sheet.createRow(0);
                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                // Creating header

                Cell cell = row.createCell(0);
                cell.setCellValue("id");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(1);
                cell.setCellValue("mail");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(2);
                cell.setCellValue("celu");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(3);
                cell.setCellValue("tDoc");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(4);
                cell.setCellValue("numDoc");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(5);
                cell.setCellValue("apellido");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(6);
                cell.setCellValue("nombre");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(7);
                cell.setCellValue("fNacimiento");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(8);
                cell.setCellValue("genero");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(9);
                cell.setCellValue("nacionalidad");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(10);
                cell.setCellValue("provincia");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(11);
                cell.setCellValue("localidadResi");
                cell.setCellStyle(headerCellStyle);

                cell = row.createCell(12);
                cell.setCellValue("domicilio");
                cell.setCellStyle(headerCellStyle);
                int indice=13;
              TreeSet <PreguntaDTO>preguntas=new TreeSet<>();

                if (!formDTO.getPreguntas().isEmpty()){
                    for (PreguntaDTO pregun: formDTO.getPreguntas()){
                        preguntas.add(pregun);
                    }

                    for (PreguntaDTO p: preguntas ) {

                        cell = row.createCell(indice);
                        cell.setCellValue(p.getEnunciado());
                        cell.setCellStyle(headerCellStyle);
                        indice++;
                    }
                }
            TreeSet <MateriaTestDTO>materias=new TreeSet<>();
                if (!testDTO.getMaterias().isEmpty()){
                    for (MateriaTestDTO mat:testDTO.getMaterias()){
                        materias.add(mat);
                    }
                    for (MateriaTestDTO p: materias ) {

                        cell = row.createCell(indice);
                        cell.setCellValue(p.getNombre());
                        cell.setCellStyle(headerCellStyle);
                        indice++;
                    }
                }



                // Creating data rows for each customer
                int indiceFilas=1;
                for (Ingresante in:ingresantes) {
                    System.out.println("entro Work en ingre"+in.getNumDoc());
                    Row dataRow = sheet.createRow(indiceFilas);

                    dataRow.createCell(0).setCellValue(in.getId());
                   // System.out.println(in.getId());
                    dataRow.createCell(1).setCellValue(in.getMail());
                   // System.out.println(in.getMail());
                    dataRow.createCell(2).setCellValue(in.getCelu());
                   // System.out.println(in.getCelu());
                    dataRow.createCell(3).setCellValue(in.gettDoc());
                   // System.out.println(in.gettDoc());
                    dataRow.createCell(4).setCellValue(in.getNumDoc());
                    dataRow.createCell(5).setCellValue(in.getApellido());
                    dataRow.createCell(6).setCellValue(in.getNombre());
                    dataRow.createCell(7).setCellValue(in.getfNacimiento());
                    dataRow.createCell(8).setCellValue(in.getGenero());
                    dataRow.createCell(9).setCellValue(in.getNacionalidad());
                    dataRow.createCell(10).setCellValue(in.getProvincia());
                    dataRow.createCell(11).setCellValue(in.getLocalidadResi());
                    dataRow.createCell(12).setCellValue(in.getDomicilio());
                    int indiceCol=12;
                    TreeSet <PreguntaAlum>preguntasAl=new TreeSet<>();
                    for (PreguntaAlum pr:in.getFormAlum().getPreguntas()){
                        preguntasAl.add(pr);
                    }
                    for (PreguntaAlum r: preguntasAl) {
                        indiceCol++;
                        if (r.getRespuesta()!=null){
                            dataRow.createCell(indiceCol).setCellValue(r.getRespuesta());
                        }else{
                            dataRow.createCell(indiceCol).setCellValue(" ");
                        }
                        System.out.println(r.getRespuesta()+in.getNumDoc());
                    }
                    TreeSet <TestAMateria>materiasAlum=new TreeSet<>();
                    for (TestAMateria mat: in.getTestAlumno().getMateriasAlumno()){
                        materiasAlum.add(mat);
                    }
                    for (TestAMateria r: materiasAlum) {
                        indiceCol++;
                        if (r.getPuntos()!=null){
                            dataRow.createCell(indiceCol).setCellValue(r.getPuntos());
                        }else{
                            dataRow.createCell(indiceCol).setCellValue(" ");
                        }
//                        System.out.println(r.getPuntos());
                    }
                    indiceFilas++;
                }

                System.out.println( "rompio fuera del for");


//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                System.out.println("paso el buout");
//                workbook.write(outputStream);
//                outputStream.close();
//                System.out.println("finalizo bien");

             String ruta =exportarAServidor(workbook);

//            } catch (IOException ex) {
//                System.out.println("se metio en el cath");
//                ex.printStackTrace();
//                return null;
//            }
    return ruta;
        }


        public static String exportarAServidor(XSSFWorkbook woorbook){

            Date ahora=new Date();
            LocalDate ahorasi=LocalDate.now();
            String fecha="-"+(ahora.getYear()+1900)+"-"+(ahora.getMonth()+1)+"-"+ahora.getDate()+"-"+ahora.getHours()+""+ahora.getMinutes()+"hs";

            System.out.println(ahora);
            String nombreArchivo="Ingresantes"+fecha+".xlsx";
           File directorioActual=new File(".");

           String ubicacion=directorioActual.getAbsolutePath();
           String ubicacion2=directorioActual.getPath();
            System.out.println(ubicacion);


           //String ubicacionSalida=ubicacion.substring(0,ubicacion.length()-1)+nombreArchivo;
          // String ubicacionSalida="/home/educacionuser/Downloads/uploads/"+nombreArchivo;
           String ubicacionSalida="C:/uploads/"+nombreArchivo;
           System.out.println(ubicacionSalida);
           FileOutputStream outputStream;
          try {
              outputStream=new FileOutputStream(ubicacionSalida);
              woorbook.write(outputStream);
              woorbook.close();
          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          return  nombreArchivo;
        }
    }

