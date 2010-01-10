/* This file is part of 'MultiGraph'
 *
 * Copyright (C) 2009 Paul Jakma
 *
 * MultiGraph is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 3, or (at your option) any
 * later version.  
 * 
 * MultiGraph is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.   
 *
 * You should have received a copy of the GNU General Public License
 * along with MultiGraph.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.nongnu.multigraph;

import java.util.Collection;

/** Simple graph: undirected and no loops allowed */
public class SimpleGraph<N, L> extends MultiGraph<N, L> {

	@Override
	protected void _set(N from, N to, int weight, L label) {
		Node<N,L> nf = get_node (from), nt;
		Collection<Edge<N,L>> edges;

		if (from == to)
			throw new UnsupportedOperationException ("Edges to self"
													 + " are not allowed!");
		
		if ((nt = this.nodes.get (to)) != null &&
			(edges = nf.edges (nt)) != null &&
			edges.size () > 0) {
			
			/* SimpleGraph should never have multiple edges between nodes */
			assert edges.size () == 1 : edges.size ();
			
			/* An edge already exists. If this is an attempt to add a 2nd edge
			 * between nodes, then it's an error.
			 */
			for (Edge<N,L> edge : edges) {
				if (edge.label () != label)
					throw new UnsupportedOperationException (
							"Multiple edges between nodes are not allowed");
			}
			
		}
		
		if (nt == null)
			nt = get_node (to);
		
		super._set (nt, nf, weight, label);
		super._set (nf, nt, weight, label);
	}

	@Override
	protected boolean _remove (N from, N to, L label) {
		boolean ret1 = super._remove (from, to, label);
		boolean ret2 = super._remove (to, from, label);

		assert (ret1 == ret2);

		return ret1;
	}
}
