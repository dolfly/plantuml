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
 * Revision $Revision: 6590 $
 *
 */
package net.sourceforge.plantuml.skin.rose;

import net.sourceforge.plantuml.SpriteContainer;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.graphic.HorizontalAlignement;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.skin.AbstractTextualComponent;
import net.sourceforge.plantuml.skin.Area;
import net.sourceforge.plantuml.ugraphic.UFont;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.URectangle;
import net.sourceforge.plantuml.ugraphic.UStroke;

final public class ComponentRoseNoteBox extends AbstractTextualComponent {

	private final HtmlColor back;
	private final HtmlColor foregroundColor;
	private final double deltaShadow;
	private final UStroke stroke;

	public ComponentRoseNoteBox(HtmlColor back, HtmlColor foregroundColor, HtmlColor fontColor, UFont font,
			Display strings, SpriteContainer spriteContainer, double deltaShadow, UStroke stroke) {
		super(strings, fontColor, font, HorizontalAlignement.LEFT, 4, 4, 4, spriteContainer);
		this.back = back;
		this.foregroundColor = foregroundColor;
		this.deltaShadow = deltaShadow;
		this.stroke = stroke;
	}

	@Override
	final public double getPreferredWidth(StringBounder stringBounder) {
		final double result = getTextWidth(stringBounder) + 2 * getPaddingX();
		return result;
	}

	@Override
	final public double getPreferredHeight(StringBounder stringBounder) {
		return getTextHeight(stringBounder) + 2 * getPaddingY();
	}

	@Override
	public double getPaddingX() {
		return 5;
	}

	@Override
	public double getPaddingY() {
		return 5;
	}

	@Override
	protected void drawInternalU(UGraphic ug, Area area) {
		final StringBounder stringBounder = ug.getStringBounder();
		final int textHeight = (int) getTextHeight(stringBounder);

		final int x2 = (int) getTextWidth(stringBounder);

		ug.getParam().setColor(foregroundColor);
		ug.getParam().setBackcolor(back);
		ug.getParam().setStroke(stroke);
		final URectangle rect = new URectangle(x2, textHeight);
		rect.setDeltaShadow(deltaShadow);
		ug.drawOldWay(rect);
		ug.getParam().setStroke(new UStroke());

		getTextBlock().drawU(ug, getMarginX1(), getMarginY());

	}
}
