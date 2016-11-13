package m3u8_sort;

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class finder {


	public String find(String regex, String inner) {
		String result = new String("loser");
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inner);
		if (matcher.find()) {
		result =  matcher.group(0);
		return result;
		} else 
		{return result; }
		}

}


class obj_exf{
	int num;
	String extinf = new String();
	String extgrp = new String();
	String url = new String();
	
	obj_exf (int n, String ei, String eg, String u){
		num = n;
		extinf = ei;
		extgrp = eg;
		url = u;
		}
	public void change_n(int new_num){
		num = new_num;
	}
	
}

public class starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try {
		String fp = "d:/tst.m3u8";
			File pl = new File(fp);
			if(pl.exists()){
				try (BufferedReader buff = new BufferedReader( new FileReader(fp) )) {
					String line;
					//String tmp;
					finder f = new finder();
					while ((line = buff.readLine())!=null){
						
						
						
						switch (line.substring(0, 7)) {
						case "#EXTINF": System.out.println(f.find("(?<=,).*", line));
						break;
						case "#EXTGRP": System.out.println(f.find("(?<=:).*", line));
						break;
						case "http://": System.out.println(line);
						break;
						
						}
						
//					if(line.startsWith("#EXTINF:")) {
						
//					}
					}
					
				}
				catch(IOException zuh){
					zuh.printStackTrace();
				}
				
				
				
				
				
			}
 		//}
		//catch(IOException ioe) {
 		//ioe.printStackTrace();
 		//}
//obj_exf test = new obj_exf(1,"zuh","zuhzuh","http://zuh.com");
//System.out.println(test.num);
//test.change_n(3);
//System.out.println(test.num);

	}

}
