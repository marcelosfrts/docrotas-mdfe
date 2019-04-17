package com.server.mdfe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XmlMdfeUtils {
	public final static String NAMESPACE_MDFE = "http://www.portalfiscal.inf.br/mdfe";
	public final static String VERSAO_300 = "3.00";
	public final static String[] ORDER_IDE = {"cUF","tpAmb","tpEmit","tpTransp","mod","serie","nMDF","cMDF","cDV",
			"modal","dhEmi","tpEmis","procEmi","verProc","UFIni","UFFim","mountInfMunCarrega","dhIniViagem"};
	
	public String DateXMLFormat(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		return f.format(date);
	}
}
