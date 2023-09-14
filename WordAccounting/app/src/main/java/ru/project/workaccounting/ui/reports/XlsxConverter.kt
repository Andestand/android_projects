package ru.project.workaccounting.ui.reports

import android.content.Context
import android.os.Environment
import jxl.Workbook
import jxl.format.Alignment
import jxl.format.Colour
import jxl.format.UnderlineStyle
import jxl.write.*

import ru.project.workaccounting.domain.models.Report
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class XlsxConverter {
    fun convertToXlsx(data: List<Report>, filePath: String, context: Context): File {
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, filePath)

        val workbook: WritableWorkbook = Workbook.createWorkbook(file)
        val sheet: WritableSheet = workbook.createSheet("Data", 0)

        val headerFormat = WritableCellFormat()
        headerFormat.setBackground(Colour.GREY_25_PERCENT)
        headerFormat.setAlignment(Alignment.CENTRE)
        headerFormat.setWrap(true)
        headerFormat.setFont(
            WritableFont(
                WritableFont.ARIAL,
                10,
                WritableFont.BOLD,
                false,
                UnderlineStyle.NO_UNDERLINE,
                Colour.WHITE
            )
        )

        val headers = arrayOf("ID", "ФИО мастера", "название работы", "количество", "дата и время", "адрес")

        for (i in headers.indices) {
            val label = Label(i, 0, headers[i], headerFormat)
            sheet.addCell(label)
            sheet.setColumnView(i, 15)
        }

        var currentRowNum = 1
        var currentWorker = ""
        for (report in data) {
            if (currentWorker != report.worker) {
                val workerCell = Label(0, currentRowNum, report.worker)
                workerCell.setCellFormat(headerFormat)
                sheet.addCell(workerCell)
                sheet.mergeCells(0, currentRowNum, headers.size - 1, currentRowNum)
                currentWorker = report.worker
                currentRowNum++
            }

            sheet.addCell(Label(0, currentRowNum, report.worker))
            sheet.addCell(Label(1, currentRowNum, report.work.workName))
            sheet.addCell(Number(2, currentRowNum, report.work.sizeWork.toDouble()))
            sheet.addCell(Label(3, currentRowNum, report.datetime.toString()))
            sheet.addCell(Label(4, currentRowNum, report.address))

            currentRowNum++
        }
        workbook.write()
        workbook.close()

        return file
    }

    fun saveFileToExternalStorage(data: String, fileName: String) {
        val filePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + fileName
        val file = File(filePath)

        try {
            val fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}