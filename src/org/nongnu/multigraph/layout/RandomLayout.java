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
package org.nongnu.multigraph.layout;

import java.awt.Dimension;
import java.util.Random;

import org.nongnu.multigraph.Graph;

/**
 * Random layout of a graph. This layout can be interesting to apply prior to a
 * ForceLayout.
 * @param <N> The type of the Nodes in the graph
 * @param <E> The type of the Edges in the graph
 */
public class RandomLayout<N extends PositionableNode, E> 
            extends Layout<N, E> {
  
  public RandomLayout (Graph<N,E> graph, Dimension bound, int maxiterations) {
    super (graph, bound, maxiterations);
  }
  
  @Override
  public boolean layout (float interval) {
    Random r = new Random ();
    
    for (N node : graph) {
      node.getPosition ().setLocation (r.nextInt (bound.width) - bound.width/2,
                                       r.nextInt (bound.height) - bound.height/2);
    }
    return false;
  }
  
}
