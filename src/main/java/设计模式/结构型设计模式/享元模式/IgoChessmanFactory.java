package 设计模式.结构型设计模式.享元模式;

import java.util.HashMap;
import java.util.Map;

public class IgoChessmanFactory {
	
	private static Map<String, IgoChessman> map = new HashMap<String, IgoChessman>();
	
	public static IgoChessman getIgoChessman(String color){
		
		IgoChessman igoChessman = map.get(color);
		
		if(igoChessman != null) return igoChessman;
		
		if("black".equals(color)){
			igoChessman = new BlackChessman();
			map.put(igoChessman.getColor(), igoChessman);
		}else if("white".equals(color)){
			igoChessman = new WhiteChessman();
			map.put(igoChessman.getColor(), igoChessman);
		}
		
	    return igoChessman;
	}
	
}
