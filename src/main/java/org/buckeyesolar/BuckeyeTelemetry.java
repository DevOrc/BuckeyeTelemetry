package org.buckeyesolar;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.resource.PathResourceManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BuckeyeTelemetry {

    public static void main(String[] args) {
        Path workingDir = Paths.get("assets").toAbsolutePath();
        File indexHtml = workingDir.resolve("index.html").toFile();

        System.out.println("Starting buckeye telemetry...");
        System.out.println("Static File Dir = " + workingDir);
        System.out.println("Index.html = " + indexHtml);

        HttpHandler staticFile = Handlers.resource(new PathResourceManager(workingDir));
        HttpHandler homepage = Handlers.redirect("/static/index.html");

        HttpHandler groupHandler = Handlers.path(homepage)
                .addPrefixPath("/static", staticFile);

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(groupHandler)
                .build();
        server.start();
    }

}
