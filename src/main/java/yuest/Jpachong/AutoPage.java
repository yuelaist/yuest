package yuest.Jpachong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoPage {

	/**
	 * @author yuest
	 * @param args
	 * 用来生成上下页面的代码
	 */
	public static void main(String[] args) {	
		//首先把能生成代码的文件读入进来（后期也可以自动生成）

		File fCodeFile=new File("D://workspace/boubeiPage");//文件路径中的斜杠问题 http://blog.csdn.net/carrot_hufei/article/details/52652935
		File fAdressFile=new File("D://workspace/boubeiaPage");
//		File fResultFile=new File("");
		BufferedReader br=null;
		BufferedReader abr=null;
		try {
			br=new BufferedReader(new FileReader(fCodeFile));
			
			abr=new BufferedReader(new FileReader(fAdressFile));
			
			StringBuilder sb=new StringBuilder();
			StringBuilder asb=new StringBuilder();
			
			
			String sCodeString="";
			String sAdressString="";
			while(sCodeString !=null){
		//把读进来的数据放到一个字符串或者其它格式的变量中
				sb.append(sCodeString.trim());
				sCodeString=br.readLine();
			}
			
			while(sAdressString !=null){
		//把页面文件读入进来，放到一个变量中
				asb.append(sAdressString.trim());
				sAdressString=abr.readLine();
			}			
			//文件中要用*号来做切割符
			String [] ause=asb.toString().split("\\*");
			String sos="";
			int j;
			for(int i=0;i<ause.length-2;i++){//多个数值读取数组长度就要考虑多个值，防止数组越界，，而且要考虑实际应用场景。
				j=i+2;//先前的写法是j=i++ ；结果是j小于i 
				System.out.println("<div align=\"center\"><a href=\""+ause[i]+" \">返回阅读上一小节</a>&nbsp; |&nbsp; <a href=\""+ause[j]+" \">继续阅读下一小节</a> </div>");
				System.out.println("");
				//			System.out.println(ause[i]);	
			}
			System.out.println(sos);
//			System.out.println(sb.toString());
//			System.out.println(asb.toString());
		} catch (FileNotFoundException fnfe) {
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
				try {
					abr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		//然后把Page变量根据地址特点进行切分
		
		//用循环将第一个文件中响应的字符串替换为Page变量切分后的地址
		
		//替换后输出一个新的文件 
	}

}
// 	https://www.cnblogs.com/A_ming/archive/2010/04/13/1711395.html 	String StringBuffer StringBuilder 三者的区别
//	https://www.cnblogs.com/mingforyou/archive/2013/09/03/3299569.html	split()的用法
