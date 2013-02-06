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
 * Revision $Revision: 8475 $
 *
 */
package net.sourceforge.plantuml.activitydiagram3.ftile;

import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.plantuml.Dimension2DDouble;
import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.ugraphic.UGraphic;

public class FtileForkInner implements Ftile {

	private final double smallArrow = 20;

	private final List<Ftile> forks = new ArrayList<Ftile>();

	public FtileForkInner(List<Ftile> forks) {
		for (Ftile ftile : forks) {
			final Ftile tmp = new FtileAssemblySimple(new FtileVerticalArrow(smallArrow), ftile);
			this.forks.add(new FtileMarged(tmp, 14));
		}
	}

	public void drawU(UGraphic ug, final double x, final double y) {
		final StringBounder stringBounder = ug.getStringBounder();
		final Dimension2D dimTotal = calculateDimension(stringBounder);

		double xpos = x;
		for (Ftile ftile : forks) {
			ftile.drawU(ug, xpos, y);
			final Dimension2D dim = ftile.calculateDimension(stringBounder);
			if (ftile.isKilled() == false) {
				final Ftile arrow = new FtileVerticalArrow(dimTotal.getHeight() - dim.getHeight());
				final double diffx = dim.getWidth() - arrow.calculateDimension(stringBounder).getWidth();
				arrow.drawU(ug, xpos + diffx / 2, y + dim.getHeight());
			}
			xpos += dim.getWidth();
		}
	}

	public Dimension2D calculateDimension(StringBounder stringBounder) {
		double height = 0;
		double width = 0;
		for (Ftile ftile : forks) {
			final Dimension2D dim = ftile.calculateDimension(stringBounder);
			width += dim.getWidth();
			if (dim.getHeight() > height) {
				height = dim.getHeight();
			}
		}
		return new Dimension2DDouble(width, height + smallArrow);
	}

	public List<Url> getUrls() {
		throw new UnsupportedOperationException();
	}

	public boolean isKilled() {
		return false;
	}

}
