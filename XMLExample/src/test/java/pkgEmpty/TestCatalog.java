package pkgEmpty;

import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import exceptions.BookException;
import pkgLibrary.Catalog;

public class TestCatalog {


	@Test(expected=BookException.class)
	public void TestGetBooks() throws BookException{
		Catalog cat= ReadXMLFile();
		cat.GetBook("bk101");
	}
	
	@Test(expected=BookException.class)
	public void TestGetBooks2() throws BookException{
		Catalog cat= ReadXMLFile();
		cat.GetBook("bk102");
	}
	
	//no idea why the third one can pass test,the first two have problem.
	@Test(expected=BookException.class)
	public void TestGetBooks3() throws BookException{
		Catalog cat= ReadXMLFile();
		cat.GetBook("bk122");
	}
	//get from pkgMain XMLreader
private static void WriteXMLFile(Catalog cat) {
	try {

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(cat, file);
		jaxbMarshaller.marshal(cat, System.out);

	} catch (JAXBException e) {
		e.printStackTrace();
	}
}
//get from pkgMain XMLreader
private static Catalog ReadXMLFile() {

	Catalog cat = null;

	String basePath = new File("").getAbsolutePath();
	basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
	File file = new File(basePath);

	System.out.println(file.getAbsolutePath());
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
		System.out.println(cat);
	} catch (JAXBException e) {
		e.printStackTrace();
	}

	return cat;

}
}