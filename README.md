# assetManager

Asset types: A, B, C.

AssetImpl

```
static int count
int id
AssetTypeEnum type
int ownerId - id of Node containing the asset
int controllerId - id of Node using the asset
```

Node
```
static int count
final int id
InetAddress ip
final int port
Set<Asset> assets
```