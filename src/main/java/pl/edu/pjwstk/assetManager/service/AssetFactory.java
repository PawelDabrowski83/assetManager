package pl.edu.pjwstk.assetManager.service;

import pl.edu.pjwstk.assetManager.exception.UnknownAssetException;
import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetImpl;
import pl.edu.pjwstk.assetManager.model.AssetType;

import java.util.HashSet;
import java.util.Set;

public class AssetFactory {

    public Asset createAsset(AssetType type) {
        if (type == null) {
            throw new UnknownAssetException();
        }
        Asset asset = new AssetImpl();
        asset.setType(type);
        return asset;
    }

}
