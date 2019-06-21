import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.server.utils.MethodsUtils;

public class testValidateListKeys {
	MethodsUtils methodsUtils = new MethodsUtils();
	String keyA = "35180303876961000233570010000796921000799140"; //Modelo CTe
	String keyB = "35180303876961000233550010000796921000799140"; //Modelo NFe
	String keyC = "35180303876961000233570010000796971000799198"; //Modelo CTe
	
	@Test
	public void testAgrupamentoDocumentoModeloDiferentes() throws Exception {
		List<String> listKeys = new ArrayList<>();
		listKeys.add(keyA);
		assertFalse(methodsUtils.isValidListDocuments(keyB, listKeys));
	}
	
	@Test
	public void testAgrupamentoDocumentoModeloSemelhantes() throws Exception {
		List<String> listKeys = new ArrayList<>();
		listKeys.add(keyA);
		assertTrue(methodsUtils.isValidListDocuments(keyC, listKeys));
	}

}