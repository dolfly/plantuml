/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
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
package net.sourceforge.plantuml.xmi;

import javax.xml.parsers.ParserConfigurationException;

import net.sourceforge.plantuml.classdiagram.ClassDiagram;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.cucadiagram.IEntity;
import net.sourceforge.plantuml.cucadiagram.Link;
import net.sourceforge.plantuml.cucadiagram.LinkDecor;
import net.sourceforge.plantuml.utils.UniqueSequence;

import org.w3c.dom.Element;

public class XmiClassDiagramStar extends XmiClassDiagramAbstract implements IXmiClassDiagram {

	public XmiClassDiagramStar(ClassDiagram classDiagram) throws ParserConfigurationException {
		super(classDiagram);

		for (final IEntity ent : classDiagram.getLeafsvalues()) {
			// if (fileFormat == FileFormat.XMI_ARGO && isStandalone(ent) == false) {
			// continue;
			// }
			final Element cla = createEntityNode(ent);
			if (cla == null) {
				continue;
			}
			ownedElement.appendChild(cla);
			done.add(ent);
		}

		// if (fileFormat != FileFormat.XMI_STANDARD) {
		for (final Link link : classDiagram.getLinks()) {
			addLink(link);
		}
		// }
	}

	// private boolean isStandalone(IEntity ent) {
	// for (final Link link : classDiagram.getLinks()) {
	// if (link.getEntity1() == ent || link.getEntity2() == ent) {
	// return false;
	// }
	// }
	// return true;
	// }

	private void addLink(Link link) {
		final String assId = "ass" + UniqueSequence.getValue();
		if (link.getType().getDecor1() == LinkDecor.EXTENDS || link.getType().getDecor2() == LinkDecor.EXTENDS) {
			addExtension(link, assId);
			return;
		}
		final Element association = document.createElement("UML:Association");
		association.setAttribute("xmi.id", assId);
		association.setAttribute("namespace", CucaDiagramXmiMaker.getModel(classDiagram));
		if (Display.isNull(link.getLabel()) == false) {
			association.setAttribute("name", forXMI(link.getLabel()));
		}

		final Element connection = document.createElement("UML:Association.connection");
		final Element end1 = document.createElement("UML:AssociationEnd");
		end1.setAttribute("xmi.id", "end" + UniqueSequence.getValue());
		end1.setAttribute("association", assId);
		end1.setAttribute("type", link.getEntity1().getUid());
		if (link.getQualifier1() != null) {
			end1.setAttribute("name", forXMI(link.getQualifier1()));
		}
		final Element endparticipant1 = document.createElement("UML:AssociationEnd.participant");
		// if (fileFormat == FileFormat.XMI_ARGO) {
		// if (done.contains(link.getEntity1())) {
		// endparticipant1.appendChild(createEntityNodeRef(link.getEntity1()));
		// } else {
		// endparticipant1.appendChild(createEntityNode(link.getEntity1()));
		// done.add(link.getEntity1());
		// }
		// } else if (fileFormat == FileFormat.XMI_STAR) {
		if (link.getType().getDecor2() == LinkDecor.COMPOSITION) {
			end1.setAttribute("aggregation", "composite");
		}
		if (link.getType().getDecor2() == LinkDecor.AGREGATION) {
			end1.setAttribute("aggregation", "aggregate");
		}
		// }
		end1.appendChild(endparticipant1);
		connection.appendChild(end1);

		final Element end2 = document.createElement("UML:AssociationEnd");
		end2.setAttribute("xmi.id", "end" + UniqueSequence.getValue());
		end2.setAttribute("association", assId);
		end2.setAttribute("type", link.getEntity2().getUid());
		if (link.getQualifier2() != null) {
			end2.setAttribute("name", forXMI(link.getQualifier2()));
		}
		final Element endparticipant2 = document.createElement("UML:AssociationEnd.participant");
		// if (fileFormat == FileFormat.XMI_ARGO) {
		// if (done.contains(link.getEntity2())) {
		// endparticipant2.appendChild(createEntityNodeRef(link.getEntity2()));
		// } else {
		// endparticipant2.appendChild(createEntityNode(link.getEntity2()));
		// done.add(link.getEntity2());
		// }
		// } else if (fileFormat == FileFormat.XMI_STAR) {
		if (link.getType().getDecor1() == LinkDecor.COMPOSITION) {
			end2.setAttribute("aggregation", "composite");
		}
		if (link.getType().getDecor1() == LinkDecor.AGREGATION) {
			end2.setAttribute("aggregation", "aggregate");
		}
		// }
		end2.appendChild(endparticipant2);
		connection.appendChild(end2);

		association.appendChild(connection);

		ownedElement.appendChild(association);

	}

	private void addExtension(Link link, String assId) {
		final Element association = document.createElement("UML:Generalization");
		association.setAttribute("xmi.id", assId);
		association.setAttribute("namespace", CucaDiagramXmiMaker.getModel(classDiagram));
		if (link.getLabel() != null) {
			association.setAttribute("name", forXMI(link.getLabel()));
		}
		if (link.getType().getDecor1() == LinkDecor.EXTENDS) {
			association.setAttribute("child", link.getEntity1().getUid());
			association.setAttribute("parent", link.getEntity2().getUid());
		} else if (link.getType().getDecor2() == LinkDecor.EXTENDS) {
			association.setAttribute("child", link.getEntity2().getUid());
			association.setAttribute("parent", link.getEntity1().getUid());
		} else {
			throw new IllegalStateException();
		}
		ownedElement.appendChild(association);

	}

}
