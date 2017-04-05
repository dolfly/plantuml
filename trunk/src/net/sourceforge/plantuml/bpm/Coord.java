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
package net.sourceforge.plantuml.bpm;

public class Coord {

	private final Line line;
	private final Col col;

	public Coord(Line line, Col row) {
		if (line == null || row == null) {
			throw new IllegalArgumentException();
		}
		this.line = line;
		this.col = row;
	}

	public final Col getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "line=" + line + " col=" + col;
	}

	public final Line getLine() {
		return line;
	}

	@Override
	public int hashCode() {
		return line.hashCode() + col.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		final Coord other = (Coord) obj;
		return this.line == other.line && this.col == other.col;
	}

}
