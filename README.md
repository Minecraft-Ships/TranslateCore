# ShipsCore

This is the core API to be translated into the platform it runs on. Offical implementations of ShipsCore are
CoreForBukkit (Bukkit API), CoreForPaper (Paper API - paired with Bukkit API) and CoreForSponge (Spongepowered API).

ShipsCore is designed to be open for any developer to pick up and start using, therefore it has API calls to be
translated for many parts of the minecraft system, not just for Ships to run.

## How to build a Jar

### Windows

Open CMD at the root of the "ShipsTo..." module. Then run the following command

```gradlew jar```

### Unix Like (Linux/MacOS)

Open Terminal at the root of the "ShipsTo..." module. Then run the following command

```gradle jar```

## How to use

ShipsCore takes the best parts of both Bukkit and Sponge and attempts to build upon this, while the API is restricted to
what both Sponge and Bukkit support, it still has a few tricks up its sleave.

### Position

The position API is split into two sections, BlockPosition and ExactPosition. While there are two sections, if you do
not need to use specific calls from each section, then there is a common interface both extend upon called Position
which provides most calls.

    World world;
    BlockPosition bPos = world.getPosition(0, 1, 0);
    ExactPosition ePos = world.getPosition(0.0, 1.0, 0.0);

Both BlockPosition and ExactPosition can easily be converted into one and another with a simple method, this means you
can guarentee (assuming no custom implementions of Position have been used) a BlockPosition from a Position using the
following code

    public static BlockPosition toBlock(Position<? extends Number> position){
        return (position instanceof BlockPosition) ? (BlockPosition)position : ((ExactPosition)position).toBlockPosition();
    }

## Block

Blocks are based mainly on the Sponge implementation due to the simple nature of them, support for Forge blocks and
BlockSnapshots (something Bukkit does not support). Therefore ShipsCore contains BlockType, BlockDetails, BlockSnapshot
all of which work together to form the BlockAPI.

## BlockDetails

BlockDetails contains all the details of the block that is not stored within BlockEntities (Sponge calls them
TileEntities, Bukkit calls them BlockStates). With that being said, ShipsCore adds the ability to store TileEntity data
inside BlockDetails (such as you can in Sponge with BlockSnapshot), this means getting blockDetails from a position will
include (if the block provides one) the BlockEntity. 

