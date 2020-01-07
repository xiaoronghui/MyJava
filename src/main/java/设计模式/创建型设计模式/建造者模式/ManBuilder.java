package 设计模式.创建型设计模式.建造者模式;

public class ManBuilder implements RoleBuilder {
	
	private Role role;

	public ManBuilder() {
		this.role = new Role();
	}

	@Override
	public void builderHeader() {
		role.setHead("人物的头构造完毕");
	}

	@Override
	public void builderBody() {
		role.setBody("人物的身体构造完毕");
	}

	@Override
	public void builderFoot() {
		role.setFoot("人物的脚构造完毕");
	}

	@Override
	public Role builderRole() {
		return role;
	}

}
