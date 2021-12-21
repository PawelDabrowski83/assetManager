package pl.edu.pjwstk.assetManager.model;

import pl.edu.pjwstk.assetManager.service.AssetFactory;

import java.util.HashSet;
import java.util.Set;



public class Node {
    static int count = 0;
    int id;
    Set<Asset> assets = new HashSet<>();

    public Node() {
        this.id = count++;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    public void setAssets(Set<Asset> assets) {
        this.assets = assets;
    }

    public Node addAsset(AssetType type) {
        Asset asset = new AssetFactory().createAsset(type);
        return addAsset(asset);
    }

    public Node addAsset(Asset asset) {
        this.assets.add(asset);
        return this;
    }
}
