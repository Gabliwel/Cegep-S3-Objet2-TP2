package outfitting.button;

import javax.swing.JButton;

public class IDButtonForListOfCottage extends JButton implements IButtonID
{

	private static final long serialVersionUID = 1L;
	private String name;
	private final int id;
	
	public IDButtonForListOfCottage(String name, int id) 
	{
		this.name = name;
		this.id = id;
		setText(name);
	}
	
	public int getId() 
	{
		return this.id;
	}
}
