package pl.edu.pjwstk.assetManager.model;

import java.util.Set;



public class Node {
    static int count = 0;
    int id;
    Set<Asset> assets;

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
}
