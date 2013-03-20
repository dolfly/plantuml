/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2013, Arnaud Roques
 *
 * Project Info:  http://plantuml.sourceforge.net
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
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 *
 * Revision $Revision: 9786 $
 *
 */
package net.sourceforge.plantuml.activitydiagram3;

import net.sourceforge.plantuml.activitydiagram3.ftile.Ftile;
import net.sourceforge.plantuml.activitydiagram3.ftile.FtileFactory;
import net.sourceforge.plantuml.cucadiagram.Display;

public class InstructionRepeat implements Instruction {

	private final InstructionList repeatList = new InstructionList();
	private final Instruction parent;
	private final LinkRendering nextLinkRenderer;

	private Display test;
	private LinkRendering endRepeatLinkRendering;

	public InstructionRepeat(Instruction parent, LinkRendering nextLinkRenderer) {
		this.parent = parent;
		this.nextLinkRenderer = nextLinkRenderer;
	}

	public void add(Instruction ins) {
		repeatList.add(ins);
	}

	public Ftile createFtile(FtileFactory factory) {
		return factory.repeat(repeatList.createFtile(factory), test, endRepeatLinkRendering);
	}

	public Instruction getParent() {
		return parent;
	}

	public void setTest(Display test, LinkRendering linkRenderer) {
		this.test = test;
		this.endRepeatLinkRendering = linkRenderer;
	}

	public boolean kill() {
		return repeatList.kill();
	}
	
	public LinkRendering getInLinkRendering() {
		return nextLinkRenderer;
	}

	public void addNote(Display note) {
		throw new UnsupportedOperationException();
	}


}