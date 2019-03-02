package com.server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;

public class FormatUtils {
	
	public String formatDate(String data, String pattern) {
		return new SimpleDateFormat(pattern).format(data);
	}
	
	public String toFormatMask(String data, PatternEnum typeGeneric) { 
		switch (typeGeneric.toString()) {
		case "CPF" : data = toFormatCpf(data);
			break;
		default:
			break;
		}
		return data;
	}

	private String toFormatCpf(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String formatarString(String texto, PatternEnum tipoMascara) throws ParseException {
		String mascara = null;
		switch (tipoMascara) {
		case CPF: mascara = "###.###.###-##";
			break;
		case CNPJ: mascara = "##.###.###/####-##";
			break;
		case IE: 
			break;
		case HABILITACAO: 
			break;
		case CEP: mascara = "##.###-###"; 
			break;
		case FONE: mascara = "(##)@####-####";
			break;			
		default:
			break;
		}
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }	

}
