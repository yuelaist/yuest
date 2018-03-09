package yuest.Jpachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoAPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File fAdress1=new File("D://workspace/use/gause");//将路径中的斜杠反写过来OK
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(fAdress1));
			StringBuilder sb=new StringBuilder();
			
			String str="";
			while(str!=null){
				sb.append(str.trim());
				str=br.readLine();				
			}
			
			String [] astr=sb.toString().split("\\*");
//			System.out.println(astr[0]);
			
			//生成表
			int size=astr.length;
			String trh="<tr>";
			String trt="</tr>";
			String tdh="<td>";
			String tdt="</td>";
			StringBuilder sbNewTab=new StringBuilder();
			
			int iTabLen=1;
			if((size%3)!=0){
				iTabLen=(size-(size%3))/3;
			}else{
				iTabLen=1+((size-(size%3))/3);
			}
			
			for(int i=1; i<=iTabLen;i++){
				sbNewTab.append(trh);
				for(int j=1;j<4;j++){
					sbNewTab.append(tdh);
					sbNewTab.append("a"+i+j+"_");
					sbNewTab.append(tdt);
				}
				sbNewTab.append(trt);
			}
			String sNewTab=sbNewTab.toString();
//			System.out.println(size-1);
			
			
			for(int i=0;i<size-1;i++){//使用增强型for循环读出来的是引用。
//				System.out.println(iTabLen);
				if(i<=iTabLen-1){
					sNewTab=sNewTab.replace("a"+(i+1)+1+"_", astr[i]);
				}else if(i>iTabLen-1 && i<=((2*iTabLen)-1)){
					sNewTab=sNewTab.replace("a"+(i+1-iTabLen)+2+"_", astr[i]);					
				}else if(i>((2*iTabLen)-1)){
					sNewTab=sNewTab.replace("a"+(i+1-(iTabLen*2))+3+"_", astr[i]);
				}else{
					System.out.println(astr[i]);
				}
				
			}
			
			System.out.println(sNewTab);
			
			
			
			
		}catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
//				try {
//					abr.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			
		}
	}

}
