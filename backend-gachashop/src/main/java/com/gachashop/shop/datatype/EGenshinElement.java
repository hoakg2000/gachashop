package com.gachashop.shop.datatype;

public enum EGenshinElement {
    ANEMO("Anemo", "url_to_anemo_icon"),
    GEO("Geo", "url_to_geo_icon"),
    ELECTRO("Electro", "url_to_electro_icon"),
    DENDRO("Dendro", "url_to_dendro_icon"),
    PYRO("Pyro", "url_to_pyro_icon"),
    HYDRO("Hydro", "url_to_hydro_icon"),
    CRYO("Cryo", "url_to_cryo_icon");

    private final String elementName;
    private final String iconUrl;

    EGenshinElement(String elementName, String iconUrl) {
        this.elementName = elementName;
        this.iconUrl = iconUrl;
    }

    public String getElementName() {
        return elementName;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
