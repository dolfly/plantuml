/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2014, Arnaud Roques
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
 * Revision $Revision: 4749 $
 *
 */
package net.sourceforge.plantuml.cucadiagram;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.plantuml.FontParam;
import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.graphic.TextBlock;
import net.sourceforge.plantuml.graphic.TextBlockLineBefore;
import net.sourceforge.plantuml.graphic.TextBlockUtils;

public class BlockMemberImpl implements BlockMember {

	private final List<Member> members = new ArrayList<Member>();

	public BlockMemberImpl(List<Member> members) {
		this.members.addAll(members);
	}

	public List<Member> getAll() {
		return Collections.unmodifiableList(members);
	}

	public TextBlock asTextBlock(FontParam fontParam, ISkinParam skinParam) {
		final MethodsOrFieldsArea methodsOrFieldsArea = new MethodsOrFieldsArea(members, fontParam, skinParam);
		return new TextBlockLineBefore(TextBlockUtils.withMargin((TextBlock) methodsOrFieldsArea, 6, 4));
	}

	public Rectangle2D getPosition(String member, StringBounder stringBounder, FontParam fontParam, ISkinParam skinParam) {
		final MethodsOrFieldsArea methodsOrFieldsArea = new MethodsOrFieldsArea(members, fontParam, skinParam);
		return methodsOrFieldsArea.getPosition(member, stringBounder);
	}

	public boolean contains(String member, FontParam fontParam, ISkinParam skinParam) {
		final MethodsOrFieldsArea methodsOrFieldsArea = new MethodsOrFieldsArea(members, fontParam, skinParam);
		return methodsOrFieldsArea.contains(member);
	}

}
