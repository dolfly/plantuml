/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of Smetana.
 * Smetana is a partial translation of Graphviz/Dot sources from C to Java.
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * This translation is distributed under the same Licence as the original C program:
 * 
 *************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************
 *
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE PUBLIC
 * LICENSE ("AGREEMENT"). [Eclipse Public License - v 1.0]
 * 
 * ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES
 * RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.
 * 
 * You may obtain a copy of the License at
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package h;
import java.util.Arrays;
import java.util.List;

import smetana.core.__ptr__;

//2 926gualwyh744kklf86qw5qsj

public interface _dt_s extends __ptr__ {
	public static List<String> DEFINITION = Arrays.asList(
"struct _dt_s",
"{",
"Dtsearch_f searchf",
"Dtdisc_t* disc",
"Dtdata_t* data",
"Dtmemory_f memoryf",
"Dtmethod_t* meth",
"int  type",
"int  nview",
"Dt_t*  view",
"Dt_t*  walk",
"void*  user",
"}");
}

// struct _dt_s
// {	Dtsearch_f	searchf;/* search function			*/
// 	Dtdisc_t*	disc;	/* method to manipulate objs		*/
// 	Dtdata_t*	data;	/* sharable data			*/
// 	Dtmemory_f	memoryf;/* function to alloc/free memory	*/
// 	Dtmethod_t*	meth;	/* dictionary method			*/
// 	int		type;	/* type information			*/
// 	int		nview;	/* number of parent view dictionaries	*/
// 	Dt_t*		view;	/* next on viewpath			*/
// 	Dt_t*		walk;	/* dictionary being walked		*/
// 	void*		user;	/* for user's usage			*/
// };