package de.qbyte.imageviewer;

import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * TODO: Qbit - describe
 * 
 * @author bbone
 */
public class ActionModel {

	/* ***** ENUMS ***** */

	public enum ActionId {
		LOAD, ZOOM_IN, ZOOM_OUT, FIT, ORIGINAL, ROTATE;
	}

	/* ***** PROPERTIES ***** */

	private final Hashtable<ActionId, Set<Listener>>	listeners	= new Hashtable<ActionModel.ActionId, Set<Listener>>();

	/* ***** CONSTRUCTORS ***** */

	/** Creates a new ActionModel. */
	public ActionModel() {
		ActionId[] actionIds = ActionId.values();
		for (ActionId actionId : actionIds) {
			this.listeners.put(actionId, new LinkedHashSet<Listener>());
		}
	}

	/* ***** METHODS ***** */

	/**
	 * TODO: Qbit - describe
	 * 
	 * @param actionId
	 * @param listener
	 */
	public void addListener(ActionId actionId, Listener listener) {
		if (listener == null)
			return;
		this.listeners.get(actionId).add(listener);
	};

	/**
	 * TODO: Qbit - describe
	 * 
	 * @param actionId
	 * @param listener
	 */
	public void removeListener(ActionId actionId, Listener listener) {
		if (listener == null)
			return;
		this.listeners.get(actionId).remove(listener);
	}

	/**
	 * TODO: Qbit - describe
	 * 
	 * @param actionId
	 * @param event
	 */
	public void notifyListener(ActionId actionId, Event event) {
		Set<Listener> set = this.listeners.get(actionId);
		for (Listener listener : set) {
			listener.handleEvent(event);
		}
	}

}
