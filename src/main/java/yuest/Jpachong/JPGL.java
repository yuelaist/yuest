package yuest.Jpachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JPGL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			
			Document doc1=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=29&menuId=80").get();
			Document doc2=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=29&menuId=80&page=2").get();
			
//			Elements elLink=doc1.getElementsByTag("h2");部分目录
			Elements elsLink0=doc1.getElementsByTag("h2");
			Elements elsLink1=doc2.getElementsByTag("h2");
			
			List<Element> lelLink=new ArrayList<Element>();
			for(Element el:elsLink0){				
				Elements elsa=el.getElementsByTag("a");
				for(Element ela:elsa){
					lelLink.add(ela);
				}
				
			}
			for(Element el:elsLink1){				
				Elements elsa=el.getElementsByTag("a");
				for(Element ela:elsa){
					lelLink.add(ela);
				}
			}
			StringBuilder sba=new StringBuilder();
			for (Element el:lelLink){
//				System.out.println(el.baseUri());//基本uri
//				System.out.println(el.absUrl("href"));//绝对路径
//				System.out.println(el);
				sba.append(el.toString());
				sba.append("*");
			}
			
//			生成链接页面文件
//			System.out.println(sba.toString());
			
			
//			生成链接页面

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
				
				//生成表
				int size=astr.length;
				String trh="<tr>";
				String trt="</tr>";
				String tdh="<td>";
				String tdt="</td>";
				StringBuilder sbNewTab=new StringBuilder();
				
				int iTabLen=1;
				int iCloumnNum=2;//设置生成几列
				if((size%iCloumnNum)!=0){
					iTabLen=(size-(size%iCloumnNum))/iCloumnNum;
				}else{
					iTabLen=1+((size-(size%iCloumnNum))/iCloumnNum);
				}
				
				for(int i=1; i<=iTabLen;i++){
					sbNewTab.append(trh);
					for(int j=1;j<iCloumnNum+1;j++){
						sbNewTab.append(tdh);
						sbNewTab.append("a"+i+j+"_");
						sbNewTab.append(tdt);
					}
					sbNewTab.append(trt);
				}
				String sNewTab=sbNewTab.toString();
				
				
				for(int i=0;i<size-1;i++){//使用增强型for循环读出来的是引用。
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
				fnfe.printStackTrace();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
			
//			功能生成上下页
//			for(int i=0;i<lelLink.size();i++){
//				if(i==0){
//					System.out.println("<div align=\"center\"><a href=\""+lelLink.get(i+1).absUrl("href")+" \">继续阅读下一小节</a> </div>");
//				}else if(i==(lelLink.size()-1)){
//					System.out.println("<div align=\"center\"><a href=\""+lelLink.get(i-1).absUrl("href")+" \">继续阅读上一小节</a> </div>");
//				}else{
//					System.out.println("<div align=\"center\"><a href=\""+lelLink.get(i-1).absUrl("href")+" \">返回阅读上一小节</a>&nbsp; |&nbsp; <a href=\""+lelLink.get(i+1).absUrl("href")+" \">继续阅读下一小节</a> </div>");
//				}
//				System.out.println(" ");
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
