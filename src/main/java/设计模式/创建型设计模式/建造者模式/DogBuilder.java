package 设计模式.创建型设计模式.建造者模式;

public class DogBuilder implements RoleBuilder{
	
	private Role role;

	public DogBuilder() {
		this.role = new Role();
	}

	@Override
	public void builderHeader() {
		role.setHead("狗的头构造完毕");
	}

	@Override
	public void builderBody() {
		role.setBody("狗的身体构造完毕");
	}

	@Override
	public void builderFoot() {
		role.setFoot("狗的脚构造完毕");
	}

	@Override
	public Role builderRole() {
		return role;
	}
}
