package org.cda.tp_devinettes.util;

public class PathViews {

    private static final String pathViews = "/WEB-INF/view/";

    public static String find(String servletName) {
        return pathViews + servletName;
    }

}
