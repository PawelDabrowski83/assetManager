package pl.edu.pjwstk.assetManager.service;

import pl.edu.pjwstk.assetManager.exception.UnknownAssetException;
import pl.edu.pjwstk.assetManager.model.Asset;
import pl.edu.pjwstk.assetManager.model.AssetImpl;
import pl.edu.pjwstk.assetManager.model.AssetType;

import java.util.HashSet;
import java.util.Set;



public class AssetFactory {
    public static final int OWNER_ID_TEST = 13;

    public Asset createAsset(AssetType type) {
        if (type == null) {
            throw new UnknownAssetException();
        }
        Asset asset = new AssetImpl(OWNER_ID_TEST);
        asset.setType(type);
        return asset;
    }

    public Set<Asset> createAssetSet(int a, int b, int c) {
        Set<Asset> assetSet = new HashSet<>();
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException();
        }
        while(a-- > 0) {
            assetSet.add(createAsset(AssetType.A));
        }
        while(b-- > 0) {
            assetSet.add(createAsset(AssetType.B));
        }
        while(c-- > 0) {
            assetSet.add(createAsset(AssetType.C));
        }
        return assetSet;
    }

}
