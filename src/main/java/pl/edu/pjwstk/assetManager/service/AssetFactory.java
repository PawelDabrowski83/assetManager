package pl.edu.pjwstk.assetManager.service;

import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetImpl;
import pl.edu.pjwstk.assetManager.model.AssetType;

public class AssetFactory {

    public static Asset createAsset(AssetType type) {
        Asset asset = new AssetImpl();
        asset.setType(type);
        return asset;
    }
}
