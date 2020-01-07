package 设计模式.行为型设计模式.解释器模式;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
        List<String> inputList = new ArrayList<String>();
        
        //根据文法,有如下句子,用解释器GrammarParser来判断这些句子是否合法,并算出结果.
        inputList.add("1+2+3+4+5+6+7+8+9");
        inputList.add("1-2+3-4+5-6+7-8+9");
        inputList.add("9");
        inputList.add("-1+2+3+5");
        inputList.add("1*2");
        inputList.add("11+2+3+9");
        
        GrammarParser grammarParser = new GrammarParser();//语法分析器(解释器)
        
        for (String input : inputList) {
            Context context = new Context(input.toCharArray());
            try {
                grammarParser.parse(context);
                System.out.println(input + "=" + context.getResult());
            } catch (Exception e) {
                System.out.println("表达式{"+input+"}语法错误，请输入正确的表达式！");
            }
        }
        
    }
}
