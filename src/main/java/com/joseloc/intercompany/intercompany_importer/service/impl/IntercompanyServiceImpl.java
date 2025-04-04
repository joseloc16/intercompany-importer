package com.joseloc.intercompany.intercompany_importer.service.impl;

import com.joseloc.intercompany.intercompany_importer.model.dto.IntercompanyExcelDto;
import com.joseloc.intercompany.intercompany_importer.model.records.ResultadoSpDto;
import com.joseloc.intercompany.intercompany_importer.repository.IntercompanySpRepository;
import com.joseloc.intercompany.intercompany_importer.service.IIntercompanyService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class IntercompanyServiceImpl implements IIntercompanyService {

    @Value( "${filename}" )
    private String fileName;

    private IntercompanySpRepository spRepository;

    private static List<IntercompanyExcelDto> data;

    public IntercompanyServiceImpl( IntercompanySpRepository spRepository ) {
        data = new ArrayList<>( );
        this.spRepository = spRepository;
    }

    @PostConstruct
    public void init( ) {
        data = readIntercompanyFromExcel( );
    }

    private List<IntercompanyExcelDto> readIntercompanyFromExcel( ) {

        List<IntercompanyExcelDto> list = new ArrayList<>( );

        try {

            File file = ResourceUtils.getFile( fileName );
            FileInputStream fis = null;
            fis = new FileInputStream( file.getAbsolutePath( ) );

            @SuppressWarnings( "resource" )
            Workbook workbook = new XSSFWorkbook( fis );

            int numberOfSheets = workbook.getNumberOfSheets( );

            for( int i = 0; i < numberOfSheets; i++ ) {

                Sheet sheet = workbook.getSheetAt( i );
                Iterator<Row> rowIterator = sheet.iterator( );

                while( rowIterator.hasNext( ) ) {

                    Row row = rowIterator.next( );

                    if( row.getRowNum( ) == 0 ) {
                        continue;
                    }

                    IntercompanyExcelDto intercompany = new IntercompanyExcelDto( );
                    Iterator<Cell> cellIterator = row.cellIterator( );

                    while( cellIterator.hasNext( ) ) {

                        Cell cell = cellIterator.next( );
                        if( cell.getColumnIndex( ) == 0 ) {
                            intercompany.setTipo( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 1 ) {
                            intercompany.setPep( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 2 ) {
                            intercompany.setKostl( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 3 ) {
                            intercompany.setConcepto( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 4 ) {
                            intercompany.setRacct( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 5 ) {
                            intercompany.setMarkup( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 6 ) {
                            intercompany.setOrdenCompra( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 7 ) {
                            intercompany.setPosicion( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 8 ) {
                            intercompany.setCodServicio( cell.getStringCellValue( ) );
                        } else if( cell.getColumnIndex( ) == 9 ) {
                            intercompany.setHabilitar( cell.getStringCellValue( ) );
                        }
                    }
                    list.add( intercompany );
                }
            }
            fis.close( );
            System.out.println( list.size( ) );
        } catch( Exception e ) {
            e.printStackTrace( );
        }
        return list;
    }

    private void loadFromExcel( List<IntercompanyExcelDto> data ) {

        int totalExitosos = 0;
        int totalErrores = 0;

        int fila = 1;

        for( IntercompanyExcelDto dto : data ) {
            try {

                log.info( "Procesando fila {}", fila );

                ResultadoSpDto resultado = spRepository.insertFromExcelRow( dto );

                if( !"00".equals( resultado.codigo( ) ) ) {
                    totalErrores++;
                } else {
                    totalExitosos++;
                }

            } catch( Exception e ) {
                totalErrores++;
                log.error( "Error procesando fila {}", fila );
                log.debug( "Stack trace completo", e );
            }
            fila++;
        }

        log.info( "Registros procesados exitosamente: {}", totalExitosos );
        log.warn( "Registros no procesados: {}", totalErrores );

    }

    @Override
    public List<IntercompanyExcelDto> saveData( ) {
        loadFromExcel( data );
        return data;
    }
}
