package com.github.bricklou.launchertuto.utils;

import fr.flowarg.flowcompat.Platform;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helpers {
    public static File generateGamePath(String folderName) {
        Path path;
        switch (Platform.getCurrentPlatform()) {
            case WINDOWS:
                path = Paths.get(System.getenv("APPDATA"));
                break;
            case MAC:
                path = Paths.get(System.getProperty("user.home"), "/Library/Application Support/");
                break;
            case LINUX:
                path = Paths.get(System.getProperty("user.home"), ".local/share");
                break;
            default:
                path = Paths.get(System.getProperty("user.home"));
        }

        path = Paths.get(path.toString(), folderName);
        return path.toFile();
    }
}
