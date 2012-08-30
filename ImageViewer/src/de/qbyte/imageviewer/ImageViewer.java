package de.qbyte.imageviewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import de.qbyte.imageviewer.ActionModel.ActionId;

public class ImageViewer {

	/* ***** PROPERTIES ***** */

	private final Display		display	= new Display();
	private final ActionModel	actionModel = new ActionModel();
	private final Shell			shell;
	private final ImageCanvas	canvas;

	/* ***** CONSTRUCTORS ***** */

	private ImageViewer() {

		// initialize shell
		shell = new Shell(display);
		shell.setSize(800, 600);
		shell.setText("Image Viewer");
		shell.setLayout(new GridLayout(1, false));

		// create application
		new ImageToolBar(shell, actionModel);
		canvas = new ImageCanvas(shell, SWT.NONE);
		
		// register listeners
		actionModel.addListener(ActionId.LOAD, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.load();
			}
		});
		actionModel.addListener(ActionId.ZOOM_IN, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.zoomIn();
			}
		});
		actionModel.addListener(ActionId.ZOOM_OUT, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.zoomOut();
			}
		});
		actionModel.addListener(ActionId.FIT, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.fit();
			}
		});
		actionModel.addListener(ActionId.ORIGINAL, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.original();
			}
		});
		actionModel.addListener(ActionId.ROTATE, new Listener() {
			@Override
			public void handleEvent(Event event) {
				canvas.rotate();
			}
		});

		// application loop
		shell.open();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

	/* ***** MAIN ***** */

	public static void main(String[] args) {
		new ImageViewer();
	}

}
