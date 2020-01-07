package 设计模式.结构型设计模式.组合模式;

public class Test {
	public static void main(String[] args) {
		
		Component root = new Composite("服装");
        Component c1 = new Composite("男装");
        Component c2 = new Composite("女装");
        
        Component leaf1 = new Leaf("衬衫");
        Component leaf2 = new Leaf("夹克");
        Component leaf3 = new Leaf("裙子");
        Component leaf4 = new Leaf("套装");
        
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);
        
        root.printStruct("");
        
        //叶子结点不支持添加孩子,这就是写抽象类Component的作用,不用叶子结点重写实现
        try {
			leaf4.addChild(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
