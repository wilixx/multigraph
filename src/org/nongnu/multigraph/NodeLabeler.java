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

/**
 * Callback interface to forward the labelling of new nodes back to 
 * the user.
 * 
 * @param <N> The type of the Nodes in the graph
 * @param <E> The type of the Edges in the graph
 */
public interface NodeLabeler<N,E> { 
  public N getNode (String n);
}
