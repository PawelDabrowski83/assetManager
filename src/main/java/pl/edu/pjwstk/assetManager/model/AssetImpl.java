package pl.edu.pjwstk.assetManager.model;

public class AssetImpl implements Asset {
    int id;
    AssetType type;

    @Override
    public void setType(AssetType type) {
        this.type = type;
    }

    @Override
    public AssetType getType() {
        return type;
    }

    @Override
    public int getId() {
        return id;
    }
}
