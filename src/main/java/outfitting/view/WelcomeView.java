package outfitting.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import outfitting.controller.iController.IWelcomeController;


public class WelcomeView extends JFrame implements View, ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Nos chalets";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final String WELCOME_PICTURE = "Cottage.jpg";
	private static final String WELCOME_ADD_BTN = "Ajouter un chalet";
	private static final String WELCOME_LIST_BTN = "Liste des chalets";
	private static final String WELCOME_OUTFITTING_ADD_BTN = "Ajouter une pourvoirie";
	private static final String WELCOME_OUTFITTING_LIST_BTN = "Liste des pourvoiries";

	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);

	private IWelcomeController controller;

	public WelcomeView() {
		super();
		this.initialize();
		this.setUpComponents();
	}

	/*
	 * On utilise setSize() uniquement parce qu'on a une image. setSize() est
	 * déconseillée avec un gestionnaire de mise en forme (layout). On peut utiliser
	 * la méthode pack() pour calculer la taille de fenêtre.
	 */
	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setSize(DEFAULT_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // par défaut: HIDE_ON_CLOSE
	}

	public void setController(IWelcomeController welcomeController) {
		this.controller = welcomeController;
	}

	@Override
	public void display() {
		this.setUpComponents();
		this.pack();
		this.setVisible(true);
	}

	private void setUpComponents() {
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER); // CENTER -> par défaut

		welcomePanel.setLayout(new BorderLayout()); // Strategy pattern: le gestionnaire de mise en forme
		addWelcomePicture(welcomePanel);
		addWelcomeMessage(welcomePanel);
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = new ImageIcon(this.getClass().getResource(WELCOME_PICTURE));
		JLabel welcomePicture = new JLabel(image);
		welcomePanel.add(welcomePicture); // CENTER -> par défaut
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel(); // FlowLayout par défaut pour un JPanel
		this.add(actionPanel, BorderLayout.SOUTH);
		addCreateCottageButton(actionPanel);
		addListCottageButton(actionPanel);
		addAddOutfittingButton(actionPanel);
		addListOutfittingButton(actionPanel);
	}
	
	private void addCreateCottageButton(JPanel actionPanel) {
		JButton addCottageBtn = new JButton(WELCOME_ADD_BTN);
		addCottageBtn.setActionCommand(WELCOME_ADD_BTN);
		addCottageBtn.addActionListener(this);
		actionPanel.add(addCottageBtn);
	}
	
	private void addListCottageButton(JPanel actionPanel) {
		JButton listCottageBtn = new JButton(WELCOME_LIST_BTN);
		listCottageBtn.setActionCommand(WELCOME_LIST_BTN);
		listCottageBtn.addActionListener(this);
		actionPanel.add(listCottageBtn);
	}
	
	private void addAddOutfittingButton(JPanel actionPanel) {
		JButton addOutfittingBtn = new JButton(WELCOME_OUTFITTING_ADD_BTN);
		addOutfittingBtn.setActionCommand(WELCOME_OUTFITTING_ADD_BTN);
		addOutfittingBtn.addActionListener(this);
		actionPanel.add(addOutfittingBtn);
	}
	
	private void addListOutfittingButton(JPanel actionPanel) {
		JButton listOutfittingBtn = new JButton(WELCOME_OUTFITTING_LIST_BTN);
		listOutfittingBtn.setActionCommand(WELCOME_OUTFITTING_LIST_BTN);
		listOutfittingBtn.addActionListener(this);
		actionPanel.add(listOutfittingBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case WELCOME_ADD_BTN -> this.controller.resquestCreateCottage();
			case WELCOME_LIST_BTN -> this.controller.resquestCottageList();
			case WELCOME_OUTFITTING_ADD_BTN -> this.controller.resquestAddOutfitting();
			case WELCOME_OUTFITTING_LIST_BTN -> this.controller.requestOutfittingList();
		}
	}

	@Override
	public void displayError(String message) 
	{
		JOptionPane.showInternalMessageDialog(null, message);
	}

	@Override
	public void displaySuccess(String message) { }

	@Override
	public void refresh() {	}
}
