/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.sequencediagram;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.graphic.HtmlColor;

final public class GroupingLeaf extends Grouping implements EventWithDeactivate {

	private final GroupingStart start;
	private final HtmlColor backColorGeneral;

	public GroupingLeaf(String title, String comment, GroupingType type, HtmlColor backColorGeneral,
			HtmlColor backColorElement, GroupingStart start) {
		super(title, comment, type, backColorElement);
		if (start == null) {
			throw new IllegalArgumentException();
		}
		this.backColorGeneral = backColorGeneral;
		this.start = start;
		start.addChildren(this);
	}

	public Grouping getJustAfter() {
		final int idx = start.getChildren().indexOf(this);
		if (idx == -1) {
			throw new IllegalStateException();
		}
		if (idx + 1 >= start.getChildren().size()) {
			return null;
		}
		return start.getChildren().get(idx + 1);
	}

	public GroupingStart getGroupingStart() {
		return start;
	}

	@Override
	public int getLevel() {
		return start.getLevel();
	}

	@Override
	public final HtmlColor getBackColorGeneral() {
		if (backColorGeneral == null) {
			return start.getBackColorGeneral();
		}
		return backColorGeneral;
	}

	public boolean dealWith(Participant someone) {
		return false;
	}

	public Url getUrl() {
		return null;
	}

	public boolean hasUrl() {
		return false;
	}

	@Override
	public boolean isParallel() {
		return start.isParallel();
	}

	private double posYendLevel;

	public void setPosYendLevel(double posYendLevel) {
		this.posYendLevel = posYendLevel;
	}

	public double getPosYendLevel() {
		return posYendLevel;
	}

	public boolean addLifeEvent(LifeEvent lifeEvent) {
		lifeEvent.setLinkedToGroupingEnd(true);
		return true;
	}

	private List<NoteOnMessage> noteOnMessages = new ArrayList<NoteOnMessage>();

	public final void setNote(Display strings, NotePosition notePosition, NoteStyle noteStyle, String backcolor, Url url) {
		if (notePosition != NotePosition.LEFT && notePosition != NotePosition.RIGHT) {
			throw new IllegalArgumentException();
		}
		this.noteOnMessages.add(new NoteOnMessage(strings, notePosition, noteStyle, backcolor, url));
	}
	
	public final List<NoteOnMessage> getNoteOnMessages() {
		return noteOnMessages;
	}


}
