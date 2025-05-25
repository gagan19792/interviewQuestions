package org.interview.questions.graph;

import java.util.List;

public interface GraphI {

    enum GrapgType{
        DIRECTED, UNDIRECTED;
    }

    void addEdges(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}
