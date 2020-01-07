package 设计模式.结构型设计模式.代理模式;

public class BusinessServiceImpl implements BusinessService{

	@Override
	public int add(String a) {
		System.out.println("新增 :{"+a+"}");
		return 1;
	}

	@Override
	public void update(String b) {
		System.out.println("更新 : {"+b+"}");
	}

}
