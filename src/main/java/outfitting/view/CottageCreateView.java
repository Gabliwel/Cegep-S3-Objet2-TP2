package outfitting.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outfitting.controller.ICottageCreateController;

public class CottageCreateView extends JDialog implements View {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Ajout d'un chalet";

	ICottageCreateController controller;

	private JTextField name = new JTextField(30);
	private JTextField guests = new JTextField(3);

	public CottageCreateView() {
		super();
		this.initialize();
		this.setUpComponents();
		this.pack(); // Pour forcer le calcul de la taille de la fenêtre
	}

	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// this.setLayout(new BorderLayout(10,10));
		// this.setModalityType(DEFAULT_MODALITY_TYPE);
	}

	public void setController(ICottageCreateController cottageCreateController) {
		// FIXME TODO
	}

	@Override
	public void display() {
		// FIXME TODO
	}

	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();
		this.setUpOtherPanels();
	}

	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	private void setUpInputDataPanel() {
		// FIXME TODO
		// Conteneur intermédiaire JPanel qui contient les étiquettes (JLabel) et les
		// zones de textes (JTextField)
		// Utiliser un GridLayout comme LayoutManager (2 colonnes)
	}

	private void setUpActionPanel() {
		// FIXME TODO
		// Conteneur intermédiaire JPanel qui contient le bouton pour ajouter un chalet
	}

}
