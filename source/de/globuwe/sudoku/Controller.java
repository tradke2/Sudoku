package de.globuwe.sudoku;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import java.util.Set;

import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.JobName;

public class Controller {

	private Sudoku model = new Sudoku();

	private SudokuApplication application;

	private Solver solver = new SolverStraightImpl();

	public Controller(SudokuApplication sudokuApplication) {
		this.application = sudokuApplication;
	}

	/**
	 * @return the model
	 */
	public Sudoku getModel() {
		return model;
	}

	/**
	 * 
	 */
	public void updateModel() {
		for (int z = 0; z < 9; z++) {
			for (int s = 0; s < 9; s++) {
				model.setElement(z, s, application.getElementValue(z, s));
			}
		}
	}

	/**
	 * 
	 */
	public Set<Integer>[] checkForCollisions() {
		updateModel();
		return model.getCollisionSets();
	}

	/**
	 * 
	 */
	public void applyNextMove() {
		updateModel();
		List<Move> solution = solver.findSolution(new Sudoku(model));
		for (Move move : solution) {
			model.applyMove(move);
		}
//		if (solution != null && solution.size() > 0) {
//			model.applyMove(solution.get(0));
//		}
	}

	/**
	 * 
	 */
	public void solve() {
		updateModel();
		List<List<Move>> solutions = solver.findAllSolutions(model);
		if (solutions.size() > 0) {
			List<Move> solution = solutions.get(0);
			for (Move move : solution) {
				model.applyMove(move);
			}
		}
	}

	/**
	 * 
	 * @throws PrinterException
	 */
	public String print() {
		Printable printData = new Printable() {
			public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
				if (pageIndex > 0) {
					return Printable.NO_SUCH_PAGE;
				}
				Graphics2D g2d = (Graphics2D) g;
				int h = application.getSudokuPanel().getHeight();
				int w = application.getSudokuPanel().getWidth();
				double yOffset = (pf.getImageableHeight() / 2 - h) / 2;
				double xOffset = (pf.getImageableWidth() - w) / 2;
				g2d.translate(pf.getImageableX() + xOffset, pf.getImageableY() + yOffset);
				application.getSudokuPanel().printAll(g);
				return Printable.PAGE_EXISTS;
			}
		};

		/* Create a print job */
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(printData);
		/* locate a print service that can handle the request */
		PrintService[] services = PrinterJob.lookupPrintServices();

		if (services.length > 0) {
			System.out.println("selected printer " + services[0].getName());
			PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
			aset.add(new JobName("Sudoku", null));
			aset.add(Chromaticity.MONOCHROME);
			try {
				pj.setPrintService(services[0]);
				// pj.pageDialog(aset);
				if (pj.printDialog(aset)) {
					pj.print(aset);
					return "Die Daten wurden an den Drucker �bergeben";
				}
			} catch (PrinterException e) {
				return "Fehler: " + e.getMessage();
			}
		}
		return "Es konnte kein Druckerdienst lokalisiert werden.";
	}

}
