package modules.terrain;

import core.Settings;
import core.features.VertexBufferObject;
import core.math.Vector;
import core.math.Vector2f;
import tools.Camera;
import tools.Program;

public class TerrainQuadtree {

    private Node rootNode;

    public TerrainQuadtree(Camera camera) {
        rootNode = new Node(camera, new Vector2f(0, 0), new Vector2f(0.5f, 0.5f), null, 1);
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void updateTree() {
        rootNode.updateNode();
    }

    public void render(Program program) {
        for(Node child : rootNode.getChildren()) {
            child.render(program);
        }
    }
}
