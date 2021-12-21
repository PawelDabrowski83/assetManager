package pl.edu.pjwstk.assetManager.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetImpl asset = (AssetImpl) o;
        return type == asset.type;
    }
}
