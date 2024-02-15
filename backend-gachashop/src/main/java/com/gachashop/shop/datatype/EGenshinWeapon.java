package com.gachashop.shop.datatype;

public enum EGenshinWeapon {
    SWORD("Sword", "url_to_sword_icon"),
    CLAYMORE("Claymore", "url_to_claymore_icon"),
    POLEARM("Polearm", "url_to_polearm_icon"),
    BOW("Bow", "url_to_bow_icon"),
    CATALYST("Catalyst", "url_to_catalyst_icon");

    private final String weaponType;
    private final String iconUrl;

    EGenshinWeapon(String weaponType, String iconUrl) {
        this.weaponType = weaponType;
        this.iconUrl = iconUrl;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}

