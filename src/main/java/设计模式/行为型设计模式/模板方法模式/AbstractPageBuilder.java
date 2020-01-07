package 设计模式.行为型设计模式.模板方法模式;

public abstract class AbstractPageBuilder implements PageBuilder {

	private static final String DEFAULT_DOCTYPE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">";
    
    private static final String DEFAULT_XMLNS = "http://www.w3.org/1999/xhtml";
    
    private StringBuffer stringBuffer = new StringBuffer();
    
    //这个公共方法固化算法的步骤,让所有子类统一,省去了工作量和复用了步骤,而且还防止了混乱
    public String buildHtml() {
        stringBuffer.append(DEFAULT_DOCTYPE);
        stringBuffer.append("<html xmlns=\"" + DEFAULT_XMLNS + "\">");
        stringBuffer.append("<head>");
        appendTitle(stringBuffer);
        appendMeta(stringBuffer);
        appendLink(stringBuffer);
        appendScript(stringBuffer);
        stringBuffer.append("</head>");
        appendBody(stringBuffer);
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }
    
    //不必要的部分子类可以不重写
    protected void appendMeta(StringBuffer stringBuffer){
    }
    
    //不必要的部分子类可以不重写
    protected void appendLink(StringBuffer stringBuffer){
    }
    
    //不必要的部分子类可以不重写
    protected void appendScript(StringBuffer stringBuffer){
    }
    
    //必要的部分子类必须实现,设计成抽象方法
    protected abstract void appendTitle(StringBuffer stringBuffer);
    
    //必要的部分子类必须实现,设计成抽象方法
    protected abstract void appendBody(StringBuffer stringBuffer);
	
}
