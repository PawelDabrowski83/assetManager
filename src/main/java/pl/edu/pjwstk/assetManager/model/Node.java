package pl.edu.pjwstk.assetManager.model;

import pl.edu.pjwstk.assetManager.service.AssetFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;



public class Node {
    static int count = 0;
    final int id;
    InetAddress ip;
    final int port;
    Set<Asset> assets = new HashSet<>();

    public Node() {
        this.id = count++;
        try {
            this.ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.port = 20000 + id;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
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
