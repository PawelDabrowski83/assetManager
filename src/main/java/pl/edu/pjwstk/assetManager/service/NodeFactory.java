package pl.edu.pjwstk.assetManager.service;

import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetType;
import pl.edu.pjwstk.assetManager.model.Node;

public class NodeFactory {
    public static final AssetFactory assetFactory = new AssetFactory();

    public Node createNode() {
        return new Node();
    }

    public Node createNode(AssetType assetType) {
        Asset asset = assetFactory.createAsset(assetType);
        return new Node().addAsset(asset);
    }

    public Node createNode(int a, int b, int c) {
        if (a == b && b == c && c == 0) {
            createNode();
        } else if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException();
        }
        Node node = createNode();
        while (a-- > 0) {
            node.addAsset(AssetType.A);
        }
        while (b-- > 0) {
            node.addAsset(AssetType.B);
        }
        while (c-- > 0) {
            node.addAsset(AssetType.C);
        }
        return node;
    }
}
