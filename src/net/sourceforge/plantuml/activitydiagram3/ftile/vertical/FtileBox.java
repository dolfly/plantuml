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
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.sourceforge.plantuml.Dimension2DDouble;
import net.sourceforge.plantuml.SpriteContainerEmpty;
import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.activitydiagram3.LinkRendering;
import net.sourceforge.plantuml.activitydiagram3.ftile.AbstractFtile;
import net.sourceforge.plantuml.activitydiagram3.ftile.Swimlane;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.graphic.FontConfiguration;
import net.sourceforge.plantuml.graphic.HorizontalAlignment;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.HtmlColorUtils;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.graphic.TextBlock;
import net.sourceforge.plantuml.graphic.TextBlockUtils;
import net.sourceforge.plantuml.ugraphic.Shadowable;
import net.sourceforge.plantuml.ugraphic.UChangeBackColor;
import net.sourceforge.plantuml.ugraphic.UChangeColor;
import net.sourceforge.plantuml.ugraphic.UFont;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.URectangle;
import net.sourceforge.plantuml.ugraphic.UStroke;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class FtileBox extends AbstractFtile {

	private static final int CORNER = 25;
	private static final int MARGIN = 10;

	private final TextBlock tb;

	private final HtmlColor color;
	private final HtmlColor backColor;
	private final LinkRendering inRenreding;
	private final Swimlane swimlane;

	final public LinkRendering getInLinkRendering() {
		return inRenreding;
	}

	public Set<Swimlane> getSwimlanes() {
		if (swimlane == null) {
			return Collections.emptySet();
		}
		return Collections.singleton(swimlane);
	}

	public Swimlane getSwimlaneIn() {
		return swimlane;
	}

	public Swimlane getSwimlaneOut() {
		return swimlane;
	}

	public FtileBox(boolean shadowing, Display label, HtmlColor color, HtmlColor backColor, UFont font,
			HtmlColor arrowColor, Swimlane swimlane) {
		super(shadowing);
		this.color = color;
		this.swimlane = swimlane;
		this.backColor = backColor;
		this.inRenreding = new LinkRendering(arrowColor);
		final FontConfiguration fc = new FontConfiguration(font, HtmlColorUtils.BLACK);
		tb = TextBlockUtils.create(label, fc, HorizontalAlignment.LEFT, new SpriteContainerEmpty());
		this.print = label.toString();
	}

	final private String print;

	@Override
	public String toString() {
		return print;
	}

	public TextBlock asTextBlock() {
		return new TextBlock() {

			public void drawU(UGraphic ug) {
				final Dimension2D dimTotal = calculateDimension(ug.getStringBounder());
				// final Dimension2D dimDesc =
				// tb.calculateDimension(ug.getStringBounder());

				final double widthTotal = dimTotal.getWidth();
				final double heightTotal = dimTotal.getHeight();
				final Shadowable rect = new URectangle(widthTotal, heightTotal, CORNER, CORNER);
				if (shadowing()) {
					rect.setDeltaShadow(3);
				}
				ug.apply(new UChangeColor(color)).apply(new UChangeBackColor(backColor)).apply(new UStroke(1.5))
						.draw(rect);

				tb.drawU(ug.apply(new UTranslate(MARGIN, MARGIN)));
			}

			public Dimension2D calculateDimension(StringBounder stringBounder) {
				final Dimension2D dim = tb.calculateDimension(stringBounder);
				return Dimension2DDouble.delta(dim, 2 * MARGIN, 2 * MARGIN);
			}

			public List<Url> getUrls() {
				return tb.getUrls();
			}
		};
	}

	public boolean isKilled() {
		return false;
	}

	public Point2D getPointIn(StringBounder stringBounder) {
		final Dimension2D dim = tb.calculateDimension(stringBounder);
		return new Point2D.Double(dim.getWidth() / 2 + MARGIN, 0);
	}

	public Point2D getPointOut(StringBounder stringBounder) {
		final Dimension2D dim = tb.calculateDimension(stringBounder);
		return new Point2D.Double(dim.getWidth() / 2 + MARGIN, dim.getHeight() + 2 * MARGIN);
	}

}