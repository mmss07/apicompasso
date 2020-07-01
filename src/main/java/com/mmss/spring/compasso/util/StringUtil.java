package com.mmss.spring.compasso.util;

import static java.util.Calendar.YEAR;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {
	
	public static boolean validaUf(String uf) {

		List<String> ufs = Stream.of("RO","AC","AM","RR","PA","AP","TO","MA","PI","CE","RN","PB","PE","AL","SE","BA","MG","ES","RJ","SP","PR","SC","RS","MS","MT","GO","DF").collect(Collectors.toList()); 
				
		for (String ufInformada : ufs) {
			if (ufInformada.equalsIgnoreCase(uf)) {
				return true;
			}
		}
		return false;
    }
	
	public static boolean isListNotNullNotEmpty(List list) {
        return ((list != null) && (!list.isEmpty()));
    }
	
	public static boolean verificarIdadeComDataAniversario(int idade, Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		int anoInformado = calendar.get(YEAR);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		int anoAtual = calendar2.get(YEAR);
		int anosInformados = anoAtual - anoInformado;
		return ((anosInformados == idade)||((anosInformados-idade)==1));
	}

}
