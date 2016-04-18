package testidl;

import org.omg.CosNaming.NameComponent;

public abstract class Entite extends CorbaUtil {

  public Entite() {
	super();
  }

  public abstract void createServant();

  protected NameComponent[] nameToRegister() {
	NameComponent[] res = new NameComponent[1];
	res[0] = new NameComponent(this.getClass().getName(), "");
	return res;
  }

  public void startEntite() {
	orb.run();
  }

}
