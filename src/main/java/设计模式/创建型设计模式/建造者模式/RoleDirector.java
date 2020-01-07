package 设计模式.创建型设计模式.建造者模式;

//导演
public class RoleDirector {
	
	public static Role constructRole(RoleBuilder roleBuilder){
		
		roleBuilder.builderHeader();
		roleBuilder.builderBody();
		roleBuilder.builderFoot();
		
		return roleBuilder.builderRole();
	}

}
