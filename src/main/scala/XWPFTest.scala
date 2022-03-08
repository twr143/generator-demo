import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.net.URISyntaxException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.apache.poi.xwpf.usermodel.{XWPFDocument, XWPFParagraph, XWPFRun}
import com.deepoove.poi.XWPFTemplate

import scala.collection.immutable.HashMap
import scala.jdk.CollectionConverters._
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions
import fr.opensagres.xdocreport.itext.extension.IPdfWriterConfiguration
import org.apache.commons.io.output.ByteArrayOutputStream

import java.io.FileOutputStream
import java.io.OutputStream

object XWPFTest
{
  @throws[URISyntaxException]
  @throws[IOException]
  def main(args: Array[String]): Unit =
  {
    val resourcePath = "templ_loan.docx"
    //    val uri = getClass.getResource(resourcePath).toURI
    //    println(uri)
    val templatePath = Paths.get(resourcePath)
    val doc = new XWPFDocument(Files.newInputStream(templatePath))
    val compiledDoc = XWPFTemplate.compile(doc)
    val vars = Map[String, String]("client_lastname" -> "Фамилия", "client_firstname" -> "Имя", "client_middlename" -> "Отч")
        val modDoc = compiledDoc.render(vars.asJava).getXWPFDocument

    val options = PdfOptions.create
    val out = new FileOutputStream("t4_out.pdf")
    val out2 = new FileOutputStream("t42_out.pdf")
//    val byteOut = new ByteArrayOutputStream()
    PdfConverter.getInstance.convert(modDoc, out, null)
//    PdfConverter.getInstance.convert(modDoc, byteOut, null)
    val vars2 = Map[String, String]("client_lastname" -> "Фам2", "client_firstname" -> "Имя2", "client_middlename" -> "Отч2")
    val modDoc2 = compiledDoc.render(vars2.asJava).getXWPFDocument
    PdfConverter.getInstance.convert(modDoc2, out2, null)

//    println(s"size of buffer is ${byteOut.size}")
    modDoc2.close()
    modDoc.close()
    out.close()
    out2.close()

  }
}