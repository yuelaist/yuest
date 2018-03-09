package yuest.Jpachong;

public class AutoTab {

	/**
	 * @param args
	 * @author 马跃
	 * @discript 用于生成表中内容
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=85;
		String trh="<tr>";
		String trt="</tr>";
		String tdh="<td>";
		String tdt="</td>";
		StringBuilder sbNewTab=new StringBuilder();
		for(int i=1; i<=(1+((size-(size%3))/3));i++){
			sbNewTab.append(trh);
			for(int j=1;j<4;j++){
				sbNewTab.append(tdh);
				sbNewTab.append("a"+i+j+"_");
				sbNewTab.append(tdt);
			}
			sbNewTab.append(trt);
		}
		
		System.out.println(sbNewTab);

	}

}
