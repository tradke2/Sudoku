package de.globuwe.sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


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
public class SudokuPanel extends javax.swing.JPanel {
	private JPanel quadPanel11;
	private JTextField jTextField1;
	private JTextField jTextField10;
	private JTextField jTextField20;
	private JTextField jTextField22;
	private JTextField jTextField21;
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
	private JTextField jTextField9;
	private JTextField jTextField8;
	private JTextField jTextField7;
	private JTextField jTextField6;
	private JTextField jTextField52;
	private JTextField jTextField53;
	private JTextField jTextField54;
	private JTextField jTextField55;
	private JTextField jTextField56;
	private JTextField jTextField57;
	private JTextField jTextField58;
	private JTextField jTextField59;
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
	private JTextField jTextField30;
	private JTextField jTextField31;
	private JTextField jTextField32;
	private JTextField jTextField33;
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
	private JTextField jTextField29;
	private JTextField jTextField28;
	private JPanel quadPanel21;
	private JTextField jTextField27;
	private JTextField jTextField26;
	private JTextField jTextField25;
	private JTextField jTextField24;
	private JTextField jTextField23;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SudokuPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public SudokuPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(236, 236));
			getThis();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JPanel getThis() {
		GridLayout thisLayout = new GridLayout(3, 3);
		thisLayout.setColumns(3);
		thisLayout.setRows(3);
		thisLayout.setHgap(5);
		thisLayout.setVgap(5);
		this.setLayout(thisLayout);
		this.setSize(236, 236);
		this.setFocusable(false);
		this.add(getQuadPanel11());
		this.add(getQuadPanel12());
		this.add(getQuadPanel13());
		this.add(getQuadPanel21());
		this.add(getQuadPanel22());
		this.add(getQuadPanel23());
		this.add(getQuadPanel31());
		this.add(getQuadPanel32());
		this.add(getQuadPanel33());
		if(this == null) {
			
		}
		return this;
	}
	
	
	private JPanel getQuadPanel11() {
		if(quadPanel11 == null) {
			quadPanel11 = new JPanel();
			GridLayout quadPanel11Layout = new GridLayout(3, 3);
			quadPanel11Layout.setColumns(3);
			quadPanel11Layout.setRows(3);
			quadPanel11.setLayout(quadPanel11Layout);
			quadPanel11.setName("quadPanel11");
			quadPanel11.add(getJTextField1());
			quadPanel11.add(getJTextField2());
			quadPanel11.add(getJTextField3());
			quadPanel11.add(getJTextField4());
			quadPanel11.add(getJTextField5());
			quadPanel11.add(getJTextField6());
			quadPanel11.add(getJTextField7());
			quadPanel11.add(getJTextField8());
			quadPanel11.add(getJTextField9());
		}
		return quadPanel11;
	}
	
	private JTextField getJTextField1() {
		if(jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField1.setName("jTextField1");
		}
		return jTextField1;
	}
	
	private JTextField getJTextField2() {
		if(jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField2.setName("jTextField2");
		}
		return jTextField2;
	}
	
	private JTextField getJTextField3() {
		if(jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField3.setName("jTextField3");
		}
		return jTextField3;
	}
	
	private JTextField getJTextField4() {
		if(jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField4.setName("jTextField4");
		}
		return jTextField4;
	}
	
	private JTextField getJTextField5() {
		if(jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField5.setName("jTextField5");
		}
		return jTextField5;
	}
	
	private JTextField getJTextField6() {
		if(jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField6.setName("jTextField6");
		}
		return jTextField6;
	}
	
	private JTextField getJTextField7() {
		if(jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField7.setName("jTextField7");
		}
		return jTextField7;
	}
	
	private JTextField getJTextField8() {
		if(jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField8.setName("jTextField8");
		}
		return jTextField8;
	}
	
	private JTextField getJTextField9() {
		if(jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField9.setName("jTextField9");
		}
		return jTextField9;
	}
	
	private JPanel getQuadPanel12() {
		if(quadPanel12 == null) {
			quadPanel12 = new JPanel();
			GridLayout jPanel1Layout2 = new GridLayout(3, 3);
			jPanel1Layout2.setColumns(3);
			jPanel1Layout2.setRows(3);
			quadPanel12.setLayout(jPanel1Layout2);
			quadPanel12.setName("quadPanael12");
			quadPanel12.add(getJTextField10());
			quadPanel12.add(getJTextField11());
			quadPanel12.add(getJTextField12());
			quadPanel12.add(getJTextField13());
			quadPanel12.add(getJTextField14());
			quadPanel12.add(getJTextField15());
			quadPanel12.add(getJTextField16());
			quadPanel12.add(getJTextField17());
			quadPanel12.add(getJTextField18());
		}
		return quadPanel12;
	}
	
	private JTextField getJTextField10() {
		if(jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField10.setName("jTextField1");
		}
		return jTextField10;
	}
	
	private JTextField getJTextField11() {
		if(jTextField11 == null) {
			jTextField11 = new JTextField();
			jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField11.setName("jTextField2");
		}
		return jTextField11;
	}
	
	private JTextField getJTextField12() {
		if(jTextField12 == null) {
			jTextField12 = new JTextField();
			jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField12.setName("jTextField3");
		}
		return jTextField12;
	}
	
	private JTextField getJTextField13() {
		if(jTextField13 == null) {
			jTextField13 = new JTextField();
			jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField13.setName("jTextField4");
		}
		return jTextField13;
	}
	
	private JTextField getJTextField14() {
		if(jTextField14 == null) {
			jTextField14 = new JTextField();
			jTextField14.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField14.setName("jTextField5");
		}
		return jTextField14;
	}
	
	private JTextField getJTextField15() {
		if(jTextField15 == null) {
			jTextField15 = new JTextField();
			jTextField15.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField15.setName("jTextField6");
		}
		return jTextField15;
	}
	
	private JTextField getJTextField16() {
		if(jTextField16 == null) {
			jTextField16 = new JTextField();
			jTextField16.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField16.setName("jTextField7");
		}
		return jTextField16;
	}
	
	private JTextField getJTextField17() {
		if(jTextField17 == null) {
			jTextField17 = new JTextField();
			jTextField17.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField17.setName("jTextField8");
		}
		return jTextField17;
	}
	
	private JTextField getJTextField18() {
		if(jTextField18 == null) {
			jTextField18 = new JTextField();
			jTextField18.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField18.setName("jTextField9");
		}
		return jTextField18;
	}
	
	private JPanel getQuadPanel13() {
		if(quadPanel13 == null) {
			quadPanel13 = new JPanel();
			GridLayout jPanel1Layout3 = new GridLayout(3, 3);
			jPanel1Layout3.setColumns(3);
			jPanel1Layout3.setRows(3);
			quadPanel13.setLayout(jPanel1Layout3);
			quadPanel13.setName("quadPanel13");
			quadPanel13.add(getJTextField19());
			quadPanel13.add(getJTextField20());
			quadPanel13.add(getJTextField21());
			quadPanel13.add(getJTextField22());
			quadPanel13.add(getJTextField23());
			quadPanel13.add(getJTextField24());
			quadPanel13.add(getJTextField25());
			quadPanel13.add(getJTextField26());
			quadPanel13.add(getJTextField27());
		}
		return quadPanel13;
	}
	
	private JTextField getJTextField19() {
		if(jTextField19 == null) {
			jTextField19 = new JTextField();
			jTextField19.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField19.setName("jTextField1");
		}
		return jTextField19;
	}
	
	private JTextField getJTextField20() {
		if(jTextField20 == null) {
			jTextField20 = new JTextField();
			jTextField20.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField20.setName("jTextField2");
		}
		return jTextField20;
	}
	
	private JTextField getJTextField21() {
		if(jTextField21 == null) {
			jTextField21 = new JTextField();
			jTextField21.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField21.setName("jTextField3");
		}
		return jTextField21;
	}
	
	private JTextField getJTextField22() {
		if(jTextField22 == null) {
			jTextField22 = new JTextField();
			jTextField22.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField22.setName("jTextField4");
		}
		return jTextField22;
	}
	
	private JTextField getJTextField23() {
		if(jTextField23 == null) {
			jTextField23 = new JTextField();
			jTextField23.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField23.setName("jTextField5");
		}
		return jTextField23;
	}
	
	private JTextField getJTextField24() {
		if(jTextField24 == null) {
			jTextField24 = new JTextField();
			jTextField24.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField24.setName("jTextField6");
		}
		return jTextField24;
	}
	
	private JTextField getJTextField25() {
		if(jTextField25 == null) {
			jTextField25 = new JTextField();
			jTextField25.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField25.setName("jTextField7");
		}
		return jTextField25;
	}
	
	private JTextField getJTextField26() {
		if(jTextField26 == null) {
			jTextField26 = new JTextField();
			jTextField26.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField26.setName("jTextField8");
		}
		return jTextField26;
	}
	
	private JTextField getJTextField27() {
		if(jTextField27 == null) {
			jTextField27 = new JTextField();
			jTextField27.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField27.setName("jTextField9");
		}
		return jTextField27;
	}
	
	private JPanel getQuadPanel21() {
		if(quadPanel21 == null) {
			quadPanel21 = new JPanel();
			GridLayout jPanel1Layout4 = new GridLayout(3, 3);
			jPanel1Layout4.setColumns(3);
			jPanel1Layout4.setRows(3);
			quadPanel21.setLayout(jPanel1Layout4);
			quadPanel21.setName("quadPanel21");
			quadPanel21.add(getJTextField28());
			quadPanel21.add(getJTextField29());
			quadPanel21.add(getJTextField30());
			quadPanel21.add(getJTextField31());
			quadPanel21.add(getJTextField32());
			quadPanel21.add(getJTextField33());
			quadPanel21.add(getJTextField34());
			quadPanel21.add(getJTextField35());
			quadPanel21.add(getJTextField36());
		}
		return quadPanel21;
	}
	
	private JTextField getJTextField28() {
		if(jTextField28 == null) {
			jTextField28 = new JTextField();
			jTextField28.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField28.setName("jTextField1");
		}
		return jTextField28;
	}
	
	private JTextField getJTextField29() {
		if(jTextField29 == null) {
			jTextField29 = new JTextField();
			jTextField29.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField29.setName("jTextField2");
		}
		return jTextField29;
	}
	
	private JTextField getJTextField30() {
		if(jTextField30 == null) {
			jTextField30 = new JTextField();
			jTextField30.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField30.setName("jTextField3");
		}
		return jTextField30;
	}
	
	private JTextField getJTextField31() {
		if(jTextField31 == null) {
			jTextField31 = new JTextField();
			jTextField31.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField31.setName("jTextField4");
		}
		return jTextField31;
	}
	
	private JTextField getJTextField32() {
		if(jTextField32 == null) {
			jTextField32 = new JTextField();
			jTextField32.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField32.setName("jTextField5");
		}
		return jTextField32;
	}
	
	private JTextField getJTextField33() {
		if(jTextField33 == null) {
			jTextField33 = new JTextField();
			jTextField33.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField33.setName("jTextField6");
		}
		return jTextField33;
	}
	
	private JTextField getJTextField34() {
		if(jTextField34 == null) {
			jTextField34 = new JTextField();
			jTextField34.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField34.setName("jTextField7");
		}
		return jTextField34;
	}
	
	private JTextField getJTextField35() {
		if(jTextField35 == null) {
			jTextField35 = new JTextField();
			jTextField35.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField35.setName("jTextField8");
		}
		return jTextField35;
	}
	
	private JTextField getJTextField36() {
		if(jTextField36 == null) {
			jTextField36 = new JTextField();
			jTextField36.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField36.setName("jTextField9");
		}
		return jTextField36;
	}
	
	private JPanel getQuadPanel22() {
		if(quadPanel22 == null) {
			quadPanel22 = new JPanel();
			GridLayout jPanel1Layout5 = new GridLayout(3, 3);
			jPanel1Layout5.setColumns(3);
			jPanel1Layout5.setRows(3);
			quadPanel22.setLayout(jPanel1Layout5);
			quadPanel22.setName("quadPanel22");
			quadPanel22.add(getJTextField37());
			quadPanel22.add(getJTextField38());
			quadPanel22.add(getJTextField39());
			quadPanel22.add(getJTextField40());
			quadPanel22.add(getJTextField41());
			quadPanel22.add(getJTextField42());
			quadPanel22.add(getJTextField43());
			quadPanel22.add(getJTextField44());
			quadPanel22.add(getJTextField45());
		}
		return quadPanel22;
	}
	
	private JTextField getJTextField37() {
		if(jTextField37 == null) {
			jTextField37 = new JTextField();
			jTextField37.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField37.setName("jTextField1");
		}
		return jTextField37;
	}
	
	private JTextField getJTextField38() {
		if(jTextField38 == null) {
			jTextField38 = new JTextField();
			jTextField38.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField38.setName("jTextField2");
		}
		return jTextField38;
	}
	
	private JTextField getJTextField39() {
		if(jTextField39 == null) {
			jTextField39 = new JTextField();
			jTextField39.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField39.setName("jTextField3");
		}
		return jTextField39;
	}
	
	private JTextField getJTextField40() {
		if(jTextField40 == null) {
			jTextField40 = new JTextField();
			jTextField40.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField40.setName("jTextField4");
		}
		return jTextField40;
	}
	
	private JTextField getJTextField41() {
		if(jTextField41 == null) {
			jTextField41 = new JTextField();
			jTextField41.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField41.setName("jTextField5");
		}
		return jTextField41;
	}
	
	private JTextField getJTextField42() {
		if(jTextField42 == null) {
			jTextField42 = new JTextField();
			jTextField42.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField42.setName("jTextField6");
		}
		return jTextField42;
	}
	
	private JTextField getJTextField43() {
		if(jTextField43 == null) {
			jTextField43 = new JTextField();
			jTextField43.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField43.setName("jTextField7");
		}
		return jTextField43;
	}
	
	private JTextField getJTextField44() {
		if(jTextField44 == null) {
			jTextField44 = new JTextField();
			jTextField44.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField44.setName("jTextField8");
		}
		return jTextField44;
	}
	
	private JTextField getJTextField45() {
		if(jTextField45 == null) {
			jTextField45 = new JTextField();
			jTextField45.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField45.setName("jTextField9");
		}
		return jTextField45;
	}
	
	private JPanel getQuadPanel23() {
		if(quadPanel23 == null) {
			quadPanel23 = new JPanel();
			GridLayout jPanel1Layout6 = new GridLayout(3, 3);
			jPanel1Layout6.setColumns(3);
			jPanel1Layout6.setRows(3);
			quadPanel23.setLayout(jPanel1Layout6);
			quadPanel23.setName("quadPanel23");
			quadPanel23.add(getJTextField46());
			quadPanel23.add(getJTextField47());
			quadPanel23.add(getJTextField48());
			quadPanel23.add(getJTextField49());
			quadPanel23.add(getJTextField50());
			quadPanel23.add(getJTextField51());
			quadPanel23.add(getJTextField52());
			quadPanel23.add(getJTextField53());
			quadPanel23.add(getJTextField54());
		}
		return quadPanel23;
	}
	
	private JTextField getJTextField46() {
		if(jTextField46 == null) {
			jTextField46 = new JTextField();
			jTextField46.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField46.setName("jTextField1");
		}
		return jTextField46;
	}
	
	private JTextField getJTextField47() {
		if(jTextField47 == null) {
			jTextField47 = new JTextField();
			jTextField47.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField47.setName("jTextField2");
		}
		return jTextField47;
	}
	
	private JTextField getJTextField48() {
		if(jTextField48 == null) {
			jTextField48 = new JTextField();
			jTextField48.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField48.setName("jTextField3");
		}
		return jTextField48;
	}
	
	private JTextField getJTextField49() {
		if(jTextField49 == null) {
			jTextField49 = new JTextField();
			jTextField49.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField49.setName("jTextField4");
		}
		return jTextField49;
	}
	
	private JTextField getJTextField50() {
		if(jTextField50 == null) {
			jTextField50 = new JTextField();
			jTextField50.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField50.setName("jTextField5");
		}
		return jTextField50;
	}
	
	private JTextField getJTextField51() {
		if(jTextField51 == null) {
			jTextField51 = new JTextField();
			jTextField51.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField51.setName("jTextField6");
		}
		return jTextField51;
	}
	
	private JTextField getJTextField52() {
		if(jTextField52 == null) {
			jTextField52 = new JTextField();
			jTextField52.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField52.setName("jTextField7");
		}
		return jTextField52;
	}
	
	private JTextField getJTextField53() {
		if(jTextField53 == null) {
			jTextField53 = new JTextField();
			jTextField53.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField53.setName("jTextField8");
		}
		return jTextField53;
	}
	
	private JTextField getJTextField54() {
		if(jTextField54 == null) {
			jTextField54 = new JTextField();
			jTextField54.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField54.setName("jTextField9");
		}
		return jTextField54;
	}
	
	private JPanel getQuadPanel31() {
		if(quadPanel31 == null) {
			quadPanel31 = new JPanel();
			GridLayout jPanel1Layout7 = new GridLayout(3, 3);
			jPanel1Layout7.setColumns(3);
			jPanel1Layout7.setRows(3);
			quadPanel31.setLayout(jPanel1Layout7);
			quadPanel31.setName("quadPanel31");
			quadPanel31.add(getJTextField55());
			quadPanel31.add(getJTextField56());
			quadPanel31.add(getJTextField57());
			quadPanel31.add(getJTextField58());
			quadPanel31.add(getJTextField59());
			quadPanel31.add(getJTextField60());
			quadPanel31.add(getJTextField61());
			quadPanel31.add(getJTextField62());
			quadPanel31.add(getJTextField63());
		}
		return quadPanel31;
	}
	
	private JTextField getJTextField55() {
		if(jTextField55 == null) {
			jTextField55 = new JTextField();
			jTextField55.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField55.setName("jTextField1");
		}
		return jTextField55;
	}
	
	private JTextField getJTextField56() {
		if(jTextField56 == null) {
			jTextField56 = new JTextField();
			jTextField56.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField56.setName("jTextField2");
		}
		return jTextField56;
	}
	
	private JTextField getJTextField57() {
		if(jTextField57 == null) {
			jTextField57 = new JTextField();
			jTextField57.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField57.setName("jTextField3");
		}
		return jTextField57;
	}
	
	private JTextField getJTextField58() {
		if(jTextField58 == null) {
			jTextField58 = new JTextField();
			jTextField58.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField58.setName("jTextField4");
		}
		return jTextField58;
	}
	
	private JTextField getJTextField59() {
		if(jTextField59 == null) {
			jTextField59 = new JTextField();
			jTextField59.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField59.setName("jTextField5");
		}
		return jTextField59;
	}
	
	private JTextField getJTextField60() {
		if(jTextField60 == null) {
			jTextField60 = new JTextField();
			jTextField60.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField60.setName("jTextField6");
		}
		return jTextField60;
	}
	
	private JTextField getJTextField61() {
		if(jTextField61 == null) {
			jTextField61 = new JTextField();
			jTextField61.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField61.setName("jTextField7");
		}
		return jTextField61;
	}
	
	private JTextField getJTextField62() {
		if(jTextField62 == null) {
			jTextField62 = new JTextField();
			jTextField62.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField62.setName("jTextField8");
		}
		return jTextField62;
	}
	
	private JTextField getJTextField63() {
		if(jTextField63 == null) {
			jTextField63 = new JTextField();
			jTextField63.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField63.setName("jTextField9");
		}
		return jTextField63;
	}
	
	private JPanel getQuadPanel32() {
		if(quadPanel32 == null) {
			quadPanel32 = new JPanel();
			GridLayout jPanel1Layout8 = new GridLayout(3, 3);
			jPanel1Layout8.setColumns(3);
			jPanel1Layout8.setRows(3);
			quadPanel32.setLayout(jPanel1Layout8);
			quadPanel32.setName("quadPanel32");
			quadPanel32.add(getJTextField64());
			quadPanel32.add(getJTextField65());
			quadPanel32.add(getJTextField66());
			quadPanel32.add(getJTextField67());
			quadPanel32.add(getJTextField68());
			quadPanel32.add(getJTextField69());
			quadPanel32.add(getJTextField70());
			quadPanel32.add(getJTextField71());
			quadPanel32.add(getJTextField72());
		}
		return quadPanel32;
	}
	
	private JTextField getJTextField64() {
		if(jTextField64 == null) {
			jTextField64 = new JTextField();
			jTextField64.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField64.setName("jTextField1");
		}
		return jTextField64;
	}
	
	private JTextField getJTextField65() {
		if(jTextField65 == null) {
			jTextField65 = new JTextField();
			jTextField65.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField65.setName("jTextField2");
		}
		return jTextField65;
	}
	
	private JTextField getJTextField66() {
		if(jTextField66 == null) {
			jTextField66 = new JTextField();
			jTextField66.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField66.setName("jTextField3");
		}
		return jTextField66;
	}
	
	private JTextField getJTextField67() {
		if(jTextField67 == null) {
			jTextField67 = new JTextField();
			jTextField67.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField67.setName("jTextField4");
		}
		return jTextField67;
	}
	
	private JTextField getJTextField68() {
		if(jTextField68 == null) {
			jTextField68 = new JTextField();
			jTextField68.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField68.setName("jTextField5");
		}
		return jTextField68;
	}
	
	private JTextField getJTextField69() {
		if(jTextField69 == null) {
			jTextField69 = new JTextField();
			jTextField69.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField69.setName("jTextField6");
		}
		return jTextField69;
	}
	
	private JTextField getJTextField70() {
		if(jTextField70 == null) {
			jTextField70 = new JTextField();
			jTextField70.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField70.setName("jTextField7");
		}
		return jTextField70;
	}
	
	private JTextField getJTextField71() {
		if(jTextField71 == null) {
			jTextField71 = new JTextField();
			jTextField71.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField71.setName("jTextField8");
		}
		return jTextField71;
	}
	
	private JTextField getJTextField72() {
		if(jTextField72 == null) {
			jTextField72 = new JTextField();
			jTextField72.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField72.setName("jTextField9");
		}
		return jTextField72;
	}
	
	private JPanel getQuadPanel33() {
		if(quadPanel33 == null) {
			quadPanel33 = new JPanel();
			GridLayout jPanel1Layout9 = new GridLayout(3, 3);
			jPanel1Layout9.setColumns(3);
			jPanel1Layout9.setRows(3);
			quadPanel33.setLayout(jPanel1Layout9);
			quadPanel33.setName("quadPanel33");
			quadPanel33.add(getJTextField73());
			quadPanel33.add(getJTextField74());
			quadPanel33.add(getJTextField75());
			quadPanel33.add(getJTextField76());
			quadPanel33.add(getJTextField77());
			quadPanel33.add(getJTextField78());
			quadPanel33.add(getJTextField79());
			quadPanel33.add(getJTextField80());
			quadPanel33.add(getJTextField81());
		}
		return quadPanel33;
	}
	
	private JTextField getJTextField73() {
		if(jTextField73 == null) {
			jTextField73 = new JTextField();
			jTextField73.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField73.setName("jTextField1");
		}
		return jTextField73;
	}
	
	private JTextField getJTextField74() {
		if(jTextField74 == null) {
			jTextField74 = new JTextField();
			jTextField74.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField74.setName("jTextField2");
		}
		return jTextField74;
	}
	
	private JTextField getJTextField75() {
		if(jTextField75 == null) {
			jTextField75 = new JTextField();
			jTextField75.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField75.setName("jTextField3");
		}
		return jTextField75;
	}
	
	private JTextField getJTextField76() {
		if(jTextField76 == null) {
			jTextField76 = new JTextField();
			jTextField76.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField76.setName("jTextField4");
		}
		return jTextField76;
	}
	
	private JTextField getJTextField77() {
		if(jTextField77 == null) {
			jTextField77 = new JTextField();
			jTextField77.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField77.setName("jTextField5");
		}
		return jTextField77;
	}
	
	private JTextField getJTextField78() {
		if(jTextField78 == null) {
			jTextField78 = new JTextField();
			jTextField78.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField78.setName("jTextField6");
		}
		return jTextField78;
	}
	
	private JTextField getJTextField79() {
		if(jTextField79 == null) {
			jTextField79 = new JTextField();
			jTextField79.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField79.setName("jTextField7");
		}
		return jTextField79;
	}
	
	private JTextField getJTextField80() {
		if(jTextField80 == null) {
			jTextField80 = new JTextField();
			jTextField80.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField80.setName("jTextField8");
		}
		return jTextField80;
	}
	
	private JTextField getJTextField81() {
		if(jTextField81 == null) {
			jTextField81 = new JTextField();
			jTextField81.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField81.setName("jTextField9");
		}
		return jTextField81;
	}
}
