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
package gen.lib.cdt;
import static gen.lib.cdt.dtrestore__c.dtrestore;
import static smetana.core.JUtilsDebug.ENTERING;
import static smetana.core.JUtilsDebug.LEAVING;
import h._dt_s;
import h._dtlink_s;

public class dtsize__c {
//1 9k44uhd5foylaeoekf3llonjq
// extern Dtmethod_t* 	Dtset


//1 1ahfywsmzcpcig2oxm7pt9ihj
// extern Dtmethod_t* 	Dtbag


//1 anhghfj3k7dmkudy2n7rvt31v
// extern Dtmethod_t* 	Dtoset


//1 5l6oj1ux946zjwvir94ykejbc
// extern Dtmethod_t* 	Dtobag


//1 2wtf222ak6cui8cfjnw6w377z
// extern Dtmethod_t*	Dtlist


//1 d1s1s6ibtcsmst88e3057u9r7
// extern Dtmethod_t*	Dtstack


//1 axa7mflo824p6fspjn1rdk0mt
// extern Dtmethod_t*	Dtqueue


//1 ega812utobm4xx9oa9w9ayij6
// extern Dtmethod_t*	Dtdeque


//1 cyfr996ur43045jv1tjbelzmj
// extern Dtmethod_t*	Dtorder


//1 wlofoiftbjgrrabzb2brkycg
// extern Dtmethod_t*	Dttree


//1 12bds94t7voj7ulwpcvgf6agr
// extern Dtmethod_t*	Dthash


//1 9lqknzty480cy7zsubmabkk8h
// extern Dtmethod_t	_Dttree


//1 bvn6zkbcp8vjdhkccqo1xrkrb
// extern Dtmethod_t	_Dthash


//1 9lidhtd6nsmmv3e7vjv9e10gw
// extern Dtmethod_t	_Dtlist


//1 34ujfamjxo7xn89u90oh2k6f8
// extern Dtmethod_t	_Dtqueue


//1 3jy4aceckzkdv950h89p4wjc8
// extern Dtmethod_t	_Dtstack




//3 6j49zum5hqto1t7fyrz8qjv1u
// static int treecount(register Dtlink_t* e)     
public static int treecount(_dtlink_s e) {
ENTERING("6j49zum5hqto1t7fyrz8qjv1u","treecount");
try {
	return e!=null ? treecount((_dtlink_s) e.getPtr("hl._left")) + treecount((_dtlink_s) e.getPtr("right")) + 1 : 0;
} finally {
LEAVING("6j49zum5hqto1t7fyrz8qjv1u","treecount");
}
}




//3 bci0ea1fa7egf4aads6gdgvsq
// int dtsize(Dt_t* dt)     
public static int dtsize_(_dt_s dt) {
ENTERING("bci0ea1fa7egf4aads6gdgvsq","dtsize");
try {
	_dtlink_s	t;
	int		size;
	if (((dt.getPtr("data").getInt("type")&010000)!=0)) dtrestore(dt,null);
	if(dt.getPtr("data").getInt("size") < 0) /* !(dt->data->type&(DT_SET|DT_BAG)) */
	{	if((dt.getPtr("data").getInt("type")&(0000004|0000010))!=0)
			dt.getPtr("data").setInt("size", treecount((_dtlink_s) dt.getPtr("data").getPtr("here")));
		else if((dt.getPtr("data").getInt("type")&(0000020|0000040|0000100))!=0)
		{	size=0;
		    for(t = (_dtlink_s) dt.getPtr("data").getPtr("hh").getPtr("_head"); t!=null; t = (_dtlink_s) t.getPtr("right"))
				size += 1;
			dt.getPtr("data").setInt("size", size);
		}
	}
	return dt.getPtr("data").getInt("size");

} finally {
LEAVING("bci0ea1fa7egf4aads6gdgvsq","dtsize");
}
}


}
