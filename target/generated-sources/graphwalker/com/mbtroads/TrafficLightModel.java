// Generated by GraphWalker (http://www.graphwalker.org)
package com.mbtroads;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/mbtroads/TrafficLightModel.json")
public interface TrafficLightModel {

    @Vertex()
    void v_Red();

    @Vertex()
    void v_Green();

    @Edge()
    void e_Toggle();

    @Vertex()
    void v_Start();

    @Edge()
    void e_TurnGreen();
}
