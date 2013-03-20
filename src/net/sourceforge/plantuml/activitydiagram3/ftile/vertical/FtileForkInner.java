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
package net.sourceforge.plantuml.activitydiagram3.ftile.vertical;

import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.plantuml.Dimension2DDouble;
import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.activitydiagram3.LinkRendering;
import net.sourceforge.plantuml.activitydiagram3.ftile.Ftile;
import net.sourceforge.plantuml.activitydiagram3.ftile.FtileMarged;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UTranslate;

class FtileForkInner implements Ftile {

	private final double smallArrow = 20;

	private final List<Ftile> forks = new ArrayList<Ftile>();
	private final VerticalFactory factory;

	public FtileForkInner(List<Ftile> forks, VerticalFactory factory, HtmlColor color) {
		this.factory = factory;
		for (Ftile ftile : forks) {
			final Ftile arrowStart;
			if (ftile instanceof FtileGroup) {
				arrowStart = new FtileVerticalLine(smallArrow, color);
			} else {
				arrowStart = new FtileVerticalArrow(smallArrow, color);
			}
			final Ftile tmp = new FtileAssemblySimple(arrowStart, ftile);
			this.forks.add(new FtileMarged(tmp, 14));
		}
	}

	public void drawUNewWayINLINED(UGraphic ug) {
		final StringBounder stringBounder = ug.getStringBounder();
		final Dimension2D dimTotal = calculateDimension(stringBounder);
		
		double xpos = 0;
		for (Ftile ftile : forks) {
			ftile.drawUNewWayINLINED(ug.apply(new UTranslate(xpos, 0)));
			final Dimension2D dim = ftile.calculateDimension(stringBounder);
			if (ftile.isKilled() == false) {
				final Ftile arrow = factory.createVerticalArrow(dimTotal.getHeight() - dim.getHeight());
				final double diffx = dim.getWidth() - arrow.calculateDimension(stringBounder).getWidth();
				arrow.drawUNewWayINLINED(ug.apply(new UTranslate((xpos + diffx / 2), dim.getHeight())));
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

	public LinkRendering getInLinkRendering() {
		return null;
	}

}