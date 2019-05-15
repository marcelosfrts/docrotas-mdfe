package com.server.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XmlUtils {
	
	//assinaXML(xml, alias, ks, senha, "#NFe" + nfe.getChaveAcesso(), "NFe", "infNFe", "Id"); 
	public static String assinarXML(String xml, String alias, KeyStore ks, char[] senha, String id, String parent, String nomeElementoContemId, String nomeAtributoId) throws Exception {     

	        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

	        List<Transform> listTransforms = new ArrayList<>();
	        listTransforms.add(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
	        listTransforms.add(fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null));

	        Reference ref = fac.newReference(id, fac.newDigestMethod(DigestMethod.SHA1, null), listTransforms, null, null);

	        SignedInfo si = fac.newSignedInfo(
	        		fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
	                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
	                Collections.singletonList(ref));

	        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senha));

	        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

	        KeyInfoFactory kif = fac.getKeyInfoFactory();
	        List x509Content = new ArrayList();
	        x509Content.add(cert);
	        X509Data xd = kif.newX509Data(x509Content);
	        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        dbf.setNamespaceAware(true);
	        Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

	        Element element = (Element) doc.getElementsByTagName(nomeElementoContemId).item(0);
	        element.setIdAttribute(nomeAtributoId, true);

	        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getElementsByTagName(parent).item(0));

	        XMLSignature signature = fac.newXMLSignature(si, ki);

	        signature.sign(dsc);

	        StringWriter writer = new StringWriter();
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer trans = tf.newTransformer();
	        trans.transform(new DOMSource(doc), new StreamResult(writer));

	        return writer.toString();
	}
	
	public static boolean validarXml(String xml, String caminhoArquivoXsd) throws IOException {
		
		File schemaFile = new ClassPathResource(caminhoArquivoXsd).getFile();
		Source sourceXml = new StreamSource(xml);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		try {
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(sourceXml);
			return true;
		}catch (SAXException e) {
			System.out.println("Xml não é válido: " + e);
			return false;
		}catch (IOException e) {
			System.out.println("Erro ao abri arquivo: " + e);
			return false;
		}
	}
}