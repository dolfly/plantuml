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
package net.sourceforge.plantuml.activitydiagram3.ftile.vcompact;

import net.sourceforge.plantuml.ColorParam;
import net.sourceforge.plantuml.FontParam;
import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.activitydiagram3.LinkRendering;
import net.sourceforge.plantuml.activitydiagram3.ftile.Ftile;
import net.sourceforge.plantuml.activitydiagram3.ftile.FtileFactory;
import net.sourceforge.plantuml.activitydiagram3.ftile.FtileFactoryDelegator;
import net.sourceforge.plantuml.activitydiagram3.ftile.Swimlane;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.svek.ConditionStyle;
import net.sourceforge.plantuml.ugraphic.UFont;

public class FtileFactoryDelegatorIf extends FtileFactoryDelegator {

	public FtileFactoryDelegatorIf(FtileFactory factory, ISkinParam skinParam) {
		super(factory, skinParam);
	}

	private static boolean NEW = true;

	@Override
	public Ftile createIf(Swimlane swimlane, final Ftile tile1, final Ftile tile2, Display labelTest, Display label1, Display label2) {

		final UFont font = getSkinParam().getFont(FontParam.ACTIVITY_ARROW2, null);

		final HtmlColor borderColor = getRose().getHtmlColor(getSkinParam(), ColorParam.activityBorder);
		final HtmlColor backColor = getRose().getHtmlColor(getSkinParam(), ColorParam.activityBackground);
		final HtmlColor arrowColor = getRose().getHtmlColor(getSkinParam(), ColorParam.activityArrow);
		final LinkRendering endThenInlinkRendering = tile1.getOutLinkRendering();
		final LinkRendering endElseInlinkRendering = tile2.getOutLinkRendering();
		final HtmlColor endThenInlinkColor = endThenInlinkRendering == null ? null : endThenInlinkRendering.getColor();
		final HtmlColor endElseInlinkColor = endElseInlinkRendering == null ? null : endElseInlinkRendering.getColor();

		if (NEW) {
			final ConditionStyle conditionStyle = getSkinParam().getConditionStyle();
			return FtileIf5.create(swimlane, tile1, tile2, borderColor, backColor, labelTest, label1, label2, font, arrowColor,
					endThenInlinkColor, endElseInlinkColor, getFactory(), conditionStyle);
		}
		return FtileIf.create(tile1, tile2, borderColor, backColor, labelTest, label1, label2, font, arrowColor,
				endThenInlinkColor, endElseInlinkColor);
	}

}