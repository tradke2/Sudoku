package de.globuwe.sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * 
 */
public class SudokuApplication extends SingleFrameApplication {
	private JMenuBar menuBar;
	private JTextField jTextField6;
	private JTextField jTextField52;
	private JTextField jTextField53;
	private JTextField jTextField54;
	private JTextField jTextField55;
	private JTextField jTextField56;
	private JTextField jTextField57;
	private JTextField jTextField58;
	private JTextField jTextField59;
	private JMenuItem jMenuItem11;
	private JMenuItem jMenuItem10;
	private JSeparator jSeparator1;
	private JButton solveButton;
	private JMenuItem jMenuItem9;
	private JMenu toolsMenu;
	private JFileChooser fileChooser;
	private JMenuItem jMenuItem8;
	private JTextField jTextField10;
	private JTextField jTextField81;
	private JTextField jTextField80;
	private JTextField jTextField79;
	private JTextField jTextField78;
	private JTextField jTextField77;
	private JTextField jTextField76;
	private JTextField jTextField75;
	private JTextField jTextField74;
	private JTextField jTextField73;
	private JPanel quadPanel33;
	private JTextField jTextField72;
	private JTextField jTextField71;
	private JTextField jTextField70;
	private JTextField jTextField69;
	private JTextField jTextField68;
	private JTextField jTextField67;
	private JTextField jTextField66;
	private JTextField jTextField65;
	private JTextField jTextField64;
	private JPanel quadPanel32;
	private JTextField jTextField63;
	private JTextField jTextField62;
	private JTextField jTextField61;
	private JTextField jTextField60;
	private JPanel quadPanel31;
	private JTextField jTextField51;
	private JTextField jTextField50;
	private JTextField jTextField49;
	private JTextField jTextField48;
	private JTextField jTextField47;
	private JTextField jTextField46;
	private JPanel quadPanel23;
	private JTextField jTextField45;
	private JTextField jTextField44;
	private JTextField jTextField43;
	private JTextField jTextField42;
	private JTextField jTextField41;
	private JTextField jTextField40;
	private JTextField jTextField39;
	private JTextField jTextField38;
	private JTextField jTextField37;
	private JPanel quadPanel22;
	private JTextField jTextField36;
	private JTextField jTextField35;
	private JTextField jTextField34;
	private JTextField jTextField33;
	private JTextField jTextField32;
	private JTextField jTextField31;
	private JTextField jTextField30;
	private JTextField jTextField29;
	private JTextField jTextField28;
	private JPanel quadPanel21;
	private JTextField jTextField27;
	private JTextField jTextField26;
	private JTextField jTextField25;
	private JTextField jTextField24;
	private JTextField jTextField23;
	private JTextField jTextField22;
	private JTextField jTextField21;
	private JTextField jTextField20;
	private JTextField jTextField19;
	private JPanel quadPanel13;
	private JTextField jTextField18;
	private JTextField jTextField17;
	private JTextField jTextField16;
	private JTextField jTextField15;
	private JTextField jTextField14;
	private JTextField jTextField13;
	private JTextField jTextField12;
	private JTextField jTextField11;
	private JPanel quadPanel12;
	private JPanel sudokuPanel;
	private JTextField jTextField9;
	private JTextField jTextField8;
	private JTextField jTextField7;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JPanel quadPanel11;
	private JPanel topPanel;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem4;
	private JMenu editMenu;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu fileMenu;
	private JButton saveButton;
	private JButton openButton;
	private JButton newButton;
	private JToolBar toolBar;
	private JPanel toolBarPanel;
	private JPanel contentPanel;
	private JTextField[][] sudokuElements;
	private String currentFilename;

	private Controller controller = new Controller(this);

	@Action
	public void open() {
		currentFilename = chooseFile();
		if (currentFilename == null) {
			return;
		}
		deserializeSudokuElements(currentFilename);
		getMainFrame().setTitle(currentFilename);
		markCollisions();
	}

	@Action
	public void save() {
		if (currentFilename == null) {
			String filename = chooseFile();
			if (filename == null) {
				return;
			}
			currentFilename = filename;
		}
		serializeSudokuElements(currentFilename);
	}

	@Action
	public void saveAs() {
		String filename = chooseFile();
		if (filename == null) {
			return;
		}
		currentFilename = filename;
		serializeSudokuElements(currentFilename);
	}

	@Action
	public void newFile() {
		currentFilename = null;
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				sudokuElements[z][s].setText("");
			}
		}
		ResourceMap rm = getContext().getResourceMap();
		getMainFrame().setTitle(rm.getString("mainFrame.title"));
		markCollisions();
	}

	@Action
	public void nextMove() {
		getAppActionMap().get("nextMove").setEnabled(false);
		final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				controller.applyNextMove();
				return null;
			}
		};
		worker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE == evt.getNewValue()) {
					try {
						worker.get();
						refresh();
						markCollisions();
					} catch (ExecutionException e) {
						showErrorMessage(e);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						getAppActionMap().get("nextMove").setEnabled(true);
					}
				}
			}
		});
		worker.execute();
	}

	@Action
	public void solve() {
		getAppActionMap().get("nextMove").setEnabled(false);
		final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				controller.solve();
				return null;
			}
		};
		worker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE == evt.getNewValue()) {
					try {
						worker.get();
						refresh();
						markCollisions();
					} catch (ExecutionException e) {
						showErrorMessage(e);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						getAppActionMap().get("nextMove").setEnabled(true);
					}
				}
			}
		});
		worker.execute();
	}


	@Action
	public void print() {
		final SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
			@Override
			protected String doInBackground() throws Exception {
				return controller.print();
			}
		};
		worker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE == evt.getNewValue()) {
					try {
						String msg = worker.get();
						JOptionPane.showMessageDialog(getMainFrame(), msg);
					} catch (ExecutionException e) {
						showErrorMessage(e);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		worker.execute();
	}

	private ActionMap getAppActionMap() {
		return Application.getInstance().getContext().getActionMap(this);
	}

	@Override
	protected void startup() {
		{
			getMainFrame().setSize(492, 326);
		}
		{
			topPanel = new JPanel();
			BorderLayout panelLayout = new BorderLayout();
			topPanel.setLayout(panelLayout);
			topPanel.setPreferredSize(new java.awt.Dimension(500, 300));
			{
				contentPanel = new JPanel();
				GroupLayout contentPanelLayout = new GroupLayout((JComponent) contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				topPanel.add(contentPanel, BorderLayout.CENTER);
				contentPanel.setPreferredSize(new java.awt.Dimension(502, 244));
				contentPanelLayout.setHorizontalGroup(contentPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(getSudokuPanel(), GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(233, 233));
				contentPanelLayout.setVerticalGroup(contentPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(getSudokuPanel(), GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(35, 35));
			}
			{
				toolBarPanel = new JPanel();
				topPanel.add(toolBarPanel, BorderLayout.NORTH);
				BorderLayout jPanel1Layout = new BorderLayout();
				toolBarPanel.setLayout(jPanel1Layout);
				{
					toolBar = new JToolBar();
					toolBarPanel.add(toolBar, BorderLayout.CENTER);
					{
						newButton = new JButton();
						toolBar.add(newButton);
						newButton.setAction(getAppActionMap().get("newFile"));
						newButton.setName("newButton");
						newButton.setFocusable(false);
					}
					{
						openButton = new JButton();
						toolBar.add(openButton);
						openButton.setAction(getAppActionMap().get("open"));
						openButton.setName("openButton");
						openButton.setFocusable(false);
					}
					{
						saveButton = new JButton();
						toolBar.add(saveButton);
						toolBar.add(getNextMoveButton());
						saveButton.setAction(getAppActionMap().get("save"));
						saveButton.setName("saveButton");
						saveButton.setFocusable(false);
					}
				}
			}
		}
		menuBar = new JMenuBar();
		{
			fileMenu = new JMenu();
			menuBar.add(fileMenu);
			fileMenu.setName("fileMenu");
			{
				jMenuItem1 = new JMenuItem();
				fileMenu.add(jMenuItem1);
				jMenuItem1.setAction(getAppActionMap().get("newFile"));
			}
			{
				jMenuItem2 = new JMenuItem();
				fileMenu.add(jMenuItem2);
				jMenuItem2.setAction(getAppActionMap().get("open"));
			}
			{
				jMenuItem3 = new JMenuItem();
				fileMenu.add(jMenuItem3);
				jMenuItem3.setAction(getAppActionMap().get("save"));
			}
			{
				jMenuItem8 = new JMenuItem();
				fileMenu.add(jMenuItem8);
				fileMenu.add(getJSeparator1());
				fileMenu.add(getJMenuItem10());
				jMenuItem8.setAction(getAppActionMap().get("saveAs"));
			}
		}
		{
			editMenu = new JMenu();
			menuBar.add(editMenu);
			menuBar.add(getToolsMenu());
			editMenu.setName("editMenu");
			{
				jMenuItem4 = new JMenuItem();
				editMenu.add(jMenuItem4);
				jMenuItem4.setAction(getAppActionMap().get("copy"));
			}
			{
				jMenuItem5 = new JMenuItem();
				editMenu.add(jMenuItem5);
				jMenuItem5.setAction(getAppActionMap().get("cut"));
			}
			{
				jMenuItem6 = new JMenuItem();
				editMenu.add(jMenuItem6);
				jMenuItem6.setAction(getAppActionMap().get("paste"));
			}
			{
				jMenuItem7 = new JMenuItem();
				editMenu.add(jMenuItem7);
				jMenuItem7.setAction(getAppActionMap().get("delete"));
			}
		}
		getMainFrame().setJMenuBar(menuBar);
		// $hide>>$
		initSudokuElements();
		addElementVerifier();
		// $hide<<$
		show(topPanel);
	}

	public static void main(String[] args) {
		launch(SudokuApplication.class, args);
	}

	private JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		return fileChooser;
	}

	private JMenu getToolsMenu() {
		if (toolsMenu == null) {
			toolsMenu = new JMenu();
			toolsMenu.setName("toolsMenu");
			toolsMenu.add(getJMenuItem9());
			toolsMenu.add(getJMenuItem11());
		}
		return toolsMenu;
	}

	private JMenuItem getJMenuItem9() {
		if (jMenuItem9 == null) {
			jMenuItem9 = new JMenuItem();
			jMenuItem9.setAction(getAppActionMap().get("nextMove"));
		}
		return jMenuItem9;
	}

	private JButton getNextMoveButton() {
		if (solveButton == null) {
			solveButton = new JButton();
			solveButton.setAction(getAppActionMap().get("nextMove"));
			solveButton.setName("solveButton");
		}
		return solveButton;
	}

	private JSeparator getJSeparator1() {
		if (jSeparator1 == null) {
			jSeparator1 = new JSeparator();
		}
		return jSeparator1;
	}

	private JMenuItem getJMenuItem10() {
		if (jMenuItem10 == null) {
			jMenuItem10 = new JMenuItem();
			jMenuItem10.setAction(getAppActionMap().get("print"));
		}
		return jMenuItem10;
	}

	public JPanel getSudokuPanel() {
		if (sudokuPanel == null) {
			sudokuPanel = new JPanel();
			GridLayout jPanel1Layout1 = new GridLayout(3, 3);
			jPanel1Layout1.setColumns(3);
			jPanel1Layout1.setHgap(5);
			jPanel1Layout1.setVgap(5);
			jPanel1Layout1.setRows(3);
			sudokuPanel.setLayout(jPanel1Layout1);
			sudokuPanel.setFocusable(false);
			sudokuPanel.setSize(236, 236);
			sudokuPanel.add(getQuadPanel11());
			sudokuPanel.add(getQuadPanel12());
			sudokuPanel.add(getQuadPanel13());
			sudokuPanel.add(getQuadPanel21());
			sudokuPanel.add(getQuadPanel22());
			sudokuPanel.add(getQuadPanel23());
			sudokuPanel.add(getQuadPanel31());
			sudokuPanel.add(getQuadPanel32());
			sudokuPanel.add(getQuadPanel33());
		}
		return sudokuPanel;
	}

	private JPanel getQuadPanel11() {
		if (quadPanel11 == null) {
			quadPanel11 = new JPanel();
			GridLayout quadPanel11Layout = new GridLayout(3, 3);
			quadPanel11Layout.setColumns(3);
			quadPanel11Layout.setRows(3);
			quadPanel11.setLayout(quadPanel11Layout);
			quadPanel11.setName("quadPanel11");
			{
				jTextField1 = new JTextField();
				quadPanel11.add(jTextField1);
				jTextField1.setName("jTextField1");
				jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField2 = new JTextField();
				quadPanel11.add(jTextField2);
				jTextField2.setName("jTextField2");
				jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField3 = new JTextField();
				quadPanel11.add(jTextField3);
				jTextField3.setName("jTextField3");
				jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField4 = new JTextField();
				quadPanel11.add(jTextField4);
				jTextField4.setName("jTextField4");
				jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField5 = new JTextField();
				quadPanel11.add(jTextField5);
				jTextField5.setName("jTextField5");
				jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField6 = new JTextField();
				quadPanel11.add(jTextField6);
				jTextField6.setName("jTextField6");
				jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField7 = new JTextField();
				quadPanel11.add(jTextField7);
				jTextField7.setName("jTextField7");
				jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField8 = new JTextField();
				quadPanel11.add(jTextField8);
				jTextField8.setName("jTextField8");
				jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField9 = new JTextField();
				quadPanel11.add(jTextField9);
				jTextField9.setName("jTextField9");
				jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel11;
	}

	private JPanel getQuadPanel12() {
		if (quadPanel12 == null) {
			quadPanel12 = new JPanel();
			GridLayout jPanel1Layout2 = new GridLayout(3, 3);
			jPanel1Layout2.setColumns(3);
			jPanel1Layout2.setRows(3);
			quadPanel12.setLayout(jPanel1Layout2);
			quadPanel12.setName("quadPanael12");
			{
				jTextField10 = new JTextField();
				quadPanel12.add(jTextField10);
				jTextField10.setName("jTextField1");
				jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField11 = new JTextField();
				quadPanel12.add(jTextField11);
				jTextField11.setName("jTextField2");
				jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField12 = new JTextField();
				quadPanel12.add(jTextField12);
				jTextField12.setName("jTextField3");
				jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField13 = new JTextField();
				quadPanel12.add(jTextField13);
				jTextField13.setName("jTextField4");
				jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField14 = new JTextField();
				quadPanel12.add(jTextField14);
				jTextField14.setName("jTextField5");
				jTextField14.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField15 = new JTextField();
				quadPanel12.add(jTextField15);
				jTextField15.setName("jTextField6");
				jTextField15.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField16 = new JTextField();
				quadPanel12.add(jTextField16);
				jTextField16.setName("jTextField7");
				jTextField16.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField17 = new JTextField();
				quadPanel12.add(jTextField17);
				jTextField17.setName("jTextField8");
				jTextField17.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField18 = new JTextField();
				quadPanel12.add(jTextField18);
				jTextField18.setName("jTextField9");
				jTextField18.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel12;
	}

	private JPanel getQuadPanel13() {
		if (quadPanel13 == null) {
			quadPanel13 = new JPanel();
			GridLayout jPanel1Layout3 = new GridLayout(3, 3);
			jPanel1Layout3.setColumns(3);
			jPanel1Layout3.setRows(3);
			quadPanel13.setLayout(jPanel1Layout3);
			quadPanel13.setName("quadPanel13");
			{
				jTextField19 = new JTextField();
				quadPanel13.add(jTextField19);
				jTextField19.setName("jTextField1");
				jTextField19.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField20 = new JTextField();
				quadPanel13.add(jTextField20);
				jTextField20.setName("jTextField2");
				jTextField20.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField21 = new JTextField();
				quadPanel13.add(jTextField21);
				jTextField21.setName("jTextField3");
				jTextField21.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField22 = new JTextField();
				quadPanel13.add(jTextField22);
				jTextField22.setName("jTextField4");
				jTextField22.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField23 = new JTextField();
				quadPanel13.add(jTextField23);
				jTextField23.setName("jTextField5");
				jTextField23.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField24 = new JTextField();
				quadPanel13.add(jTextField24);
				jTextField24.setName("jTextField6");
				jTextField24.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField25 = new JTextField();
				quadPanel13.add(jTextField25);
				jTextField25.setName("jTextField7");
				jTextField25.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField26 = new JTextField();
				quadPanel13.add(jTextField26);
				jTextField26.setName("jTextField8");
				jTextField26.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField27 = new JTextField();
				quadPanel13.add(jTextField27);
				jTextField27.setName("jTextField9");
				jTextField27.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel13;
	}

	private JPanel getQuadPanel21() {
		if (quadPanel21 == null) {
			quadPanel21 = new JPanel();
			GridLayout jPanel1Layout4 = new GridLayout(3, 3);
			jPanel1Layout4.setColumns(3);
			jPanel1Layout4.setRows(3);
			quadPanel21.setLayout(jPanel1Layout4);
			quadPanel21.setName("quadPanel21");
			{
				jTextField28 = new JTextField();
				quadPanel21.add(jTextField28);
				jTextField28.setName("jTextField1");
				jTextField28.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField29 = new JTextField();
				quadPanel21.add(jTextField29);
				jTextField29.setName("jTextField2");
				jTextField29.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField30 = new JTextField();
				quadPanel21.add(jTextField30);
				jTextField30.setName("jTextField3");
				jTextField30.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField31 = new JTextField();
				quadPanel21.add(jTextField31);
				jTextField31.setName("jTextField4");
				jTextField31.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField32 = new JTextField();
				quadPanel21.add(jTextField32);
				jTextField32.setName("jTextField5");
				jTextField32.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField33 = new JTextField();
				quadPanel21.add(jTextField33);
				jTextField33.setName("jTextField6");
				jTextField33.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField34 = new JTextField();
				quadPanel21.add(jTextField34);
				jTextField34.setName("jTextField7");
				jTextField34.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField35 = new JTextField();
				quadPanel21.add(jTextField35);
				jTextField35.setName("jTextField8");
				jTextField35.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField36 = new JTextField();
				quadPanel21.add(jTextField36);
				jTextField36.setName("jTextField9");
				jTextField36.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel21;
	}

	private JPanel getQuadPanel22() {
		if (quadPanel22 == null) {
			quadPanel22 = new JPanel();
			GridLayout jPanel1Layout5 = new GridLayout(3, 3);
			jPanel1Layout5.setColumns(3);
			jPanel1Layout5.setRows(3);
			quadPanel22.setLayout(jPanel1Layout5);
			quadPanel22.setName("quadPanel22");
			{
				jTextField37 = new JTextField();
				quadPanel22.add(jTextField37);
				jTextField37.setName("jTextField1");
				jTextField37.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField38 = new JTextField();
				quadPanel22.add(jTextField38);
				jTextField38.setName("jTextField2");
				jTextField38.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField39 = new JTextField();
				quadPanel22.add(jTextField39);
				jTextField39.setName("jTextField3");
				jTextField39.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField40 = new JTextField();
				quadPanel22.add(jTextField40);
				jTextField40.setName("jTextField4");
				jTextField40.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField41 = new JTextField();
				quadPanel22.add(jTextField41);
				jTextField41.setName("jTextField5");
				jTextField41.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField42 = new JTextField();
				quadPanel22.add(jTextField42);
				jTextField42.setName("jTextField6");
				jTextField42.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField43 = new JTextField();
				quadPanel22.add(jTextField43);
				jTextField43.setName("jTextField7");
				jTextField43.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField44 = new JTextField();
				quadPanel22.add(jTextField44);
				jTextField44.setName("jTextField8");
				jTextField44.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField45 = new JTextField();
				quadPanel22.add(jTextField45);
				jTextField45.setName("jTextField9");
				jTextField45.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel22;
	}

	private JPanel getQuadPanel23() {
		if (quadPanel23 == null) {
			quadPanel23 = new JPanel();
			GridLayout jPanel1Layout6 = new GridLayout(3, 3);
			jPanel1Layout6.setColumns(3);
			jPanel1Layout6.setRows(3);
			quadPanel23.setLayout(jPanel1Layout6);
			quadPanel23.setName("quadPanel23");
			{
				jTextField46 = new JTextField();
				quadPanel23.add(jTextField46);
				jTextField46.setName("jTextField1");
				jTextField46.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField47 = new JTextField();
				quadPanel23.add(jTextField47);
				jTextField47.setName("jTextField2");
				jTextField47.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField48 = new JTextField();
				quadPanel23.add(jTextField48);
				jTextField48.setName("jTextField3");
				jTextField48.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField49 = new JTextField();
				quadPanel23.add(jTextField49);
				jTextField49.setName("jTextField4");
				jTextField49.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField50 = new JTextField();
				quadPanel23.add(jTextField50);
				jTextField50.setName("jTextField5");
				jTextField50.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField51 = new JTextField();
				quadPanel23.add(jTextField51);
				jTextField51.setName("jTextField6");
				jTextField51.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField52 = new JTextField();
				quadPanel23.add(jTextField52);
				jTextField52.setName("jTextField7");
				jTextField52.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField53 = new JTextField();
				quadPanel23.add(jTextField53);
				jTextField53.setName("jTextField8");
				jTextField53.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField54 = new JTextField();
				quadPanel23.add(jTextField54);
				jTextField54.setName("jTextField9");
				jTextField54.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel23;
	}

	private JPanel getQuadPanel31() {
		if (quadPanel31 == null) {
			quadPanel31 = new JPanel();
			GridLayout jPanel1Layout7 = new GridLayout(3, 3);
			jPanel1Layout7.setColumns(3);
			jPanel1Layout7.setRows(3);
			quadPanel31.setLayout(jPanel1Layout7);
			quadPanel31.setName("quadPanel31");
			{
				jTextField55 = new JTextField();
				quadPanel31.add(jTextField55);
				jTextField55.setName("jTextField1");
				jTextField55.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField56 = new JTextField();
				quadPanel31.add(jTextField56);
				jTextField56.setName("jTextField2");
				jTextField56.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField57 = new JTextField();
				quadPanel31.add(jTextField57);
				jTextField57.setName("jTextField3");
				jTextField57.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField58 = new JTextField();
				quadPanel31.add(jTextField58);
				jTextField58.setName("jTextField4");
				jTextField58.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField59 = new JTextField();
				quadPanel31.add(jTextField59);
				jTextField59.setName("jTextField5");
				jTextField59.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField60 = new JTextField();
				quadPanel31.add(jTextField60);
				jTextField60.setName("jTextField6");
				jTextField60.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField61 = new JTextField();
				quadPanel31.add(jTextField61);
				jTextField61.setName("jTextField7");
				jTextField61.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField62 = new JTextField();
				quadPanel31.add(jTextField62);
				jTextField62.setName("jTextField8");
				jTextField62.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField63 = new JTextField();
				quadPanel31.add(jTextField63);
				jTextField63.setName("jTextField9");
				jTextField63.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel31;
	}

	private JPanel getQuadPanel32() {
		if (quadPanel32 == null) {
			quadPanel32 = new JPanel();
			GridLayout jPanel1Layout8 = new GridLayout(3, 3);
			jPanel1Layout8.setColumns(3);
			jPanel1Layout8.setRows(3);
			quadPanel32.setLayout(jPanel1Layout8);
			quadPanel32.setName("quadPanel32");
			{
				jTextField64 = new JTextField();
				quadPanel32.add(jTextField64);
				jTextField64.setName("jTextField1");
				jTextField64.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField65 = new JTextField();
				quadPanel32.add(jTextField65);
				jTextField65.setName("jTextField2");
				jTextField65.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField66 = new JTextField();
				quadPanel32.add(jTextField66);
				jTextField66.setName("jTextField3");
				jTextField66.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField67 = new JTextField();
				quadPanel32.add(jTextField67);
				jTextField67.setName("jTextField4");
				jTextField67.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField68 = new JTextField();
				quadPanel32.add(jTextField68);
				jTextField68.setName("jTextField5");
				jTextField68.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField69 = new JTextField();
				quadPanel32.add(jTextField69);
				jTextField69.setName("jTextField6");
				jTextField69.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField70 = new JTextField();
				quadPanel32.add(jTextField70);
				jTextField70.setName("jTextField7");
				jTextField70.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField71 = new JTextField();
				quadPanel32.add(jTextField71);
				jTextField71.setName("jTextField8");
				jTextField71.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField72 = new JTextField();
				quadPanel32.add(jTextField72);
				jTextField72.setName("jTextField9");
				jTextField72.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel32;
	}

	private JPanel getQuadPanel33() {
		if (quadPanel33 == null) {
			quadPanel33 = new JPanel();
			GridLayout jPanel1Layout9 = new GridLayout(3, 3);
			jPanel1Layout9.setColumns(3);
			jPanel1Layout9.setRows(3);
			quadPanel33.setLayout(jPanel1Layout9);
			quadPanel33.setName("quadPanel33");
			{
				jTextField73 = new JTextField();
				quadPanel33.add(jTextField73);
				jTextField73.setName("jTextField1");
				jTextField73.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField74 = new JTextField();
				quadPanel33.add(jTextField74);
				jTextField74.setName("jTextField2");
				jTextField74.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField75 = new JTextField();
				quadPanel33.add(jTextField75);
				jTextField75.setName("jTextField3");
				jTextField75.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField76 = new JTextField();
				quadPanel33.add(jTextField76);
				jTextField76.setName("jTextField4");
				jTextField76.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField77 = new JTextField();
				quadPanel33.add(jTextField77);
				jTextField77.setName("jTextField5");
				jTextField77.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField78 = new JTextField();
				quadPanel33.add(jTextField78);
				jTextField78.setName("jTextField6");
				jTextField78.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField79 = new JTextField();
				quadPanel33.add(jTextField79);
				jTextField79.setName("jTextField7");
				jTextField79.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField80 = new JTextField();
				quadPanel33.add(jTextField80);
				jTextField80.setName("jTextField8");
				jTextField80.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextField81 = new JTextField();
				quadPanel33.add(jTextField81);
				jTextField81.setName("jTextField9");
				jTextField81.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		return quadPanel33;
	}

	/**
	 * 
	 * @param e
	 */
	protected void showErrorMessage(ExecutionException e) {
		String why = null;
		Throwable cause = e.getCause();
		if (cause != null) {
			why = cause.getMessage();
		} else {
			why = e.getMessage();
		}
		e.printStackTrace(System.err);
		JOptionPane.showMessageDialog(getMainFrame(), "Fehler: " + why, "Fehler", JOptionPane.ERROR_MESSAGE);
	}
	
	private JMenuItem getJMenuItem11() {
		if(jMenuItem11 == null) {
			jMenuItem11 = new JMenuItem();
			jMenuItem11.setName("jMenuItem11");
			jMenuItem11.setAction(getAppActionMap().get("solve"));
		}
		return jMenuItem11;
	}
	
	
	// $hide>>$

	/**
	 * 
	 */
	private void initSudokuElements() {

		sudokuElements = new JTextField[9][];
		for (int i = 0; i < 9; i++) {
			sudokuElements[i] = new JTextField[9];
		}
		Component[] quadPanels = sudokuPanel.getComponents();
		for (int i = 0; i < quadPanels.length; i++) {
			if (quadPanels[i] instanceof JPanel) {
				Component[] els = ((JPanel) quadPanels[i]).getComponents();
				for (int j = 0; j < els.length; j++) {
					int z = (i / 3) * 3 + j / 3;
					int s = (i % 3) * 3 + j % 3;
					sudokuElements[z][s] = (JTextField) els[j];
				}
			}
		}
	}

	/**
	 * 
	 */
	private void addElementVerifier() {
		InputVerifier iv = new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				boolean result = verifyInput(input);
				result = result && markCollisions();
				return result;
			}
		};
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuElements[i][j].setInputVerifier(iv);
			}
		}
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	protected boolean verifyInput(JComponent input) {
		String txt = ((JTextField) input).getText().trim();
		if (txt.isEmpty()) {
			return true;
		}
		try {
			int i = Integer.parseInt(txt);
			if (!(i <= 9 && i >= 1)) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * @param filename
	 * 
	 */
	private void serializeSudokuElements(String filename) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int z = 0; z < 9; z++) {
			if (z > 0) {
				sb.append(" ");
			}
			sb.append("[");
			for (int s = 0; s < 9; s++) {
				if (s > 0) {
					sb.append(" ");
				}
				String str = sudokuElements[z][s].getText();
				if (str.isEmpty()) {
					sb.append("0");
				} else {
					sb.append(str);
				}
			}
			sb.append("]");
			sb.append(System.getProperty("line.separator"));
		}
		sb.append("]");
		try {
			Writer fw = new BufferedWriter(new FileWriter(filename, false));
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	private String chooseFile() {
		JFileChooser chooser = getFileChooser();
		final String extension = "sud";
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Sudoku", extension);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(getMainFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().getAbsolutePath();
			if (filename.lastIndexOf(".") == -1) {
				filename = filename + "." + extension;
			}
			return filename;
		}
		return null;
	}

	/**
	 * 
	 * @param filename
	 */
	private void deserializeSudokuElements(String filename) {
		try {
			Reader fr = new BufferedReader(new FileReader(filename));
			int c = fr.read();
			c = skipWhitespace(fr, c);
			parseSudoku(fr, c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param fr
	 * @param current
	 * @throws IOException
	 */
	private void parseSudoku(Reader fr, int current) throws IOException {
		int c = current;
		if (c != '[') {
			throw new IOException("Illegal Character '" + c + "'");
		}
		c = fr.read();
		for (int z = 0; z < 9; z++) {
			c = skipWhitespace(fr, c);
			c = parseSudokuLine(fr, c, z);
		}
		c = skipWhitespace(fr, c);
		if (c != ']') {
			throw new IOException("Illegal Character '" + c + "'");
		}
		c = fr.read();
	}

	/**
	 * 
	 * @param fr
	 * @param current
	 * @param z
	 * @throws IOException
	 */
	private int parseSudokuLine(Reader fr, int current, int z) throws IOException {
		int c = current;
		if (c != '[') {
			throw new IOException("Illegal Character '" + c + "'");
		}
		c = fr.read();
		for (int s = 0; s < 9; s++) {
			StringBuilder sb = new StringBuilder();
			c = skipWhitespace(fr, c);
			sb.append((char) c);
			while (true) {
				c = fr.read();
				if (c == -1) {
					throw new IOException("Unexpected EOF");
				}
				if (Character.isWhitespace(c) || c == ']') {
					break;
				}
				sb.append((char) c);
			}
			try {
				int val = Integer.parseInt(sb.toString());
				if (val < 0 || val > 9) {
					throw new IOException("Illegal value: " + val);
				}
				if (val == 0) {
					sudokuElements[z][s].setText("");
				} else {
					sudokuElements[z][s].setText(sb.toString());
				}
			} catch (NumberFormatException e) {
				throw new IOException("Illegal value: " + sb);
			}
		}
		c = skipWhitespace(fr, c);
		if (c != ']') {
			throw new IOException("Illegal Character '" + c + "'");
		}
		c = fr.read();
		return c;
	}

	/**
	 * 
	 * @param fr
	 * @throws IOException
	 */
	private int skipWhitespace(Reader fr, int current) throws IOException {
		int c = current;
		while (Character.isWhitespace(c) && c != -1) {
			c = fr.read();
		}
		return c;
	}

	/**
	 * 
	 * @param z
	 * @param s
	 * @return
	 */
	public int getElementValue(int z, int s) {
		int val = 0;
		try {
			val = Integer.parseInt(sudokuElements[z][s].getText());
		} catch (NumberFormatException e) {
			// ok
		}
		return val;
	}

	/**
	 * 
	 */
	private boolean markCollisions() {
		Set<Integer>[] collSets = controller.checkForCollisions();
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				sudokuElements[z][s].setBackground(Color.white);
			}
		}

		int maxSize = 0;
		for (int i = 0; i < collSets.length; i++) {
			if (collSets[i].size() > maxSize) {
				maxSize = collSets[i].size();
			}
			for (int e : collSets[i]) {
				int s = e % 10;
				int z = e / 10;
				sudokuElements[z][s].setBackground(Color.pink);
			}
		}
		return maxSize == 0;
	}

	/**
	 * 
	 */
	public void refresh() {
		Sudoku model = controller.getModel();
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				int v = model.getElement(z, s);
				if (v == 0) {
					sudokuElements[z][s].setText("");
				} else {
					sudokuElements[z][s].setText(Integer.toString(v));
				}
			}
		}
	}

	// $hide<<$

}
