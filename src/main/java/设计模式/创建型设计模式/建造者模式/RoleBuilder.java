package 设计模式.创建型设计模式.建造者模式;

interface RoleBuilder {
	
	void builderHeader();
	
	void builderBody();
	
	void builderFoot();
	
	Role builderRole();

}
