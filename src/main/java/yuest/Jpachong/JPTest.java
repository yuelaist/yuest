package yuest.Jpachong;

import java.io.IOException;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// 数据采集.数据采集
//数据采集.节点.文档
//对象
//选择.对象



public class JPTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			Document doc1=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=28&menuId=79").get();
			Document doc2=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=28&menuId=79&page=2").get();
			Document doc3=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=28&menuId=79&page=3").get();
			Document doc4=Jsoup.connect("http://www.boubei.com/tss/channel.portal?1=1&channelId=28&menuId=79&page=4").get();
//			System.out.println(doc); //输出DOC 发现doc里面是由东西的，说明下面的单个获取对象的方法不对。
			
			//得到html的所有东西
			Elements h2Tag1=doc1.getElementsByTag("h2");
			Elements h2Tag2=doc2.getElementsByTag("h2");
			Elements h2Tag3=doc3.getElementsByTag("h2");
			Elements h2Tag4=doc4.getElementsByTag("h2");
//			Element aTag1=doc1.getElementsByTag("h2").tagName("a").get(0);//获取h2下面的a标签  但是有两个嵌套a标签,索引从零开始。
			
//						
			
//			System.out.println(h2Tag1);//输出的内容会包括html代码
			Elements [] ah2TagSet={h2Tag1,h2Tag2,h2Tag3,h2Tag4};
			
			
//			String [] astr=new String[];
//			LinkedHashMap<String,String> lhm = new LinkedHashMap<String,String>();
			
			
			
			for(Elements h2TagSet:ah2TagSet){
				for(Element h2Tag:h2TagSet){
//					String sh2Tag=h2Tag.text();
//					hsstr1.add(sh2Tag);
//					System.out.println(sh2Tag);
//					String sh2Tagc=h2Tag.children().text();//这里已经是最小标签了，需要从中取得元素
//					<a href="/tss/article.portal?1=1&amp;articleId=30" target="_blank"> 第0章 引言 </a>
					
					Elements sh2Tagc=h2Tag.children();
					
//					String str=new String();
					
					msi : {String sAutoTag="<li>"+sh2Tagc+"</li>";
					System.out.println(sAutoTag);
//					System.out.println(sh2Tagc.text());
					}
					
					for(Element attr:sh2Tagc){
//						str=attr.attributes().get("href");//能通过Element 来获取attributes 
						
										
					}
					
					
//					System.out.println(sh2Tagc);
//					System.out.println(h2Tag.children());
					
				}
			}			
//			System.out.println(hsstr1.size());
//			Iterator iterator0=hsstr0.iterator();
//			Iterator iterator1=hsstr1.iterator();迭代器限制以及容器限制 选用LinkedHashMap
			
			
//			for(Element h2Tag:h2Tag1){//无法使用双层遍历器遍历出页面内容
//				String sh2Tag=h2Tag.text();//text函数会剔除html代码 只取文本。
//				System.out.println(sh2Tag);
//			
//			}
			
			//分离出html 下<a>...</a>之间的所有东西
//			Elements links=content.getElementsByTag("a");//空指针异常
			
			//使用这个以后下面的for无法遍历，只能遍历数组或java.lang.迭代的实例
			//Element links=doc.select("#content").first();//此处的links仍然为null
			//System.out.println(links);
			
//			Elements links=content.getElementsByTag(" ");//通过标签获得
			//扩展名为.png的图片
//			Elements pngs=doc.select("img[src$=.png]");
			
			//class等于masthead 的div标签
//			Element masthead=doc.select("div.masthead").first();//此处masthead 仍然为null
			
//			for(Element link : links){
//				//得到<a>..</a>里面的网址
//				String linkHref=link.attr("href");				
//				System.out.println(linkHref);
//				//得到<a>..</a>里面的汉字			
//				String linkText =link.text();
//				System.out.println(linkText);
//				
//			}
		
			
		}catch(	IOException e){
			e.printStackTrace();
		}
	}
}
