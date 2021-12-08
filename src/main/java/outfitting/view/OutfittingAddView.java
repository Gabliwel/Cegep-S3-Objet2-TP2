package outfitting.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outfitting.controller.IOutfittingAddController;
import outfitting.dto.OutfittingDtoForAdd;
import outfitting.model.entity.Contact;
import outfitting.model.entity.RegionName;

public class OutfittingAddView extends JDialog implements View, ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Ajouter une pourvoirie";
	private static final String OUTFITTING_NAME = "Nom de la pourvoirie:";
	private static final String OUTFITTING_REGION = "Région de la pourvoirie:";
	private static final String OUTFITTING_PHONE_NUMBER = "Numéro de téléphone de la pourvoirie:";
	private static final String OUTFITTING_EMAIL = "Email de la pourvoirie";
	private static final String OUTFITTING__CONTACT_NAME = "Nom du contact de la pourvoirie:";
	private static final String OUTFITTING_CONTACT_PHONE_NUMBER = "Numéro de téléphone du contact de la pourvoirie:";
	private static final String OUTFITTING_CONTACT_EMAIL = "Email du contact de la pourvoirie:";
	private static final String ADD_OUTFITTING = "BTN_ADD_OUTFITTING";
	private static final String BTN_ADD_OUTFITTING = "Ajouter";
	
	private JTextField name = new JTextField(30);
	private JComboBox<String> region = new JComboBox<String>(RegionName.getAllRegionNames());
	private JTextField phoneNumber = new JTextField(3);
	private JTextField email = new JTextField(3);
	private JTextField contactName = new JTextField(3);
	private JTextField contactPhoneNumber = new JTextField(3);
	private JTextField contactEmail = new JTextField(3);
	
	private IOutfittingAddController controller;
	
	public OutfittingAddView() {
		super();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}

	public void setController(IOutfittingAddController outfittingAddController) {
		this.controller = outfittingAddController;
	}
	
	@Override
	public void display() {
		this.setUpComponents();
		this.pack();
		this.setVisible(true);
	}

	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();
		this.setUpOtherPanels();
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel(); 
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton addOutfittingBtn = new JButton(BTN_ADD_OUTFITTING);
		addOutfittingBtn.setActionCommand(ADD_OUTFITTING);
		addOutfittingBtn.addActionListener(this);
		actionPanel.add(addOutfittingBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case ADD_OUTFITTING -> sendAddDtoToController();
		}
	}

	private void sendAddDtoToController() {
		if(name != null && !name.getText().isBlank() && region != null && region.getSelectedItem().toString()!= "" &&
				phoneNumber != null && !phoneNumber.getText().isBlank() && email != null && !email.getText().isBlank() &&
					contactName !=null && !contactName.getText().isBlank() && contactPhoneNumber != null && !contactPhoneNumber.getText().isBlank() &&
						contactEmail != null && !contactEmail.getText().isBlank())
		{
			controller.addDtoOutfitting(new OutfittingDtoForAdd(name.getText(), region.getSelectedItem().toString(), phoneNumber.getText(), 
					email.getText(), new Contact(contactName.getText(), contactPhoneNumber.getText(), contactEmail.getText())));
			this.dispose();
		}
		else
		{
			JOptionPane.showInternalMessageDialog(null, "La pourvoirie n'a pas été ajouté, veuiller bien remplir tout les champs.", "Erreur", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void setUpInputDataPanel() {
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		
		inputDataPanel.setLayout(new GridLayout(4, 4));
		
		JLabel outfittingName = new JLabel(OUTFITTING_NAME);
		inputDataPanel.add(outfittingName);
		
		inputDataPanel.add(name);
		
		JLabel outfttingRegion = new JLabel(OUTFITTING_REGION);
		inputDataPanel.add(outfttingRegion);
		
		inputDataPanel.add(region);
		
		JLabel outfittingPhoneNumber = new JLabel(OUTFITTING_PHONE_NUMBER);
		inputDataPanel.add(outfittingPhoneNumber);
		
		inputDataPanel.add(phoneNumber);
		
		JLabel outfittingEmail = new JLabel(OUTFITTING_EMAIL);
		inputDataPanel.add(outfittingEmail);
		
		inputDataPanel.add(email);
		
		JLabel outfittingContactName = new JLabel(OUTFITTING__CONTACT_NAME);
		inputDataPanel.add(outfittingContactName);
		
		inputDataPanel.add(contactName);
		
		JLabel outfittingContactPhoneNumber = new JLabel(OUTFITTING_CONTACT_PHONE_NUMBER);
		inputDataPanel.add(outfittingContactPhoneNumber);
		
		inputDataPanel.add(contactPhoneNumber);
		
		JLabel outfittingContactEmail = new JLabel(OUTFITTING_CONTACT_EMAIL);
		inputDataPanel.add(outfittingContactEmail);
		
		inputDataPanel.add(contactEmail);
	}

	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	@Override
	public void displayError(String message) {
		JOptionPane.showInternalMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void displaySuccess(String message) {
		JOptionPane.showInternalMessageDialog(null, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void refresh() {	}
}