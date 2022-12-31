package org.core.platform.update.bukkit;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.core.platform.update.PlatformUpdate;
import org.core.platform.update.result.FailedResult;
import org.core.platform.update.result.SuccessfulResult;
import org.core.platform.update.result.UpdateResult;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;

public class DevBukkitUpdateChecker implements PlatformUpdate<DevBukkitUpdateOption> {

    private final String curseForge = "https://api.curseforge.com";
    public static final String ID = "dev.bukkit";

    @Override
    public URI getUpdateSite() {
        try {
            return new URI(this.curseForge);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getIdName() {
        return ID;
    }

    @Override
    public CompletableFuture<UpdateResult> checkForUpdate(@NotNull DevBukkitUpdateOption devOptions) {
        CompletableFuture<UpdateResult> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                URL url = new URL(this.curseForge + "/servermods/files?projectIds=" + devOptions.numberId());
                URLConnection connection = url.openConnection();
                connection.setConnectTimeout(5000);

                connection.addRequestProperty("User-Agent", "Transfer-Core");
                connection.setDoOutput(true);

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = br.readLine();
                JsonElement element = JsonParser.parseString(line);
                JsonArray array = element.getAsJsonArray();
                if (array.isEmpty()) {
                    future.complete(new FailedResult(
                            "No versions found, probably incorrect id of '" + devOptions.numberId() + "'"));
                    return;
                }
                JsonObject latestElement = array.get(array.size() - 1).getAsJsonObject();

                String pluginName = latestElement.get("name").getAsString();
                String pluginURL = latestElement.get("downloadUrl").getAsString();
                String pluginVersion = latestElement.get("gameVersion").getAsString();
                URL downloadURL = new URL(pluginURL);

                DevBukkitPlugin plugin = new DevBukkitPlugin(pluginName, pluginVersion, downloadURL);
                future.complete(new SuccessfulResult(plugin));
            } catch (IOException e) {
                future.complete(new FailedResult(e.getMessage()));
            }
        }).start();
        return future;
    }
}
