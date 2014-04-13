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
 */
package net.sourceforge.plantuml.version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum License {

	GPL, LGPL, APACHE, EPL, MIT;

	public static License getCurrent() {
		return GPL;
	}

	private void addMit(final List<String> text) {
		text.add("PlantUML is free software; you can redistribute it and/or modify it");
		text.add("under the terms of the MIT License.");
		text.add("");
		text.add("See http://opensource.org/licenses/MIT");
		text.add("");
		text.add("Permission is hereby granted, free of charge, to any person obtaining");
		text.add("a copy of this software and associated documentation files (the \"Software\"),");
		text.add("to deal in the Software without restriction, including without limitation");
		text.add("the rights to use, copy, modify, merge, publish, distribute, sublicense,");
		text.add("and/or sell copies of the Software, and to permit persons to whom the");
		text.add("Software is furnished to do so, subject to the following conditions:");
		text.add("");
		text.add("The above copyright notice and this permission notice shall be included");
		text.add("in all copies or substantial portions of the Software.");
		text.add("");
		text.add("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS");
		text.add("OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,");
		text.add("FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE");
		text.add("AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,");
		text.add("WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR");
		text.add("IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.");
		text.add("");
		text.add("Note that images (whatever their format : PNG, SVG...) generated by running PlantUML");
		text.add("are owned by the author of their corresponding sources code (that is, their");
		text.add("textual description in PlantUML language). Those images are not covered by");
		text.add("the MIT License.");
		text.add("");
		text.add("The generated images can then be used without any reference to the MIT License.");
		text.add("It is not even necessary to stipulate that they have been generated with PlantUML,");
		text.add("also this will be appreciate by PlantUML team.");
		text.add("");
		text.add("There is an exception : if the textual description in PlantUML language is also covered");
		text.add("by a license (like the MIT), then the generated images are logically covered");
		text.add("by the very same license.");
	}

	private void addEpl(final List<String> text) {
		text.add("PlantUML is free software; you can redistribute it and/or modify it");
		text.add("under the terms of the Eclipse Public License.");
		text.add("");
		text.add("THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE PUBLIC");
		text.add("LICENSE (\"AGREEMENT\"). [Eclipse Public License - v 1.0]");
		text.add("");
		text.add("ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES");
		text.add("RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.");
		text.add("");
		text.add("You may obtain a copy of the License at");
		text.add("");
		text.add("http://www.eclipse.org/legal/epl-v10.html");
		text.add("");
		text.add("Unless required by applicable law or agreed to in writing, software");
		text.add("distributed under the License is distributed on an \"AS IS\" BASIS,");
		text.add("WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
		text.add("See the License for the specific language governing permissions and");
		text.add("limitations under the License.");
		text.add("");
		text.add("Note that images (whatever their format : PNG, SVG...) generated by running PlantUML");
		text.add("are owned by the author of their corresponding sources code (that is, their");
		text.add("textual description in PlantUML language). Those images are not covered by");
		text.add("the Eclipse Public License.");
		text.add("");
		text.add("The generated images can then be used without any reference to the Eclipse Public License.");
		text.add("It is not even necessary to stipulate that they have been generated with PlantUML,");
		text.add("also this will be appreciate by PlantUML team.");
		text.add("");
		text.add("There is an exception : if the textual description in PlantUML language is also covered");
		text.add("by a license (like the EPL), then the generated images are logically covered");
		text.add("by the very same license.");
	}

	private void addApache(final List<String> text) {
		text.add("PlantUML is free software; you can redistribute it and/or modify it");
		text.add("under the terms of the Apache Software License.");
		text.add("");
		text.add("Licensed under the Apache License, Version 2.0 (the \"License\");");
		text.add("you may not use this file except in compliance with the License.");
		text.add("You may obtain a copy of the License at");
		text.add("");
		text.add("http://www.apache.org/licenses/LICENSE-2.0");
		text.add("");
		text.add("Unless required by applicable law or agreed to in writing, software");
		text.add("distributed under the License is distributed on an \"AS IS\" BASIS,");
		text.add("WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
		text.add("See the License for the specific language governing permissions and");
		text.add("limitations under the License.");
		text.add("");
		text.add("Note that images (whatever their format : PNG, SVG...) generated by running PlantUML");
		text.add("are owned by the author of their corresponding sources code (that is, their");
		text.add("textual description in PlantUML language). Those images are not covered by");
		text.add("the Apache license.");
		text.add("");
		text.add("The generated images can then be used without any reference to the Apache license.");
		text.add("It is not even necessary to stipulate that they have been generated with PlantUML,");
		text.add("also this will be appreciate by PlantUML team.");
		text.add("");
		text.add("There is an exception : if the textual description in PlantUML language is also covered");
		text.add("by a license (like the Apache), then the generated images are logically covered");
		text.add("by the very same license.");
	}

	private void addGpl(final List<String> text) {
		text.add("PlantUML is free software; you can redistribute it and/or modify it");
		text.add("under the terms of the GNU General Public License as published by");
		text.add("the Free Software Foundation, either version 3 of the License, or");
		text.add("(at your option) any later version.");
		text.add("");
		text.add("PlantUML distributed in the hope that it will be useful, but");
		text.add("WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY");
		text.add("or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public");
		text.add("License for more details.");
		text.add("");
		text.add("You should have received a copy of the GNU General Public");
		text.add("License along with this library; if not, write to the Free Software");
		text.add("Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,");
		text.add("USA.");
		text.add("");
		text.add("Note that images (whatever their format : PNG, SVG...) generated by running PlantUML");
		text.add("are owned by the author of their corresponding sources code (that is, their");
		text.add("textual description in PlantUML language). Those images are not covered by");
		text.add("the GPL license.");
		text.add("");
		text.add("The generated images can then be used without any reference to the GPL license.");
		text.add("It is not even necessary to stipulate that they have been generated with PlantUML,");
		text.add("also this will be appreciate by PlantUML team.");
		text.add("");
		text.add("There is an exception : if the textual description in PlantUML language is also covered");
		text.add("by a license (like the GPL), then the generated images are logically covered");
		text.add("by the very same license.");
	}

	private void addLgpl(final List<String> text) {
		text.add("PlantUML is free software; you can redistribute it and/or modify it");
		text.add("under the terms of the GNU Lesser General Public License as published by");
		text.add("the Free Software Foundation, either version 3 of the License, or");
		text.add("(at your option) any later version.");
		text.add("");
		text.add("PlantUML distributed in the hope that it will be useful, but");
		text.add("WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY");
		text.add("or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public");
		text.add("License for more details.");
		text.add("");
		text.add("You should have received a copy of the GNU Lesser General Public");
		text.add("License along with this library; if not, write to the Free Software");
		text.add("Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,");
		text.add("USA.");
		text.add("");
		text.add("Note that images (whatever their format : PNG, SVG...) generated by running PlantUML");
		text.add("are owned by the author of their corresponding sources code (that is, their");
		text.add("textual description in PlantUML language). Those images are not covered by");
		text.add("the LGPL license.");
		text.add("");
		text.add("The generated images can then be used without any reference to the LGPL license.");
		text.add("It is not even necessary to stipulate that they have been generated with PlantUML,");
		text.add("although this will be appreciate by PlantUML team.");
		text.add("");
		text.add("There is an exception : if the textual description in PlantUML language is also covered");
		text.add("by a license (like the LGPL), then the generated images are logically covered");
		text.add("by the very same license.");
	}

	private List<String> getHeaderStart() {
		final List<String> text = new ArrayList<String>();
		text.add("========================================================================");
		text.add("PlantUML : a free UML diagram generator");
		text.add("========================================================================");
		text.add("");
		text.add("(C) Copyright 2009-2014, Arnaud Roques");
		text.add("");
		text.add("Project Info:  http://plantuml.sourceforge.net");
		text.add("");
		return text;
	}

	public List<String> getJavaHeader() {
		final List<String> h = new ArrayList<String>();
		h.add("/* ========================================================================");
		h.add(" * PlantUML : a free UML diagram generator");
		h.add(" * ========================================================================");
		h.add(" *");
		h.add(" * (C) Copyright 2009-2014, Arnaud Roques");
		h.add(" *");
		h.add(" * Project Info:  http://plantuml.sourceforge.net");
		h.add(" * ");
		h.add(" * This file is part of PlantUML.");
		h.add(" *");
		if (this == License.LGPL) {
			h.add(" * PlantUML is free software; you can redistribute it and/or modify it");
			h.add(" * under the terms of the GNU Lesser General Public License as published by");
			h.add(" * the Free Software Foundation, either version 3 of the License, or");
			h.add(" * (at your option) any later version.");
			h.add(" *");
			h.add(" * PlantUML distributed in the hope that it will be useful, but");
			h.add(" * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY");
			h.add(" * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public");
			h.add(" * License for more details.");
			h.add(" *");
			h.add(" * You should have received a copy of the GNU Lesser General Public");
			h.add(" * License along with this library; if not, write to the Free Software");
			h.add(" * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,");
			h.add(" * USA.");
			h.add(" *");
		} else if (this == License.APACHE) {
			h.add(" * Licensed under the Apache License, Version 2.0 (the \"License\");");
			h.add(" * you may not use this file except in compliance with the License.");
			h.add(" * You may obtain a copy of the License at");
			h.add(" * ");
			h.add(" * http://www.apache.org/licenses/LICENSE-2.0");
			h.add(" * ");
			h.add(" * Unless required by applicable law or agreed to in writing, software");
			h.add(" * distributed under the License is distributed on an \"AS IS\" BASIS,");
			h.add(" * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
			h.add(" * See the License for the specific language governing permissions and");
			h.add(" * limitations under the License.");
			h.add(" *");
		} else if (this == License.EPL) {
			h.add(" * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE PUBLIC");
			h.add(" * LICENSE (\"AGREEMENT\"). [Eclipse Public License - v 1.0]");
			h.add(" * ");
			h.add(" * ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES");
			h.add(" * RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.");
			h.add(" * ");
			h.add(" * You may obtain a copy of the License at");
			h.add(" * ");
			h.add(" * http://www.eclipse.org/legal/epl-v10.html");
			h.add(" * ");
			h.add(" * Unless required by applicable law or agreed to in writing, software");
			h.add(" * distributed under the License is distributed on an \"AS IS\" BASIS,");
			h.add(" * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
			h.add(" * See the License for the specific language governing permissions and");
			h.add(" * limitations under the License.");
			h.add(" * ");
		} else if (this == License.MIT) {
			h.add(" * Licensed under The MIT License (Massachusetts Institute of Technology License)");
			h.add(" * ");
			h.add(" * See http://opensource.org/licenses/MIT");
			h.add(" * ");
			h.add(" * Permission is hereby granted, free of charge, to any person obtaining");
			h.add(" * a copy of this software and associated documentation files (the \"Software\"),");
			h.add(" * to deal in the Software without restriction, including without limitation");
			h.add(" * the rights to use, copy, modify, merge, publish, distribute, sublicense,");
			h.add(" * and/or sell copies of the Software, and to permit persons to whom the");
			h.add(" * Software is furnished to do so, subject to the following conditions:");
			h.add(" * ");
			h.add(" * The above copyright notice and this permission notice shall be included");
			h.add(" * in all copies or substantial portions of the Software.");
			h.add(" * ");
			h.add(" * THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS");
			h.add(" * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,");
			h.add(" * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE");
			h.add(" * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,");
			h.add(" * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR");
			h.add(" * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.");
			h.add(" * ");
		}
		h.add(" *");
		h.add(" * Original Author:  Arnaud Roques");
		h.add(" */");
		return Collections.unmodifiableList(h);
	}

	public List<String> getText() {
		final List<String> text = getHeaderStart();
		if (this == License.GPL) {
			addGpl(text);
		} else if (this == License.MIT) {
			addMit(text);
		} else if (this == License.EPL) {
			addEpl(text);
		} else if (this == License.APACHE) {
			addApache(text);
		} else if (this == License.LGPL) {
			addLgpl(text);
		} else {
			throw new IllegalStateException();
		}
		return text;
	}

}
