import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.Collection;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.security.auth.x500.X500Principal;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class Main {

	private JFrame frame;
	public JTextField AdressLbl;
	public JTextField InstructionLbl;
	public JTextField DestReg;
	public JTextField Src1;
	public JTextField Src2I;
	public JButton addBtn;
	public JTextPane instListLbl;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public static JTextPane dataMemoLbl;
	public static JTextPane registersLbl;
	private JLabel lblDestinationRegister;
	private JLabel lblSoruceregister;
	private JLabel lblSoruceregister_1;
	private JLabel lblAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		dataMemory.initializeDataMemo();
		RegFile.initializeRegisters();
		populateDataMemoLbl();
		populateRegistersLbl();
		
		
	}
	public void addToList() {
		InstructionMemo.instructionlst.add(AdressLbl.getText());
		InstructionMemo.instructionlst.add(InstructionLbl.getText());
		InstructionMemo.instructionlst.add(DestReg.getText());
		InstructionMemo.instructionlst.add(Src1.getText());
		InstructionMemo.instructionlst.add(Src2I.getText());
		String x = "";
		x = AdressLbl.getText() +" "+ InstructionLbl.getText() +" "+ DestReg.getText() +" "+ Src1.getText() +" "+ Src2I.getText();
		instListLbl.setText(instListLbl.getText() + "\n" + x);
		
	}
	public static void populateDataMemoLbl() {
		dataMemoLbl.setText("");
//		for (int i = 0; i <= 396; i+=4) {
//			int y = dataMemory.dataMemo.get(i);
//			dataMemoLbl.setText(dataMemoLbl.getText() + "\n" + i + " -----> " + y);
//					
//		}
		for (Map.Entry<Integer, Integer> entry : dataMemory.dataMemo.entrySet()) {
			dataMemoLbl.setText(dataMemoLbl.getText() + "\n" + entry.getKey() + "-->" + entry.getValue());
		}
	}
	public static void populateRegistersLbl() {
		registersLbl.setText("");
		for(Map.Entry<String, Integer> entry : RegFile.registers.entrySet()) {
			registersLbl.setText(registersLbl.getText() + "\n" + entry.getKey() +" --> "+ entry.getValue());
		}
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1032, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		AdressLbl = new JTextField();
		AdressLbl.setBounds(10, 33, 191, 34);
		frame.getContentPane().add(AdressLbl);
		AdressLbl.setColumns(10);
		
		InstructionLbl = new JTextField();
		InstructionLbl.setBounds(211, 33, 191, 34);
		InstructionLbl.setColumns(10);
		frame.getContentPane().add(InstructionLbl);
		
		DestReg = new JTextField();
		DestReg.setBounds(412, 33, 191, 34);
		DestReg.setColumns(10);
		frame.getContentPane().add(DestReg);
		
		Src1 = new JTextField();
		Src1.setBounds(613, 33, 191, 34);
		Src1.setColumns(10);
		frame.getContentPane().add(Src1);
		
		Src2I = new JTextField();
		Src2I.setBounds(815, 33, 191, 34);
		Src2I.setColumns(10);
		Src2I.setAutoscrolls(true);
		frame.getContentPane().add(Src2I);
		
		addBtn = new JButton("Add Instruction");
		addBtn.setBounds(10, 78, 191, 34);
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(addBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 191, 377);
		frame.getContentPane().add(scrollPane);
		
		instListLbl = new JTextPane();
		instListLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		instListLbl.setEditable(false);
		scrollPane.setViewportView(instListLbl);
		instListLbl.setAutoscrolls(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(351, 152, 130, 377);
		frame.getContentPane().add(scrollPane_1);
		
		dataMemoLbl = new JTextPane();
		dataMemoLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		dataMemoLbl.setEditable(false);
		scrollPane_1.setViewportView(dataMemoLbl);
		dataMemoLbl.setAutoscrolls(true);
		
		JButton ExcuteBtn = new JButton("Excute");
		ExcuteBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		ExcuteBtn.setBounds(211, 78, 191, 34);
		frame.getContentPane().add(ExcuteBtn);
		ExcuteBtn.addActionListener(e -> Alu.excuteInstruction());
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(211, 152, 130, 377);
		frame.getContentPane().add(scrollPane_2);
		
		registersLbl = new JTextPane();
		registersLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		registersLbl.setEditable(false);
		scrollPane_2.setViewportView(registersLbl);
		
		JLabel lblNewLabel = new JLabel("Instructions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 123, 191, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRegisters = new JLabel("Registers");
		lblRegisters.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisters.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisters.setBounds(211, 123, 130, 18);
		frame.getContentPane().add(lblRegisters);
		
		JLabel lblMemory = new JLabel("Memory");
		lblMemory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMemory.setBounds(351, 123, 130, 18);
		frame.getContentPane().add(lblMemory);
		
		JLabel lblNewLabel_1 = new JLabel("Label\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 8, 191, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblDestinationRegister = new JLabel("Instruction");
		lblDestinationRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestinationRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestinationRegister.setBounds(211, 8, 191, 14);
		frame.getContentPane().add(lblDestinationRegister);
		
		lblSoruceregister = new JLabel("Destination Reg/RS1\r\n\r\n");
		lblSoruceregister.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoruceregister.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoruceregister.setBounds(412, 8, 191, 14);
		frame.getContentPane().add(lblSoruceregister);
		
		lblSoruceregister_1 = new JLabel("Soruce Register 1");
		lblSoruceregister_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoruceregister_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoruceregister_1.setBounds(613, 8, 191, 14);
		frame.getContentPane().add(lblSoruceregister_1);
		
		lblAddress = new JLabel("Source Register 2/Immidiate");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(815, 8, 191, 14);
		frame.getContentPane().add(lblAddress);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(491, 152, 515, 377);
		frame.getContentPane().add(scrollPane_3);
		
		JTextPane txtpnInstructionsSupported = new JTextPane();
		scrollPane_3.setViewportView(txtpnInstructionsSupported);
		txtpnInstructionsSupported.setForeground(new Color(0, 0, 0));
		txtpnInstructionsSupported.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnInstructionsSupported.setEditable(false);
		txtpnInstructionsSupported.setText("Instructions Supported \r\nAdd,addi\r\nsw,lw\r\nslt,sll,beq\r\n\r\nHow to use, Please follow the Directions carefully\r\nIf instruction Doesn\u2019t have a Label leave \"label\" text box empty.\r\n\r\nAfter each instruction press \"Add Instruction\" button to add the instruction to the list.\r\n\r\nwhen done adding the instruction press \"Execute\" to being executing the instructions one by one.\r\n\r\nWhen using the BEQ instruction the first register to be compared goes in the \"Destination Reg/RS1\" textbox and the second Register goes in the \"Source Register 1\" text box, and the label goes in the \"Source Register 2 /immediate\" text box.\r\n\r\nWhen using SW instruction, The register to be saved to memory goes in the  \"Destination Reg/RS1\" text box, and the source Register Goes in the \"source Register 1\" and the offset goes in the \"Source Register 2/Immediate\" text box.\r\n\r\nRest of the instructions Are used Normally\r\n");
		
		//add each text box a a seperate index
		addBtn.addActionListener(e -> addToList());
	}
}
