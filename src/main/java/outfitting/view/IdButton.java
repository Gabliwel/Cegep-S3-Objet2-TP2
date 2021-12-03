package outfitting.view;

import javax.swing.JButton;

public class IdButton extends JButton {

	private static final long serialVersionUID = 1L;
	private int idEntity;
	
	public IdButton(String detailBtn, int idEntity) {
		super(detailBtn);
		this.idEntity = idEntity;
	}

	public int getIdEntity() {
		return idEntity;
	}
}