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
 * Revision $Revision: 5183 $
 *
 */
package net.sourceforge.plantuml.activitydiagram3.ftile.vertical;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.List;

import net.sourceforge.plantuml.Dimension2DDouble;
import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.activitydiagram3.ftile.AbstractFtile2;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.graphic.TextBlock;
import net.sourceforge.plantuml.ugraphic.UChangeBackColor;
import net.sourceforge.plantuml.ugraphic.UChangeColor;
import net.sourceforge.plantuml.ugraphic.UEllipse;
import net.sourceforge.plantuml.ugraphic.UGraphic;

public class FtileCircleStart extends AbstractFtile2 {

	private static final int SIZE = 20;

	private final HtmlColor backColor;

	public FtileCircleStart(HtmlColor backColor) {
		this.backColor = backColor;
	}

	public TextBlock asTextBlock() {
		return new TextBlock() {

			public void drawUNewWayINLINED(UGraphic ug) {
				final UEllipse circle = new UEllipse(SIZE, SIZE);
				if (SHADOWING) {
					circle.setDeltaShadow(3);
				}
				ug.apply(new UChangeColor(null)).apply(new UChangeBackColor(backColor)).drawOldWay(circle);
			}

			public Dimension2D calculateDimension(StringBounder stringBounder) {
				return new Dimension2DDouble(SIZE, SIZE);
			}

			public List<Url> getUrls() {
				return Collections.emptyList();
			}
		};
	}

	public boolean isKilled() {
		return false;
	}

	public Point2D getPointIn(StringBounder stringBounder) {
		return new Point2D.Double(SIZE / 2, 0);
	}

	public Point2D getPointOut(StringBounder stringBounder) {
		return new Point2D.Double(SIZE / 2, SIZE);
	}

}