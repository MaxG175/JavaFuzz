import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.Assume;
import org.junit.runner.RunWith;

@RunWith(JQF.class)
public class PDFParserTest{
        @Fuzz
        public void testParser(InputStream input) throws SAXException, TikaException{
                BodyContentHandler handler = new BodyContentHandler();
                Metadata metadata = new Metadata();
                ParseContext pcontext = new ParseContext();
                PDFParser pdfparser = new PDFParser();

                try{
                        pdfparser.parse(input, handler, metadata, pcontext);

                } catch (IOException e){
                        Assume.assumeNoException(e);
                }
        }
}



